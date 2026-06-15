class User {
    constructor(id, userName, password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    getUserName() {
        return this.userName;
    }

    getPassword() {
        return this.password;
    }
}