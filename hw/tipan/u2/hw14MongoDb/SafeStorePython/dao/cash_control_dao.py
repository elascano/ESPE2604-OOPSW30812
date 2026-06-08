from database.mongo_connection import db

collection = db["cashControl"]

def save_cash_control(cash):
    collection.insert_one({
        "cashier": cash.cashier,
        "opening": cash.opening,
        "closing": cash.closing,
        "difference": cash.difference
    })