export class Ingredient {
    public ingredientId: string;
    public name: string;
    public stockQuantity: number;
    public unit: string;
    public minimumAlertQuantity: number;

    constructor(
        ingredientId = '',
        name = '',
        stockQuantity = 0,
        unit = '',
        minimumAlertQuantity = 0
    ) {
        this.ingredientId = ingredientId;
        this.name = name;
        this.stockQuantity = stockQuantity;
        this.unit = unit;
        this.minimumAlertQuantity = minimumAlertQuantity;
    }

    public static fromDocument(doc: any): Ingredient | null {
        if (!doc) return null;
        return new Ingredient(
            doc.ingredientId,
            doc.name,
            doc.stockQuantity,
            doc.unit,
            doc.minimumAlertQuantity
        );
    }
}
