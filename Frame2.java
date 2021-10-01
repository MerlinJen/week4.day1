package week4.day1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/frame.html");
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		WebElement frame1 = driver.findElement(By.xpath("//div[@id='wrapframe']/iframe"));
		driver.switchTo().frame(frame1);
		WebElement screenShot=driver.findElement(By.id("Click"));
		File source=screenShot.getScreenshotAs(OutputType.FILE);
		File dest=new File("./MavenProject/snaps/seat.png");
		FileUtils.copyFile(source, dest);
		driver.switchTo().defaultContent();
		int frameSize =driver.findElements(By.tagName("iframe")).size();
		System.out.println("The total number of frames present: " +frameSize);
	}
}

//http://leafground.com/pages/frame.html
//1.Take the the screenshot of the click me button of first frame
//2.Find the number of frames
//  - find the Elements by tagname - iframe
//  - Store it in a list
//  - Get the size of the list. (This gives the count of the frames visible to the main page)