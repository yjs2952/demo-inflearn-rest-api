package com.study.demoinflearnrestapi.event;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.time.LocalDateTime;

@Component
public class EventValidator {

    public void validate(EventDto eventDto, Errors errors) {
        if (eventDto.getBasePrice() > eventDto.getMaxPrice() && eventDto.getMaxPrice() != 0) {
            errors.rejectValue("basePrice", "wrongValue", "basePrice is wrong");
            errors.rejectValue("maxPrice", "wrongValue", "basePrice is wrong");     // rejectValue 필드 에러
            errors.reject("wrongPrices", "Values for prices are wrong");               // reject 글로벌 에러
        }

        LocalDateTime endEventTime = eventDto.getEndEventTime();
        if (endEventTime.isBefore(eventDto.getBeginEventTime()) ||
                endEventTime.isBefore(eventDto.getCloseEnrollmentDateTime()) ||
                endEventTime.isBefore(eventDto.getBeginEnrollmentDateTime())) {
            errors.rejectValue("endEventTime", "wrongValue", "endEventTime is wrong");
        }
    }

    // TODO: 2020-06-12 beginEventTime
    // TODO: 2020-06-12 closeEnrollmentDateTime
}
