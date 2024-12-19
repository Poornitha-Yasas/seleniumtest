package Screenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TakeScreenshotExample {

    WebDriver driver;

    @BeforeMethod
    public void openWebPage(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");
    }

    @Test
    public void takeScreenshotTest() throws IOException, AWTException {

        //Capture Screenshot of full web page

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(System.getProperty("user.dir")+"\\Screenshots\\" + "alertFullWebPage.png");
        FileHandler.copy(sourceFile,destinationFile);

        //Capture Screenshot of Section of a web page

        WebElement section1pageElement = driver.findElement(By.xpath("//*[@id='j_idt88']/div/div[1]"));
        File source = section1pageElement.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir")+"\\Screenshots\\" + "alert-sectionWebPage.png");
        FileUtils.copyFile(source, target);

        //Capture Screenshot of an Element on a page

        WebElement elementofPage = driver.findElement(By.xpath("//*[@id='j_idt88']/div/div[1]/div[1]"));
        File source1 = elementofPage.getScreenshotAs(OutputType.FILE);
        File target1 = new File(System.getProperty("user.dir")+"\\Screenshots\\" + "alert-elementofWebPage.png");
        FileUtils.copyFile(source1, target1);

        //Capture Screenshot of full entire screen

        WebElement alertBox = driver.findElement(By.id("j_idt88:j_idt91"));
        alertBox.click();

        Robot robot = new Robot();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(screenSize);
        BufferedImage source2 = robot.createScreenCapture(rectangle);
        File destinationFile2 = new File(System.getProperty("user.dir")+"\\Screenshots\\" + "alertPageEntireScreen.png");
        ImageIO.write(source2, "png", destinationFile2);

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
