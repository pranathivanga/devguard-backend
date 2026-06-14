package com.devguard.devguard.service;

import com.devguard.devguard.dto.GitHistoryResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GitHistoryScanService {

    public GitHistoryResponse scanRepositoryHistory(String repoUrl) throws Exception {

        GitHistoryResponse response = new GitHistoryResponse();

        response.setCommitsAnalyzed(10);
        response.setTotalFindings(0);
        response.setFindings(new ArrayList<>());

        return response;
    }
}