const fs = require('fs');
const readline = require('readline');

class Microphone {
    constructor(id, brand, modell, length) {
        this.id = id;
        this._brand = brand;
        this._modell = modell;
        this._length = length;
    }

    get brand() {
        return this._brand;
    }

    get modell() {
        return this._modell;
    }

    get length() {
        return this._length;
    }

    set brand(newBrand) {
        this._brand = newBrand;
    }

    set modell(newmodell) {
        this._modell = newmodell;
    }

    set length(newLength) {
        this._length = newLength;
    }
}

class ReadMicrophone {
    static read(filename) {
        try {
            const jsonString = fs.readFileSync(filename, 'utf8');
            const MicrophoneData = JSON.parse(jsonString);
            return MicrophoneData.map(p => new Microphone(p.id, p._brand, p._modell, p._length));
        } catch (error) {
            throw new Error(`Error reading ${filename}: ${error.message}`);
        }
    }
}

class SaveMicrophone {
    static save(Microphones, filename) {
        if (!Array.isArray(Microphones) || !Microphones.every(p => p instanceof Microphone)) {
            throw new Error("save is not an array of Microphone instances.");
        }
        const json = JSON.stringify(Microphones);
        fs.writeFileSync(filename, json);
        console.log(`Microphones saved to ${filename}`);
    }
}

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function askQuestion(query) {
    return new Promise(resolve => rl.question(query, resolve));
}

async function main() {
    const Microphones = [];
    let id = 1;

    while (true) {
        const brand = await askQuestion(`brand for Microphone ${id}: `);
        const modell = await askQuestion(`modell for Microphone ${id}: `);
        const length = await askQuestion(`length for Microphone ${id}: `);

        Microphones.push(new Microphone(id, brand, modell, parseFloat(length)));

        const another = await askQuestion('Do you want to add another Microphone? (yes/no): ');
        if (another.toLowerCase() !== 'yes') {
            break;
        }

        id++;
    }

    const filename = 'Microphone.json';
    SaveMicrophone.save(Microphones, filename);

    const readMicrophones = ReadMicrophone.read(filename);

    console.log("Read Microphones:", readMicrophones);

    rl.close();
}

main();