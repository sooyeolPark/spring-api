package com.jmc.springapi.test.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.jmc.springapi.test.domain.Test;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class TestDto {
    @Data
    @NoArgsConstructor
    public static class TestResponse {
        private Long id;
        private int testInt;
        private String testContents;
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        private LocalDateTime createdAt;
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        private LocalDateTime updatedAt;
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        private LocalDateTime deletedAt;
        @Builder
        public TestResponse(Long id, int testInt, String testContents,
                         LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
            this.id = id;
            this.testInt = testInt;
            this.testContents = testContents;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
            this.deletedAt = deletedAt;
        }

        public static TestResponse of(Test test) {
            return TestResponse.builder()
                    .id(test.getId())
                    .testInt(test.getTestInt())
                    .testContents(test.getTestContents())
                    .createdAt(test.getCreatedAt())
                    .updatedAt(test.getUpdatedAt())
                    .deletedAt(test.getDeletedAt())
                    .build();
        }
    }
}
