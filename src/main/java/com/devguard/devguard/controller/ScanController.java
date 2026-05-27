package com.devguard.devguard.controller;

import com.devguard.devguard.dto.CiResponse;
import com.devguard.devguard.model.ScanRecord;
import com.devguard.devguard.repository.ScanRepository;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

import com.devguard.devguard.dto.ScanRequest;
import com.devguard.devguard.dto.ScanResponse;
import com.devguard.devguard.service.ScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scan")
public class ScanController {

    @Autowired
    private ScanRepository repository;
    @Autowired
    private ScanService scanService;

    @PostMapping("/text")
    public ScanResponse scanText(@RequestBody ScanRequest request) {
        return scanService.scanText(request.getContent());
    }
    @PostMapping("/file")
    public ScanResponse scanFile(@RequestParam("file") MultipartFile file) throws IOException {

        String content = new String(file.getBytes());

        return scanService.scanText(content);
    }
    @GetMapping("/history")
    public List<ScanRecord> getHistory() {
        return repository.findAll();
    }
    @PostMapping("/ci")
    public CiResponse scanCI(@RequestBody ScanRequest request) {
        return scanService.scanForCI(request.getContent());
    }
    @PostMapping("/zip")
    public ScanResponse scanZip(@RequestParam("file") MultipartFile file) throws IOException {
        return scanService.scanZip(file);
    }
}