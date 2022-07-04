package com.beanstalk.core.spanner.entities.market;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type="uuid-char")
    private UUID id;

    private String sport;

    private String competition;

    private String name;

    private String location;

    private String image;

    private LocalDateTime startTime;

    private Integer state;

    private Boolean completed;

    @OneToMany(mappedBy = "market")
    private List<Competitor> competitors;


}
