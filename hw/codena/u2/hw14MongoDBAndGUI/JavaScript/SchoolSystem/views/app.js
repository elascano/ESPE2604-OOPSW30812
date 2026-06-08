const Student = require("../models/Student");

const Teacher = require("../models/Teacher");

const Course = require("../models/Course");

const StudentController = require("../controllers/studentController");

const TeacherController = require("../controllers/teacherController");

const CourseController = require("../controllers/courseController");

const studentController = new StudentController();

const teacherController = new TeacherController();

const courseController = new CourseController();

const saveButton =
    document.getElementById(
        "saveStudentButton"
    );

saveButton.addEventListener(
    "click",

    async () => {

        const id =
            document.getElementById(
                "studentId"
            ).value;

        const firstName =
            document.getElementById(
                "firstName"
            ).value;

        const lastName =
            document.getElementById(
                "lastName"
            ).value;

        const age =
            document.getElementById(
                "age"
            ).value;

        const student =
            new Student(
                id,
                firstName,
                lastName,
                parseInt(age)
            );

        await studentController
            .saveStudent(student);

        alert(
            "Student Saved"
        );
    }
);

const saveTeacherButton =
    document.getElementById(
        "saveTeacherButton"
    );

saveTeacherButton.addEventListener(

    "click",

    async () => {

        const id =
            document.getElementById(
                "teacherId"
            ).value;

        const name =
            document.getElementById(
                "teacherName"
            ).value;

        const subject =
            document.getElementById(
                "subject"
            ).value;

        const teacher =
            new Teacher(
                id,
                name,
                subject
            );

        await teacherController
            .saveTeacher(
                teacher
            );

        alert(
            "Teacher Saved"
        );
    }
);

const saveCourseButton =
    document.getElementById(
        "saveCourseButton"
    );

saveCourseButton.addEventListener(

    "click",

    async () => {

        const id =
            document.getElementById(
                "courseId"
            ).value;

        const name =
            document.getElementById(
                "courseName"
            ).value;

        const teacher =
            document.getElementById(
                "courseTeacher"
            ).value;

        const course =
            new Course(
                id,
                name,
                teacher
            );

        await courseController
            .saveCourse(
                course
            );

        alert(
            "Course Saved"
        );
    }
);

const searchStudentButton =
    document.getElementById(
        "searchStudentButton"
    );

searchStudentButton.addEventListener(

    "click",

    async () => {

        const student =
            await studentController
                .searchStudent(
                    document.getElementById(
                        "studentId"
                    ).value
                );

        if (!student) {

            alert("Student not found");

            return;
        }

        document.getElementById(
            "firstName"
        ).value = student.firstName;

        document.getElementById(
            "lastName"
        ).value = student.lastName;

        document.getElementById(
            "age"
        ).value = student.age;
    }
);

const updateStudentButton =
    document.getElementById(
        "updateStudentButton"
    );

updateStudentButton.addEventListener(

    "click",

    async () => {

        const student =
            new Student(

                document.getElementById(
                    "studentId"
                ).value,

                document.getElementById(
                    "firstName"
                ).value,

                document.getElementById(
                    "lastName"
                ).value,

                parseInt(
                    document.getElementById(
                        "age"
                    ).value
                )
            );

        await studentController
            .updateStudent(student);

        alert("Student Updated");
    }
);

const deleteStudentButton =
    document.getElementById(
        "deleteStudentButton"
    );

deleteStudentButton.addEventListener(

    "click",

    async () => {

        await studentController
            .deleteStudent(

                document.getElementById(
                    "studentId"
                ).value
            );

        alert("Student Deleted");
    }
);

const searchTeacherButton =
    document.getElementById(
        "searchTeacherButton"
    );

searchTeacherButton.addEventListener(

    "click",

    async () => {

        const teacher =
            await teacherController
                .searchTeacher(
                    document.getElementById(
                        "teacherId"
                    ).value
                );

        if (!teacher) {

            alert("Teacher not found");

            return;
        }

        document.getElementById(
            "teacherName"
        ).value = teacher.name;

        document.getElementById(
            "subject"
        ).value = teacher.subject;
    }
);

const updateTeacherButton =
    document.getElementById(
        "updateTeacherButton"
    );

updateTeacherButton.addEventListener(

    "click",

    async () => {

        const teacher =
            new Teacher(

                document.getElementById(
                    "teacherId"
                ).value,

                document.getElementById(
                    "teacherName"
                ).value,

                document.getElementById(
                    "subject"
                ).value
            );

        await teacherController
            .updateTeacher(teacher);

        alert("Teacher Updated");
    }
);

const deleteTeacherButton =
    document.getElementById(
        "deleteTeacherButton"
    );

deleteTeacherButton.addEventListener(

    "click",

    async () => {

        await teacherController
            .deleteTeacher(

                document.getElementById(
                    "teacherId"
                ).value
            );

        alert("Teacher Deleted");
    }
);

const searchCourseButton =
    document.getElementById(
        "searchCourseButton"
    );

searchCourseButton.addEventListener(

    "click",

    async () => {

        const course =
            await courseController
                .searchCourse(
                    document.getElementById(
                        "courseId"
                    ).value
                );

        if (!course) {

            alert("Course not found");

            return;
        }

        document.getElementById(
            "courseName"
        ).value = course.name;

        document.getElementById(
            "courseTeacher"
        ).value = course.teacher;
    }
);

const updateCourseButton =
    document.getElementById(
        "updateCourseButton"
    );

updateCourseButton.addEventListener(

    "click",

    async () => {

        const course =
            new Course(

                document.getElementById(
                    "courseId"
                ).value,

                document.getElementById(
                    "courseName"
                ).value,

                document.getElementById(
                    "courseTeacher"
                ).value
            );

        await courseController
            .updateCourse(course);

        alert("Course Updated");
    }
);

const deleteCourseButton =
    document.getElementById(
        "deleteCourseButton"
    );

deleteCourseButton.addEventListener(

    "click",

    async () => {

        await courseController
            .deleteCourse(

                document.getElementById(
                    "courseId"
                ).value
            );

        alert("Course Deleted");
    }
);