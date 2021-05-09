import org.junit.Test;

public class Login extends MainTest {

    //Login olma işlemleri
    @Test
    public void doTest() throws InterruptedException {
        getUrl("https://www.gittigidiyor.com/uye-girisi");
        setById("L-UserNameField", "testmailim0@gmail.com");
        setById("L-PasswordField", "test1234");
        clickById("gg-login-enter");
        controlLoginPage();
        Thread.sleep(4000);
        wait.until(documentReady);
    }
    //Kullanıcı adı ve şifrenin doğruluğu kontrol edilir
    private void controlLoginPage() throws InterruptedException {
        if (driver.getCurrentUrl().contains("uye-girisi")) {
            System.out.println("Login işlemi başarısız.");
            driver.close();
            throw new InterruptedException();
        } else {
            System.out.println("Login işlemi başarılı");
        }
    }
}
