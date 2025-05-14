import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Veeva {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oea16\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.veeva.com/");
        driver.manage().window().maximize();
        System.out.println("✅ Opened Veeva homepage");


        Thread.sleep(3000);
        WebElement about = driver.findElement(By.xpath(Locators.about));
        Actions actions = new Actions(driver);
        actions.moveToElement(about).perform();
        System.out.println("✅ Hovered over 'About Veeva' section");

        Thread.sleep(3000);
        WebDriverWait waitForCareers = new WebDriverWait(driver, 25);
        WebElement careers = waitForCareers.until(ExpectedConditions.elementToBeClickable(By.xpath(Locators.careers)));
        careers.click();
        System.out.println("✅ Clicked 'Careers' link");

        Thread.sleep(3000);
        String originalTab = driver.getWindowHandle();

        for (String newTab : driver.getWindowHandles()) {
            if (!newTab.equals(originalTab)) {
                driver.switchTo().window(newTab);
                break;
            }
        }
        Thread.sleep(3000);
        WebDriverWait waitForSearch = new WebDriverWait(driver, 25);
        WebElement searchJobs = waitForSearch.until(ExpectedConditions.elementToBeClickable(By.xpath(Locators.searchJobs)));
        searchJobs.click();
        System.out.println("✅ Clicked 'Search Jobs' button");

        Thread.sleep(3000);
        WebElement dropDown= driver.findElement(By.xpath(Locators.dropDown));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(dropDown).perform();
        dropDown.click();
        System.out.println("✅ Opened region dropdown");

        Thread.sleep(3000);
        WebElement unitedStates= driver.findElement(By.id("formRegion4"));
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(unitedStates).perform();
        unitedStates.click();
        System.out.println("✅ Selected 'United States' from region dropdown");

        Thread.sleep(3000);
        WebElement checkBox= driver.findElement(By.id("formRemote"));
        Actions actions3 = new Actions(driver);
        actions3.moveToElement(checkBox).perform();
        checkBox.click();
        System.out.println("✅ Checked the 'Remote' checkbox");

        Thread.sleep(3000);
        WebElement keywords= driver.findElement(By.xpath(Locators.keywords));
        keywords.sendKeys("Associate Quality Engineer");
        System.out.println("✅ Entered 'Associate Quality Engineer' in keyword search");

        Thread.sleep(3000);
        String pageText= driver.getPageSource();
        assertTrue(pageText.contains("Associate Quality Engineer"));
        assertTrue(pageText.contains("Remote"));
        assertTrue(pageText.contains("United States"));
        System.out.println("✅ All content validations passed");

        Thread.sleep(3000);
        driver.quit();
        System.out.println("✅ Browser closed");
        }
    }