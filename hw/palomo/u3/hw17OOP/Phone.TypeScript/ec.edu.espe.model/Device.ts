export abstract class Device {
    constructor(
        private brand: string,
        private model: string
    ) {}

    public getBrand(): string {
        return this.brand;
    }

    public getModel(): string {
        return this.model;
    }

    abstract turnOn(): void;
    abstract turnOff(): void;
}