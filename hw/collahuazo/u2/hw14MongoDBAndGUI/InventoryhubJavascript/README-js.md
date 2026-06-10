# InventoryHub JavaScript Version

Esta carpeta contiene la versión JavaScript de InventoryHub con un backend Express y un frontend web estático.

## Estructura
- `package.json` - dependencias de Node.js.
- `src/server.js` - servidor Express y rutas API.
- `src/models/` - modelos de datos para Customer, Product y Supplier.
- `src/controllers/` - lógica de negocio + acceso a base de datos.
- `src/utils/db.js` - conexión a MongoDB.
- `public/` - frontend HTML/CSS/JS.

## Requisitos
- Node.js 18+ instalado
- Acceso a MongoDB (se usa la misma URI del proyecto original)

## Instalación
Desde la carpeta `javascript_inventoryhub`:

```powershell
npm install
```

## Ejecución
```powershell
npm start
```

Luego abre `http://localhost:3000`.

## API
- `GET /api/customers`
- `GET /api/products`
- `GET /api/suppliers`
- `POST /api/customers`
- `POST /api/products`
- `POST /api/suppliers`
