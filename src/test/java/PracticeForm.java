import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeForm {

    WebDriver driver;


    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");

    }

    @Test
    public void validFormSubmission() throws InterruptedException {

        //First Name
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Poornitha");

        //Last Name
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Yasas");

        //Email
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("yasas@gmail.com");

        //Gender select
        WebElement gender = driver.findElement(By.xpath("//label[normalize-space()='Male']"));
        gender.click();

        //Mobile Number
        WebElement mobileNumber = driver.findElement(By.id("userNumber"));
        mobileNumber.sendKeys("0766889001");

        //DOB
        WebElement dateofBirth = driver.findElement(By.id("dateOfBirthInput"));
        dateofBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        dateofBirth.sendKeys("12 Nov 2001");

        //Subject
        WebElement subject = driver.findElement(By.id("subjectsContainer"));
        subject.click();
        WebElement inputField = driver.findElement(By.id("subjectsInput"));
        inputField.click();
        inputField.sendKeys("English");
        inputField.sendKeys(Keys.ENTER);

        //Hobbies
        WebElement sportsCheckBox = driver.findElement(By.xpath("//label[normalize-space()='Sports']"));
        sportsCheckBox.click();
        WebElement readingCheckBox = driver.findElement(By.xpath("//label[normalize-space()='Reading']"));
        readingCheckBox.click();
        WebElement musicCheckBox = driver.findElement(By.xpath("//label[normalize-space()='Music']"));
        musicCheckBox.click();

        //Picture
        String data = "C:\\Users\\ASUS\\Downloads\\sample.jpg";
        WebElement uploadUsingSendKeys = driver.findElement(By.id("uploadPicture"));
        uploadUsingSendKeys.sendKeys(data);

        //Current Address
        WebElement address = driver.findElement(By.id("currentAddress"));
        address.sendKeys("318/01,01,Lihini Gardens,Gonamadiththa,Piliyandala");

        //State and City
        WebElement stateOption = driver.findElement(By.id("state"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stateOption);
        stateOption.click();
        WebElement state = driver.findElement(By.xpath("//*[@id='react-select-3-option-2']"));
        state.click();

        WebElement cityOption = driver.findElement(By.id("city"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cityOption);
        cityOption.click();
        WebElement city = driver.findElement(By.xpath("//*[@id='react-select-4-option-1']"));
        city.click();

        //Submit Btn
        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();
        Thread.sleep(5000);  //For clear visible user details

        //Close Btn
        WebElement closeBtn = driver.findElement(By.id("closeLargeModal"));
        closeBtn.click();

    }

    @Test
    public void mandatoryValidation() {

        //Email
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("yasas@gmail.com");

        //DOB
        WebElement dateofBirth = driver.findElement(By.id("dateOfBirthInput"));
        dateofBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        dateofBirth.sendKeys("12 Nov 2001");

        //Subject
        WebElement subject = driver.findElement(By.id("subjectsContainer"));
        subject.click();
        WebElement inputField = driver.findElement(By.id("subjectsInput"));
        inputField.click();
        inputField.sendKeys("English");
        inputField.sendKeys(Keys.ENTER);

        //Hobbies
        WebElement sportsCheckBox = driver.findElement(By.xpath("//label[normalize-space()='Sports']"));
        sportsCheckBox.click();
        WebElement readingCheckBox = driver.findElement(By.xpath("//label[normalize-space()='Reading']"));
        readingCheckBox.click();
        WebElement musicCheckBox = driver.findElement(By.xpath("//label[normalize-space()='Music']"));
        musicCheckBox.click();

        //Picture
        String data = "C:\\Users\\ASUS\\Downloads\\sample.jpg";
        WebElement uploadUsingSendKeys = driver.findElement(By.id("uploadPicture"));
        uploadUsingSendKeys.sendKeys(data);

        //Current Address
        WebElement address = driver.findElement(By.id("currentAddress"));
        address.sendKeys("318/01,01,Lihini Gardens,Gonamadiththa,Piliyandala");

        //State and City
        WebElement stateOption = driver.findElement(By.id("state"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stateOption);
        stateOption.click();
        WebElement state = driver.findElement(By.xpath("//*[@id='react-select-3-option-2']"));
        state.click();

        WebElement cityOption = driver.findElement(By.id("city"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cityOption);
        cityOption.click();
        WebElement city = driver.findElement(By.xpath("//*[@id='react-select-4-option-1']"));
        city.click();

        //Submit Btn
        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();

    }

    @Test
    public void emailValidation() throws InterruptedException {
        WebElement email = driver.findElement(By.id("userEmail"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", email);
        email.sendKeys("yasasgmail.com");

        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
