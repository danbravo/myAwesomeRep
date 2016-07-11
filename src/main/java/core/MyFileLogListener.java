package core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

public class MyFileLogListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Path report = Paths.get("D:\\projects\\Consilium\\reports\\FailedTest_" +
                LocalDateTime.now().toString().replace(":", "-")
                + ".txt");

        Charset charset = Charset.forName("UTF-8");
        try (BufferedWriter writer = Files.newBufferedWriter(report, charset, StandardOpenOption.CREATE)) {
            writer.write("Time: " + new Date(System.currentTimeMillis()) + "\n");
            writer.write("Test '" + iTestResult.getName() + "' FAILED" + "\n");
            writer.write("Class: " + iTestResult.getTestClass() + "\n");
            writer.write("Priority of method: " + iTestResult.getMethod().getPriority() + "\n");
            writer.write("Methods depended upon: " + Arrays.toString(iTestResult.getMethod().getMethodsDependedUpon()) + "\n");
            writer.newLine();
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        String fileName = iTestResult.getMethod().getMethodName() + "_" + LocalDateTime.now().toString().replace(":", "-");
        takeScreenshot(fileName);
        AllureAttachments.saveImageAttach("Failure screenshot attachment", "D:\\projects\\Consilium\\screens\\"+fileName+".png");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Path report = Paths.get("D:\\projects\\Consilium\\reports\\SkippedTest_" +
                LocalDateTime.now().toString().replace(":", "-")
                + ".txt");

        Charset charset = Charset.forName("UTF-8");
        try(BufferedWriter writer = Files.newBufferedWriter(report, charset, StandardOpenOption.CREATE)) {
            writer.write("Time: " + new Date(System.currentTimeMillis()) + "\n");
            writer.write("Test '" + iTestResult.getName() + "' SKIPPED" + "\n");
            writer.write("Class: " + iTestResult.getTestClass() + "\n");
            writer.write("Priority of method: " + iTestResult.getMethod().getPriority() + "\n");
            writer.write("Methods depended upon: " + Arrays.toString(iTestResult.getMethod().getMethodsDependedUpon()) + "\n");
            writer.newLine();
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    private void takeScreenshot(String fileName) {
        File scrFile = ((TakesScreenshot)MethodsFact.driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File("D:\\projects\\Consilium\\screens\\"+fileName+".png"));
        } catch (IOException e) {
            System.err.println("Unable to create a screenshot" + e.getMessage());
        }
    }
}
