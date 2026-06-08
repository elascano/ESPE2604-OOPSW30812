from datetime import datetime

alerts = []

class ExpirationAlert:
    def __init__(self, productId, productName, expiryDate, daysUntilExpiry):
        self.productId = productId
        self.productName = productName
        self.expiryDate = expiryDate
        self.daysUntilExpiry = daysUntilExpiry
        self.notificationSent = False

def generate_alerts(products):
    global alerts
    alerts = []
    current_date = datetime.now()
    
    for product in products:
        if product.get("expiryDate"):
            try:
                expiry_date = datetime.strptime(product["expiryDate"], "%Y-%m-%d")
                days_until_expiry = (expiry_date - current_date).days
                
                if 0 <= days_until_expiry <= 30:
                    alerts.append(ExpirationAlert(
                        product["id"], 
                        product["name"], 
                        product["expiryDate"], 
                        days_until_expiry
                    ))
            except:
                pass
    return alerts

def send_notifications():
    for alert in alerts:
        if not alert.notificationSent:
            print(f"NOTIFICATION: Product '{alert.productName}' expires in {alert.daysUntilExpiry} days")
            alert.notificationSent = True

def get_active_alerts():
    return [a for a in alerts]