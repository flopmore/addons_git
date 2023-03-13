import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.EgeaCom;


public class App2 {

    public static void main(String[] args) throws Exception {
       // System.setProperty("idPlanif","23");
        // System.setProperty("idConfi","1");
        // System.setProperty("idPaq","0");
        // System.setProperty("modoEjecucion","N");

        


        WebDriver driver;
        EgeaCom egea = new EgeaCom();
		egea.setModo("CF");
		egea.leerConfiguracion("C:/AutomatizacionPrueba/src/config.txt");
        // egea.reportaTraza("App", "INFO", "OK", "Abrir navegador Chrome", "");
       


        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        
        driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");

        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("AutoFN");

        driver.findElement(By.xpath("//input[@name=\"last_name\"]")).sendKeys("AutoLN");
    
        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("AutoEmail"+"@mail.com");
   
        driver.findElement(By.xpath("//textarea[@name=\"message\"]")).sendKeys("Hello world ");
      
        driver.findElement(By.xpath("//input[@value=\"SUBMIT\"]")).click();
 
        WebElement contactUs_Submission_Message = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
  

        driver.quit();
        egea.reportaResultado("App", egea.getTrazaLog("App"), "KO", null);
            

       
    }
}
