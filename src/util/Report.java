package util;

import java.util.List;
import java.time.LocalDate;

public class Report {
    private String reportType;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Transaction> transactions;

    public Report(String reportType, String startDateString, String endDateString, List<Transaction> transactions) {
        this.reportType = reportType;
        this.startDate = LocalDate.parse(startDateString);
        this.endDate = LocalDate.parse(endDateString);
        this.transactions = transactions;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
