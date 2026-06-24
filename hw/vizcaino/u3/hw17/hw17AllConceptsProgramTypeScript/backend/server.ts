import express from "express";
import cors from "cors";
import { MongoClient } from "mongodb";

const app = express();
app.use(cors());
app.use(express.json());

const uri = "mongodb://Adrian:Adrian@ac-mcmbw4z-shard-00-00.e4n4vbs.mongodb.net:27017,ac-mcmbw4z-shard-00-01.e4n4vbs.mongodb.net:27017,ac-mcmbw4z-shard-00-02.e4n4vbs.mongodb.net:27017/hw17TypeScript?ssl=true&replicaSet=atlas-127ql3-shard-0&authSource=admin&retryWrites=true&w=majority";

const client = new MongoClient(uri);

let collection: any;

async function start() {
    await client.connect();

    const db = client.db("hw17TypeScript");
    collection = db.collection("users");

    console.log("API running on 3000");

    app.get("/users", async (req, res) => {
        res.json(await collection.find().toArray());
    });

    app.post("/users", async (req, res) => {
        console.log("RECIBIDO:", req.body);
        await collection.insertOne(req.body);
        res.json({ ok: true });
    });

    app.listen(3000);
}

start();