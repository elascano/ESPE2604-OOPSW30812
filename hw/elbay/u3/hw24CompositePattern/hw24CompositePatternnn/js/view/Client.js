class Client {
    static rootItem = null;

    static doClientTasks() {
        if (Client.rootItem) {
            Client.rootItem.describe();
        }
    }
}

module.exports = Client;
