package co.edu.unisabana.promesa;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.Scanner;

public class SalesReportConsole {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SalesReportService reportService = new SalesReportService();

        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();

        System.out.println("Downloading report...");

        reportService.downloadReport(year, month)
                .thenAccept(result -> {
                    // Parse the result as XML and extract the month_sales and month_revenue values
                    try {
                        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder builder = factory.newDocumentBuilder();
                        InputSource is = new InputSource(new StringReader(result));
                        Document doc = builder.parse(is);
                        Element root = doc.getDocumentElement();

                        int monthSales = Integer.parseInt(root.getElementsByTagName("month_sales").item(0).getTextContent());
                        int monthRevenue = Integer.parseInt(root.getElementsByTagName("month_revenue").item(0).getTextContent());

                        System.out.println("Sales for " + MonthName.getMonthName(month) + " " + year + ": " + monthSales);
                        System.out.println("Revenue for " + MonthName.getMonthName(month) + " " + year + ": $" + monthRevenue);
                    } catch (Exception e) {
                        System.err.println("Error parsing report data: " + e.getMessage());
                    }
                })
                .exceptionally(ex -> {
                    // Display the error message in the console
                    System.err.println("Error downloading report: " + ex.getMessage());

                    return null;
                });

        System.out.println("Download started. Waiting for result...");
    }
}