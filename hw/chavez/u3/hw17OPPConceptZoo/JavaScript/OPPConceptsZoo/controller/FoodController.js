import Food from "../model/Food.js";

export default class FoodController {

    createFood(id, description) {

        return new Food(
            id,
            description
        );

    }

}