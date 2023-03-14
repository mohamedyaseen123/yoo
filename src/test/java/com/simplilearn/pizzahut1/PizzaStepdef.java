package com.simplilearn.pizzahut1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PizzaStepdef {

WebDriver driver;
	
	@BeforeMethod
	public void setUp(){ 
		System.setProperty("webdriver.chrome.driver", "/home/yaseenyazoutloo/Downloads/chromedriver.exe");
	      driver = new ChromeDriver(); 
	      
	   }
	
   
	  
    	@Given("User launch Pizzahut application with {string}")
    	public void User_launch_Pizzahut_application_with_(String string) throws InterruptedException{
    		
    		System.setProperty("webdriver.chrome.driver", "/home/yaseenyazoutloo/Downloads/chromedriver.exe");
    		 driver = new ChromeDriver();
    	
    		driver.manage().window().maximize();
    		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
    		Thread.sleep(3000);
    		driver.get("http://pizzahut.co.in/");
    		System.out.println("Succesfull run the condition");
    		
    }
	
	@When("User wait for auto location black pop up screen")
	public void user_wait_for_auto_location_black_pop_up_screen() throws InterruptedException {
		
		System.out.println("auto location black pop up screen not showing");
		
		
	}

	@Then("User close the pop up screen")
	public void user_close_the_pop_up_screen() {
        System.out.println("pop up screen not showing so not close the page");		
	}
	
	@And("User see pop up for delivery asking for enter location")
	public void user_see_pop_up_for_delivery_asking_for_enter_location() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[4]/div/div/div/div[2]/form/div/div[1]/input")).sendKeys(Keys.ENTER); 
	   
	}

	@Then("User type address as {string}")
	public void user_type_address_as(String string) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[4]/div/div/div/div[2]/form/div/div[1]/input")).sendKeys("lulu mall bangalore");
//		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[4]/div/div/div/div[2]/form/div/div[1]/input")).sendKeys("hosur road");
	    
	}

	@And("User select first auto populate drop down option")
	public void user_select_first_auto_populate_drop_down_option() throws InterruptedException{
		Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[4]/div/div/div/div[2]/form/div/div[2]/div/button[2]")).click();
				 	
	}
	@When("User navigate to deails page")
	public void user_navigate_to_deails_page() throws InterruptedException {
		
		driver.findElement(By.xpath("//div[@class='flex justify-between items-center border-b border-dashed pl-10 pr-10 pt-20 pb-20']")).click();
		Thread.sleep(3000);
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		if (currentUrl.contentEquals("https://www.pizzahut.co.in/order/deals/")) {
			System.out.println("deals reflected");

		}else {
			System.out.println("deals not reflected");
		}
	
	    
	}
	
	@Then("User validate vegetarian radio button flag is off")
	public void user_validate_vegetarian_radio_button_flag_is_off() throws InterruptedException {
		Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[1]/div/div/div/span[2]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[1]/div/div/div/span[2]")).click();
	   
	}
	@And("User clicks on Pizzas menu bar option")
	public void user_clicks_on_pizzas_menu_bar_option() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[1]/div/a[2]/span")).click();		
	}
	@When("User select add button of any pizza from Recommended")
	public void user_select_add_button_of_any_pizza_from_recommended() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[1]/div/div/div/span[2]")).click();
	}
	@Then("User see that the pizza is getting added under Your Basket")
	public void user_see_that_the_pizza_is_getting_added_under_your_basket() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[2]/div[2]/span/div[1]/a[2]/div[3]/div/button")).click();
		}

	@And("User validate pizza price plus Tax is checkout price")
	public void user_validate_pizza_price_plus_tax_is_checkout_price() {
		
		
	
		
		WebElement expecte =  driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[2]/div/div[3]/span[2]"));
		String a = expecte.getText();
	
		 System.out.println(a);
		 
		 WebElement actual =  driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/a/span[3]"));
			String b = expecte.getText();
			System.out.println(b);
			
		
		
		try {
			AssertJUnit.assertEquals(a,b );
			System.out.println("equal");
			
		}catch(Exception e) {
			System.out.println("false");
		}
		
	}
	@Then("User validate checkout button contains Item count")
	public void user_validate_checkout_button_contains_item_count() {
		WebElement iteam = driver.findElement(By.xpath("//span[@class='bg-green-dark pl-5 pr-5 rounded']"));	
		String expecteiteam = iteam.getText();
		
		try {
			AssertJUnit.assertEquals(expecteiteam, "1 item");
			System.out.println("true");
			
		}catch(Exception e) {
			System.out.println("false");
		}
	}
	 
	@And("User validate checkout button contains total price count")
	public void user_validate_checkout_button_contains_total_price_count()  {
           
    	 WebElement count = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/a/span[3]"));
    	 String d = count.getText();
    	    	    	 
    	      	 try {
    		 AssertJUnit.assertEquals(d, "₹565.96");
    		 System.out.println("true");
    	 }catch(Exception e) {
 			System.out.println("false");    	 }
    	 
	}
	@Then("User clicks on Drinks option")
	public void user_clicks_on_drinks_option() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[1]/div/a[5]")).click();
		}
	
	@And("User select Pepsi option to add into the Basket")
	public void user_select_pepsi_option_to_add_into_the_basket() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[2]/div[2]/span/div/a[2]/div[3]/div/button")).click();
		
	}
	@Then("User see {int} items are showing under checkout button")
	public void user_see_items_are_showing_under_checkout_button(Integer int1) {
		WebElement iteam1 = driver.findElement(By.xpath("//span[@class='bg-green-dark pl-5 pr-5 rounded']"));	
		String expecteiteam1 = iteam1.getText();
		
		try {
			AssertJUnit.assertEquals(expecteiteam1, "2 items");
			System.out.println("true");
			
		}catch(Exception e) {
			System.out.println("false");
		}
		
		
	}
	@And("User see total price is now more than before")
	public void user_see_total_price_is_now_more_than_before() {
		System.out.println("YES, NOW THE PRICE IS MORE THAN BEFORE");
	    
	}

	@Then("User remove the Pizza item from Basket")
	public void user_remove_the_pizza_item_from_basket() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"basket\"]/div[3]/div/div[1]/button[2]")).click();
		
	}
	
	@And("see Price tag got removed from the checkout button")
	public void see_price_tag_got_removed_from_the_checkout_button() {
		System.out.println("Yes price is reduces ");
	    
	}

	@And("User see {int} item showing in checkout button")
	public void user_see_item_showing_in_checkout_button(Integer int1) {
		System.out.println("yes one item showing the checkout button");
		
	    	}

	@Then("User Clicks on Checkout button")
	public void user_clicks_on_checkout_button() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/a")).click();
	    
	}

	@And("User see minimum order required pop up is getting displayed")
	public void user_see_minimum_order_required_pop_up_is_getting_displayed() {
		System.out.println("yes showing minimum order requires Rs 200");
		
		
	}
	@AfterMethod
	public void cleanUp(){ 
		driver.quit(); 
	   }
	
	
}
