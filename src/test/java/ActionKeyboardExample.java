import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionKeyboardExample {

    WebDriver driver;

    @BeforeMethod
    public void keyboardOperationsTestBrowserOpen(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void keyboardActionsTest1() throws InterruptedException {
        driver.get("https://www.google.com");
        WebElement googleSearchTextBox = driver.findElement(By.name("q"));
        googleSearchTextBox.sendKeys("Welcome");

        Actions action = new Actions(driver);
        //select text
//        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
//
//        Thread.sleep(5000);
//
//        action.keyDown(Keys.SHIFT)
//                .sendKeys("write capital letters").perform();
//        Thread.sleep(5000);
//                action.keyUp(Keys.SHIFT)
//                .keyDown(Keys.CONTROL)
//                .sendKeys("a")
//                .keyUp(Keys.CONTROL)
//                .keyDown(Keys.CONTROL)
//                .sendKeys("x")
//                .perform();


        //To Write in capital in a textbox

        action.keyDown(googleSearchTextBox,Keys.SHIFT)
                .sendKeys("write capital letters").perform();
    }



    @Test
    public void keyboardActionsTest2() throws InterruptedException {
        driver.get("https://www.leafground.com/list.xhtml");
        Thread.sleep(4000);

        List<WebElement> selectable =  driver.findElements(By.xpath("//ul[@aria-label='From']/li"));
        int size = selectable.size();
        System.out.println("Li count is :" +size);

        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL)
                .click(selectable.get(0))
                .click(selectable.get(1))
                .click(selectable.get(2))
                .perform();
    }
}
