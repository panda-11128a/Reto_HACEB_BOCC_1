package com.haceb.pageObjectModel;

import jdk.nashorn.internal.objects.annotations.Getter;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class HacebFormulario1 extends PageObject {
    private final By textEmail =By.xpath("//*[@id=\"gigya-loginID-51216659851706440\"]");
    private final By textNombre =By.xpath("//*[@id=\"gigya-textbox-72173553995486780\"]");
    private final By textApellido =By.xpath("//*[@id=\"gigya-textbox-146410824335495100\"]");
    private final By textPass =By.xpath("//*[@id=\"gigya-password-54061940132406190\"]");
    private final By textPassConfirmar =By.xpath("//*[@id=\"gigya-password-142670944012194750\"]");
    private final By checkTerminos =By.xpath("//*[@id=\"gigya-register-form\"]/div[2]/div[9]/label/span");
    private final By checkAutorizacion =By.xpath("/html/body/div[5]/div[2]/div/form/div[2]/div[10]/div[2]/label");
    private final By checkRegistrarme =By.xpath("//*[@id=\"gigya-register-form\"]/div[2]/div[11]/input");
    @Getter
    public By getTextEmail() {
        return textEmail;
    }
    @Getter
    public By getTextNombre() {
        return textNombre;
    }
    @Getter
    public By getTextApellido() {
        return textApellido;
    }
    @Getter
    public By getTextPass() {
        return textPass;
    }
    @Getter
    public By getTextPassConfirmar() {
        return textPassConfirmar;
    }
    @Getter
    public By getCheckTerminos() {
        return checkTerminos;
    }
    @Getter
    public By getCheckAutorizacion() {
        return checkAutorizacion;
    }
    @Getter
    public By getCheckRegistrarme() {
        return checkRegistrarme;
    }
}
