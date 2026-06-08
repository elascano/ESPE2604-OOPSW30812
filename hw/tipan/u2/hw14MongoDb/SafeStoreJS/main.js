const Supplier = require("./model/supplier");
const CashControl = require("./model/cashControl");
const SlowMoving = require("./model/slowMoving");

const { saveSupplier } = require("./dao/supplierDao");
const { saveCashControl } = require("./dao/cashControlDao");
const { saveSlowMoving } = require("./dao/slowMovingDao");

async function run() {

    const supplier = new Supplier("1", "David", "0988247321", "david@gmail.com");
    await saveSupplier(supplier);

    const cash = new CashControl("David", 100, 150);
    await saveCashControl(cash);

    const item = new SlowMoving("Papel Higienico", 150, 3, "Slow Moving");
    await saveSlowMoving(item);

    console.log("TODO GUARDADO EN MONGO JS");
}

run();