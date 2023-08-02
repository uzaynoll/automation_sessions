package Utils;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {
    WebDriver driver;
    public Helper(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot(){
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Path path = Path.of("D:\\automation_sessions\\src\\main\\Screenshots");
            if(Files.notExists(path)){
                new File("D:\\automation_sessions\\src\\main\\Screenshots").mkdirs();
            }
            SimpleDateFormat df = new SimpleDateFormat("ddMMyyyyHHmmss");
            String timeStamp = df.format(new Date());

            File file = new File("D:\\automation_sessions\\src\\main\\Screenshots");
            long diff = new Date().getTime() - file.lastModified();
            if (diff >  24 * 60 * 60 * 1000) {
                file.delete();
            }

            FileUtils.copyFile(screenshot, new File("D:\\automation_sessions\\src\\main\\Screenshots\\"+timeStamp+".png"));
            System.out.println("Screenshot created");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public boolean verifyPageLoadingCompleted() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        return javascriptExecutor.executeScript("return document.readyState").toString().equalsIgnoreCase("complete");
    }
}
