const LibraryGUI = require('./view/library_gui');

async function main() {
    const app = new LibraryGUI();
    await app.run();
}

main().catch(console.error);