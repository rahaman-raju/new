package authenTication;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.DriverSetup_Login;

public class login_Search_Details extends DriverSetup_Login {

	@Test(description = "Login to the app with valid credentials", priority = 1)
	public void ValidEmail() throws InterruptedException {

		driver.findElement(By.id("username")).sendKeys("testuser");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("login-btn")).click();
		Thread.sleep(2000);

		WebElement result = driver.findElement(By.xpath("//div[contains(@class,'flex flex-col')]//h1[1]"));
		result.isDisplayed();
		String src = result.getText();
		System.out.println("Output is: " + src);

	}

	@Test(description = "Searching with different values", priority = 2)
	public void searchValue() throws InterruptedException {

		driver.findElement(By.id("username")).sendKeys("testuser");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("login-btn")).click();
		Thread.sleep(2000);
		try {
			try {
				WebElement src = driver.findElement(By.id("manga-search"));
				src.clear();
				src.sendKeys("Naruto");
				driver.findElement(By.xpath("//div[contains(@class,'w-full flex')]//button[1]")).click();

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement result = wait.until(
						ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Naruto')]")));

				// Verify that the search result containing "Naruto" is displayed
				if (result.isDisplayed()) {
					System.out.println("Search result for 'Naruto' is displayed.");
				} else {
					System.out.println("Search result for 'Naruto' is not displayed.");
				}

			} catch (Exception e) {

			}
			try {
				WebElement src = driver.findElement(By.id("manga-search"));
				src.clear();
				src.sendKeys("One Piece");
				driver.findElement(By.xpath("//div[contains(@class,'w-full flex')]//button[1]")).click();

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement result = wait.until(
						ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'One Piece')]")));

				if (result.isDisplayed()) {
					System.out.println("Search result for 'One Piece' is displayed.");
				} else {
					System.out.println("Search result for 'One Piece' is not displayed.");
				}

			} catch (Exception e) {

			}

			try {
				WebElement src = driver.findElement(By.id("manga-search"));
				src.clear();
				src.sendKeys("Seven Deadly Sins");
				driver.findElement(By.xpath("//div[contains(@class,'w-full flex')]//button[1]")).click();

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement result = wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Seven Deadly Sins')]")));

				if (result.isDisplayed()) {
					System.out.println("Search result for 'Seven Deadly Sins' is displayed.");
				} else {
					System.out.println("Search result for 'Seven Deadly Sins' is not displayed.");
				}

			} catch (Exception e) {

			}

			WebElement src = driver.findElement(By.id("manga-search"));
			src.clear();
			src.sendKeys("No manga found");
			driver.findElement(By.xpath("//div[contains(@class,'w-full flex')]//button[1]")).click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement result = wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'No manga found')]")));

			if (result.isDisplayed()) {
				System.out.println("Search result for 'No manga found' is displayed.");
			} else {
				System.out.println("Search result for 'No manga found' is not displayed.");
			}

		} finally {

		}

	}

	@Test(description="Manga details", priority=3)
	public void mangaDetails () throws InterruptedException{
		
		driver.findElement(By.id("username")).sendKeys("testuser");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("login-btn")).click();
		Thread.sleep(2000);
		
	try {
		//Image
		try {
		 WebElement overviewImage = driver.findElement(By.xpath("(//img[@alt='Attack on Titan'])"));
         String overviewImageUrl = overviewImage.getAttribute("src");

    
         WebElement viewDetailsLink = driver.findElement(By.xpath("(//p[contains(@class,'text-gray-600 text-sm')]//span)[1]"));
         viewDetailsLink.click();

         WebElement detailsImage = driver.findElement(By.xpath("(//img[@alt='Attack on Titan'])[2]"));
         String detailsImageUrl = detailsImage.getAttribute("src");

         
         if (overviewImageUrl.equals(detailsImageUrl)) {
             System.out.println("Images match!");
         } else {
             System.out.println("Images do not match!");
         }
         
         

     } catch (Exception e) {
        
     }
		driver.findElement(By.xpath("//button[normalize-space(text())='Close']")).click();
        Thread.sleep(2000);
		
		
		//Name
				try {
				 WebElement overviewName = driver.findElement(By.xpath("//h3[normalize-space(text())='Attack on Titan']"));
		         String overName = overviewName.getText();

		    
		         WebElement viewDetailsLink = driver.findElement(By.xpath("(//p[contains(@class,'text-gray-600 text-sm')]//span)[1]"));
		         viewDetailsLink.click();

		         WebElement detailsImage = driver.findElement(By.xpath("//div[contains(@class,'bg-white p-6')]//h3[1]"));
		         String detailsName = detailsImage.getText();

		         
		         if (overName.equals(detailsName)) {
		             System.out.println("Name match!");
		         } else {
		             System.out.println("Name is Not Matching");
		         }
		         
		         

		     } catch (Exception e) {
		        
		     }
				driver.findElement(By.xpath("//button[normalize-space(text())='Close']")).click();
		         Thread.sleep(2000);
				
				
				//Summary
				try {
				 WebElement overviewName = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[4]/p[1]"));
		         String overName = overviewName.getText();

		    
		         WebElement viewDetailsLink = driver.findElement(By.xpath("(//p[contains(@class,'text-gray-600 text-sm')]//span)[1]"));
		         viewDetailsLink.click();

		         WebElement detailsImage = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[3]/div[1]/p[1]"));
		         String detailsName = detailsImage.getText();

		         
		         if (overName.equals(detailsName)) {
		             System.out.println("Summary match!");
		         } else {
		             System.out.println("Summary Not Matching");
		         }
		        

		     } catch (Exception e) {
		        
		     }
				
				driver.findElement(By.xpath("//button[normalize-space(text())='Close']")).click();
		         Thread.sleep(2000);
		         
				//Close button
				try {
					
				driver.findElement(By.xpath("(//p[contains(@class,'text-gray-600 text-sm')]//span)[1]")).click();
					
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        WebElement modalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'fixed inset-0')]//div[1]")));
					
				WebElement closeButton = driver.findElement(By.xpath("//button[normalize-space(text())='Close']"));
	            closeButton.click();

	            boolean isModalClosed = wait.until(ExpectedConditions.invisibilityOf(modalElement));

	            // Output the result
	            if (isModalClosed) {
	                System.out.println("Close button works correctly. Modal is closed.");
	            } else {
	                System.out.println("Close button did not close the modal.");
	            }
	            
				}
	            catch (Exception e) {
			        
			     }
			     
			     
	}
		finally {}
	}

}

