from flask import Flask, request, jsonify, send_from_directory
from flask_cors import CORS
from pymongo import MongoClient
from bson import ObjectId
from datetime import datetime
import os

app = Flask(__name__, static_folder='public', static_url_path='')
CORS(app)

MONGO_URI = "mongodb+srv://Joel:Joel@cluster0.aex8od4.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"
DATABASE_NAME = "safestore_db"

client = MongoClient(MONGO_URI)
db = client[DATABASE_NAME]
products_collection = db["products"]
credits_collection = db["credits"]

print("Connected to MongoDB Atlas")

@app.route('/')
def index():
    return send_from_directory('public', 'index.html')

@app.route('/api/products', methods=['GET'])
def get_products():
    products = list(products_collection.find({}, {"_id": 0}))
    return jsonify(products)

@app.route('/api/products', methods=['POST'])
def add_product():
    data = request.json
    result = products_collection.insert_one(data)
    return jsonify({"message": "Product added successfully", "product": data})

@app.route('/api/products/<int:id>', methods=['PUT'])
def update_product(id):
    data = request.json
    result = products_collection.update_one(
        {"id": id},
        {"$set": data}
    )
    if result.modified_count > 0:
        return jsonify({"message": "Product updated successfully"})
    return jsonify({"message": "Product not found"}), 404

@app.route('/api/products/<int:id>', methods=['DELETE'])
def delete_product(id):
    result = products_collection.delete_one({"id": id})
    if result.deleted_count > 0:
        return jsonify({"message": "Product deleted successfully"})
    return jsonify({"message": "Product not found"}), 404

@app.route('/api/credits', methods=['GET'])
def get_credits():
    credits = list(credits_collection.find({}, {"_id": 0}))
    return jsonify(credits)

@app.route('/api/credits', methods=['POST'])
def add_credit():
    data = request.json
    data["currentDebt"] = 0
    data["transactions"] = []
    data["isBlocked"] = False
    result = credits_collection.insert_one(data)
    return jsonify({"message": "Credit added successfully", "credit": data})

@app.route('/api/credits/<int:id>', methods=['PUT'])
def update_credit(id):
    data = request.json
    result = credits_collection.update_one(
        {"customerId": id},
        {"$set": data}
    )
    if result.modified_count > 0:
        return jsonify({"message": "Credit updated successfully"})
    return jsonify({"message": "Credit not found"}), 404

@app.route('/api/credits/<int:id>', methods=['DELETE'])
def delete_credit(id):
    result = credits_collection.delete_one({"customerId": id})
    if result.deleted_count > 0:
        return jsonify({"message": "Credit deleted successfully"})
    return jsonify({"message": "Credit not found"}), 404

@app.route('/api/expiration/alerts', methods=['GET'])
def get_expiration_alerts():
    products = list(products_collection.find({}, {"_id": 0}))
    alerts = []
    today = datetime.now().date()
    
    for p in products:
        if p.get("expiryDate"):
            try:
                expiry_date = datetime.strptime(p["expiryDate"], "%Y-%m-%d").date()
                days_until = (expiry_date - today).days
                if 0 <= days_until <= 30:
                    alerts.append({
                        "productId": p["id"],
                        "productName": p["name"],
                        "expiryDate": p["expiryDate"],
                        "daysUntilExpiry": days_until
                    })
                    print(f"ALERT: {p['name']} expires in {days_until} days")
            except:
                pass
    
    return jsonify(alerts)

@app.route('/api/sync/to-cloud', methods=['POST'])
def sync_to_cloud():
    print("Already using MongoDB directly. No sync needed.")
    return jsonify({"message": "Already connected to MongoDB Cloud"})

@app.route('/api/sync/from-cloud', methods=['POST'])
def sync_from_cloud():
    print("Already using MongoDB directly. No sync needed.")
    return jsonify({"message": "Already connected to MongoDB Cloud"})

if __name__ == '__main__':
    print("\n" + "=" * 50)
    print("SafeStore Server Running with MongoDB Cloud")
    print("=" * 50)
    print(f"Database: {DATABASE_NAME}")
    print(f"Products collection: {products_collection.count_documents({})} documents")
    print(f"Credits collection: {credits_collection.count_documents({})} documents")
    print(f"Open browser: http://localhost:3000")
    print("=" * 50 + "\n")
    app.run(debug=True, port=3000, host='0.0.0.0')