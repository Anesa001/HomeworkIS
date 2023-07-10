package core;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Invoice {
    private Order order;

    public Invoice(Order order) {
        this.order = order;
    }

    public void generatePDF(String filePath) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            document.add(new Paragraph("Invoice"));
            document.add(new Paragraph("Order ID: " + order.getId()));
            document.add(new Paragraph("Order Date: " + order.getOrderDate()));
            document.add(new Paragraph("User: " + order.getUser().getUsername()));
            // Add more invoice details as needed
            document.close();
            System.out.println("Invoice generated successfully.");
        } catch (DocumentException | IOException e) {
            System.out.println("Error generating invoice: " + e.getMessage());
        }
    }
}

