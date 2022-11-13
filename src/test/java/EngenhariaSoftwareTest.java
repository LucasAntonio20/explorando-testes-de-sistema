import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EngenhariaSoftwareTest {
    WebDriver webDriver;

    @BeforeAll
    public void setupAll(){
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/chromedriver_win32/chromedriver.exe");
    }

    @BeforeEach
    public void setup(){
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @AfterEach
    public void close(){
        webDriver.close();
    }

    @Test
    public void openMinecraftPage(){
        webDriver.get("https://www.minecraft.net/pt-br");
        Assertions.assertEquals("https://www.minecraft.net/pt-br",
                webDriver.getCurrentUrl());
    }

    @Test
    public void findGetMinecraftButtonTest(){
        webDriver.get("https://www.minecraft.net/pt-br");
        WebElement buttonGM = webDriver.findElement(
                By.xpath("//*[@id=\"mc-globalhead__navcontainer\"]/nav[2]/ul/li[2]/a"));
        buttonGM.click();
        Assertions.assertEquals("https://www.minecraft.net/pt-pt/get-minecraft",
                webDriver.getCurrentUrl());
    }

    @Test
    public void searchSupportButtonTest(){
        webDriver.get("https://www.minecraft.net/pt-br");
        WebElement buttonGM = webDriver.findElement(
                By.xpath("//*[@id=\"mc-globalhead__navcontainer\"]/nav[1]/ul/li[4]/a"));
        buttonGM.click();
        Assertions.assertEquals("https://help.minecraft.net/hc/en-us",
                webDriver.getCurrentUrl());
    }

}
