import type { Character } from '../models/Character';

export interface CharacterRepository {
  save(character: Character): Promise<void>;
  findById(id: string): Promise<Character | null>;
  findAll(): Promise<Character[]>;
  delete(id: string): Promise<void>;
}
