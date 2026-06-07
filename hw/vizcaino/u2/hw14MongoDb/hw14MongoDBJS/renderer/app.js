const backupDAO =
require("../dao/BackupDAO");

const reservationDAO =
require("../dao/ReservationDAO");

const comboDAO =
require("../dao/ComboDAO");

let selectedBackupId = null;
let selectedReservationId = null;
let selectedComboId = null;

async function loadBackups() {

    const backups =
    await backupDAO.findAll();

    const tbody =
    document.querySelector("#backupTable tbody");

    tbody.innerHTML = "";

    backups.forEach(backup => {

        const row =
        document.createElement("tr");

        row.innerHTML = `
            <td>${backup.id}</td>
            <td>${backup.fileName}</td>
            <td>${backup.status}</td>
            <td>${backup.date}</td>
        `;

        row.onclick = () => {

            selectedBackupId =
            backup.id;

        };

        tbody.appendChild(row);

    });
}

async function loadReservations() {

    const reservations =
    await reservationDAO.findAll();

    const tbody =
    document.querySelector("#reservationTable tbody");

    tbody.innerHTML = "";

    reservations.forEach(reservation => {

        const row =
        document.createElement("tr");

        row.innerHTML = `
            <td>${reservation.id}</td>
            <td>${reservation.customerName}</td>
            <td>${reservation.phone}</td>
            <td>${reservation.status}</td>
        `;

        row.onclick = () => {

            selectedReservationId =
            reservation.id;

        };

        tbody.appendChild(row);

    });
}

async function loadCombos() {

    const combos =
    await comboDAO.findAll();

    const tbody =
    document.querySelector("#comboTable tbody");

    tbody.innerHTML = "";

    combos.forEach(combo => {

        const row =
        document.createElement("tr");

        row.innerHTML = `
            <td>${combo.id}</td>
            <td>${combo.name}</td>
            <td>${combo.description}</td>
            <td>${combo.price}</td>
        `;

        row.onclick = () => {

            selectedComboId =
            combo.id;

        };

        tbody.appendChild(row);

    });
}

document
.getElementById("addBackup")
.onclick = async () => {

    await backupDAO.save({

        id:
        parseInt(
        document.getElementById("backupId").value),

        fileName:
        document.getElementById("backupFileName").value,

        status:
        document.getElementById("backupStatus").value,

        date:
        document.getElementById("backupDate").value
    });

    loadBackups();
};

document
.getElementById("deleteBackup")
.onclick = async () => {

    if(selectedBackupId !== null) {

        await backupDAO.delete(
        selectedBackupId);

        loadBackups();
    }
};

document
.getElementById("refreshBackup")
.onclick = loadBackups;

document
.getElementById("addReservation")
.onclick = async () => {

    await reservationDAO.save({

        id:
        parseInt(
        document.getElementById("reservationId").value),

        customerName:
        document.getElementById("customerName").value,

        phone:
        document.getElementById("phone").value,

        status:
        document.getElementById("reservationStatus").value
    });

    loadReservations();
};

document
.getElementById("deleteReservation")
.onclick = async () => {

    if(selectedReservationId !== null) {

        await reservationDAO.delete(
        selectedReservationId);

        loadReservations();
    }
};

document
.getElementById("refreshReservation")
.onclick = loadReservations;

document
.getElementById("addCombo")
.onclick = async () => {

    await comboDAO.save({

        id:
        parseInt(
        document.getElementById("comboId").value),

        name:
        document.getElementById("comboName").value,

        description:
        document.getElementById("comboDescription").value,

        price:
        parseFloat(
        document.getElementById("comboPrice").value)
    });

    loadCombos();
};

document
.getElementById("deleteCombo")
.onclick = async () => {

    if(selectedComboId !== null) {

        await comboDAO.delete(
        selectedComboId);

        loadCombos();
    }
};

document
.getElementById("refreshCombo")
.onclick = loadCombos;

loadBackups();
loadReservations();
loadCombos();