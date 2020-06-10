package com.study.demoinflearnrestapi.event;

import lombok.*;

import java.time.LocalDateTime;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class EventDto {
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
}
