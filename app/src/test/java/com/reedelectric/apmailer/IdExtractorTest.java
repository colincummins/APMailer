package com.reedelectric.apmailer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

class IdExtractorTest {
    private final IdExtractor extractor = new IdExtractor();

    @Test
    void extractsId() throws IOException {
        Path pdfPath = Path.of("src/test/resources/single_page_statement.pdf");

        String id = extractor.extract(pdfPath);

        assertEquals("09950-1", id);
    }

    @Test
    void returnsNullWhenIdIsMissing() throws IOException {
        Path pdfPath = Path.of("src/test/resources/blank.pdf");

        String id = extractor.extract(pdfPath);

        assertNull(id);
    }
}
