package com.reedelectric.apmailer;

import java.io.IOException;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class NameExtractor {
    private static final Pattern NAME_PATTERN = Pattern.compile("Customer ID:\\R(.+)\\R");

    public String extract(Path pdfPath) throws IOException {
        try (PDDocument target = Loader.loadPDF(pdfPath.toFile())) {
            return extract(target);
        }
    }

    public String extract(PDDocument document) throws IOException {
        PDFTextStripper stripper = new PDFTextStripper();
        Matcher m = NAME_PATTERN.matcher(stripper.getText(document));
        if (m.find()) {
            return m.group(1).trim();
        }
        return null;
    }
}
