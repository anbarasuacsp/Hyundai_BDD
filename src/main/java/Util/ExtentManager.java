package Util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("src/main/java/reports/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(reporter);
            reporter.config().setReportName("Automation Test Report");
            reporter.config().setDocumentTitle("Test Results");
        }
        return extent;
    }
}
