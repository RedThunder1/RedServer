package redserver.redserver.commands.report.manager;

import java.util.UUID;

public class ReportForm {

    private String reporterName;
    private String reportedName;
    private String reason;
    public UUID id;

    public ReportForm(String reporterName, String reportedName, String reason, UUID id) {
        this.reporterName = reporterName;
        this.reportedName = reportedName;
        this.reason = reason;
        this.id = id;
    }

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public String getReportedName() {
        return reportedName;
    }

    public void setReportedName(String reportedName) {
        this.reportedName = reportedName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public UUID getReportId() {return id;}

    public void setId(UUID id) {this.id = id;}
}
