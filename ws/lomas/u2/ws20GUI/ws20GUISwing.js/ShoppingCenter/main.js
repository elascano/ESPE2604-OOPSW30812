document.addEventListener("DOMContentLoaded", () => {
    const btnIngresar = document.getElementById("btnIngresar");
    
    if (btnIngresar) {
        btnIngresar.addEventListener("click", () => {
            const usuario = document.getElementById("txtUsuario").value;
            const contrasena = document.getElementById("psdPassword").value;

          
            if (usuario === "admin" && contrasena === "1234") {
               
                window.location.href = "FrmCustomer.html";
            } else {
                alert("Usuario o Contraseña incorrectos");
            }
        });
    }
});

//http://localhost:3006/ec.edu.espe.shoppingcenter.view/FrmSplash.html