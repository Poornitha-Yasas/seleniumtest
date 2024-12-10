import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FrameExample {

    WebDriver driver;

    @BeforeMethod
    public void frameTestPage(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/frame.xhtml");
    }

    @Test
    public void frameTests(){
        //Click me (Inside Frame)


        driver.switchTo().frame(0);
        WebElement button1 = driver.findElement(By.xpath("//button[@id='Click']"));
        button1.click();

        String afterClickButtonText = button1.getText();
        System.out.println("After Click Button Text is :" +afterClickButtonText);

        //Click me (Inside Nested Frame)

        driver.switchTo().defaultContent();
        driver.switchTo().frame(2);
        driver.switchTo().frame("frame2");

        WebElement button3 = driver.findElement(By.id("Click"));
        button3.click();

        String afterClickNestedFrameButtonText = button3.getText();
        System.out.println("After Click Nested Frame Button Text is :" +afterClickNestedFrameButtonText);

        //How many frames in this page

        driver.switchTo().defaultContent();
        List<WebElement> getIframeTagCount =  driver.findElements(By.tagName("iframe"));
        int size = getIframeTagCount.size();
        System.out.println("Number of Frames in this page is :" +size);

        for (WebElement iframeElemet :getIframeTagCount){
            String framesrcAttributeValue = iframeElemet.getAttribute("src");
            System.out.println("Frame src Attribute Value is :" +framesrcAttributeValue);
        }



        driver.quit();



    }
}
