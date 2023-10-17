package com.jmc.springapi.test.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "test")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "test_int")
    private int testInt;

    @Column(name = "test_contents")
    private String testContents;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Builder
    public Test(int testInt, String testContents, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        this.testInt = testInt;
        this.testContents = testContents;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

}
