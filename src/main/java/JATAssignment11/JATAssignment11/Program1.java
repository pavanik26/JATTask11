package JATAssignment11.JATAssignment11;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Program1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
	       
	       // Initialize ChromeDriver with options
	       WebDriver driver = new ChromeDriver();
	       try {
        driver.get("https://the-internet.herokuapp.com/windows");
        
        // Maximize the window
        driver.manage().window().maximize();
        
        WebElement lnkClick = driver.findElement(By.xpath("//a[text()='Click Here']"));
        lnkClick.click();
        
        waitForElement(4000);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());

        // Switch to the new tab (the second tab)
        driver.switchTo().window(tabs.get(1));
        
        String text = driver.findElement(By.xpath("//h3")).getText();
        System.out.println("Text in new window: " + text);
        
        driver.close();
        waitForElement(4000);
        // Switch back to tab1
        driver.switchTo().window(tabs.get(0));
        
        // Verify tab1 is active
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://the-internet.herokuapp.com/windows")) { // Replace with your tab1 URL
            System.out.println("Original window is active.");
        } else {
            System.out.println("Original window is NOT active.");
        }

	       }finally {
	            driver.quit();
	       }
	}
	
	public static void waitForElement(int milliseconds)
   	{
   		try {
   			Thread.sleep(milliseconds);
   		} catch (InterruptedException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   	} 

}
