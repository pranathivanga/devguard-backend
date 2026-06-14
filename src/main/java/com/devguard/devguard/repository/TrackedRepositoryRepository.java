package com.devguard.devguard.repository;

import com.devguard.devguard.model.TrackedRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackedRepositoryRepository
        extends JpaRepository<TrackedRepository, Long> {
}