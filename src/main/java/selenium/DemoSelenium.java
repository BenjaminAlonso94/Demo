package selenium;

import herramientas.Word;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class DemoSelenium extends Word {
    WebDriver driver = null;
    public void abrirUrl(){
        try {
            crearDocumentoST();
            System.setProperty("webdriver.ie.driver", "C:\\Users\\softtek\\IdeaProjects\\Prueba\\driver\\IEDriverServer.exe");
            //System.setProperty("webdriver.chrome.driver", "C:\\Users\\softtek\\IdeaProjects\\Prueba\\driver\\chromedriver.exe");
            driver = new InternetExplorerDriver();
            //driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://www.seleniumhq.org/");
            Thread.sleep(5000);
            crearParrafo("Prueba");
            crearImagen(driver);
            crearImagen(driver);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void iniciarSesion(){
        By txtNomina = By.xpath("");
        By txtContrasena = By.xpath("");
        By txtSucursal = By.xpath("");
        By txtCaja = By.xpath("");
        By btnIngresar = By.xpath("");
        By txtCliente = By.xpath("");
        By btnIniciar = By.xpath("");
        espera(txtNomina);
        driver.findElement(txtNomina).sendKeys("");
        espera(txtContrasena);
        driver.findElement(txtContrasena).sendKeys("");
        espera(txtSucursal);
        driver.findElement(txtSucursal).sendKeys("");
        espera(txtCaja);
        driver.findElement(txtCaja).sendKeys("");
        espera(btnIngresar);
        driver.findElement(btnIngresar).click();
        espera(btnIniciar);
        driver.findElement(btnIniciar).click();
    }

    public void datosDeBusqueda(){
        By txtNombre = By.xpath("");
        By txtAPaterno = By.xpath("");
        By txtAMaterno = By.xpath("");
        By txtFechaNac = By.xpath("");
        By txtRFC = By.xpath("");
        By txtCalleNumero = By.xpath("");
        By txtCP = By.xpath("");
        By btnIniciar = By.xpath("");
        By btnClienteNoM = By.xpath("");
        driver.findElement(txtNombre).sendKeys("");
        driver.findElement(txtAPaterno).sendKeys("");
        driver.findElement(txtAMaterno).sendKeys("");
        driver.findElement(txtFechaNac).sendKeys("");
        driver.findElement(txtRFC).sendKeys("");
        driver.findElement(txtCalleNumero).sendKeys("");
        driver.findElement(txtCP).sendKeys("");
        driver.findElement(btnIniciar).click();
        driver.findElement(btnClienteNoM).click();
    }

    public void cerrarSesion(){
        try {
            driver.quit();
            Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void espera(By element){
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
    }
}
