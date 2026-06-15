# ESPE2604-OOPSW30812

## Object Oriented Programming for ESPE ESPE2604-OOPSW30812

### Instructor: Jorge Edison Lascano
### Student: Mateo Artieda

This is the folder for UNIT 2 Exams.

---

# Examen Unidad 2: Country Manager Application (Java Swing - MVC)

Esta aplicación gestiona la información de varios países implementando operaciones completas **CRUD** (Create, Read, Update, Delete) utilizando el lenguaje **Java** y la arquitectura **Modelo-Vista-Controlador (MVC)**.

## 1. Diseño del Diagrama de Clases (MVC Pattern)

El diseño está separado en tres paquetes principales para garantizar un diseño limpio y modular:
* **Model**: 
  * `Country`: Representa la entidad con los atributos `id`, `name`, `population`, `area` y la lógica de negocio para calcular la densidad poblacional.
  * `CountryModel`: Se encarga de gestionar la lista de países en memoria y persistir los datos en un archivo de texto (`countries.txt`).
* **View**:
  * `CountryView`: Diseña la interfaz gráfica de usuario Swing con sus componentes y paneles.
* **Controller**:
  * `CountryController`: Conecta la interfaz y el modelo, manejando los eventos de acción de los botones.

### Diagrama de Clases UML
![UML Class Diagram](class_diagram.jpg)

---

## 2. Mockup de Interfaz Gráfica (GUI Mockup) & Widgets Utilizados

La aplicación contiene un panel superior de título, un formulario con campos de texto para la entrada de datos, botones para realizar acciones de inserción, búsqueda, actualización y borrado, y una tabla inferior para mostrar los registros.

### Mockup de la GUI
![GUI Mockup](gui_mockup.jpg)

### Componentes Utilizados (Widgets)
* **`JFrame`**: Ventana principal contenedora de la aplicación (`CountryView`).
* **`JPanel`**: Contenedores para organizar los subpaneles (cabecera, formulario, botones, tabla).
* **`JLabel`**: Etiquetas de texto descriptivo para el formulario.
* **`JTextField`**: Campos de entrada para ID del país, Nombre, Población y Área.
* **`JButton`**: Botones para desencadenar eventos de CRUD (Create, Update, Delete, Clear, Find).
* **`JTable`**: Grilla de datos que muestra los países cargados y su densidad poblacional calculada.
* **`JScrollPane`**: Panel que permite desplazarse en la tabla si hay muchos registros.
* **`JOptionPane`**: Ventanas de diálogo emergentes para validación, éxito y alertas.

---

## 3. Lógica de Negocio y Persistencia
* **Lógica de Negocio**: Cálculo de la densidad poblacional (habitantes por kilómetro cuadrado).
  $$\text{Densidad} = \frac{\text{Población}}{\text{Área}}$$
  Esto se calcula dinámicamente en el getter `getPopulationDensity()` de la clase `Country`.
* **Persistencia**: Los datos se cargan y guardan automáticamente en formato de texto plano tipo CSV en el archivo `countries.txt`. Al iniciar el programa, si el archivo no existe, se crea con datos de ejemplo (Ecuador, Colombia, Perú, Brasil).

---

## 4. Instrucciones para Ejecutar la Aplicación

Para facilitar la prueba de la aplicación, se han creado scripts por lotes (.bat) listos para usar:
1. Abre la carpeta del código: [CountryManager](file:///C:/Users/G300/Documents/ESPE2604-OOPSW30812/exams/artieda/u2/CountryManager).
2. Haz doble clic en [compile.bat](file:///C:/Users/G300/Documents/ESPE2604-OOPSW30812/exams/artieda/u2/CountryManager/compile.bat) para compilar las clases.
3. Haz doble clic en [run.bat](file:///C:/Users/G300/Documents/ESPE2604-OOPSW30812/exams/artieda/u2/CountryManager/run.bat) para iniciar la interfaz gráfica.
