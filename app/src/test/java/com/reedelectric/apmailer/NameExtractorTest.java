package com.reedelectric.apmailer;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

public class NameExtractorTest {
    @Test
    void extractsName() throws IOException {
        File pdfFile = new File("src/test/resources/single_page_statement.pdf");
        NameExtractor extractor = new NameExtractor();
        String name = extractor.extract(pdfFile.toPath());
        assertEquals("KINDER MORGAN (4) BULK TERM INC", name, "Wrong/no name extracted" );
    }

    @Test
    void extractsNull() throws IOException {
        File pdfFile = new File("src/test/resources/blank.pdf");
        NameExtractor extractor = new NameExtractor();
        String name = extractor.extract(pdfFile.toPath());
        assertNull(name, "Extracting customer name from PDF with no name should return null");
    }

}
