# Strategy Pattern - Sorting App (Python)

Implementacion del patron **Strategy** para seleccionar el algoritmo de
ordenamiento adecuado segun el tamano del arreglo, con arquitectura **MVC**
y una carpeta `utils/` para la conexion a la base de datos.

## Estructura del proyecto

```
sorting_strategy_app/
├── model/
│   └── sort_record.py           # SOLO estructura de la clase SortRecord
├── controller/
│   ├── sorting_strategy.py      # Clase padre (Strategy): SortingStrategy
│   ├── bubble_sort.py           # Clase hija (ConcreteStrategyA): BubbleSort
│   ├── insertion_sort.py        # Clase hija (ConcreteStrategyC): InsertionSort
│   ├── quick_sort.py            # Clase hija (ConcreteStrategyB): QuickSort
│   ├── sorting_context.py       # Context: SortingContext
│   └── sort_controller.py       # Logica: parseo, validacion, seleccion de
│                                 #   algoritmo, orquestacion con la BD
├── view/
│   └── main_view.py             # Punto de entrada + GUI (Tkinter) -> SortApp (Client)
├── utils/
│   └── db_connection.py         # Conexion a MongoDB Atlas
└── requirements.txt
```

## Relacion con el diagrama UML (patron Strategy)

| Clase del diagrama | Archivo |
|---|---|
| SortApp (Client) | `view/main_view.py` |
| SortingContext (Context) | `controller/sorting_context.py` |
| SortingStrategy (Strategy, clase padre) | `controller/sorting_strategy.py` |
| BubbleSort (ConcreteStrategyA) | `controller/bubble_sort.py` |
| QuickSort (ConcreteStrategyB) | `controller/quick_sort.py` |
| InsertionSort (ConcreteStrategyC) | `controller/insertion_sort.py` |

## Reglas de seleccion del algoritmo (segun el enunciado)

| Tamano del arreglo | Algoritmo       |
|---------------------|-----------------|
| 2 a 6                | Bubble Sort     |
| 7 a 10               | Insertion Sort  |
| 11 en adelante       | Quick Sort      |
| < 2                  | Error (invalido)|

## Configuracion antes de ejecutar

1. Instala las dependencias:
   ```bash
   pip install -r requirements.txt
   ```

2. Abre `utils/db_connection.py` y reemplaza:
   - `CONNECTION_STRING` con tu cadena de conexion real de MongoDB Atlas
     (Atlas → Database → Connect → Drivers → Python).
   - `DB_NAME = "strategyLastName"` → reemplaza `LastName` por tu apellido.
   - `COLLECTION_NAME = "arrayFirstName"` → reemplaza `FirstName` por tu nombre.

   Asegurate tambien de que tu IP este en la lista blanca de Atlas
   (Network Access) y que el usuario/password de la cadena sean correctos.

## Ejecutar la aplicacion

```bash
python view/main_view.py
```

Ingresa los numeros separados por comas (ej. `5, 8, 7, 2`) y presiona
**Ordenar**. La ventana mostrara el arreglo sin ordenar, su tamano, el
algoritmo elegido y el arreglo ordenado; el mismo registro se guarda en tu
coleccion de MongoDB Atlas con el formato:

```json
{"unsorted": "5, 8, 7, 2", "size": 4, "sort algorithm": "InsertionSort", "sorted": "2, 5, 7, 8"}
```
