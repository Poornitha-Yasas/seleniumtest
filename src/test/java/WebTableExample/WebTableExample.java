package WebTableExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableExample {

    WebDriver driver;

    @BeforeMethod
    public void openTablePage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @Test
    public void webTableTest() throws InterruptedException {
        //How many rows in the table

        int rowCount = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
        System.out.println("Row Count is : " + rowCount);

        //How many columns in the table

        int columnCount = driver.findElements(By.xpath("//table[@id='productTable']/thead/tr/th")).size();
        System.out.println("Column Count is : " + columnCount);

        //Retrieve the specific row/column data

        String value = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[3]/td[3]")).getText();
        System.out.println("Specific row/column data is : " + value);

        //Retrieve all the data from table

        for (int i = 1; i <= rowCount; i++) { //Rows
            for (int j = 1; j < columnCount; j++) { //Columns
                String tableData = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
                System.out.print(tableData + "   ");
            }
            System.out.println();
        }

        //Print ID anda Name only
            //find the product Price,which name related to product 3
        for (int i = 1; i <= rowCount; i++) {
            String tableID = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[1]")).getText();
            String productName = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[2]")).getText();
            System.out.println("TableID : " + tableID + " Product Name : " + productName);

            if (productName.equals("Tablet")){
                String productPrice = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[3]")).getText();
                System.out.println("Relevant product price : " + productPrice);
                break;
            }

        }

        //Select all the checkboxes

        int pageCount = driver.findElements(By.xpath("//ul[@id='pagination']/li")).size();
        List<WebElement> pages =  driver.findElements(By.xpath("//ul[@id='pagination']/li"));

        for (int k = 0; k < pageCount; k++) {
            pages.get(k).click();
            Thread.sleep(1000);
            for (int i = 1; i <= rowCount; i++) {
                boolean atb = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[4]/input")).isSelected();
                if (!atb) {
                    driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[4]/input")).click();
                    Thread.sleep(300);
                }
            }
        }

        //Select one checkbox

        int tblRow = 1;
        driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+tblRow+"]/td[4]/input")).click();


        driver.quit();
    }
}