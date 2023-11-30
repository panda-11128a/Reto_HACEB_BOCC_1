package com.haceb.pageObjectModel;

import jdk.nashorn.internal.objects.annotations.Getter;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class HacebInicial extends PageObject {
    private final By divRegistro=By.xpath("//div[@class='link-account-item link-account-user']");
    private final By divPopup=By.xpath("//div[@class='gigya-screen-dialog-close']");
    private final By aRegistrar =By.xpath("//a[@href='#' and @class='cdc-fire cdc-register']");
    private final By btnAccesoHacebRegistro =By.xpath("//button[@id='vtexIdUI-custom-oauth']");

    @Getter
    public By getDivRegistro() {
        return divRegistro;
    }
    @Getter
    public By getDivPopup() {
        return divPopup;
    }
    @Getter
    public By getaRegistrar() {
        return aRegistrar;
    }
    @Getter
    public By getBtnAccesoHacebRegistro() {
        return btnAccesoHacebRegistro;
    }

}
