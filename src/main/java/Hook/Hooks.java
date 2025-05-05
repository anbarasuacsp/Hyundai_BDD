package Hook;

import BaseClass.DriverFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.*;

public class Hooks {
    private static ExtentReports extent;
    private static ExtentTest test;
    @BeforeAll
    public static void setupReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Environment", "QA");
    }
    @Before
    public void setUp(Scenario scenario) {
        DriverFactory.initDriver();
        test = extent.createTest(scenario.getName());
    }
    @AfterStep
    public void logStep(Scenario scenario) {
        if (scenario.isFailed()) {
            test.fail("Step failed");
        } else {
            test.pass("Step passed");
        }
    }
    @After
    public void tearDown(Scenario scenario) {
        test.info("Scenario completed: " + scenario.getStatus());
        DriverFactory.quitDriver();
    }
    @AfterAll
    public static void flushReport() {
        extent.flush();
    }
}
