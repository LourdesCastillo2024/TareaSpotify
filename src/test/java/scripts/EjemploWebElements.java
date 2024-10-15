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
    public void CP002_REGISTRO() throws InterruptedException{
    //Registrar nueva cuenta
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

        //clic al boton Registrarte
        WebElement btnRegistrarte;
        By byBtnRegistrarte = By.xpath("//button[@data-testid=\"signup-button\"]");
        btnRegistrarte = driver.findElement(byBtnRegistrarte);
        btnRegistrarte.click();
        Thread.sleep(5000);
        driver.findElement(By.id("username")).sendKeys("test1@algo.cl");
        Thread.sleep(2000);

        //Clic al botón Siguiente
        WebElement btnSiguiente;
        By byBtnSiguiente = By.xpath("//button[@data-testid=\"submit\"]");
        btnSiguiente = driver.findElement(byBtnSiguiente);
        btnSiguiente.click();
        Thread.sleep(2000);

        //Crear contraseña
        WebElement btnPassword;
        By byPassword = By.className("Input-sc-1gbx9xe-0 hRUqRg encore-text-body-medium");
        Thread.sleep(2000);
        driver.findElement(By.id("new-password")).sendKeys("test1@algo.cl");
        Thread.sleep(2000);

        //Clic al botón Siguiente2
        WebElement btnSiguiente2;
        By byBtnSiguiente2 = By.xpath("//button[@data-testid=\"submit\"]");
        btnSiguiente2 = driver.findElement(byBtnSiguiente2);
        btnSiguiente2.click();
        Thread.sleep(2000);

        //Registrar datos
        driver.findElement(By.id("displayName")).sendKeys("Lulu"); //Nombre
        Thread.sleep(2000);
        driver.findElement(By.id("day")).sendKeys("17"); //Día nac
        Thread.sleep(2000);
        driver.findElement(By.id("month")).sendKeys("Diciembre"); //Mes nac
        Thread.sleep(2000);
        driver.findElement(By.id("year")).sendKeys("1980"); //Año nac
        Thread.sleep(2000);
        //Genero
        WebElement rbtnGenero;
        //By byrbtnGenero = By.cssSelector("input[type='radio'][value='Mujer']"); //genero Mujer
        //By byrbtnGenero = By.className("Indicator-sc-hjfusp-0 jRuGOG");
        //By byrbtnGenero = By.xpath("<span class=\"Indicator-sc-hjfusp-0 jRuGOG\"></span>");
        //By byrbtnGenero = By.id("gender_option_female");
        //By byrbtnGenero = By.xpath("//input[@type='radio' and @value='female']");
        //By byrbtnGenero = By.className("Radio-sc-tr5kfi-0 icoMsB");
        //By byrbtnGenero = By.xpath("Indicator-sc-hjfusp-0 jRuGOG");
        //By byrbtnGenero = By.xpath("//div[@class='Radio-sc-tr5kfi-0 icoMsB']/input[@type='radio'][@value='female']");
        //By byrbtnGenero = By.className("encore-text encore-text-body-small TextForLabel-sc-1wen0a8-0 dfnyAW");
        //By byrbtnGenero = By.xpath("//input[@type='radio' and @value='female']");
        //By byrbtnGenero = By.xpath("//label[text()='gender_option_female']/precending-sibling::input[@type='radio']");
        //By byrbtnGenero = By.xpath("//label[text()='Mujer']/precending-sibling::input[@type='radio']");
        //By byrbtnGenero = By.xpath("//input[@id='gender_option_female']");
        By byrbtnGenero = By.className("Indicator-sc-hjfusp-0 jRuGOG");
        rbtnGenero = driver.findElement(byrbtnGenero);
        rbtnGenero.click();
        Thread.sleep(2000);

    }

    public static String corregirEncoding(String textoIncorrecto) {
        // Convertir la cadena incorrecta de la codificación ISO-8859-1 a UTF-8
        byte[] bytes = textoIncorrecto.getBytes(StandardCharsets.ISO_8859_1);
        String textoCorregido = new String(bytes, StandardCharsets.UTF_8);

        return textoCorregido;
    }
}
