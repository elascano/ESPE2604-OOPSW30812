"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const StreamingPlatformController_1 = require("../controller/StreamingPlatformController");
async function main() {
    const controller = new StreamingPlatformController_1.StreamingPlatformController();
    await controller.init();
    console.log("Backend running");
}
main();
