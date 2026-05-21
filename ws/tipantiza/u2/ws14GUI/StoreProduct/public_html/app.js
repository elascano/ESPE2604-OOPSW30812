const express = require('express');
const path = require('path');

const productRoutes = require('./routes/products');

const app = express();

app.use(express.json());

/*
    Archivos públicos:
    CSS y JS
*/
app.use(express.static(path.join(__dirname, 'view')));

/*
    API
*/
app.use('/api/products', productRoutes);

/*
    Página principal
*/
app.get('/', (req, res) => {

    res.sendFile(
        path.join(__dirname, 'view/index.html')
    );
});

const PORT = 3000;

app.listen(PORT, () => {

    console.log(`
    Servidor iniciado en:

    http://localhost:${PORT}
    `);
});