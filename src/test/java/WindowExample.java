import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowExample {

    WebDriver driver;

    @BeforeMethod
    public void windowTestPage(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/window.xhtml");
    }

    @Test
    public void windowTest() throws InterruptedException {

     //Click and confirm new Window Opens

        //First method


        String oldWindow = driver.getWindowHandle();
        System.out.println("Parent Window :" +oldWindow);

        WebElement openButton = driver.findElement(By.xpath("//*[@id='j_idt88:new']"));
        openButton.click();
        Thread.sleep(3000);

        Set<String> handles = driver.getWindowHandles();
        System.out.println("Handles Size :" +handles);

        for (String newWindow:handles){
            System.out.println(newWindow);
            driver.switchTo().window(newWindow);
            System.out.println("Page title is :" +driver.getTitle());

        }

        driver.close();

        driver.switchTo().window(oldWindow);


        WebElement openButton1 = driver.findElement(By.xpath("//*[@id='j_idt88:new']"));
        boolean openButtonVisibility = openButton1.isDisplayed();

        //Second method

//        List<String> list = new ArrayList<String>(handles);  //Converting set to List
//        if (list.size()>1){
//            driver.switchTo().window(list.get(1));
//            System.out.println("Page title is :" +driver.getTitle());
//            driver.close();
//            driver.switchTo().window(oldWindow);
//        }

     //Find the number of tabs open

        WebElement multiWindowButton = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt91']"));
        multiWindowButton.click();
        Thread.sleep(3000);

        Set<String> multiwindows = driver.getWindowHandles();
        int howmanywindows = multiwindows.size();
        System.out.println("No of Windows Open :" +howmanywindows);


     //Close all windows except Primary

        WebElement dontCloseButton = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt93']"));
        dontCloseButton.click();
        Thread.sleep(3000);

        Set<String> newWindowsHandle = driver.getWindowHandles();

        for (String allWindows : newWindowsHandle){
            if (!allWindows.equals(oldWindow)) {
                driver.switchTo().window(allWindows);
                driver.close();
            }
        }

        driver.switchTo().window(oldWindow);
        driver.close();

    }
}
