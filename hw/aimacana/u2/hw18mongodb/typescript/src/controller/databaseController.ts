export interface IDatabaseController<T> {
    create(entity: T): Promise<void>;
    readAll(): Promise<T[]>;
    readById(idField: string, idValue: string): Promise<T | null>;
    update(idField: string, idValue: string, fieldName: string, newValue: any): Promise<void>;
    delete(idField: string, idValue: string): Promise<void>;
    cleanCollection(): Promise<void>;
}
