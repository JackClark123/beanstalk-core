package com.beanstalk.core.bigtable.repositories;

import com.beanstalk.core.bigtable.BeanstalkDataType;
import com.beanstalk.core.bigtable.Family;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.models.ColumnFamily;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.ModifyColumnFamiliesRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

public class CreateIfNotExists {

    private static final Logger logger = LoggerFactory.getLogger(CreateIfNotExists.class);

    public static void tables(String project, String instance, String table, Class cls) {

        BigtableTableAdminClient adminClient;

        try {
            // Creates the settings to configure a bigtable table admin client.
            BigtableTableAdminSettings adminSettings =
                    BigtableTableAdminSettings.newBuilder()
                            .setProjectId(project)
                            .setInstanceId(instance)
                            .build();

            adminClient = BigtableTableAdminClient.create(adminSettings);

            // Creates a bigtable table admin client.
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (table == null) {
            logger.error("Table name not set for class " + cls.getName());
        } else {
            if (!adminClient.exists(table)) {
                CreateTableRequest createTableRequest =
                        CreateTableRequest.of(table);

                Set<String> families = new HashSet<>(createFamilies(cls));

                for (String family : families) {
                    createTableRequest.addFamily(family);
                }

                adminClient.createTable(createTableRequest);
                logger.info("Created table " + table);
            } else {

                logger.info("Table " + table + " already exists");

                Set<String> currentColumnFamilies = new HashSet<>();
                Set<String> newColumnFamilies = new HashSet<>(createFamilies(cls));

                for (ColumnFamily columnFamily : adminClient.getTable(table).getColumnFamilies()) {
                    currentColumnFamilies.add(columnFamily.getId());
                }

                newColumnFamilies.removeAll(currentColumnFamilies);

                ModifyColumnFamiliesRequest modifyColumnFamiliesRequest =
                        ModifyColumnFamiliesRequest.of(table);

                for (String family : newColumnFamilies) {
                    logger.info("Table " + table + ": adding family " + family);
                    modifyColumnFamiliesRequest.addFamily(family);
                }

                adminClient.modifyFamilies(modifyColumnFamiliesRequest);
            }
        }

    }

    public static void tables(String project, String instance, String table, String... familyNames) {
        BigtableTableAdminClient adminClient;

        try {
            // Creates the settings to configure a bigtable table admin client.
            BigtableTableAdminSettings adminSettings =
                    BigtableTableAdminSettings.newBuilder()
                            .setProjectId(project)
                            .setInstanceId(instance)
                            .build();

            adminClient = BigtableTableAdminClient.create(adminSettings);

            // Creates a bigtable table admin client.
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (!adminClient.exists(table)) {
            CreateTableRequest createTableRequest =
                    CreateTableRequest.of(table);

            for (String family : familyNames) {
                createTableRequest.addFamily(family);
            }

            adminClient.createTable(createTableRequest);
            logger.info("Created table " + table);
        } else {
            logger.info("Table " + table + " already exists");

            Set<String> currentColumnFamilies = new HashSet<>();
            HashSet<String> newColumnFamilies = new HashSet<>(Arrays.asList(familyNames));

            for (ColumnFamily columnFamily : adminClient.getTable(table).getColumnFamilies()) {
                currentColumnFamilies.add(columnFamily.getId());
            }

            newColumnFamilies.removeAll(currentColumnFamilies);

            ModifyColumnFamiliesRequest modifyColumnFamiliesRequest =
                    ModifyColumnFamiliesRequest.of(table);

            for (String family : newColumnFamilies) {
                logger.info("Table " + table + ": adding family " + family);
                modifyColumnFamiliesRequest.addFamily(family);
            }

            adminClient.modifyFamilies(modifyColumnFamiliesRequest);
        }

    }

    private static List<String> createFamilies(Class clazz) {
        List<String> families = new ArrayList<>();

        for (Field field: clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Family.class)) {

                if (BeanstalkDataType.class.isAssignableFrom(field.getType())) {
                    families.addAll(createFamilies(field.getType()));
                }

                families.add(field.getAnnotation(Family.class).value());
            }
        }

        return families;
    }

}
