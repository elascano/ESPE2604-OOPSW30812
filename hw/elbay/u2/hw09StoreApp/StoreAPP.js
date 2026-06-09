<!DOCTYPE html>
<html>
<head>
    <title>Gestión de Estudiantes</title>
    <style>
        body{
            font-family:Arial;
            width:600px;
            margin:auto;
        }

        input,select{
            width:100%;
            margin:5px 0;
            padding:5px;
        }

        table{
            width:100%;
            border-collapse:collapse;
            margin-top:20px;
        }

        th,td{
            border:1px solid black;
            padding:8px;
        }
    </style>
</head>
<body>

<h2>Gestión de Estudiantes</h2>

<input type="text" id="id" placeholder="ID">
<input type="text" id="nombre" placeholder="Nombre">

<label>Edad</label>
<input type="range" id="edad" min="0" max="100">

<select id="curso">
    <option>Matemáticas</option>
    <option>Física</option>
    <option>Inglés</option>
</select>

<button onclick="guardar()">Guardar</button>

<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Edad</th>
            <th>Curso</th>
        </tr>
    </thead>
    <tbody id="tabla"></tbody>
</table>

<script>
function guardar(){
    let id = document.getElementById("id").value;
    let nombre = document.getElementById("nombre").value;
    let edad = document.getElementById("edad").value;
    let curso = document.getElementById("curso").value;

    let fila = `
    <tr>
        <td>${id}</td>
        <td>${nombre}</td>
        <td>${edad}</td>
        <td>${curso}</td>
    </tr>`;

    document.getElementById("tabla").innerHTML += fila;
}
</script>

</body>
</html>