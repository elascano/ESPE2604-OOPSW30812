class Grade {
  constructor(studentId, value) {
    if (value < 0 || value > 20) {
      throw new Error("Grade must be between 0 and 20.");
    }
    this.studentId = studentId;
    this.value = value;
  }

  toJson() {
    return {
      studentId: this.studentId,
      value: this.value,
    };
  }

  static fromJson(data) {
    return new Grade(data.studentId || "", Number(data.value || 0));
  }
}

module.exports = Grade;
