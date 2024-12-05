import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertExample {
    WebDriver driver;

    @BeforeMethod
    public void alertTestsPage(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");
    }

    @Test
    public void alertTest() throws InterruptedException {

        //Alert (Simple Dialog)

        WebElement alertBox = driver.findElement(By.id("j_idt88:j_idt91"));
        alertBox.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        alert.accept();

        //Alert (Confirm Dialog)

        WebElement confirmBox = driver.findElement(By.id("j_idt88:j_idt93"));
        confirmBox.click();
        Alert alert1 = driver.switchTo().alert();
        Thread.sleep(300);
        alert.dismiss();

        //Alert (Prompt Dialog)

        WebElement promptBox = driver.findElement(By.id("j_idt88:j_idt104"));
        promptBox.click();
        Alert alert2 = driver.switchTo().alert();
        Thread.sleep(300);
        String alertText = alert2.getText();
        System.out.println("Alert Text is :" + alertText);
        alert2.sendKeys("My name is Yasas");
        alert2.accept();

        driver.quit();

    }
}
