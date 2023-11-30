#language:es
Característica: Registro Haceb
  Escenario: Registro exitoso Haceb
    Dado que el usuario abre el navegador
    Cuando ingrese al acceso de usuario en Haceb
    Y seleccione la opción de registrar
    Y ingrese a la página de registro de Haceb
    Y el usuario ingrese los campos Correo electrónico "<email>", Nombre "<nombre>", Apellido "<apellido>", Contraseña "<password>", y Confirme su contraseña "<confirmar_contraseña>"
    Y acepte los términos y condiciones
    Y autorice el uso de sus datos personales
    Y haga clic en el botón de registrarme
    Entonces debería ser redirigido al menú principal y tener la opción de iniciar sesión

