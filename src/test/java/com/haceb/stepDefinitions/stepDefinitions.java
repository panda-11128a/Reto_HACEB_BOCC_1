package com.haceb.stepDefinitions;
import com.haceb.steps.HacebInicialSteps;
import io.cucumber.java.es.*;
import net.thucydides.core.annotations.Steps;
public class stepDefinitions {
   @Steps
    HacebInicialSteps hacebInicialSteps;
    @Dado("que el usuario abre el navegador")
    public void queElUsuarioAbreElNavegador() {
        hacebInicialSteps.abrirNavegadorHaceb();
        hacebInicialSteps.cerrarPopupSiPresente();
        
    }
    @Cuando("ingrese al acceso de usuario en Haceb")
    public void ingreseAlAccesoDeUsuarioEnHaceb() {
        hacebInicialSteps.clickIconoUsuario();
        
    }
    @Cuando("seleccione la opción de registrar")
    public void seleccioneLaOpciónDeRegistrar() {

        hacebInicialSteps.clickRegistrarUsuario();
        
    }
    @Cuando("ingrese a la página de registro de Haceb")
    public void ingreseALaPáginaDeRegistroDeHaceb() {
        hacebInicialSteps.ingresarPaginaRegistroHaceb();

        
    }
    @Cuando("el usuario ingrese los campos Correo electrónico {string}, Nombre {string}, Apellido {string}, Contraseña {string}, y Confirme su contraseña {string}")
    public void elUsuarioIngreseLosCamposCorreoElectrónicoNombreApellidoContraseñaYConfirmeSuContraseña(String string, String string2, String string3, String string4, String string5) {

     hacebInicialSteps.llenadoCamposExcel();
    }
    @Cuando("acepte los términos y condiciones")
    public void acepteLosTérminosYCondiciones() {
       hacebInicialSteps.aceptarTerminosYCondiciones();
        
        
    }
    @Cuando("autorice el uso de sus datos personales")
    public void autoriceElUsoDeSusDatosPersonales() {
     hacebInicialSteps.autorizarUsoDatosPersonales();
        
        
    }
    @Cuando("haga clic en el botón de registrarme")
    public void hagaClicEnElBotónDeRegistrarme() {
     hacebInicialSteps.clickBotonRegistrarme();
        
        
    }
    @Entonces("debería ser redirigido al menú principal y tener la opción de iniciar sesión")
    public void deberíaSerRedirigidoAlMenúPrincipalYTenerLaOpciónDeIniciarSesión() {
     hacebInicialSteps.completarRegistroFormulario();
     hacebInicialSteps.clickEnviar();
     hacebInicialSteps.abrirPerfil();
     hacebInicialSteps.validacionFinal();
        
    }
}
