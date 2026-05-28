// model/jsonManager.js
// Manejador de archivos JSON

export class JsonManager {
    static FILE_NAME = 'students.json';

    // Guardar estudiantes en localStorage (simula archivo JSON)
    static saveStudents(students) {
        try {
            const data = students.map(s => s.toJSON());
            localStorage.setItem(this.FILE_NAME, JSON.stringify(data, null, 2));
            console.log('Students saved successfully');
            return true;
        } catch (error) {
            console.error('Error saving:', error);
            return false;
        }
    }

    // Leer estudiantes desde localStorage
    static readStudents() {
        try {
            const saved = localStorage.getItem(this.FILE_NAME);
            if (!saved) return [];
            
            const data = JSON.parse(saved);
            return data.map(item => Student.fromJSON(item));
        } catch (error) {
            console.error('Error reading:', error);
            return [];
        }
    }

    // Exportar a JSON file (download)
    static exportToFile() {
        const data = localStorage.getItem(this.FILE_NAME);
        if (!data) return;
        
        const blob = new Blob([data], { type: 'application/json' });
        const url = URL.createObjectURL(blob);
        const a = document.createElement('a');
        a.href = url;
        a.download = this.FILE_NAME;
        a.click();
        URL.revokeObjectURL(url);
    }

    // Importar desde archivo JSON
    static importFromFile(file, callback) {
        const reader = new FileReader();
        reader.onload = (e) => {
            try {
                const data = JSON.parse(e.target.result);
                localStorage.setItem(this.FILE_NAME, JSON.stringify(data, null, 2));
                callback(true);
            } catch (error) {
                callback(false, error.message);
            }
        };
        reader.readAsText(file);
    }
}