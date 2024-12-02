import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownExample {

    WebDriver driver;

    @BeforeMethod
    public void dropdownTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void leafgrounddropdownTest() throws InterruptedException {


        //Select values in Basic dropdown

        driver.get("https://www.leafground.com/select.xhtml");
        WebElement dropdown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByVisibleText("Playwright");
        Thread.sleep(3000);

        //Get the number of dropdown options

        List<WebElement> listofOptions = select.getOptions();
        int size = listofOptions.size();
        System.out.println("Number of elemets in dropdown :" + size);

        for (WebElement element : listofOptions) {
            System.out.println(element.getText());
        }

        //Using sendkeys to select the dropdown value

        dropdown.sendKeys("Puppeteer");
        Thread.sleep(3000);

        //select value in a boostrap dropdown

        WebElement dropDown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropDown2.click();
        List<WebElement> listofdropdown2 = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));

        for (WebElement element : listofdropdown2) {
            String dropDownvalue= element.getText();
            if (dropDownvalue.equals("USA")) {
                element.click();
                break;
            }
        }
    }

    //Google Search - pick a value from suggestions

    @Test
    public void googlesearchdropdownTest() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Palitha");
        Thread.sleep(3000);
        List<WebElement> googlesearchlist = driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d']"));
        System.out.println(googlesearchlist.size());
        for (WebElement element : googlesearchlist) {
            System.out.println(element.getText());
        }
    }

    //Handle hidden auto suggestions dropdown and search using DOM Debugger Trick



}
