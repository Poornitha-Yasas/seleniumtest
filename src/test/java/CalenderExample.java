import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class CalenderExample {

    WebDriver driver;

    @BeforeMethod
    public void openCalenderTestPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/");
        Thread.sleep(3000);
    }

    @Test
    public void calenderTest(){
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        //Method 1

//        WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
//        datePicker.sendKeys("07/02/2024");

        //Method 2
        WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
        datePicker.click();

        selectPastDate("2001", "May", "12");




    }

    public void selectFutureDate(String year, String month, String day){
        while (true){
            String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if (actualYear.equals(year) && actualMonth.equals(month)){
                break;
            }else {
                driver.findElement(By.xpath("//a[@title='Next']")).click();
            }
        }

        List<WebElement> alldates =  driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));

        for (WebElement dateElemnt:alldates){
            if(dateElemnt.getText().equals(day)){
                dateElemnt.click();
                break;
            }
        }
    }

    public void selectPastDate(String year, String month, String day){
        while (true){
            String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if (actualYear.equals(year) && actualMonth.equals(month)){
                break;
            }else {
                driver.findElement(By.xpath("//a[@title='Prev']")).click();
            }
        }

        List<WebElement> alldates =  driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));

        for (WebElement dateElemnt:alldates){
            if(dateElemnt.getText().equals(day)){
                dateElemnt.click();
                break;
            }
        }
    }


}