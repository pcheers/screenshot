package com.screenshot.examples.misc;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Example {

  public static final Logger LOGGER = LoggerFactory.getLogger(Example.class);
  public static void main(String[] args) throws IOException, InterruptedException{
	  //Change the value to your installation
	  System.setProperty("webdriver.gecko.driver","C:/Users/Raja/WorkSpace/work/workbench/screenshot/geckodriver-v0.16.1-win64/geckodriver.exe");
	  //Name of the screenshot file to be created.
	  final File screenShot = new File("screenshot1.png").getAbsoluteFile();
	  WebDriver driver = new FirefoxDriver();
	  try{
		  driver.get("http://www.cnn.com");
		  driver.manage().window().maximize();
		  Thread.sleep(2000);
		  Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		  ImageIO.write(fpScreenshot.getImage(),"PNG",screenShot);
	  }finally{
		  driver.close();
	  }
  }
}
