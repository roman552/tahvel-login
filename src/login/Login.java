package login;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    static private WebDriver driver;
    //50309183710

    public static void login(String isikukood) {
        
        if(!(isikukood.length() == 11)) {
            System.out.println("enter isikukood!");
            return;
        }
        
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get("https://tahvel.edu.ee/");
        
        WebElement loginBtn = driver.findElements(By.className("md-button")).get(2);
        loginBtn.click();
        
        WebElement smartIdBtn = driver.findElements(By.className("md-tab-markup")).get(1);
        smartIdBtn.click();
        
        WebElement loginSmartIdBtn = driver.findElements(By.className("md-raised")).get(3);
        loginSmartIdBtn.click();
        
        WebElement smartIdOptionBtn = driver.findElements(By.className("c-tab-login__nav-link")).get(2);
        smartIdOptionBtn.click();
        
        WebElement isikukoodInput = driver.findElement(By.id("sid-personal-code"));
        isikukoodInput.sendKeys("", isikukood);
        
        WebElement smartIdLoginBtn = driver.findElements(By.className("c-btn--primary")).get(2);
        smartIdLoginBtn.click();
    }
}
