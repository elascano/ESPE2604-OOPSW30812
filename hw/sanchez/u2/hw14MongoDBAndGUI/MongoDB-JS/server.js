const express = require('express');
const cors = require('cors');
const path = require('path');
require('dotenv').config();

const { connect, getDatabase, close } = require('./config/database');
const productRoutes = require('./routes/products');
const creditRoutes = require('./routes/credits');
const expirationRoutes = require('./routes/expiration');

const app = express();
const PORT = process.env.PORT || 3000;

app.use(cors());
app.use(express.json());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/api/products', productRoutes);
app.use('/api/credits', creditRoutes);
app.use('/api/expiration', expirationRoutes);

app.get('/api/stats', async (req, res) => {
    try {
        const db = getDatabase();
        const productsCount = await db.collection('products').countDocuments();
        const creditsCount = await db.collection('credits').countDocuments();
        res.json({ productsCount, creditsCount });
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

app.get('*', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

async function startServer() {
    try {
        await connect();
        
        const db = getDatabase();
        const productsCount = await db.collection('products').countDocuments();
        const creditsCount = await db.collection('credits').countDocuments();
        
        console.log('\n' + '='.repeat(50));
        console.log('SafeStore Server Running with MongoDB Cloud');
        console.log('='.repeat(50));
        console.log(`Database: ${process.env.DATABASE_NAME}`);
        console.log(`Products in MongoDB: ${productsCount}`);
        console.log(`Credits in MongoDB: ${creditsCount}`);
        console.log(`Server: http://localhost:${PORT}`);
        console.log('='.repeat(50) + '\n');
        
        app.listen(PORT, () => {
            console.log(`Server running on http://localhost:${PORT}`);
        });
    } catch (error) {
        console.error('Failed to start server:', error);
        process.exit(1);
    }
}

process.on('SIGINT', async () => {
    await close();
    process.exit(0);
});

startServer();