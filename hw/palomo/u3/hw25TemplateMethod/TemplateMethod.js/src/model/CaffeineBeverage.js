/**
 * @author Cristian Palomo, Error 404, @ESPE
 * 
 */
export class CaffeineBeverage {
    async prepareRecipe() {
        this.boilWater();
        this.brew();
        this.pourInCup();
        if (await this.wantsCondiments()) {
            this.addCondiments();
        }
    }

    boilWater() {
        console.log("Boiling water");
    }

    pourInCup() {
        console.log("Pouring into cup");
    }

    brew() {
        throw new Error("brew() debe ser implementado por la subclase");
    }

    addCondiments() {
        throw new Error("addCondiments() debe ser implementado por la subclase");
    }

    async wantsCondiments() {
        return true;
    }
}
