package com.jmc.springapi.test.repository;

import com.jmc.springapi.test.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}

