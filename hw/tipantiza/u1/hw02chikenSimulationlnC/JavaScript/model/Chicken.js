class Chicken {

    constructor(name, color, ageInYears, isMolting, numberOfEggs, numberOfPoops){
        this.name = name;
        this.color = color;
        this.ageInYears = ageInYears;
        this.numberOfEggs = numberOfEggs;
        this.numberOfPoops = numberOfPoops;
    }

    showInformation(){
        console.log("\n---Chicken information---");
        console.log("Name: " + this.name);
        console.log("Color: " + this.color);
        console.log("Age in years: " + this.ageInYears);
        console.log("Number of eggs: " + this.numberOfEggs);
        console.log("Number of poops: " + this.numberOfPoops);
    }

    cluck(){
        console.log("\nCluck cluck");
    }

    wander(){
        console.log("\n" + this.name + " is wandering around");
    }

    eat(){
        console.log("\n" + this.name + " is eating");
    }

    drink(){
        console.log("\n" + this.name + " is drinking");
    }

    poop(){
        this.numberOfPoops += 1;

        console.log("\n" + this.name + " pooped");
        console.log("Number of poops: " + this.numberOfPoops);
    }

    layAnEgg(){
        this.numberOfEggs += 1;

        console.log("\n" + this.name + " laid an egg");
        console.log("Number of eggs: " + this.numberOfEggs);
    }

}

export default Chicken;