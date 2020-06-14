package com.study.demoinflearnrestapi.event;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode(of = "id")
@Entity
public class Event {

    @Id @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime beginEnrollmentDateTime;
    private LocalDateTime closeEnrollmentDateTime;
    private LocalDateTime beginEventTime;
    private LocalDateTime endEventTime;
    private String location;    // (option) 없을 시 온라인 모임
    private int basePrice;      // (optional)
    private int maxPrice;      // (optional)
    private int limitOfEnrollment;      // (optional)
    private boolean offline;
    private boolean free;

    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus = EventStatus.DRAFT;

    public void update() {
        // update free
        if (basePrice == 0 && maxPrice == 0) {
            free = true;
        } else {
            free = false;
        }

        // update offline
        if (location == null || location.isBlank()) {
            offline = false;
        } else {
            offline = true;
        }
    }
}
