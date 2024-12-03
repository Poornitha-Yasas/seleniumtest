import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RadioCheckBoxExample {

    WebDriver driver;

    @BeforeMethod
    public void textBoxTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void radioTest(){

        //Find the default select radio button

        driver.get("https://www.leafground.com/radio.xhtml");
        boolean chromeradioOption = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean firefoxradioOption = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safariradioOption = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edgeradioOption = driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if (chromeradioOption){
            String chromeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.println("Default select radio button is " + chromeText);
        } else if (firefoxradioOption){
            String firefoxText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            System.out.println("Default select radio button is " + firefoxText);
        }else if (safariradioOption){
            String safariText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.println("Default select radio button is " + safariText);
        }else if (edgeradioOption){
            String edgeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
            System.out.println("Default select radio button is " + edgeText);
        }

        //Select the age group only if not selected

        WebElement myAgegroup = driver.findElement(By.id("j_idt87:age:0"));
        boolean isChecked = myAgegroup.isSelected();
        if (!isChecked){
            //myAgegroup.click();

            driver.findElement(By.xpath("//label[@for='j_idt87:age:0']")).click();
        }


    }



    @Test
    public void checkboxTest(){

        //Select wanted checkboxes and verifying those checkboxes selected status
        driver.get("https://www.leafground.com/checkbox.xhtml");
        List<WebElement> chechBoxList =  driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        for (WebElement element : chechBoxList){
            if (!(element.getText().equals("Others"))){
                element.click();
            }
        }

        for (int i=1; i<=chechBoxList.size(); i++ ){
            boolean checkBoxStatus = driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)[" + i+ "]")).isSelected();
            System.out.println("Checkbox" + i + "Selected status is :" + checkBoxStatus);
        }

    }
}
