package com.study.demoinflearnrestapi.event;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

// Junit4 의 경우
// @Runwith(JunitParamsRunner.class)
class EventTest {

    @Test
    void builder(){
        Event event = Event.builder()
                .name("Inflearn Spring REST API")
                .description("REST API development with Spring")
                .build();
        assertThat(event).isNotNull();
    }

    @Test
    void javaBean(){
        // given
        String name = "Event";
        String description = "Spring";

        // when
        Event event = new Event();
        event.setName(name);
        event.setDescription(description);

        // then
        assertThat(event.getName()).isEqualTo(name);
        assertThat(event.getDescription()).isEqualTo(description);
    }

    // Junit4 에서는 JunitParams 의존성을 받아서 사용하면 된다.
    // @Parameters({"0,0,true", "100,0,false", "0,100,false"})
    // @Parameters(method = "paramsForTestFree)
    @ParameterizedTest
    @CsvSource(value = {"0,0,true", "100,0,false", "0,100,false"})
    void testFree(int basePrice, int maxPrice, boolean isFree) {
        // given
        Event event = Event.builder()
                .basePrice(basePrice)
                .maxPrice(maxPrice)
                .build();

        // when
        event.update();

        // then
        assertThat(event.isFree()).isEqualTo(isFree);
    }

// Junit4 의 경우
//    private Object[] parametersForTestFree(){
//        return new Object[] {
//                new Object()[] {0,0,true},
//                new Object()[] {100,0,false},
//                new Object()[] {0,100,false},
//                new Object()[] {100,200,false}
//        };
//    }
    
    @Test
    void testOffline(){
        // given
        Event event = Event.builder()
                .location("강남역 네이버 D2 스타텁 팩토리")
                .build();

        // when
        event.update();

        // then
        assertThat(event.isOffline()).isTrue();

        // given
        event = Event.builder()
                .build();

        // when
        event.update();

        // then
        assertThat(event.isOffline()).isFalse();
    }
}

