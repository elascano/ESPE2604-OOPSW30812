const { app, BrowserWindow } = require("electron");
const path = require("path");

require("./ec.edu.espe.main/app");

function createWindow() {

    const win = new BrowserWindow({
        width: 1000,
        height: 700
    });

    win.loadFile(
        path.join(__dirname, "GUI", "index.html")
    );
}

app.whenReady().then(() => {

    setTimeout(() => {
        createWindow();
    }, 2000);

});

app.on("window-all-closed", () => {

    if (process.platform !== "darwin") {
        app.quit();
    }
});