const Sort = require("../model/Sort");
const SortingContext = require("../model/SortingContext");
const BubbleSort = require("../model/BubbleSort");
const InsertionSort = require("../model/InsertionSort");
const QuickSort = require("../model/QuickSort");


const sortArray = async (req, res) => {

    try {

        const array = req.body.array;

        let algorithm;
        let strategy;


        if (array.length >= 2 && array.length <= 6) {

            algorithm = "BubbleSort";
            strategy = new BubbleSort();

        } else if (array.length >= 7 && array.length <= 10) {

            algorithm = "InsertionSort";
            strategy = new InsertionSort();

        } else {

            algorithm = "QuickSort";
            strategy = new QuickSort();

        }


        const context = new SortingContext(strategy);

        const sorted = context.execute(array);


        const data = new Sort({

            unsorted: array,

            size: array.length,

            algorithm: algorithm,

            sorted: sorted

        });


        await data.save();


        res.json({

            original: array,

            size: array.length,

            algorithm: algorithm,

            result: sorted

        });


    } catch (error) {

        res.status(500).json({
            message: error.message
        });

    }

};


module.exports = {
    sortArray
};