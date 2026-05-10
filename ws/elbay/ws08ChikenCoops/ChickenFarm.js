/**
 *
 * @author Didier Elbay <Code_Bros , @ESPE>
 */

class Chiken {
    constructor(id, name, color, bornOnDate, isMolting, age) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.bornOnDate = bornOnDate;
        this.isMolting = isMolting;
        this.age = age;
    }

    toString() {
        return `Chiken{id=${this.id}, name=${this.name}, color=${this.color}, bornOnDate=${this.bornOnDate}, isMolting=${this.isMolting}, age=${this.age}}`;
    }
}

let chickens = new Array(5);

chickens[0] = new Chiken(
    1,
    "Lucy",
    "brown and white",
    new Date(),
    false,
    1
);

chickens[1] = new Chiken(
    2,
    "Didier Elbay",
    "Red",
    new Date(1999, 11, 1),
    true,
    0
);

chickens[2] = new Chiken(
    3,
    "Jorge Lascano",
    "Black",
    new Date(2021, 7, 23),
    false,
    2
);

chickens[3] = new Chiken(
    4,
    "Jose",
    "Violet",
    new Date(2006, 2, 10),
    true,
    0
);

chickens[4] = new Chiken(
    5,
    "Pepito Perez",
    "Red",
    new Date(2008, 0, 12),
    true,
    0
);

for (let i = 0; i < 5; i++) {
    console.log("chicken [" + (i + 1) + "] " + chickens[i].toString());
}