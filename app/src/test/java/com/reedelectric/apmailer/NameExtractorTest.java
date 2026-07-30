package com.reedelectric.apmailer;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.Test;

public class NameExtractorTest {
    @Test
    void displayContents() throws IOException {
        File pdfFile = new File("src/test/resources/single_page_statement.pdf");
        try (PDDocument target = Loader.loadPDF(pdfFile)) {
            PDFTextStripper stripper = new PDFTextStripper();
            System.out.println(stripper.getText(target));

        }

    }


}
