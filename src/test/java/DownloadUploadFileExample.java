import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class DownloadUploadFileExample {

    WebDriver driver;

    @BeforeMethod
    public void openFileTestPage() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test
    public void fileDownloadTest() throws InterruptedException {
        driver.get("https://www.leafground.com/file.xhtml");
        WebElement downloadButton = driver.findElement(By.id("j_idt93:j_idt95"));
        downloadButton.click();
        Thread.sleep(3000);

        File file = new File("C:\\Users\\ASUS\\Downloads");
        File[] totalFiles = file.listFiles();
        for (File findfile :totalFiles){
            if (findfile.getName().equals("TestLeaf Logo.png")){
                System.out.println("File is downloaded");
                break;
            }
        }



    }

    @Test
    public void fileUploadTest() throws AWTException, InterruptedException {
        driver.get("https://www.leafground.com/file.xhtml");

        //1st way - Using Robot Class
//        WebElement uploadButton = driver.findElement(By.id("j_idt88:j_idt89"));
//        uploadButton.click();
//
//        //Windows control begin
//
//        String data = "C:\\Users\\ASUS\\Downloads\\phases.png";
//        StringSelection selection = new StringSelection(data);
//
//        //Copy path to clipboard
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
//
//        Thread.sleep(3000);
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//
//        Thread.sleep(3000);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);


        //2nd way - Using sendkeys (Applicable only elemnt type is file)

        String data = "C:\\Users\\ASUS\\Downloads\\phases.png";

        WebElement uploadUsingSendKeys = driver.findElement(By.id("j_idt88:j_idt89_input"));
        uploadUsingSendKeys.sendKeys(data);
    }

}
