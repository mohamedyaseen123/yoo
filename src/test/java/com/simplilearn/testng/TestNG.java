package com.simplilearn.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class TestNG {
	
	WebDriver driver;
	
	  @BeforeSuite
	  public void beforeSuite() {
		  
		  System.setProperty("webdriver.chrome.driver", "/home/yaseenyazoutloo/Downloads/chromedriver.exe");
			driver = new ChromeDriver(); 
	  }


  @Test
  public void lunchapplication() throws InterruptedException {
	  


			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			driver.get("http://pizzahut.co.in/");
			System.out.println("Succesfull run the condition");

			//set_the_user_delivery_location_as_Lulu_Mall_Bangalore() {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@class='typography-5 search search--hut input border-0 py-15 px-10 min-w-50']")).sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@class='typography-5 search search--hut input border-0 py-15 px-10 min-w-50']")).sendKeys("lulu mall bangalore");
//			driver.findElement(By.xpath("//input[@class='typography-5 search search--hut input border-0 py-15 px-10 min-w-50']")).sendKeys("hosur road");


			// The user is now on the Deals page. Validate that the URL has text as ‘deals’() 
			//			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[4]/div/div/div/div[2]/form/div/div[2]/div/button[2]")).click();
					Thread.sleep(3000);

			driver.findElement(By.xpath("//div[@data-synth='offer-collection-hut']")).click();


			Thread.sleep(3000);
			String currentUrl = driver.getCurrentUrl();
			System.out.println(currentUrl);
			if (currentUrl.contentEquals("https://www.pizzahut.co.in/order/deals/")) {
				System.out.println("deals reflected");

			}else {
				System.out.println("deals not reflected");
			}
			//Go_to_sides_and_add_any_item_that_isbelow() 
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@data-synth='link--sides--side']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='button button--md button--green flex-1 font-semibold']")).click();
			//driver.findElement(By.xpath("//button[@data-synth='link--basket']")).click();
			//		Thread.sleep(5000);




			//Validate that the product is added under Basket but checkout button price item is still now showing() {
	         
			WebElement c = driver.findElement(By.xpath("//a[@data-synth='link--mexican-garlic-breadstix-single']"));
			String valid = c.getText();
			

			if(valid.contains("Mexican Garlic Breadstix")) {
				System.out.println("true");

			}else {
				System.out.println("false");
			}
			
			
			
			//NavigatetotheDrinkspage() {
			Thread.sleep(3000);

			driver.findElement(By.xpath("//a[@data-synth='link--drinks--side']")).click();

			//Add_any_two_drinks_so_that_total_cart_pricing_is_more_than_200() throws InterruptedException {


			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@data-synth='button--pepsi-600ml--one-tap']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@data-synth='button--pepsi-black-250ml--one-tap']")).click();

			//Click on the Checkout button. The user will be navigated to the checkout page();

			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@class='button button--primary  justify-between']")).click();
			Thread.sleep(2000);
			driver.get("https://www.pizzahut.co.in/order/checkout/");
			driver.findElement(By.xpath("//input[@placeholder='First name is fine']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@placeholder='First name is fine']")).sendKeys("Mohamed Yaseen");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@placeholder='So we can contact you']")).sendKeys("8220432782");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@placeholder='To send your confirmation']")).sendKeys("yaseenyaz@outlook.com");

			//Validate that the Online Payment radio button is selected by default
			WebElement radio = driver.findElement(By.xpath("//input[@id='payment-method--razorpay']"));
			if(radio.isEnabled()) {
				System.out.println("enable");

			}else {
				System.out.println("disable");

			}
			//Change the Payment option to Cash

			Thread.sleep(3000);
			WebElement cashOption = driver.findElement(By.xpath("//label[@data-synth='payment-method--cash-label']"));
			cashOption.click();

			//			Validate that the I agree checkbox is checked by default

			//driver.findElement(By.xpath("//label[@class='mb-30 block']")).click();
			Thread.sleep(2000);
			WebElement radio1 = driver.findElement(By.xpath("//input[@name='marketingOptIn']"));


			if(radio1.isEnabled()) {
				System.out.println("enable");

			}else {
				System.out.println("disable");

			}
			//Click on the Apply Gift Card link
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='w-full']")).click();

			//A pop up should appear. Click on the Voucher
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='sc-fznMnq gdZumo']")).click();
			// Give the Voucher code as 12345 and submit
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@name='voucherId']")).sendKeys("12345");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@type='submit']")).click();

			Thread.sleep(2000);
			//			Validate if an error is coming that the number is incorrect

			WebElement a = driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/form/div[2]/span"));
			String text = a.getText();
			System.out.println(text);

			if(text.contains("Sorry")) {
				System.out.println("true");

			}else {
				System.out.println("false");
			}
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='icon-remove-3 absolute top-0 right-0 mr-20 mt-20']")).click();
			//		The user should again navigate to your Basket page.
			
			
			WebElement b = driver.findElement(By.xpath("//h2[@class='typography-2 text-center px-20 pt-10 lg:pt-40 pb-10']"));
			String text1 = b.getText();
			System.out.println(text1);

			if(text1.contains("Your Basket")) {
				System.out.println("true");

			}else {
				System.out.println("false");
			}
	  
  }

  @AfterSuite
  public void afterSuite() {
	  driver.quit();
  }

}
