package com.reedelectric.apmailer;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

public class PDFProcessor {
    void split(Path inputPath, Path outputDirectory) throws IOException {
        Objects.requireNonNull(inputPath, "inputPath");
        Objects.requireNonNull(outputDirectory, "outputDirectory");
        Splitter splitter = new Splitter();
        PDDocument sourcePdf = Loader.loadPDF(inputPath.toFile());
        List<PDDocument> pages = splitter.split(sourcePdf);
        // TODO: Save them
        // TODO: Return the paths

    }

}
