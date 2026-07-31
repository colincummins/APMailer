package com.reedelectric.apmailer;

import java.io.IOException;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class IdExtractor {
    private static final Pattern ID_PATTERN = Pattern.compile("Bill to:\\s*(.+?)Customer ID:");

    public String extract(Path pdfPath) throws IOException {
        try (PDDocument document = Loader.loadPDF(pdfPath.toFile())) {
            return extract(document);
        }
    }

    public String extract(PDDocument document) throws IOException {
        PDFTextStripper stripper = new PDFTextStripper();
        Matcher matcher = ID_PATTERN.matcher(stripper.getText(document));
        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        return null;
    }
}
