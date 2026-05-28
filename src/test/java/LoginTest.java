import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {  //check if basic UI log in brings user to logged in application
//note that java function must be running first -- java -jar C:\Users\luqui\Documents\Cyan-Resumes\MinistryOfTesting\mot-cert-support-app-java-trunk\target\mot-cert-support-app-java-0.1-exec.jar

    @Test
    public void testPageUpdatesToProjectPageAfterLogin() {
        WebDriverManager.chromedriver().setup(); //downloads / sets up driver library that connects to browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver_var = new ChromeDriver(); //start new ChromeDriverobject and tie to driver_var variable
        driver_var.get("http://localhost:8080"); //launch our browser app
        driver_var.findElement(By.name("email")).sendKeys("admin@test.com"); //find email field and enter value
        driver_var.findElement(By.name("password")).sendKeys("password123"); //find pw field and enter value
        driver_var.findElement(By.cssSelector("button")).click(); // execute the submit button to log in
        WebDriverWait wait = new WebDriverWait(driver_var, Duration.ofSeconds(10)); // wait up to 10 seconds in case page is slow to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-title"))); //wait for element to be visible on new (loading) page
        String logged_in_title_var = driver_var.findElement(By.cssSelector(".card-title")).getText(); //find a specific element on page and extract the text

        assertEquals("Projects", logged_in_title_var); //confirm the element text matches "Projects"

        driver_var.close();
        driver_var.quit();
    }

}
