import { StreamingPlatformController } from "../controller/StreamingPlatformController";

const controller = new StreamingPlatformController();

async function init() {
    await controller.init();
    await loadUsers();
}

async function createUser() {
    const name = (document.getElementById("name") as HTMLInputElement).value;
    const plan = (document.getElementById("plan") as HTMLInputElement).value;

    await controller.create({ name, plan });
    await loadUsers();
}

async function loadUsers() {
    const users = await controller.read();

    const table = document.getElementById("table")!;
    table.innerHTML = "";

    users.forEach((u: any) => {
        const row = document.createElement("tr");
        row.innerHTML = `<td>${u.name}</td><td>${u.plan}</td>`;
        table.appendChild(row);
    });
}

async function updateUser() {
    const name = (document.getElementById("name") as HTMLInputElement).value;
    const plan = (document.getElementById("plan") as HTMLInputElement).value;

    await controller.update(name, plan);
    await loadUsers();
}

async function deleteUser() {
    const name = (document.getElementById("name") as HTMLInputElement).value;

    await controller.delete(name);
    await loadUsers();
}

(window as any).createUser = createUser;
(window as any).updateUser = updateUser;
(window as any).deleteUser = deleteUser;
(window as any).loadUsers = loadUsers;

init();