import org.junit.Test;

public class Search extends MainTest {

    private Object setByClassName;

    @Test
    public void doTest() throws InterruptedException {
        searchByKeyword();
    }
    //Arama kutucuğuna yazılan kelime aranır
    private void searchByKeyword() throws InterruptedException {

        findProduct("bilgisayar");
        Thread.sleep(5000);
        wait.until(documentReady);
    }
}
