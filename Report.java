// Dependency Inversion.

// With problems :

public class Report {}

class HtmlReportWriter {
    public void writeReportToHtml(Report report) {
        System.out.println("Write Report To HTML.");
    }
}

class ReportGenerator {
    private HtmlReportWriter reportWriter = new HtmlReportWriter();

    public void generateReport(Report report) {
        reportWriter.writeReportToHtml(report);
    }
}

// The Solution : 

interface ReportWriter {
    void writeReport(Report report);
}

class HtmlReportWriter1 implements ReportWriter{

    @Override
    public void writeReport(Report report) {
        System.out.println("Write Report To HTML.");
    }

}

class CsvReportWriter implements ReportWriter {

    @Override
    public void writeReport(Report report) {
        System.out.println("Write Report To CSV.");
    }
    
}

class ReportGenerator1 {
    private ReportWriter reportWriter;

    public void generateReport(Report report) {
        reportWriter.writeReport(report);
    }

    public void setReportWriter(ReportWriter reportWriter) {
        this.reportWriter = reportWriter;
    }
}

// End Solution : 