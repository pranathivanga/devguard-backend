package com.devguard.devguard.repository;

import com.devguard.devguard.model.ScanRecord;
import com.devguard.devguard.model.ScanRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScanRepository extends JpaRepository<ScanRecord,Long> {
}
