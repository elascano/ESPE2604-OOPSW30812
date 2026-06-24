import { StreamingPlatformController } from "../controller/StreamingPlatformController";

async function main() {
    const controller = new StreamingPlatformController();
    await controller.init();

    console.log("Backend running");
}

main();