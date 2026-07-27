import Cow from "../model/Cow.js";
import Pig from "../model/Pig.js";
import Chicken from "../model/Chicken.js";
import Sheep from "../model/Sheep.js";

export default class AnimalController {

    createAnimal(type, id, breed, bornOn, weight) {

        switch (type) {

            case "Cow":
                return new Cow(
                    id,
                    breed,
                    bornOn,
                    weight
                );

            case "Pig":
                return new Pig(
                    id,
                    breed,
                    bornOn,
                    weight
                );

            case "Chicken":
                return new Chicken(
                    id,
                    breed,
                    bornOn,
                    weight
                );

            case "Sheep":
                return new Sheep(
                    id,
                    breed,
                    bornOn,
                    weight
                );

            default:
                return null;
        }
    }

}