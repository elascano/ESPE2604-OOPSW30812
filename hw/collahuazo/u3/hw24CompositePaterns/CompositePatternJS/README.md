# Composite Pattern - JavaScript (MVC)

Traducción a JavaScript (CommonJS / Node.js, sin dependencias) del proyecto
Java original (patrón de diseño **Composite**), manteniendo la misma
estructura MVC. `Setup.js` es el punto de entrada, igual que la clase
`Setup` con `main()` en la versión Java.

## Requisitos

Node.js (no requiere `package.json` ni dependencias externas).

## Cómo ejecutar

```bash
node composite/view/Setup.js
```

## Estructura

```
CompositePatternJS/
└── composite/
    ├── model/
    │   ├── Employee.js       → Componente abstracto (Employee)
    │   ├── Supervisor.js     → Composite abstracto (tiene hijos)
    │   ├── Manager.js        → Composite concreto
    │   ├── President.js      → Composite concreto (Singleton)
    │   ├── Clerk.js           → Hoja
    │   └── Teller.js          → Hoja
    ├── controller/
    │   └── Client.js         → Usa la jerarquía sin distinguir hoja/compuesto
    └── view/
        └── Setup.js          → Arma el organigrama y se autoejecuta (main)
```

## Equivalencias Java -> JavaScript

| Java                                    | JavaScript                                                        |
|-------------------------------------------|------------------------------------------------------------------|
| `abstract class Employee`                 | `class Employee` que lanza error si `new.target === Employee`     |
| `Vector<Employee> directReports`          | `Array` (`this.directReports = []`)                               |
| `super.stateName()`                       | `super.stateName()`                                               |
| Constructor privado + Singleton (President) | Campo privado estático `#president` + bandera interna que bloquea `new President()` fuera de `getPresident()` |
| Atributos `public static` (Client)        | Campos estáticos de clase (`static employee`, `static doClientTasks()`) |
| `public static void main()` (Setup)       | Función `setup()` que se llama a sí misma al final del archivo (`setup();`) |
| `System.out.println`                      | `console.log`                                                    |
| `import`/módulos                          | `require` / `module.exports` (CommonJS, sin necesidad de `package.json`) |

## Salida esperada

```
President Pete
Manager Able
Teller Lonny
Clerk Cal
Manager Becky
Teller Juanita
Teller Tina
Teller Thelma
```
