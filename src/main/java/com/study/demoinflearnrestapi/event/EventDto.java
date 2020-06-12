package com.study.demoinflearnrestapi.event;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class EventDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotNull
    private LocalDateTime beginEnrollmentDateTime;
    @NotNull
    private LocalDateTime closeEnrollmentDateTime;
    @NotNull
    private LocalDateTime beginEventTime;
    @NotNull
    private LocalDateTime endEventTime;

    private String location;    // (option) 없을 시 온라인 모임
    @Min(0)
    private int basePrice;      // (optional)
    @Min(0)
    private int maxPrice;      // (optional)
    @Min(0)
    private int limitOfEnrollment;
}
