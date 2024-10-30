package JATAssignment11.JATAssignment11;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Program2 {
	
	public static void main(String[] args) {
		 // TODO Auto-generated method stub
		  WebDriverManager.chromedriver().setup();
		
	       
	       // Initialize ChromeDriver with options
	       WebDriver driver = new ChromeDriver();	     
   
        
        try {
            // Navigate to the nested frames page
            driver.get("http://the-internet.herokuapp.com/nested_frames");
            
            
            // Maximize the window
            driver.manage().window().maximize();
            waitForElement(4000);

            // Switch to the top frame
            driver.switchTo().frame("frame-top");

            // Find all frames within the top frame
            List<WebElement> frames = driver.findElements(By.tagName("frame"));

            // Get the count of frames
            int frameCount = frames.size();
            if(frameCount==3) {
            System.out.println("Number of frames in 'frame-top' is 3 ");
            }
            else
            {
            System.out.println("Number of frames in 'frame-top' is not 3");
            }
            
            // Switch to the left frame            
            driver.switchTo().frame("frame-left");
            
           // Wait for the body element to be visible and get its text
            WebElement leftFrameText = driver.findElement(By.tagName("body"));
            String leftText = leftFrameText.getText();

            
           // Verify the text in the left frame
            if (leftText.equals("LEFT")) {
                System.out.println("Verification passed: Left frame contains the text 'LEFT'.");
            } else {
                System.out.println("Verification failed: Left frame does not contain the text 'LEFT'.");
            }
          
         // Switch back to top frame   
         driver.switchTo().parentFrame();
         
         // Switch to the middle frame
         driver.switchTo().frame("frame-middle");        
     
         
         // Wait for the body element to be visible and get its text
         WebElement middleFrameText = driver.findElement(By.tagName("body"));
         String middleText = middleFrameText.getText();

         
        // Verify the text in the middle frame
         if (middleText.equals("MIDDLE")) {
             System.out.println("Verification passed: Middle frame contains the text 'MIDDLE'.");
         } else {
             System.out.println("Verification failed: Middle frame does not contain the text 'MIDDLE'.");
         } 
         
        // Switch back to top frame 
         driver.switchTo().parentFrame();
         
        // Switch to the right frame
         driver.switchTo().frame("frame-right");
         
        // Wait for the body element to be visible and get its text
         WebElement rightFrameText = driver.findElement(By.tagName("body"));
         String rightText = rightFrameText.getText();

         
        // Verify the text in the right frame
         if (rightText.equals("RIGHT")) {
             System.out.println("Verification passed: Right frame contains the text 'RIGHT'.");
         } else {
             System.out.println("Verification failed: Right frame does not contain the text 'RIGHT'.");
         }
         
         // Switch back to top frame 
         driver.switchTo().parentFrame();
         
         // Switch back to the main content
         driver.switchTo().defaultContent();
         
         // Switch to the bottom frame
         driver.switchTo().frame("frame-bottom");
         
        // Wait for the body element to be visible and get its text
         WebElement bottomFrameText = driver.findElement(By.tagName("body"));
         String bottomText = bottomFrameText.getText();

         
        // Verify the text in the bottom frame
         if (bottomText.equals("BOTTOM")) {
             System.out.println("Verification passed: Bottom frame contains the text 'BOTTOM'.");
         } else {
             System.out.println("Verification failed: Bottom frame does not contain the text 'BOTTOM'.");
         }
         
        // Switch back to the top frame
         driver.switchTo().parentFrame();
         
         //Verify page title
         String title = driver.getTitle();
         if (title=="Frames") {
             System.out.println("Page title is Frames");
         } else {
             System.out.println("Page title is not Frames");
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
