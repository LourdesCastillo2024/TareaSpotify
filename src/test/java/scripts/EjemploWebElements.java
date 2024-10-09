package scripts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.charset.StandardCharsets;

public class EjemploWebElements {

    @Test
    public  void CP001_ERROR_LOGIN() throws InterruptedException{
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

        Thread.sleep(2000);

        driver.findElement(By.id("login-button")).click();

        Thread.sleep(2000);
/*
        String resultadoEsperado = "Nombre de usuario o contraseña incorrectos.";
            String resultadoActual = driver.findElement(By.xpath("//span[contains(text(), 'contrase')]")).getText();


        if(resultadoActual.equalsIgnoreCase(resultadoEsperado)){
            System.out.println("Funciona :D");
        }else{
            System.out.println("no hay igualdad");
            System.out.println(" Resultado obtenido: "+ corregirEncoding(resultadoActual));
            System.out.println(" Resultado esperado: "+ resultadoEsperado);

        }*/

        Assertions.assertEquals(corregirEncoding("Nombre de usuario o contraseña incorrectos."),driver.findElement(By.xpath("//span[contains(text(), 'contrase')]")).getText());
        Thread.sleep(5000);
        driver.close();
    }

    @Test
    public void CP002_Algo(){

    }

    public static String corregirEncoding(String textoIncorrecto) {
        // Convertir la cadena incorrecta de la codificación ISO-8859-1 a UTF-8
        byte[] bytes = textoIncorrecto.getBytes(StandardCharsets.ISO_8859_1);
        String textoCorregido = new String(bytes, StandardCharsets.UTF_8);

        return textoCorregido;
    }
}
