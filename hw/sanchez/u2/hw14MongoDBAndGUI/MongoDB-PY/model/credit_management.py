import json
import os
from datetime import datetime

FILE_NAME = "credits.json"
accounts = []

def load_from_file():
    global accounts
    try:
        if os.path.exists(FILE_NAME):
            with open(FILE_NAME, 'r', encoding='utf-8') as f:
                accounts = json.load(f)
        else:
            accounts = []
    except Exception as e:
        print(f"Error loading credits: {e}")
        accounts = []

def save_to_file():
    try:
        with open(FILE_NAME, 'w', encoding='utf-8') as f:
            json.dump(accounts, f, indent=2, ensure_ascii=False, default=str)
    except Exception as e:
        print(f"Error saving credits: {e}")

def get_all_accounts():
    return [a.copy() for a in accounts]

def create_account(account):
    accounts.append(account)
    save_to_file()

def find_account_by_id(id):
    for a in accounts:
        if a["customerId"] == id:
            return a
    return None

load_from_file()