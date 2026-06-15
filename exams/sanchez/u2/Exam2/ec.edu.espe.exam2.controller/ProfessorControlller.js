class ProfessorController {

    constructor() {
        this.professor = [];
    }

    createProfessor(professor) {
        this.professors.push(professor);
    }

    getAllProducts() {
        return this.professors;
    }

    findById(id) {
        return this.professors.find(p => p.id === id);
    }

    updateProfessor(id, newData) {
        const professor = this.findById(id);

        if(professor){
            professor.name = newData.name;
            professor.price = newData.price;
            professor.quantity = newData.quantity;
        }
    }

    deleteProfessor(id) {
        this.professors =
            this.professors.filter(p => p.id !== id);
    }
}