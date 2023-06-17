package util;

import java.util.Date;
import java.util.List;

public class Report {
private String reportType;
private Date startDate;
private Date endDate;
private List<Transaction> transactions;


public Report(String reportType, Date startDate, Date endDate, List<Transaction> transactions) {
    this.reportType = reportType;
    this.startDate = startDate;
    this.endDate = endDate;
    this.transactions = transactions;
}


public String getReportType() {
    return reportType;
}


public void setReportType(String reportType) {
    this.reportType = reportType;
}


public Date getStartDate() {
    return startDate;
}


public void setStartDate(Date startDate) {
    this.startDate = startDate;
}


public Date getEndDate() {
    return endDate;
}


public void setEndDate(Date endDate) {
    this.endDate = endDate;
}


public List<Transaction> getTransactions() {
    return transactions;
}


public void setTransactions(List<Transaction> transactions) {
    this.transactions = transactions;
}
}
