package co.edu.unisabana.promesa;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;

public class XMLParse {
    public static String downloadFromServer(int year, int month) throws Exception {
        String fileName = "sales_report.xml";
        File file = new File("src/"+fileName);
        if (!file.exists()) {
            throw new Exception("Sales report file not found: " + fileName);
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);
        NodeList reports = doc.getElementsByTagName("sales_report");

        for (int i = 0; i < reports.getLength(); i++) {
            Node report = reports.item(i);
            Element reportElement = (Element) report;

            int reportYear = Integer.parseInt(reportElement.getAttribute("year"));
            String reportMonth = reportElement.getAttribute("month");

            if (reportYear == year && reportMonth.equalsIgnoreCase(MonthName.getMonthName(month))) {
                int monthSales = Integer.parseInt(reportElement.getElementsByTagName("month_sales").item(0).getTextContent());
                int monthRevenue = Integer.parseInt(reportElement.getElementsByTagName("month_revenue").item(0).getTextContent());

                StringBuilder sb = new StringBuilder();
                sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
                sb.append("<sales_report year=\"").append(year).append("\" month=\"").append(MonthName.getMonthName(month)).append("\">\n");
                sb.append("<month_sales>").append(monthSales).append("</month_sales>\n");
                sb.append("<month_revenue>").append(monthRevenue).append("</month_revenue>\n");
                sb.append("</sales_report>");

                return sb.toString();
            }
        }

        throw new Exception("Sales report not found for year " + year + " and month " + month);
    }
}

