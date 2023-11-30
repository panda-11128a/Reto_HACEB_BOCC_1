package com.haceb.pageObjectModel;

import jdk.nashorn.internal.objects.annotations.Getter;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class HacebFormulario2 extends PageObject {
    private final By inCedula =By.xpath("/html/body/div[5]/div[2]/div/form/div[1]/div[3]/input");
    private final By inGenero =By.xpath("/html/body/div[5]/div[2]/div/form/div[1]/div[4]/select");
    private final By inFechaNacimiento=By.xpath("/html/body/div[5]/div[2]/div/form/div[1]/div[5]/input");
    private final By inExtTelf =By.xpath("/html/body/div[5]/div[2]/div/form/div[1]/div[6]/fieldset/select");

    private final By inNumeroContacto =By.xpath("/html/body/div[5]/div[2]/div/form/div[1]/div[6]/fieldset/input");

    private final By inDepartamento =By.xpath("/html/body/div[5]/div[2]/div/form/div[1]/div[7]/select");

    private final By inCiudad =By.xpath("/html/body/div[5]/div[2]/div/form/div[1]/div[8]/select");
    private final By btnEnviar =By.xpath("//*[@id='gigya-profile-form']/div[2]/div[8]/font/font/input");

    @Getter
    public By getInCedula() {
        return inCedula;
    }
    @Getter
    public By getInGenero() {
        return inGenero;
    }
    @Getter
    public By getInFechaNacimiento() {
        return inFechaNacimiento;
    }
    @Getter
    public By getInExtTelf() {
        return inExtTelf;
    }
    @Getter
    public By getInNumeroContacto() {
        return inNumeroContacto;
    }
    @Getter
    public By getInDepartamento() {
        return inDepartamento;
    }
    @Getter
    public By getInCiudad() {
        return inCiudad;
    }
    @Getter
    public By getBtnEnviar() {
        return btnEnviar;
    }
}
