import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainDriver {
    static WebDriverWait wait;
    static WebDriver driver;
    static ExpectedCondition<Boolean> documentReady = driver -> {
        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
    };

    static {
        if(driver == null)
            setup();
    }

    @Before
    public static void setup(){
        if(driver != null)
            return;

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Anıl\\Desktop\\Gittigidiyor-Testing\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.gittigidiyor.com.tr");
        wait = new WebDriverWait(driver, 20);
    }
    @After
    public static void cutConnection() {
        driver.close();
    }

    public void setById(String id, String value) {
        driver.findElement(By.id(id)).clear();
        driver.findElement(By.id(id)).sendKeys(value);
    }
    //Bilgisayar kelimesi için arama yapılır
    public void findProduct(String value){
        getUrl("https://www.gittigidiyor.com/arama/?k=" + value);
    }

    //ikinci sayfaya gidilir
    public void selectPage(String value, int pageNumber){
        getUrl("https://www.gittigidiyor.com/arama/?k=" + value + "&sf=" + pageNumber);
    }
    //Sepete gidilir
    public void myBasket(){
        getUrl("https://www.gittigidiyor.com/sepetim");
    }

    //Click metodu
    public void clickById(String id) {
        driver.findElement(By.id(id)).click();
    }

    //URL metodu
    public void getUrl(String URL) {
        driver.get(URL);
    }



    
}
