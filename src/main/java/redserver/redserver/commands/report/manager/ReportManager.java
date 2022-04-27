package redserver.redserver.commands.report.manager;

import java.util.ArrayList;
import java.util.UUID;

public class ReportManager {

    public ArrayList<ReportForm> reportForms;

    public ReportManager() { reportForms = new ArrayList<>(); }

    public void addReport(ReportForm reportForm) { reportForms.add(reportForm); }

    public void removeReport(ReportForm reportForm) { reportForms.remove(reportForm); }

    public ReportForm getReportFormByID(UUID id) {
        for(ReportForm reportForm : reportForms) {
            if(String.valueOf(reportForm.id).equals(String.valueOf(id))) { 
            	return reportForm; 
            }
        }
        
        return null;
    }



}
