import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {

    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage() throws InterruptedException {

//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setBrowserVersion("130");
//        chromeOptions.addArguments("--start-maximized");
//        chromeOptions.addArguments("--incognito");
//        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
        Thread.sleep(2000);
    }

    @Test
    public void TextBoxTests() {

        //Type Name
        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Poornitha Yasas");

        //Append Country to this City
        WebElement appendText = driver.findElement(By.id("j_idt88:j_idt91"));
        appendText.sendKeys("Sri Lanka");

        //Verify if textbox is disabled
        boolean enabled= driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is Text Box enabled" + enabled);

        //Clear the type text
        WebElement clearText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        clearText.clear();

        //Retrieve the type Text
        WebElement textElement = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = textElement.getAttribute("value");
        System.out.println(value);

        //Type email and Tab.Confirm control moved to next element.
        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("Poornithayasasx0@gmail.com" + Keys.TAB + "Confirmed Control moved to next element");


    }

}
