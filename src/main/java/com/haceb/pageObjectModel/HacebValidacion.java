package com.haceb.pageObjectModel;

import jdk.nashorn.internal.objects.annotations.Getter;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class HacebValidacion extends PageObject {
    private final By txtUsuario =By.xpath("/html/body/div[5]/section/div/div/div/div/section/header/div[2]/div/div/div[1]");
    private final By txtCorreo =By.xpath("/html/body/div[5]/section/div/div/div/div/section/main/main/div[1]/div/article/main/div/div[2]/div/form/div[2]/div[3]/input");
@Getter
    public By getTxtUsuario() {
        return txtUsuario;
    }
@Getter
    public By getTxtCorreo() {
        return txtCorreo;
    }
}
