class Student {
  constructor(id, firstName, lastName, phoneNumber) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
  }

  toJson() {
    return {
      id: this.id,
      firstName: this.firstName,
      lastName: this.lastName,
      phoneNumber: this.phoneNumber,
    };
  }

  static fromJson(data) {
    return new Student(
      data.id || "",
      data.firstName || "",
      data.lastName || "",
      data.phoneNumber || ""
    );
  }
}

module.exports = Student;
