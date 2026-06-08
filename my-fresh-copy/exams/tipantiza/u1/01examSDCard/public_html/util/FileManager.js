import fs from 'fs';

export class FileManager {

    constructor(filePath) {
        this.filePath = filePath;
    }

    save(data) {

        fs.writeFileSync(
            this.filePath,
            JSON.stringify(data, null, 2)
        );
    }

    load() {

        if (!fs.existsSync(this.filePath)) {
            return [];
        }

        const data =
            fs.readFileSync(
                this.filePath,
                'utf-8'
            );

        return JSON.parse(data);
    }
}