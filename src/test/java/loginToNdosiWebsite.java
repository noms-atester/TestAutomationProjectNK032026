import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class loginToNdosiWebsite {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Test
    public void logintondosiwebsite(){
        driver.get("https://ndosisimplifiedautomation.vercel.app/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("( (//*[contains(normalize-space(text()), 'Login')])[1] )")).click();
        driver.findElement(By.id("login-email")).sendKeys("nktests@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("drows$ap");
        driver.findElement(By.xpath("//*[@id=\"login-submit\"]")).click();

        WebElement welcomeMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("dashboard-section"))
        );

        String dashboardText = welcomeMessage.getText();
        //System.out.print(dashboardText + "\n\n");
        //Assert.assertEquals(welcomeText, "Welcome back, Noms! \uD83D\uDC4B\n");
        String welcomeSubstring = "Welcome back, Noms!";

        // Assertion: checks if dashboardText contains the welcomeSubstring
        Assert.assertTrue(dashboardText.contains(welcomeSubstring), "The text did not contain the expected 'Welcome back' substring");

        // Asserting welcome text with regular expression if different user(s) logged in
        String dashboardWelcomeText = driver.findElement(By.xpath("//*[@class='dashboard-section']//child::h2")).getText();
        // System.out.print(dashboardWelcomeText + "\n");
        String welcomeWithNoEmoji = dashboardWelcomeText.substring(0, dashboardWelcomeText.indexOf("!") + 1);
        // System.out.print(welcomeWithNoEmoji);
        // Pattern: "Welcome back, " followed by any user's name until "!"
        Assert.assertTrue(welcomeWithNoEmoji.matches("Welcome back, .*!"));


        driver.findElement(By.xpath("( (//span[contains(normalize-space(text()), 'Learn')])[1] )")).click();
        driver.findElement(By.xpath("( (//*[contains(normalize-space(text()), 'Learning Materials')])[1] )")).click();
        driver.findElement(By.xpath("( (//*[contains(normalize-space(text()), 'Web Automation Basic Form')])[1] )")).click();
        driver.findElement(By.id("name")).sendKeys("Noms");
        driver.findElement(By.id("email")).sendKeys("nktests@gmail.com");
        driver.findElement(By.id("age")).sendKeys("25");
        Select selectGender = new Select(driver.findElement(By.id("gender")));
        selectGender.selectByValue("female");
        Select selectCountry = new Select(driver.findElement(By.id("country")));
        selectCountry.selectByValue("south-africa");
        Select selectExperience = new Select(driver.findElement(By.id("experience")));
        selectExperience.selectByValue("beginner");
        driver.findElement(By.id("skill-selenium")).click();
        driver.findElement(By.id("skill-testing")).click();
        String comment = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin mauris urna, semper quis risus ut, viverra blandit massa. Duis sed nulla at tellus sagittis lobortis.";
        driver.findElement(By.id("comments")).sendKeys(comment);
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("submit-btn")).click();

        WebElement formSubmittedMessage = driver.findElement(By.xpath("( (//*[contains(normalize-space(text()), 'Form Submitted!')])[1] )"));

        Assert.assertTrue(formSubmittedMessage.isDisplayed(), "Your form has been submitted successfully!");
    }

//    @Test
//    public void webAutomationBasicForm(){
//        driver.get("https://ndosisimplifiedautomation.vercel.app/");
//        driver.manage().window().maximize();
//
//        driver.findElement(By.xpath("( (//*[contains(normalize-space(text()), 'Login')])[1] )")).click();
//        driver.findElement(By.id("login-email")).sendKeys("nktests@gmail.com");
//        driver.findElement(By.id("login-password")).sendKeys("drows$ap");
//        driver.findElement(By.xpath("//*[@id=\"login-submit\"]")).click();
//
//        driver.findElement(By.xpath("( (//span[contains(normalize-space(text()), 'Learn')])[1] )")).click();
//        driver.findElement(By.xpath("( (//*[contains(normalize-space(text()), 'Learning Materials')])[1] )")).click();
//        driver.findElement(By.xpath("( (//*[contains(normalize-space(text()), 'Web Automation Basic Form')])[1] )")).click();
//        driver.findElement(By.id("name")).sendKeys("Noms");
//        driver.findElement(By.id("email")).sendKeys("nktests@gmail.com");
//        driver.findElement(By.id("age")).sendKeys("25");
////        driver.findElement(By.id("gender")).click();
//        Select selectGender = new Select(driver.findElement(By.id("gender")));
//        selectGender.selectByValue("female");
//        Select selectCountry = new Select(driver.findElement(By.id("country")));
//        selectCountry.selectByValue("south-africa");
//        Select selectExperience = new Select(driver.findElement(By.id("experience")));
//        selectExperience.selectByValue("beginner");
//        driver.findElement(By.id("skill-selenium")).click();
//        driver.findElement(By.id("skill-testing")).click();
//        String comment = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin mauris urna, semper quis risus ut, viverra blandit massa. Duis sed nulla at tellus sagittis lobortis.";
//        driver.findElement(By.id("comments")).sendKeys(comment);
//        driver.findElement(By.id("terms")).click();
//        driver.findElement(By.xpath("//*[@id=\"login-submit\"]")).click();
//
//        WebElement formSubmittedMessage = driver.findElement(By.xpath("( (//*[contains(normalize-space(text()), 'Form Submitted!')])[1] )"));
//
//        Assert.assertTrue(formSubmittedMessage.isDisplayed(), "Your form has been submitted successfully!");
//    }

    @AfterMethod
    public void teardown(){

        driver.quit();
    }
}
