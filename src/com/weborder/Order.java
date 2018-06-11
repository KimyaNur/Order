package com.weborder;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Order {

	public static void main(String[] args) throws InterruptedException {
		Random randomnumber =new Random();
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\KNSA\\Documents\\Selenium dependencies\\drivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		Thread.sleep(2000);
		//driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		Thread.sleep(2000);
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		Thread.sleep(2000);
		//tagName[attributeName='valueOfAttribute']
		driver.findElement(By.cssSelector("a[href='Process.aspx']")).click();
		
		WebElement btn = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity"));
		Actions action = new Actions(driver);
		action.doubleClick(btn).perform();
		int i = randomnumber.nextInt(100)+1;
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(""+i);
		
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder(20);
        sb.append("John ");
        Random random = new Random();
        for (int j = 0; j < 6; j++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        sb.append(" Smith");
        String output = sb.toString();
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys(output);
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Any st");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Anytown");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("Virginia");
		
		String zipCode=randomnumber.nextInt(90000)+10000+"";
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(zipCode);
		
		
//		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(r.nextInt(10)+"");
//		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(r.nextInt(10)+"");
//		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(r.nextInt(10)+"");
//		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(r.nextInt(10)+"");
//		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(r.nextInt(10)+"");
		
		int luck=randomnumber.nextInt(3);
		if (luck==0 ) {
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).
			sendKeys("4"+(long) (Math.random() * 1000000000000000L)+"");
		}else if(luck==1 )  { 	
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();

			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).
			sendKeys("5"+(long) (Math.random() * 1000000000000000L)+"");

		}else if(luck==2 ) {
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).click();

			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).
			sendKeys("3"+(long) (Math.random() * 100000000000000L)+"");
		}
		
				int temp=randomnumber.nextInt(2);
				        String randomMonth= temp==1 ? temp+""+randomnumber.nextInt(3): temp+""+randomnumber.nextInt(10);

				        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys(randomMonth+"/"+randomnumber.nextInt(82)+18);
				       Thread.sleep(2000);
				       driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
				       
				       
				       String expected = "New order has been successfully added";
				      // String actual =driver.findElement(By.xpath("[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong"));
				   
				      // driver.findElement(By.xpath("[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong")).getText().contains(expected);
					   
				       if(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong")).getText().contains("New order has been successfully added")) {
						      System.out.println("Pass");
						    } else {
						      System.out.println("Fail");
						    }
				
		

		

	}

}
