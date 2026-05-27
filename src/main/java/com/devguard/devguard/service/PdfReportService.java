package com.devguard.devguard.service;

import com.devguard.devguard.dto.FileReport;
import com.devguard.devguard.dto.ScanResponse;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class PdfReportService {

    public byte[] generatePdf(ScanResponse response) throws Exception {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, out);
        document.open();

        document.add(new Paragraph("DevGuard Scan Report"));
        document.add(new Paragraph("Total Files: " + response.getTotalFiles()));
        document.add(new Paragraph("Total Findings: " + response.getTotalFindings()));
        document.add(new Paragraph("Risk Score: " + response.getRiskScore()));
        document.add(new Paragraph(" "));

        for (FileReport file : response.getFiles()) {
            document.add(new Paragraph("File: " + file.getFileName()));

            file.getFindings().forEach(f -> {
                try {
                    document.add(new Paragraph(
                            " - " + f.getType() + " (" + f.getSeverity() + ")"
                    ));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            document.add(new Paragraph(" "));
        }

        document.close();

        return out.toByteArray();
    }
}