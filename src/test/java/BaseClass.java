import Locators.HomePage;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class BaseClass implements HomePage {

    WebDriver driver;
    final static Logger logger = Logger.getLogger(BaseClass.class.getName());


    @BeforeTest
    public void triggerBrowser() {

        String log4j = System.getProperty("user.dir")+"/src/log4j.properties";
        PropertyConfigurator.configure(log4j);
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\PATTAPU\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(HomePage_URL);
    }

    @AfterTest
    public void snapshot() throws IOException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("hh_mm_ss");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String formattedDate = dateFormat.format(date);
        logger.info(formattedDate);
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("D:/rukesh/" + formattedDate + ".png"));

        }


}

