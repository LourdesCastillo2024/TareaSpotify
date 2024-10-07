package scripts;

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

        //espere 5 segundos
        Thread.sleep(5000);

        //clic al boton iniciar Sesión
        WebElement btnIniciarSesion;

        driver.close();
    }
}
