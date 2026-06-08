const { app, BrowserWindow, ipcMain } = require('electron');
const mongoose = require('mongoose');
const DoctorModel = require('./model/doctorModel');

let win;

const uri = "mongodb+srv://Angie:Angie@angienx.spphrbg.mongodb.net/MothersAppDB?retryWrites=true&w=majority";

function createWindow() {
    win = new BrowserWindow({
        width: 620,
        height: 380,
        resizable: false,
        autoHideMenuBar: true,
        webPreferences: {
            nodeIntegration: true,
            contextIsolation: false
        }
    });

    const htmlContent = `
    <!DOCTYPE html>
    <html>
    <head>
        <style>
            body { font-family: sans-serif; background-color: #f5f5f5; margin: 0; padding: 15px; user-select: none; }
            .title-panel { background-color: #e6ebf0; border: 1px solid #ababab; text-align: center; padding: 8px 0; margin-bottom: 15px; font-weight: bold; font-size: 14px; }
            .main-container { display: flex; gap: 15px; }
            .panel { border: 1px solid #b0b0b0; background-color: #f5f5f5; padding: 20px 15px 15px 15px; position: relative; flex: 1; }
            .panel::before { content: attr(data-title); position: absolute; top: -10px; left: 10px; background: #f5f5f5; padding: 0 5px; font-size: 12px; font-weight: bold; }
            .form-panel { display: flex; flex-direction: column; gap: 18px; }
            .actions-panel { display: flex; flex-direction: column; gap: 10px; justify-content: center; }
            .form-group { display: flex; align-items: center; }
            .form-group label { width: 140px; font-size: 12px; }
            .form-group input, .form-group select { flex: 1; padding: 4px; border: 1px solid #ababab; font-size: 12px; }
            .btn { width: 100%; padding: 5px; font-size: 12px; background-color: #e1e1e1; border: 1px solid #7a7a7a; cursor: pointer; }
            .btn:hover { background-color: #d0d0d0; }
        </style>
    </head>
    <body>
        <div class="title-panel">DOCTOR MANAGEMENT SYSTEM</div>
        <div class="main-container">
            <div class="panel form-panel" data-title=" Doctor Management ">
                <div class="form-group" style="margin-top: 5px;">
                    <label>ID:</label>
                    <input type="text" id="txtId">
                </div>
                <div class="form-group">
                    <label>NAME:</label>
                    <input type="text" id="txtName">
                </div>
                <div class="form-group">
                    <label>SPECIALITY:</label>
                    <select id="cmbSpeciality">
                        <option value="Obstetrics">Obstetrics</option>
                        <option value="Gynecology">Gynecology</option>
                        <option value="Pediatrics">Pediatrics</option>
                        <option value="General Medicine">General Medicine</option>
                    </select>
                </div>
            </div>
            <div class="panel actions-panel" data-title=" Operations ">
                <button class="btn" onclick="save()">Save/Update Doctor</button>
                <button class="btn" onclick="alert('Invoking viewPatientHistory()...')">Load Doctor</button>
                <button class="btn" onclick="window.close()">Back to Menu</button>
            </div>
        </div>
        <script>
            const { ipcRenderer } = require('electron');
            function save() {
                const id = document.getElementById('txtId').value.trim();
                const name = document.getElementById('txtName').value.trim();
                const speciality = document.getElementById('cmbSpeciality').value;
                if(!id || !name) return alert('Fields cannot be empty.');
                ipcRenderer.send('save-data', { id, name, speciality });
            }
            ipcRenderer.on('res', (e, m) => {
                alert(m);
                document.getElementById('txtId').value = '';
                document.getElementById('txtName').value = '';
            });
        </script>
    </body>
    </html>`;

    win.loadURL('data:text/html;charset=utf-8,' + encodeURIComponent(htmlContent));
}

ipcMain.on('save-data', async (event, { id, name, speciality }) => {
    try {
        const doc = new DoctorModel({ doctorData: { id: parseInt(id), name, speciality } });
        await doc.save();
        event.reply('res', 'Doctor data saved directly to Cloud!');
    } catch(err) { 
        event.reply('res', 'Error: ' + err.message); 
    }
});

app.whenReady().then(() => {
    mongoose.connect(uri)
        .then(() => {
            console.log("Connected to MongoDB Atlas successfully!");
            createWindow();
        })
        .catch(err => console.error("Database connection error:", err));
});