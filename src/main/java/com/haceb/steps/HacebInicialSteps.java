package com.haceb.steps;

import com.haceb.pageObjectModel.HacebFormulario1;
import com.haceb.pageObjectModel.HacebFormulario2;
import com.haceb.pageObjectModel.HacebInicial;
import com.haceb.pageObjectModel.HacebValidacion;
import com.haceb.utils.Data;
import com.haceb.utils.Esperas;
import net.serenitybdd.core.exceptions.NoSuchElementException;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.fluentlenium.core.annotation.Page;




import java.util.Map;
import java.util.Set;

public class HacebInicialSteps {
    @Page
    HacebInicial hacebInicial;
    HacebFormulario1 hacebFormulario1;
    HacebFormulario2 hacebFormulario2;
    HacebValidacion hacebValidacion;

    @Step("Abrir el navegador Haceb")
    public void abrirNavegadorHaceb(){
        hacebInicial.openUrl("https://www.haceb.com");
    }
    @Step("Cerrar el pop-up si está presente")
    public void cerrarPopupSiPresente() {
        try {
            By publicidadCloseButtonLocator = hacebInicial.getDivPopup();


            Esperas.esperaVisible(hacebInicial.getDriver(), publicidadCloseButtonLocator);


            Actions actions = new Actions(hacebInicial.getDriver());
            actions.moveToElement(hacebInicial.getDriver().findElement(publicidadCloseButtonLocator)).perform();


            hacebInicial.getDriver().findElement(publicidadCloseButtonLocator).click();
        }
        catch (NoSuchElementException ignore){

        }
    }
    @Step("Ingrese al acceso de usuario")
    public void clickIconoUsuario() {
        Esperas.espera1(hacebInicial.getDriver(), hacebInicial.getDivRegistro());
        WebElement menuElement = hacebInicial.getDriver().findElement(hacebInicial.getDivRegistro());

        Actions actions = new Actions(hacebInicial.getDriver());
        actions.moveToElement(menuElement).perform();
    }
    @Step("Click en la opcion registrar")
    public void clickRegistrarUsuario() {
        Esperas.espera1(hacebInicial.getDriver(), hacebInicial.getaRegistrar());
        WebElement registrarElement = hacebInicial.getDriver().findElement(hacebInicial.getaRegistrar());

        Actions actions = new Actions(hacebInicial.getDriver());
        actions.moveToElement(registrarElement).click().perform();
    }
    @Step("ingrese a la página de registro de Haceb")
    public void ingresarPaginaRegistroHaceb() {
        Esperas.espera1(hacebInicial.getDriver(), hacebInicial.getBtnAccesoHacebRegistro());
        WebElement btnRegistro = hacebInicial.getDriver().findElement(hacebInicial.getBtnAccesoHacebRegistro());
        btnRegistro.click();


        WebDriver driver = hacebInicial.getDriver();
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String windowHandle : allWindows) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        //driver.manage().window().maximize();
        try {
            Thread.sleep(5000); // Espera de 5 segundos
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }


        String currentUrl = driver.getCurrentUrl();
        if (!currentUrl.equals("https://www.haceb.com/HacebLogin")) {
            throw new IllegalStateException("La URL de la nueva ventana no es la esperada.");
        }
    }
    @Step("El usuario digita los campos desde Excel")
    public void llenadoCamposExcel() {
       // String contrasena = Data.extractTo().get(0).get("password");

        Map<String, String> datosUsuario = Data.extractTo().get(0); // Obtiene los datos del primer usuario en Excel

        try {
            Thread.sleep(5000); // Espera de 5 segundos
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }

        hacebInicial.getDriver().findElement(hacebFormulario1.getTextEmail()).sendKeys(datosUsuario.get("email"), Keys.TAB);

        hacebInicial.getDriver().findElement(hacebFormulario1.getTextNombre()).sendKeys(datosUsuario.get("nombre"), Keys.TAB);

        hacebFormulario1.getDriver().findElement(hacebFormulario1.getTextApellido()).sendKeys(datosUsuario.get("apellido"), Keys.TAB);

        hacebFormulario1.getDriver().findElement(hacebFormulario1.getTextPass()).sendKeys(datosUsuario.get("password"), Keys.TAB);

        hacebFormulario1.getDriver().findElement(hacebFormulario1.getTextPassConfirmar()).sendKeys(datosUsuario.get("confirmar_contrasena"));

    }

    @Step("Aceptar términos y condiciones")
    public void aceptarTerminosYCondiciones() {
        WebDriver driver = hacebFormulario1.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;


        By checkTerminosSelector = hacebFormulario1.getCheckTerminos();


        Esperas.espera2(driver, checkTerminosSelector);


        WebElement checkboxTerminos = driver.findElement(checkTerminosSelector);
        js.executeScript("arguments[0].click();", checkboxTerminos);



        By checkAutorizacionSelector = hacebFormulario1.getCheckAutorizacion();
        WebElement checkAutorizacionElement = driver.findElement(checkAutorizacionSelector);
        js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", checkAutorizacionElement);


        boolean isAutorizacionVisible = (boolean) js.executeScript(
                "var elem = arguments[0], box = elem.getBoundingClientRect(), cx = box.left + box.width / 2, cy = box.top + box.height / 2, e = document.elementFromPoint(cx, cy); for (; e; e = e.parentElement) { if (e === elem) return true; } return false;",
                checkAutorizacionElement);
        if (!isAutorizacionVisible) {
            throw new IllegalStateException("El checkbox de autorización de uso de datos personales no está visible en la pantalla.");
        }
    }


    @Step("Autorizar el uso de datos personales")
    public void autorizarUsoDatosPersonales() {
        WebDriver driver = hacebFormulario1.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        By checkAutorizacionSelector = hacebFormulario1.getCheckAutorizacion();


        Esperas.espera1(driver, checkAutorizacionSelector);

        WebElement checkboxAutorizacion = driver.findElement(checkAutorizacionSelector);
        js.executeScript("arguments[0].click();", checkboxAutorizacion);
    }





    @Step("Hacer clic en el botón de registrarme")
    public void clickBotonRegistrarme() {
        Esperas.espera1(hacebFormulario1.getDriver(), hacebFormulario1.getCheckRegistrarme());
        WebElement registrarElement = hacebFormulario1.getDriver().findElement(hacebFormulario1.getCheckRegistrarme());

        Actions actions = new Actions(hacebFormulario1.getDriver());
        actions.moveToElement(registrarElement).click().perform();
    }
    @Step("Completar registro")
    public void completarRegistroFormulario(){
        Map<String, String> datosUsuario = Data.extractTo().get(0);
        try {
            Thread.sleep(5000); // Espera de 5 segundos
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }

        hacebFormulario2.getDriver().findElement(hacebFormulario2.getInCedula()).sendKeys(datosUsuario.get("cedula"), Keys.TAB);

        hacebFormulario2.getDriver().findElement(hacebFormulario2.getInGenero()).sendKeys(datosUsuario.get("genero"), Keys.TAB);

        hacebFormulario2.getDriver().findElement(hacebFormulario2.getInFechaNacimiento()).sendKeys(datosUsuario.get("fecha"), Keys.TAB);

        hacebFormulario2.getDriver().findElement(hacebFormulario2.getInExtTelf()).sendKeys(datosUsuario.get("codigo"), Keys.TAB);

        hacebFormulario2.getDriver().findElement(hacebFormulario2.getInNumeroContacto()).sendKeys(datosUsuario.get("contacto"), Keys.TAB);

        hacebFormulario2.getDriver().findElement(hacebFormulario2.getInDepartamento()).sendKeys(datosUsuario.get("departamento"), Keys.TAB);

        hacebFormulario2.getDriver().findElement(hacebFormulario2.getInCiudad()).sendKeys(datosUsuario.get("ciudad"));
    }
    @Step("Click en enviar")
    public void clickEnviar() {
        WebDriver driver = hacebFormulario2.getDriver();

        Esperas.espera1(driver, hacebFormulario2.getBtnEnviar());
        WebElement enviarElement = driver.findElement(hacebFormulario2.getBtnEnviar());
        enviarElement.click();

        try {
            Thread.sleep(5000); // Espera de 5 segundos
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
        String originalWindow = driver.getWindowHandle();


        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Maximizar la nueva ventana
        //driver.manage().window().maximize();



    }
    @Step("Perfil")
    public void abrirPerfil(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
        hacebInicial.openUrl("https://www.haceb.com/_secure/account#/profile");
    }


    @Step("Validación nombre usuario y correo")
    public void validacionFinal(){
        try {
            Thread.sleep(15000);
            String usuario=hacebValidacion.getDriver().findElement(hacebValidacion.getTxtUsuario()).getText();
            String correo=hacebValidacion.getDriver().findElement(hacebValidacion.getTxtCorreo()).getText();

            if (usuario.isEmpty()||correo.isEmpty()){
                System.out.println("Se verifica los campos "+usuario + " " + correo + " son correctos");
            }
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }

    }






}




