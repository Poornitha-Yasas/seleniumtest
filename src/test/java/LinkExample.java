import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkExample {

    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/dashboard.xhtml");
    }

    @Test
    public void LinkTest(){
        //Take me to dashboard
        WebElement homelink = driver.findElement(By.partialLinkText("Dashboard"));
        homelink.click();
        driver.navigate().back();


        //Find my destination
        WebElement wheretogo = driver.findElement(By.partialLinkText("Find the URL"));
        String path = wheretogo.getAttribute("href");
        System.out.println("This link is going to : " + path);


        //Am i broke link
        WebElement brokenlink =driver.findElement(By.linkText("Broken?"));
        brokenlink.click();

        String title = driver.getTitle();
        if(title.contains("404")){
            System.out.println("This link is broken");
        }
        else {
            System.out.println("This link is not broken");
        }
        driver.navigate().back();


        //Duplicate Link
        WebElement homelink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homelink1.click();
        driver.navigate().back();


        //Count Page Links
        List<WebElement> countlinks = driver.findElements(By.tagName("a"));
        int pagelinkcount = countlinks.size();
        System.out.println("Number of links in full page : " + pagelinkcount);


        //Count Layout Links
        WebElement layoutelement = driver.findElement(By.className("layout-main-content"));
        List<WebElement> countoflayoutlinks = layoutelement.findElements(By.tagName("a"));
        System.out.println("Count of Layout link" + countoflayoutlinks.size());




    }
}
