import * as readline from "node:readline/promises";

export async function getUserInput(promptText) {
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout,
    });
    let answer;
    try {
        answer = await rl.question(promptText);
    } catch {
        answer = null;
    } finally {
        rl.close();
    }
    return answer ?? "no";
}
