const Vehicle =
require("../ec.edu.espe.model/Vehicle");

const { getDatabase } =
require("../config/mongodb");

class VehicleController {

    async createVehicle(
        id,
        description,
        value,
        quantity
    ) {

        const vehicle =
        new Vehicle(
            id,
            description,
            value,
            quantity
        );

        const db =
        await getDatabase();

        await db
        .collection("vehicles")
        .insertOne(vehicle);

        console.log(
            "Vehicle Saved"
        );

        return vehicle;
    }

    async getVehicles() {

        const db =
        await getDatabase();

        return await db
        .collection("vehicles")
        .find({})
        .toArray();
    }
}

module.exports = VehicleController;