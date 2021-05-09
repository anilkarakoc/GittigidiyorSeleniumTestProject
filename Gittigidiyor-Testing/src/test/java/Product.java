import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class Product extends MainTest {

    @Test
    public void doTest() throws InterruptedException {
        choosePage();
        chooseProduct();
        addToBasket();
        openMyBasket();
        increaseBasket();
        deleteMyBasket();
    }
    //Arama kutucuğuna bilgisayar yazılır
    private void choosePage() throws InterruptedException {
        selectPage("bilgisayar", 2);
        pageControl();
        Thread.sleep(2000);
    }
    //Rastgele bir ürün seçilir
    private void chooseProduct() throws InterruptedException {
        int randomProductIndex = new Random().nextInt(48);
        WebElement productElement = driver.findElement(By.cssSelector(".products-container > li:nth-child(" + randomProductIndex + ")"));
        productElement.findElement(By.cssSelector("a")).click();
        Thread.sleep(4000);
        wait.until(documentReady);
    }
    //Seçilen ürün sepete eklenir
    private void addToBasket() throws InterruptedException {

        WebElement element = driver.findElement(By.id("add-to-basket"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(1000);
        element.click();
        Thread.sleep(1000);
    }
    //Sepet açılır
    private void openMyBasket() throws InterruptedException {
        myBasket();
        Thread.sleep(2000);
    }

    //Sepetteki ürün sayısı 2 olarak belirlenir
    private void increaseBasket() throws InterruptedException {
        driver.findElement(By.xpath("(//select[@class='amount'])/option[contains(text(),'2')]")).click();
        Thread.sleep(5000);
    }
    //Sepet boşaltılır
    private void deleteMyBasket() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='btn-delete btn-update-item']")).click();
        Thread.sleep(2000);
    }
    //2. sayfanın açılıp açılmadığı kontrol edilir
    private void pageControl() throws InterruptedException {

        if (driver.getCurrentUrl().endsWith("2")) {
            System.out.println("2. sayfa açıldı.");
        } else {
            System.out.println("2. sayfa açılamadı.");
            driver.close();
            throw new InterruptedException();
        }
        Thread.sleep(2000);
    }






}

