package com.cydeo.utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

//Here we use driverPool.get()-->driverPool.set()-->& driverPool.remove(). Inherit thread local jobWeDoing
//INTERVIEW? ParalelTesting? I use MyWebDriver withMy Thread Local which provides me with driver for my each thread
//I use plug in maven run circle to ru my plug in

public class Driver {

    /*
    Creating a private constructor, so we are closing
    access to the object of this class from outside the class
     */
    private Driver(){}

    /*
    We make WebDriver private, because we want to close access from outside the class.
    We make it static because we will use it in a static method.
     */
    //private static WebDriver driver; // value is null by default

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /*
    Create a re-usable utility method which will return same driver instance when we call it
     */
    public static WebDriver getDriver(){

        if (driverPool.get() == null){

            /*
            Every time we use drive we are going to use-->driverPool.get example above
            We read our browserType from configuration.properties.
            This way, we can control which browser is opened from outside our code, from configuration.properties.
             */
            String browserType = ConfigurationReader.getProperty("browser");

            /*
                Depending on the browserType that will be return from configuration.properties file
                switch statement will determine the case, and open the matching browser
                  //CreateNewObjectInsteadOfUse->driverPool.set-->driverPool.set(new ChromeDriver());
                 //InsteadOfUseDriverGetDriver use-->driverPool.get().manage().window().maximize();
                 Here we allow multiple thread 2 have their ourDriver but each thread have they oun singleton design
            */
            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }
       //Return my driver I use-->  return driverPool.get();
        return driverPool.get();

    }

    /*
    This method will make sure our driver value is always null after using quit() method
     */
    public static void closeDriver(){
        if (driverPool.get() != null){    //IfNo then move to the next line
            driverPool.get().quit(); // this line will terminate the existing session. value will not even be null
            driverPool.remove();
        }
    }

}