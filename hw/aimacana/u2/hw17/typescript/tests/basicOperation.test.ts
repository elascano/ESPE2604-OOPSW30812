import { describe, it, expect } from 'vitest';
import { BasicOperation } from '../src/calculator/basicOperation.js';

describe('BasicOperation', () => {
    describe('add', () => {
        it('should correctly sum two numbers', () => {
            expect(BasicOperation.add(0.0, 0.0)).toBe(0.0);
            expect(BasicOperation.add(5.5, 4.5)).toBe(10.0);
            expect(BasicOperation.add(-1.0, 1.0)).toBe(0.0);
        });
    });

    describe('subtract', () => {
        it('should correctly subtract two numbers', () => {
            expect(BasicOperation.subtract(0.0, 0.0)).toBe(0.0);
            expect(BasicOperation.subtract(10.0, 4.5)).toBe(5.5);
            expect(BasicOperation.subtract(-1.0, -1.0)).toBe(0.0);
        });
    });
});
