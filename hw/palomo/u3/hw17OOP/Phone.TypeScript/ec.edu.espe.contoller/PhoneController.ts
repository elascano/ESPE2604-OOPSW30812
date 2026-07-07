import * as fs from "fs";
import { CellPhone } from "../ec.edu.espe.model/CellPhone";

export class PhoneController {

    private filePath = "../ec.edu.espe.data/phones.json";

    public savePhone(phone: CellPhone): void {

        let phones: any[] = [];

        if (fs.existsSync(this.filePath)) {
            const data = fs.readFileSync(this.filePath, "utf8");

            if (data.trim() !== "") {
                phones = JSON.parse(data);
            }
        }

        phones.push(phone.toJSON());

        fs.writeFileSync(
            this.filePath,
            JSON.stringify(phones, null, 4)
        );

        console.log("Phone saved successfully!");
    }

    public showPhones(): void {

        if (!fs.existsSync(this.filePath)) {
            console.log("No registered phones.");
            return;
        }

        const phones = JSON.parse(
            fs.readFileSync(this.filePath, "utf8")
        );

        console.log("\nREGISTERED PHONES");
        console.table(phones);
    }
}