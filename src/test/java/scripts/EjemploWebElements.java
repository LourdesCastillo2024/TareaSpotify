package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EjemploWebElements {
    public static void main(String[] args) throws InterruptedException{

        String rutaProyecto = System.getProperty("user.dir");
        String rutaDriver = rutaProyecto+
                "\\src\\test\\resources\\drivers\\chromedriver.exe";

        //Enlazar el webDriver al browser de nuestro sistema
        System.setProperty("webdriver.chrome.driver",rutaDriver);

        //Instanciar un objeto que represente al browser (driver)
        WebDriver driver = new ChromeDriver();

        driver.get("https://open.spotify.com/intl-es");

        driver.manage().window().maximize();

        //espere 5 segundos
        Thread.sleep(5000);

        //clic al boton iniciar Sesión
        WebElement btnIniciarSesion;
        By byBtnIniciarSesion = By.xpath("//button[@data-testid=\"login-button\"]");

        btnIniciarSesion = driver.findElement(byBtnIniciarSesion);
        btnIniciarSesion.click();

        Thread.sleep(5000);

        driver.findElement(By.id("login-username")).sendKeys("cualquiercosa@algo.cl");

        Thread.sleep(5000);

        //driver.close();
    }
}
