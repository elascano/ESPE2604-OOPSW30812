export abstract class Item {
  private id: string;
  private name: string;
  private weight: number;
  private description: string;
  private baseValue: number;

  constructor(id: string, name: string, weight: number, description: string, baseValue: number) {
    this.id = id;
    this.name = name;
    this.weight = weight;
    this.description = description;
    this.baseValue = baseValue;
  }

  public getId(): string { return this.id; }
  public setId(id: string): void { this.id = id; }

  public getName(): string { return this.name; }
  public setName(name: string): void { this.name = name; }

  public getWeight(): number { return this.weight; }
  public setWeight(weight: number): void { this.weight = weight; }

  public getDescription(): string { return this.description; }
  public setDescription(description: string): void { this.description = description; }

  public getBaseValue(): number { return this.baseValue; }
  public setBaseValue(baseValue: number): void { this.baseValue = baseValue; }
}
