package pl.kwi.intg;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;


public class InputIntgTestPage extends AbstrIntgTestPage{
		
	public InputIntgTestPage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
	}
	
	@Override
	public void checkIfPageLoaded() {
		
		// Wait
        wait.until(ExpectedConditions.textToBePresentInElement(By.id("title"), "Hello World"));
        
        // Conditions
        title = driver.getTitle();
        assertEquals("Hello World - Input", title);
        text = driver.findElement(By.id("title")).getText();
        assertEquals("Hello World", text); 
		
	}

}
