package co.edu.unisabana.promesa;

import java.util.concurrent.CompletableFuture;

public class SalesReportService {

    public CompletableFuture<String> downloadReport(int year, int month) {
        CompletableFuture<String> promise = new CompletableFuture<>();

        Thread thread = new Thread(() -> {
            try {
                // Simulate a long download by sleeping for a few seconds
                Thread.sleep(5000);

                // Download the report from the remote server and return the data
                String reportData = XMLParse.downloadFromServer(year, month);
                promise.complete(reportData);
            } catch (Exception e) {
                promise.completeExceptionally(e);
            }
        });

        thread.start();

        return promise;
    }
}
