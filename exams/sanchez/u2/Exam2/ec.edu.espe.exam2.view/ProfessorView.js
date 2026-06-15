
class ProfessorView {

    renderProfessor(professor) {

        console.log("PROFESSOR LIST");

        professor.forEach(professor => {
            console.log(
                `${professor.id} - ${professor.name}
                 Total: ${professor.getTotalValue()}`
            );
        });
    }

    showMessage(message) {
        console.log(message);
    }
}
