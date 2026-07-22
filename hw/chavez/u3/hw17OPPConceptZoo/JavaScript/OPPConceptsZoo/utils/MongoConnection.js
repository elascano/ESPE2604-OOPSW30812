import { MongoClient } from "mongodb";

const uri =
    "mongodb+srv://odalys:odalys@cluster0.2cf9puv.mongodb.net/?appName=Cluster0";

const client = new MongoClient(uri);

export async function connect() {

    await client.connect();

    return client.db("FarmDB");

}