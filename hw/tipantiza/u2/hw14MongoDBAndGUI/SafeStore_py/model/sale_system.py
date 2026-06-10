"""
Sale System Module
@author Alexander Tipantiza, The Softwarriors, @ESPE
"""

import json
import os
from datetime import datetime
from typing import List, Optional
from dataclasses import dataclass, field
from .product_management import ProductManagement

# File paths
SALES_FILE = "sales.json"
HOLD_FILE = "sales_hold.json"


@dataclass
class SaleItem:
    """Sale item class"""
    product_id: int
    product_name: str
    quantity: int
    unit_price: float
    total_price: float = 0.0
    
    def __post_init__(self):
        self.total_price = self.quantity * self.unit_price
    
    def set_quantity(self, quantity: int):
        self.quantity = quantity
        self.total_price = self.quantity * self.unit_price
    
    def set_unit_price(self, unit_price: float):
        self.unit_price = unit_price
        self.total_price = self.quantity * self.unit_price
    
    def __repr__(self):
        return f"{self.product_name} x{self.quantity} = ${self.total_price:.2f}"


@dataclass
class Sale:
    """Sale class"""
    sale_id: int
    customer_name: str
    sale_type: str
    payment_method: str
    items: List[SaleItem] = field(default_factory=list)
    date: datetime = field(default_factory=datetime.now)
    subtotal: float = 0.0
    tax: float = 0.0
    total: float = 0.0
    
    def __post_init__(self):
        self.calculate_totals()
    
    def add_item(self, item: SaleItem):
        """Add item to sale"""
        self.items.append(item)
        self.calculate_totals()
    
    def calculate_totals(self):
        """Calculate subtotal, tax and total"""
        self.subtotal = sum(item.total_price for item in self.items)
        self.tax = self.subtotal * 0.15
        self.total = self.subtotal + self.tax
    
    def to_dict(self):
        """Convert to dictionary for JSON serialization"""
        return {
            'sale_id': self.sale_id,
            'customer_name': self.customer_name,
            'sale_type': self.sale_type,
            'payment_method': self.payment_method,
            'date': self.date.isoformat(),
            'items': [
                {
                    'product_id': item.product_id,
                    'product_name': item.product_name,
                    'quantity': item.quantity,
                    'unit_price': item.unit_price,
                    'total_price': item.total_price
                }
                for item in self.items
            ],
            'subtotal': self.subtotal,
            'tax': self.tax,
            'total': self.total
        }
    
    @classmethod
    def from_dict(cls, data: dict):
        """Create Sale from dictionary"""
        items = [
            SaleItem(
                product_id=item['product_id'],
                product_name=item['product_name'],
                quantity=item['quantity'],
                unit_price=item['unit_price']
            )
            for item in data['items']
        ]
        sale = cls(
            sale_id=data['sale_id'],
            customer_name=data['customer_name'],
            sale_type=data['sale_type'],
            payment_method=data['payment_method'],
            items=items
        )
        sale.date = datetime.fromisoformat(data['date'])
        return sale
    
    def __repr__(self):
        return f"Sale #{self.sale_id} | Customer: {self.customer_name} | Total: ${self.total:.2f}"


class SaleSystem:
    """Sale system manager"""
    
    _sales: List[Sale] = []
    _pending_sale: Optional[Sale] = None
    
    @classmethod
    def _load_sales(cls):
        """Load sales from file"""
        if os.path.exists(SALES_FILE):
            try:
                with open(SALES_FILE, 'r', encoding='utf-8') as f:
                    data = json.load(f)
                    cls._sales = [Sale.from_dict(s) for s in data]
            except Exception as e:
                print(f"Error loading sales: {e}")
    
    @classmethod
    def _save_sales(cls):
        """Save sales to file"""
        try:
            with open(SALES_FILE, 'w', encoding='utf-8') as f:
                json.dump([s.to_dict() for s in cls._sales], f, indent=2, ensure_ascii=False)
        except Exception as e:
            print(f"Error saving sales: {e}")
    
    @classmethod
    def _save_hold(cls):
        """Save pending sale to file"""
        if cls._pending_sale:
            try:
                with open(HOLD_FILE, 'w', encoding='utf-8') as f:
                    json.dump(cls._pending_sale.to_dict(), f, indent=2, ensure_ascii=False)
            except Exception as e:
                print(f"Error saving hold: {e}")
    
    @classmethod
    def _load_hold(cls):
        """Load pending sale from file"""
        if os.path.exists(HOLD_FILE):
            try:
                with open(HOLD_FILE, 'r', encoding='utf-8') as f:
                    data = json.load(f)
                    cls._pending_sale = Sale.from_dict(data)
            except Exception as e:
                print(f"Error loading hold: {e}")
    
    @classmethod
    def start_new_sale(cls, customer_name: str, sale_type: str, payment_method: str) -> Sale:
        """Start a new sale"""
        sale_id = len(cls._sales) + 1
        cls._pending_sale = Sale(sale_id, customer_name, sale_type, payment_method)
        print(f"New sale started - ID: {sale_id}")
        return cls._pending_sale
    
    @classmethod
    def add_product_to_current_sale(cls, product_id: int, quantity: int) -> bool:
        """Add product to current sale"""
        if cls._pending_sale is None:
            print("No active sale. Start a new sale first.")
            return False
        
        product = ProductManagement.find_by_id(product_id)
        if product is None:
            print("Product not found")
            return False
        
        if quantity > product.get_stock():
            print(f"Insufficient stock. Available: {product.get_stock()}")
            return False
        
        unit_price = product.get_wholesale_price() if (
            cls._pending_sale.sale_type.lower() == "mayor" and quantity >= 12
        ) else product.get_retail_price()
        
        item = SaleItem(product_id, product.get_name(), quantity, unit_price)
        cls._pending_sale.add_item(item)
        
        ProductManagement.update_product_stock(product_id, product.get_stock() - quantity)
        
        print(f"Product added: {quantity} x {product.get_name()} - ${unit_price:.2f} each")
        print(f"Current subtotal: ${cls._pending_sale.subtotal:.2f}")
        return True
    
    @classmethod
    def finalize_sale(cls) -> bool:
        """Finalize current sale"""
        if cls._pending_sale is None or not cls._pending_sale.items:
            print("No active sale with products")
            return False
        
        print("\nSALE SUMMARY")
        print(f"Customer: {cls._pending_sale.customer_name}")
        print(f"Type: {cls._pending_sale.sale_type}")
        print(f"Subtotal: ${cls._pending_sale.subtotal:.2f}")
        print(f"IVA (15%): ${cls._pending_sale.tax:.2f}")
        print(f"TOTAL: ${cls._pending_sale.total:.2f}")
        
        confirm = input("\nConfirm sale? (s/n): ").lower()
        if confirm == 's':
            cls._sales.append(cls._pending_sale)
            cls._save_sales()
            print(f"Sale #{cls._pending_sale.sale_id} finalized")
            cls._pending_sale = None
            return True
        else:
            print("Sale cancelled")
            return False
    
    @classmethod
    def hold_current_sale(cls):
        """Hold current sale"""
        if cls._pending_sale is None:
            print("No active sale to hold")
            return
        
        cls._save_hold()
        print("Sale put on hold. You can attend the next customer.")
        cls._pending_sale = None
    
    @classmethod
    def resume_hold_sale(cls):
        """Resume held sale"""
        cls._load_hold()
        
        if cls._pending_sale is None:
            print("No sale on hold")
            return
        
        print(f"Held sale resumed - ID: {cls._pending_sale.sale_id}")
        print(f"Customer: {cls._pending_sale.customer_name}")
        print(f"Items in cart: {len(cls._pending_sale.items)}")
    
    @classmethod
    def get_current_sale(cls) -> Optional[Sale]:
        """Get current pending sale"""
        return cls._pending_sale
    
    @classmethod
    def get_all_sales(cls) -> List[Sale]:
        """Get all sales"""
        cls._load_sales()
        return cls._sales.copy()
    
    @classmethod
    def search_sale(cls, sale_id: int) -> Optional[Sale]:
        """Search sale by ID"""
        cls._load_sales()
        for s in cls._sales:
            if s.sale_id == sale_id:
                return s
        return None