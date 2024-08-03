package gopi;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import sun.net.ftp.FtpDirEntry.Type;

public class FitPeoPageCheck {

	@Test
	public void FitpeoPage() throws InterruptedException, Exception {

		// setup the chromedriver path
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vgopi\\Downloads\\chromedriver-win32 (1)\\chromedriver-win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		// navigate to fitpeo Page
		driver.get("https://www.fitpeo.com/");
		driver.manage().window().maximize();

		// Clicking the Revenue icon
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a//div[text()='Revenue Calculator']")).click();

        // Using Robot class i am doing Scrolling
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Robot r = new Robot();
		r.mouseWheel(3);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Using action class i am changing the position of slidebar and capturing slide
		// values
		WebElement slider = driver.findElement(
				By.xpath("//span[@class='MuiSlider-root MuiSlider-colorPrimary MuiSlider-sizeMedium css-duk49p']"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(slider).moveByOffset(-26, 0).release().perform();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		String SildeVlaues = driver.findElement(By.xpath("//span/input[@data-index='0']")).getAttribute("value");

		
	//check box value
		String textboxval = driver.findElement(By.xpath("//div/input[@type='number']")).getAttribute("value");
		System.out.println("First time Silde Bar value check after scrolling :" + SildeVlaues);
		System.out.println("First time text Box value check : "+textboxval);
		
		//Validating actual vs Expected ;
		boolean isture = textboxval.equals(SildeVlaues);
		Assert.assertEquals(isture, true);
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// And selecting textbox and giving the value and checking in slide bar

		WebElement Slidebox = driver.findElement(By.xpath(
				"//div/input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng']"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Slidebox.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		for (int i = 0; i < 2; i++) {
			js.executeScript("arguments[0].value='" + Keys.BACK_SPACE + "';", Slidebox);
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Slidebox.sendKeys("560");

		// checking the slide bar and printing in console
		String SildeVlauesrevcheck = driver.findElement(By.xpath("//span/input[@data-index='0']")).getAttribute("value");
		
	//check box value
		String textboxvalrevcheck = driver.findElement(By.xpath("//div/input[@type='number']")).getAttribute("value");

		System.out.println("Second time Silde Bar after giving check box values : " + SildeVlauesrevcheck);
		System.out.println("Second time text Box value check  giving text box : "+textboxvalrevcheck);
		boolean isture1 = textboxvalrevcheck.equals(SildeVlauesrevcheck);
		Assert.assertEquals(isture1, true);

		// Scrolling down and selecting the check boxes what ever we want
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		r.mouseWheel(3);
		List<WebElement> checkboxclick = driver
				.findElements(By.xpath("//input[@class='PrivateSwitchBase-input css-1m9pwf3']"));
		checkboxclick.get(0).click();// 0 - means
		checkboxclick.get(1).click();
		checkboxclick.get(2).click();
		checkboxclick.get(7).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Taking amount and validating actual  vs Expected 
		
		String totalrecurringvalue = driver.findElement(By.xpath("//p[contains(text(),'Total Recurring Reimbursement for all Patients Per Month:')]")).getText();
		String[] val = totalrecurringvalue.split(":");
		Assert.assertEquals("Total Recurring Reimbursement for all Patients Per Month:", val[0]+":");
		System.out.print("Total Recurring Reimbursement ==" + val[1]);

		driver.quit();

	}
}

//			Thread.sleep(3000);
//			driver.findElement(By.xpath("//a[@id='opentab']")).click();
//			Set<String>k = driver.getWindowHandles();
//			Thread.sleep(3000);
//			List<String> sa = new ArrayList<String>(k);
//			 driver.switchTo().window(sa.get(1));
//			Thread.sleep(3000);
//		String child =	driver.findElement(By.xpath("//a[contains(text(),'Access all our Courses')]")).getText();
//			System.out.println("ChildWindow"+child);
//			 driver.switchTo().window(sa.get(0));
//			Thread.sleep(3000);
//			String l =driver.findElement(By.xpath("//button[contains(text(),'Login')]")).getText();
//			System.out.println("ParentWindow"+l);
//			Thread.sleep(2000);
////			JavascriptExecutor js = (JavascriptExecutor) driver;
////			js.executeScript("window.scrollBy(0,1700)", "");
////			Thread.sleep(2000);
//			Robot r = new Robot();
//			r.wait(2000);
////			driver.switchTo().frame("iframe-name");
////		String frame =	driver.findElement(By.xpath("(//a[contains(text(),'Blog')])[1]")).getText();
////			System.out.println(frame +" frame");
//			Thread.sleep(3000);
////			driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("ind");
////			Thread.sleep(3000);
////			driver.findElement(By.xpath("(//li[@class='ui-menu-item']/div)[2]")).click();
////			
////			//input[@id="autocomplete"]
////			driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
////			Thread.sleep(3000);
////			Alert aa = driver.switchTo().alert();
////			Thread.sleep(3000);
////			aa.accept();
////			Thread.sleep(3000);
//			driver.quit();
//		
//			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//			TakesScreenshot s = (TakesScreenshot)driver;
//			File ts =s.getScreenshotAs(OutputType.FILE);
//			File dis = new File("C:\\SS\\ssk.jpg");
//			FileUtils.copyDirectory(ts, dis);
//			
// .navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
//			System.out.println(driver.getTitle());
//			System.out.println(driver.getCurrentUrl());
//			driver.manage().window().maximize();
// driver.fin
// driver.get("https://www.globalsqa.com/demo-site/draganddrop/#Photo%20Manager");
//			Thread.sleep(5000);
//			driver.manage().window().maximize();
//			Actions a = new Actions(driver);
//		WebElement k =	driver.findElement(By.xpath("//input[@name='enter-name']"));
//			a.sendKeys(k, "Gopi").perform();
// Thread.sleep(5000);
//			driver.findElement(By.xpath("//a[@id='opentab']")).click();
//			Thread.sleep(3000);
//			
//		Set<String> window = driver.getWindowHandles();
//		
//	ArrayList<String> list = new ArrayList<String>(window);
//Thread.sleep(2000);
//         driver.switchTo().window(list.get(1)) ;
//          Thread.sleep(5000);
//       String k =   driver.findElement(By.xpath("//a[text()='Access all our Courses']")).getText();
//       System.out.println(k);
//       Thread.sleep(2000);
//       driver.switchTo().window(list.get(0)) ;
//          Thread.sleep(5000);
//      String kk=    driver.findElement(By.xpath("//input[@value='Confirm']")).getText();
//      System.out.println(kk);
