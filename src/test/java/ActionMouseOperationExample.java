import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionMouseOperationExample {

    WebDriver driver;

    @BeforeMethod
    public void mouseOperationTestBrowserOpen(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void MouseOperationTest() throws InterruptedException {
        driver.get("https://www.leafground.com/drag.xhtml");

        System.out.println("1) <<<<<<<<<<Move to an element operation>>>>>>>>>>");

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt37")))
        .moveToElement(driver.findElement(By.id("menuform:j_idt38")))
        .moveToElement(driver.findElement(By.id("menuform:j_idt39")))
        .moveToElement(driver.findElement(By.id("menuform:j_idt40")))
        .moveToElement(driver.findElement(By.id("menuform:j_idt41"))).perform();



        System.out.println("2) <<<<<<<<<<Move to an element operation>>>>>>>>>>");

        WebElement from = driver.findElement(By.id("form:drag"));
        WebElement to = driver.findElement(By.id("form:drop"));

//        actions.clickAndHold(from).moveToElement(to).release(to).perform(); //1st way
        actions.dragAndDrop(from,to).perform(); //2nd way


        System.out.println("3) <<<<<<<<<<Move to an element operation>>>>>>>>>>");

        WebElement sliderpoint1 = driver.findElement(By.xpath("//div[@id='form:j_idt125']/span[1]"));
        System.out.println("Location od sliderpoint 1 before moving :" + sliderpoint1.getLocation());
        actions.dragAndDropBy(sliderpoint1,50, 0).perform();
        System.out.println("Location od sliderpoint 1 after moving :" + sliderpoint1.getLocation());



        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        System.out.println("4) <<<<<<<<<<Right Click>>>>>>>>>>");

        WebElement rightClickButtonElement = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

        Actions action1 = new Actions(driver);
        actions.contextClick(rightClickButtonElement).perform();
        driver.findElement(By.xpath("//span[normalize-space()='Edit']")).click();
        Alert alertPop = driver.switchTo().alert();
        System.out.println("Alert Pop text as :" + alertPop.getText());
        alertPop.accept();


        driver.quit();

    }


}

