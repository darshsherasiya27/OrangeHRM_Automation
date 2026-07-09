package com.orangehrm.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("test-output/ExtentReport.html");

            spark.config().setDocumentTitle("OrangeHRM Automation");

            spark.config().setReportName("Automation Test Report");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo("Tester", "Darsh Sherasiya");

            extent.setSystemInfo("Framework", "Selenium + TestNG");

            extent.setSystemInfo("Language", "Java");
            
            extent.setSystemInfo("OS", System.getProperty("os.name"));

            extent.setSystemInfo("Java Version",
                    System.getProperty("java.version"));

            extent.setSystemInfo("Browser", "Chrome");

        }

        return extent;

    }

}