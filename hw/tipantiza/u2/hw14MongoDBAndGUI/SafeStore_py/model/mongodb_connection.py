"""
MongoDB Connection Handler with JSON backup
"""

from pymongo import MongoClient
from bson import ObjectId
import json
import os
from datetime import datetime

class MongoDBConnection:
    """MongoDB connection manager with JSON file backup"""
    
    CONNECTION_STRING = "mongodb+srv://tipantizaalexander:Alexander20@cluster0.z86uqo3.mongodb.net/?appName=Cluster0"
    DATABASE_NAME = "SafeStoreAppDB"
    
    _client = None
    _database = None
    _is_connected = False
    
    JSON_PRODUCTS_FILE = "data/products.json"
    JSON_SUPPLIERS_FILE = "data/suppliers.json"
    JSON_SALES_FILE = "data/sales.json"
    
    @classmethod
    def _ensure_data_dir(cls):
        if not os.path.exists("data"):
            os.makedirs("data")
            print("📁 Created data directory")
    
    @classmethod
    def connect(cls):
        cls._ensure_data_dir()
        print("🔌 Connecting to MongoDB Atlas...")
        
        try:
            cls._client = MongoClient(
                cls.CONNECTION_STRING,
                serverSelectionTimeoutMS=5000,
                connectTimeoutMS=10000
            )
            cls._client.admin.command('ping')
            cls._database = cls._client[cls.DATABASE_NAME]
            cls._is_connected = True
            print("✅ Connected to MongoDB Atlas!")
            cls.sync_from_mongodb()
        except Exception as e:
            print(f"⚠️ Connection failed: {e}")
            print("📁 Working offline (using JSON files only)")
            cls._is_connected = False
    
    @classmethod
    def is_connected(cls):
        return cls._is_connected
    
    @classmethod
    def _save_to_json(cls, filepath, data):
        try:
            cls._ensure_data_dir()
            with open(filepath, 'w', encoding='utf-8') as f:
                json.dump(data, f, indent=2, default=str)
            return True
        except Exception as e:
            print(f"Error saving JSON: {e}")
            return False
    
    @classmethod
    def _load_from_json(cls, filepath):
        try:
            if os.path.exists(filepath):
                with open(filepath, 'r', encoding='utf-8') as f:
                    return json.load(f)
        except Exception as e:
            print(f"Error loading JSON: {e}")
        return []
    
    @classmethod
    def sync_from_mongodb(cls):
        if not cls._is_connected:
            return
        try:
            products = list(cls._get_products_collection().find())
            for p in products:
                p['_id'] = str(p['_id'])
            cls._save_to_json(cls.JSON_PRODUCTS_FILE, products)
            print(f"📁 Synced {len(products)} products")
            
            suppliers = list(cls._get_suppliers_collection().find())
            for s in suppliers:
                s['_id'] = str(s['_id'])
            cls._save_to_json(cls.JSON_SUPPLIERS_FILE, suppliers)
            print(f"📁 Synced {len(suppliers)} suppliers")
            
            sales = list(cls._get_sales_collection().find())
            for sale in sales:
                sale['_id'] = str(sale['_id'])
            cls._save_to_json(cls.JSON_SALES_FILE, sales)
            print(f"📁 Synced {len(sales)} sales")
        except Exception as e:
            print(f"Sync error: {e}")
    
    @classmethod
    def _get_products_collection(cls):
        return cls._database["products"]
    
    @classmethod
    def save_product(cls, product):
        try:
            if '_id' in product:
                del product['_id']
            if cls._is_connected:
                try:
                    result = cls._get_products_collection().insert_one(product)
                    product['_id'] = str(result.inserted_id)
                    print(f"✅ Product saved to MongoDB")
                except Exception as e:
                    print(f"MongoDB save error: {e}")
            products = cls._load_from_json(cls.JSON_PRODUCTS_FILE)
            if not product.get('productId'):
                product['productId'] = str(len(products) + 1)
            products.append(product)
            cls._save_to_json(cls.JSON_PRODUCTS_FILE, products)
            print(f"📁 Product saved to JSON")
            return True
        except Exception as e:
            print(f"Error: {e}")
            return False
    
    @classmethod
    def get_all_products(cls):
        products = cls._load_from_json(cls.JSON_PRODUCTS_FILE)
        if products:
            return products
        if cls._is_connected:
            try:
                cursor = cls._get_products_collection().find()
                products = []
                for doc in cursor:
                    doc['_id'] = str(doc['_id'])
                    products.append(doc)
                if products:
                    cls._save_to_json(cls.JSON_PRODUCTS_FILE, products)
                return products
            except Exception as e:
                print(f"Error: {e}")
        return []
    
    @classmethod
    def update_product(cls, product_id, product):
        try:
            products = cls._load_from_json(cls.JSON_PRODUCTS_FILE)
            json_success = False
            for i, p in enumerate(products):
                if p.get('productId') == product_id or p.get('_id') == product_id:
                    if '_id' in p:
                        product['_id'] = p['_id']
                    products[i] = product
                    cls._save_to_json(cls.JSON_PRODUCTS_FILE, products)
                    json_success = True
                    break
            mongodb_success = False
            if cls._is_connected:
                try:
                    query = {"$or": [{"productId": product_id}, {"_id": ObjectId(product_id)}]}
                    result = cls._get_products_collection().update_one(query, {"$set": product})
                    mongodb_success = result.modified_count > 0
                except Exception as e:
                    print(f"MongoDB update error: {e}")
            return json_success or mongodb_success
        except Exception as e:
            print(f"Error: {e}")
            return False
    
    @classmethod
    def delete_product(cls, product_id):
        try:
            products = cls._load_from_json(cls.JSON_PRODUCTS_FILE)
            original_len = len(products)
            products = [p for p in products if p.get('productId') != product_id and p.get('_id') != product_id]
            json_success = len(products) < original_len
            if json_success:
                cls._save_to_json(cls.JSON_PRODUCTS_FILE, products)
            mongodb_success = False
            if cls._is_connected:
                try:
                    query = {"$or": [{"productId": product_id}, {"_id": ObjectId(product_id)}]}
                    result = cls._get_products_collection().delete_one(query)
                    mongodb_success = result.deleted_count > 0
                except Exception as e:
                    print(f"MongoDB delete error: {e}")
            return json_success or mongodb_success
        except Exception as e:
            print(f"Error: {e}")
            return False
    
    @classmethod
    def _get_suppliers_collection(cls):
        return cls._database["suppliers"]
    
    @classmethod
    def save_supplier(cls, supplier):
        try:
            if '_id' in supplier:
                del supplier['_id']
            if cls._is_connected:
                try:
                    result = cls._get_suppliers_collection().insert_one(supplier)
                    supplier['_id'] = str(result.inserted_id)
                    print(f"✅ Supplier saved to MongoDB")
                except Exception as e:
                    print(f"MongoDB save error: {e}")
            suppliers = cls._load_from_json(cls.JSON_SUPPLIERS_FILE)
            if not supplier.get('supplierId'):
                supplier['supplierId'] = str(len(suppliers) + 1)
            suppliers.append(supplier)
            cls._save_to_json(cls.JSON_SUPPLIERS_FILE, suppliers)
            print(f"📁 Supplier saved to JSON")
            return True
        except Exception as e:
            print(f"Error: {e}")
            return False
    
    @classmethod
    def get_all_suppliers(cls):
        suppliers = cls._load_from_json(cls.JSON_SUPPLIERS_FILE)
        if suppliers:
            return suppliers
        if cls._is_connected:
            try:
                cursor = cls._get_suppliers_collection().find()
                suppliers = []
                for doc in cursor:
                    doc['_id'] = str(doc['_id'])
                    suppliers.append(doc)
                if suppliers:
                    cls._save_to_json(cls.JSON_SUPPLIERS_FILE, suppliers)
                return suppliers
            except Exception as e:
                print(f"Error: {e}")
        return []
    
    @classmethod
    def update_supplier(cls, supplier_id, supplier):
        try:
            suppliers = cls._load_from_json(cls.JSON_SUPPLIERS_FILE)
            json_success = False
            for i, s in enumerate(suppliers):
                if s.get('supplierId') == supplier_id or s.get('_id') == supplier_id:
                    if '_id' in s:
                        supplier['_id'] = s['_id']
                    suppliers[i] = supplier
                    cls._save_to_json(cls.JSON_SUPPLIERS_FILE, suppliers)
                    json_success = True
                    break
            mongodb_success = False
            if cls._is_connected:
                try:
                    query = {"$or": [{"supplierId": supplier_id}, {"_id": ObjectId(supplier_id)}]}
                    result = cls._get_suppliers_collection().update_one(query, {"$set": supplier})
                    mongodb_success = result.modified_count > 0
                except Exception as e:
                    print(f"MongoDB update error: {e}")
            return json_success or mongodb_success
        except Exception as e:
            print(f"Error: {e}")
            return False
    
    @classmethod
    def delete_supplier(cls, supplier_id):
        try:
            suppliers = cls._load_from_json(cls.JSON_SUPPLIERS_FILE)
            original_len = len(suppliers)
            suppliers = [s for s in suppliers if s.get('supplierId') != supplier_id and s.get('_id') != supplier_id]
            json_success = len(suppliers) < original_len
            if json_success:
                cls._save_to_json(cls.JSON_SUPPLIERS_FILE, suppliers)
            mongodb_success = False
            if cls._is_connected:
                try:
                    query = {"$or": [{"supplierId": supplier_id}, {"_id": ObjectId(supplier_id)}]}
                    result = cls._get_suppliers_collection().delete_one(query)
                    mongodb_success = result.deleted_count > 0
                except Exception as e:
                    print(f"MongoDB delete error: {e}")
            return json_success or mongodb_success
        except Exception as e:
            print(f"Error: {e}")
            return False
    
    @classmethod
    def _get_sales_collection(cls):
        return cls._database["sales"]
    
    @classmethod
    def save_sale(cls, sale):
        try:
            if '_id' in sale:
                del sale['_id']
            sale['saved_at'] = datetime.now().isoformat()
            if cls._is_connected:
                try:
                    result = cls._get_sales_collection().insert_one(sale)
                    sale['_id'] = str(result.inserted_id)
                    print(f"✅ Sale saved to MongoDB")
                except Exception as e:
                    print(f"MongoDB save error: {e}")
            sales = cls._load_from_json(cls.JSON_SALES_FILE)
            sales.append(sale)
            cls._save_to_json(cls.JSON_SALES_FILE, sales)
            print(f"📁 Sale saved to JSON")
            return True
        except Exception as e:
            print(f"Error: {e}")
            return False
    
    @classmethod
    def get_all_sales(cls):
        sales = cls._load_from_json(cls.JSON_SALES_FILE)
        if sales:
            print(f"📁 Loaded {len(sales)} sales from JSON")
            return sales
        if cls._is_connected:
            try:
                cursor = cls._get_sales_collection().find()
                sales = []
                for doc in cursor:
                    doc['_id'] = str(doc['_id'])
                    sales.append(doc)
                if sales:
                    cls._save_to_json(cls.JSON_SALES_FILE, sales)
                return sales
            except Exception as e:
                print(f"Error: {e}")
        return []
    
    @classmethod
    def delete_sale(cls, sale_id):
        try:
            sales = cls._load_from_json(cls.JSON_SALES_FILE)
            original_len = len(sales)
            sales = [s for s in sales if str(s.get('saleId')) != sale_id and s.get('_id') != sale_id]
            json_success = len(sales) < original_len
            if json_success:
                cls._save_to_json(cls.JSON_SALES_FILE, sales)
            mongodb_success = False
            if cls._is_connected:
                try:
                    query = {"$or": [{"saleId": int(sale_id) if sale_id.isdigit() else sale_id}, {"_id": ObjectId(sale_id)}]}
                    result = cls._get_sales_collection().delete_one(query)
                    mongodb_success = result.deleted_count > 0
                except Exception as e:
                    print(f"MongoDB delete error: {e}")
            return json_success or mongodb_success
        except Exception as e:
            print(f"Error: {e}")
            return False