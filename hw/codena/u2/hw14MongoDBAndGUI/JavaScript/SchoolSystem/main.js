const { BrowserWindow, app } = require("electron");
const mongo = require("./database/mongo");

function createWindow() {

    const window = new BrowserWindow({
        width: 1200,
        height: 800,

        webPreferences: {
            nodeIntegration: true,
            contextIsolation: false
        }
    });

    window.loadFile("views/index.html");
}

app.whenReady().then(() => {

    createWindow();
});