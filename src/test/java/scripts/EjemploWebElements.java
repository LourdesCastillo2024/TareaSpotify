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
        //Genero Mujer
        WebElement rbtnGenero;
        //By byrbtnGenero = By.cssSelector("input[type='radio'][value='Mujer']"); //genero Mujer
        //By byrbtnGenero = By.className("Indicator-sc-hjfusp-0 jRuGOG");
        //By byrbtnGenero = By.xpath("<span class=\"Indicator-sc-hjfusp-0 jRuGOG\"></span>");
        //By byrbtnGenero = By.id("gender_option_female");
        //By byrbtnGenero = By.xpath("//input[id='gender_option_female' and @type='radio' and @value='female']");
        //By byrbtnGenero = By.className("Radio-sc-tr5kfi-0 icoMsB");
        //By byrbtnGenero = By.xpath("Indicator-sc-hjfusp-0 jRuGOG");
        //By byrbtnGenero = By.xpath("//div[@class='Radio-sc-tr5kfi-0 icoMsB']/input[@type='radio'][@value='female']");
        //By byrbtnGenero = By.className("encore-text encore-text-body-small TextForLabel-sc-1wen0a8-0 dfnyAW");
        //By byrbtnGenero = By.xpath("//input[@type='radio' and @value='female']");
        //By byrbtnGenero = By.xpath("//label[text()='gender_option_female']/precending-sibling::input[@type='radio']");
        //By byrbtnGenero = By.xpath("//label[text()='Mujer']/precending-sibling::input[@type='radio']");
        //By byrbtnGenero = By.xpath("//input[@id='gender_option_female']");
        //By byrbtnGenero = By.className("Indicator-sc-hjfusp-0 jRuGOG");
        //By byrbtnGenero = By.xpath("//span [@class='Indicator-sc-hjfusp-0 jRuGOG'");
        //By byrbtnGenero = By.xpath("//input[@type='radio' and id='gender_option_female' and @name='gender']");
        By byrbtnGenero = By.cssSelector("input[type='radio'][id='gender_option_female'][value='female']");
        rbtnGenero = driver.findElement(byrbtnGenero);
        rbtnGenero.click();
        Thread.sleep(2000);

    }

    @Test
    public void CP003_HAZTECLIENTE() throws InterruptedException{
        //Caso de prueba para registrarse como cliente del Banco BCI a través de la página web
        //Ruta del proyecto
        String rutaProyecto = System.getProperty("user.dir");
        String rutaDriver = rutaProyecto+
                "\\src\\test\\resources\\drivers\\chromedriver.exe";

        //Enlazar el webDriver al browser de nuestro sistema
        System.setProperty("webdriver.chrome.driver",rutaDriver);

        //Instanciar un objeto que represente al browser (driver)
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.bci.cl/personas");
        driver.manage().window().maximize();

        //espere 5 segundos
        Thread.sleep(5000);

        //clic en el link "Hazte cliente"
        WebElement btnHazteCliente;
        By byBtnHazteCliente = By.xpath("//a[contains(text(),'Hazte Cliente')]");
        btnHazteCliente = driver.findElement(byBtnHazteCliente);
        btnHazteCliente.click();
        Thread.sleep(3000);
        //Rut
        //WebElement rut;
        //By byRut = By.xpath("//input[@name='rut'");
        //driver.findElement(byRut).sendKeys("255740938");
        //driver.findElement(By.xpath("//input[@type='text']")).sendKeys("255740938");
        //driver.findElement(By.xpath("//input [@div ='_ngcontent-ypx-c38'] @class = 'btn-clean'")).sendKeys("255740938");
        //driver.findElement(By.className("bci-up ng-dirty ng-valid ng-touched")).sendKeys("255740938");
        //By byRut = By.xpath("div _ngcontent-ypx-c38");
        //driver.findElement(byRut).sendKeys("255740938");
        //driver.findElement()
        //and @type='text' and placeholder='Ingresa tu RUT'
        //By locator = By.xpath("//input[@class='ng-invalid ng-touched ng-dirty']");
        //By locator = By.className("ng-invalid ng-touched ng-dirty");
        By locator = By.xpath("//input[@type='text' and @placeholder='Ingresa tu Rut']");
        driver.findElement(locator).sendKeys("255740938");
//telefono
        //By telefono = By.className("bci-wk-oneAreCode");
        //driver.findElement(telefono).sendKeys("999999999");
//email
        //WebElement elemento = driver.findElement(By.cssSelector("input[type='email'][placeholder='Ingresa tu email']"));
        //driver.findElement((By) elemento).sendKeys("test@test.com");

        //Thread.sleep(3000);
        driver.quit();

    }
    public static String corregirEncoding(String textoIncorrecto) {
        // Convertir la cadena incorrecta de la codificación ISO-8859-1 a UTF-8
        byte[] bytes = textoIncorrecto.getBytes(StandardCharsets.ISO_8859_1);
        String textoCorregido = new String(bytes, StandardCharsets.UTF_8);

        return textoCorregido;
    }
}
