import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.Dimension;


import java.awt.*;

public class ButtonExample {

    WebDriver driver;

    @BeforeMethod
    public void buttonTestPage(){
        driver = new ChromeDriver();
        Dimension newSize = new Dimension(1280, 720);
        driver.manage().window().setSize(newSize);
//        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml");
    }

    @Test
    public void buttonTests(){
        //Click and confirm title

        driver.findElement(By.xpath("//*[@id='j_idt88:j_idt90']")).click();
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("Actual title is same as expected");
        }
        else {
            System.out.println("Actual title is not same as expected");
        }

//        Assert.assertEquals(actualTitle, expectedTitle,"Title doesn't match");

        //Find the position of the submit button

        driver.navigate().back();
        WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xyPoint = getPosition.getLocation();
        int x = xyPoint.getX();
        int y = xyPoint.getY();
        System.out.println("X Position is: " + x + " Y Position is: " + y);

        //Find the save button color

        WebElement buttonColor = driver.findElement(By.id("j_idt88:j_idt96"));
        String color = buttonColor.getCssValue("background-color");
        System.out.println("Button Color is: " + color);

        //Find the height and width of this button

        WebElement size = driver.findElement(By.id("j_idt88:j_idt98"));
        int height = size.getSize().getHeight();
        int width = size.getSize().getWidth();
        System.out.println("Height is: " + height + " Width is: " + width);

        driver.quit();





    }

}
