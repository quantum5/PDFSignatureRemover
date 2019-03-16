package xyz.quantum2;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PDFSignatureRemover {
    private static void help() {
        System.out.println("Usage: java -jar PDFSignatureRemover.jar <input PDF> <output PDF>");
        System.exit(1);
    }

    private static void error(String error) {
        System.err.println("Error when removing PDF signature: " + error);
        System.exit(1);
    }

    public static void main(String... args) {
        if (args.length != 2) {
            help();
        }

        File input = new File(args[0]);
        File output = new File(args[1]);

        if (!input.isFile()) {
            error("Input file not found: " + input);
        }

        PdfReader reader;
        try {
            reader = new PdfReader(input.toString());
        } catch (IOException e) {
            error("Failed to read input PDF: " + e);
            return;
        }

        try {
            AcroFields acroFields = reader.getAcroFields();
            for (String name : acroFields.getFields().keySet()) {
                acroFields.removeField(name);
            }

            try {
                PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(output));
                stamper.close();
            } catch (IOException | DocumentException e) {
                error("Failed to write output PDF: " + e);
            }
        } finally {
            reader.close();
        }
    }
}
