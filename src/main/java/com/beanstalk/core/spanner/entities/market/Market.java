package com.beanstalk.core.spanner.entities.market;


import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Market implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    private String sport;

    private String competition;

    private String name;

    private String location;

    private String image;

    private Timestamp startTime;

    private Integer state;

    private Boolean completed;

    @OneToMany(mappedBy = "market", fetch = FetchType.EAGER)
    private Set<Competitor> competitors;


}
