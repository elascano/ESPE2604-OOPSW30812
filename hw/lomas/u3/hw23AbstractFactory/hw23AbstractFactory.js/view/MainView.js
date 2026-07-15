class MainView {
    constructor() {
        this.controller = new WidgetController();
        this.generateBtn = document.getElementById("generateBtn");
        this.outputArea = document.getElementById("outputArea");
        
        this.init();
    }

    init() {
        this.generateBtn.addEventListener("click", () => this.onGenerate());
    }

    onGenerate() {
        const result = this.controller.generateWidgets();
        this.outputArea.textContent = result;
    }
}
window.MainView = MainView;