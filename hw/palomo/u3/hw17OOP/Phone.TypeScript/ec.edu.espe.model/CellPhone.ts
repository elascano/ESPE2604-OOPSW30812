import { Device } from "./Device";
import { Battery } from "./Battery";
import { Screen } from "./Screen";
import { SIMCard } from "./SIMCard";

export class CellPhone extends Device {

    constructor(
        brand: string,
        model: string,
        private imei: string,

        // Composition
        private battery: Battery,

        // Association
        private screen: Screen,

        // Aggregation
        private simCard: SIMCard
    ) {
        super(brand, model);
    }

    override turnOn(): void {
        console.log("Phone ON");
    }

    override turnOff(): void {
        console.log("Phone OFF");
    }

    public makeCall(number: string): void {
        console.log(`Calling ${number}`);
    }

    public showInfo(): void {
        console.log("\nPHONE INFORMATION");
        console.log(`Brand: ${this.getBrand()}`);
        console.log(`Model: ${this.getModel()}`);
        console.log(`IMEI: ${this.imei}`);
        console.log(`Battery: ${this.battery.getCapacity()} mAh`);
        console.log(`Screen: ${this.screen.getSize()} inches`);
        console.log(`Operator: ${this.simCard.getOperator()}`);
    }

    public toJSON() {
        return {
            brand: this.getBrand(),
            model: this.getModel(),
            imei: this.imei,
            battery: this.battery.getCapacity(),
            screen: this.screen.getSize(),
            operator: this.simCard.getOperator()
        };
    }
}