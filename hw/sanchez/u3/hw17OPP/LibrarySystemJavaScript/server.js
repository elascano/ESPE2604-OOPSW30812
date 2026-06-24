const express = require("express");
const path = require("path");
const { connectToDatabase } = require("./utils/MongoConnection");

const app = express();

app.use(express.json());
app.use(express.static(path.join(__dirname, "public")));
app.use("/books", require("./routes/bookRoutes"));

async function startServer() {
    try {
        await connectToDatabase();
        app.listen(3000, () => {
            console.log("🚀 Library System running on port 3000");
            console.log("📚 Abre http://localhost:3000");
        });
    } catch (error) {
        console.error("❌ No se pudo iniciar el servidor:", error);
        process.exit(1);
    }
}

startServer();