import {Button} from "./Button";

export class LinuxButton implements Button {
    paint(): void {
        console.log("Renderizando un boton con estilo Linux.");
    }
}
