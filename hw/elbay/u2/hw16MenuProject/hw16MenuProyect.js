<input type="text" id="usuario" placeholder="Usuario">
<input type="password" id="pass" placeholder="Contraseña">
<button onclick="validar()">Ingresar</button>

<script>
function validar() {
    let u = document.getElementById("usuario").value;
    let p = document.getElementById("pass").value;
    
    if (u === "admin" && p === "1234") {
        alert("Acceso concedido");
    } else {
        alert("Usuario o contraseña incorrectos");
    }
}
</script>