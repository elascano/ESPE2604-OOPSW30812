const dns = require('dns');

dns.setDefaultResultOrder('ipv4first');

const { MongoClient } = require("mongodb");

const uri = "mongodb://daniel:daniel1234@ac-oatfhmo-shard-00-00.zfwd5wx.mongodb.net:27017,ac-oatfhmo-shard-00-01.zfwd5wx.mongodb.net:27017,ac-oatfhmo-shard-00-02.zfwd5wx.mongodb.net:27017/?ssl=true&replicaSet=atlas-mo7edf-shard-0&authSource=admin&appName=Cluster0"

async function test() {

    const client = new MongoClient(uri);

    try {

        console.log("Connecting...");

        await client.connect();

        console.log("Connected!");

        const db = client.db("admin");

        await db.command({ ping: 1 });

        console.log("Ping successful!");

    } catch(error) {

        console.error("ERROR:");
        console.error(error);

    } finally {

        await client.close();
    }
}

test();