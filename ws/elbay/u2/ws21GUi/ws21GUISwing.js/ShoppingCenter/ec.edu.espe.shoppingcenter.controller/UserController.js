class UserController {
    login(userName, password) {
        const user = new User(1, "Christopher", "Christopher");
        return user.getUserName() === userName && user.getPassword() === password;
    }
}