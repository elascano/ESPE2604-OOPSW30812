#pip install pymongo dnspython
import tkinter as tk
from tkinter import messagebox, ttk
from datetime import datetime
from pymongo import MongoClient

CONNECTION_STRING = "mongodb+srv://Angie:Angie@angienx.spphrbg.mongodb.net/"

try:
    client = MongoClient(CONNECTION_STRING)
    db = client["FarmZooDB"]
except Exception as e:
    print(f"Database connection error: {e}")

class FarmSystemApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Farm Management System")
        self.root.geometry("500x450")
        
        self.main_container = tk.Frame(self.root)
        self.main_container.pack(fill="both", expand=True)
        
        self.menubar = tk.Menu(self.root)
        self.root.config(menu="") 
        
        self.show_login_frame()

    def setup_menu(self):
        self.menubar = tk.Menu(self.root)
        
        options_menu = tk.Menu(self.menubar, tearoff=0)
        options_menu.add_command(label="Logout", command=self.logout)
        self.menubar.add_cascade(label="Options", menu=options_menu)
        
        animals_menu = tk.Menu(self.menubar, tearoff=0)
        animals_menu.add_command(label="Chicken Management", command=self.show_chicken_frame)
        animals_menu.add_command(label="Cow Management", command=self.show_cow_frame)
        animals_menu.add_command(label="Pig Management", command=self.show_pig_frame)
        animals_menu.add_command(label="Sheep Management", command=self.show_sheep_frame)
        self.menubar.add_cascade(label="Animals", menu=animals_menu)
        
        self.root.config(menu=self.menubar)

    def clear_container(self):
        for widget in self.main_container.winfo_children():
            widget.destroy()

    def show_login_frame(self):
        self.clear_container()
        self.root.config(menu="") 
        
        tk.Label(self.main_container, text="Login Secure System", font=("Arial", 14, "bold")).pack(pady=40)
        
        tk.Label(self.main_container, text="Username:").pack(pady=5)
        txt_user = tk.Entry(self.main_container, width=25)
        txt_user.pack()
        
        tk.Label(self.main_container, text="Password:").pack(pady=5)
        txt_password = tk.Entry(self.main_container, width=25, show="*")
        txt_password.pack()
        
        def login_validate():
            username = txt_user.get().strip()
            password = txt_password.get().strip()
            
            if not username or not password:
                messagebox.showwarning("Warning", "Please fill in all fields")
                return
                
            try:
                user_found = db["Users"].find_one({"username": username, "password": password})
                if user_found:
                    messagebox.showinfo("Success", "Welcome to the Farm System!")
                    self.setup_menu()
                    self.show_home()
                else:
                    messagebox.showerror("Error", "Invalid username or password")
            except Exception as e:
                messagebox.showerror("Database Error", f"Error connecting to Atlas: {e}")

        tk.Button(self.main_container, text="Login", command=login_validate, width=15, bg="#2ecc71", fg="white").pack(pady=25)

    def show_home(self):
        self.clear_container()
        lbl_welcome = tk.Label(self.main_container, text="Welcome To Farm Management System", font=("Arial", 14, "bold"))
        lbl_welcome.pack(pady=150)

    def logout(self):
        messagebox.showinfo("Logout", "Closing session...")
        self.show_login_frame()

    def show_chicken_frame(self):
        self.clear_container()
        tk.Label(self.main_container, text="Chicken Management", font=("Arial", 12, "bold")).pack(pady=10)
        
        tk.Label(self.main_container, text="Id:").pack()
        spn_id = tk.Spinbox(self.main_container, from_=1, to=1000, width=10)
        spn_id.pack(pady=2)
        
        tk.Label(self.main_container, text="Egg Production (Weekly):").pack()
        txt_eggs = tk.Entry(self.main_container, width=15)
        txt_eggs.pack(pady=2)
        
        chk_molting_var = tk.BooleanVar()
        chk_molting = tk.Checkbutton(self.main_container, text="Is Molting Plumes?", variable=chk_molting_var)
        chk_molting.pack(pady=5)
        
        lbl_result = tk.Label(self.main_container, text="Status: -", font=("Arial", 10, "bold"), fg="blue")
        lbl_result.pack(pady=10)

        def save():
            try:
                id_val = int(spn_id.get())
                eggs = int(txt_eggs.get())
                is_molting = chk_molting_var.get()
                
                status = "Optimal Production" if (not is_molting and eggs > 2) else "Low Efficiency"
                
                doc = {"id": id_val, "eggs": eggs, "isMolting": is_molting, "status": status, "date": datetime.now()}
                db["chickens"].insert_one(doc)
                
                lbl_result.config(text=f"Status: {status}")
                messagebox.showinfo("Success", "Chicken saved to Atlas!")
            except ValueError:
                messagebox.showerror("Error", "Please fill valid numerical data")

        def delete():
            id_val = int(spn_id.get())
            res = db["chickens"].find_one_and_delete({"id": id_val})
            if res:
                lbl_result.config(text="Status: Record Deleted")
                messagebox.showinfo("Deleted", f"Chicken ID {id_val} removed.")
            else:
                messagebox.showwarning("Not Found", "ID not found in Atlas.")

        btn_frame = tk.Frame(self.main_container)
        btn_frame.pack(pady=15)
        tk.Button(btn_frame, text="Back to Menu", command=self.show_home).grid(row=0, column=0, padx=5)
        tk.Button(btn_frame, text="Delete", command=delete, bg="#e74c3c", fg="white").grid(row=0, column=1, padx=5)
        tk.Button(btn_frame, text="Save", command=save, bg="#3498db", fg="white").grid(row=0, column=2, padx=5)

    def show_cow_frame(self):
        self.clear_container()
        tk.Label(self.main_container, text="Cow Management", font=("Arial", 12, "bold")).pack(pady=10)
        
        tk.Label(self.main_container, text="Id:").pack()
        spn_id = tk.Spinbox(self.main_container, from_=1, to=1000, width=10)
        spn_id.pack(pady=2)
        
        tk.Label(self.main_container, text="Milk Production (Liters):").pack()
        txt_milk = tk.Entry(self.main_container, width=15)
        txt_milk.pack(pady=2)
        
        tk.Label(self.main_container, text="Weight (kg):").pack()
        txt_weight = tk.Entry(self.main_container, width=15)
        txt_weight.pack(pady=2)
        
        lbl_result = tk.Label(self.main_container, text="Efficiency: - | Meat: -", font=("Arial", 10, "bold"), fg="blue")
        lbl_result.pack(pady=10)

        def save():
            try:
                id_val = int(spn_id.get())
                milk = float(txt_milk.get())
                weight = float(txt_weight.get())
                
                efficiency = (milk / weight) * 100
                expected_meat = (weight * 0.20) + (weight * 0.12)
                
                doc = {"id": id_val, "milk": milk, "weight": weight, "efficiency": efficiency, "meatYield": expected_meat, "date": datetime.now()}
                db["cows"].insert_one(doc)
                
                lbl_result.config(text=f"Efficiency: {efficiency:.1f}% | Meat: {expected_meat:.2f} kg")
                messagebox.showinfo("Success", "Cow saved to Atlas!")
            except ValueError:
                messagebox.showerror("Error", "Please verify your input measurements")

        def delete():
            id_val = int(spn_id.get())
            res = db["cows"].find_one_and_delete({"id": id_val})
            if res:
                lbl_result.config(text="Deleted")
                messagebox.showinfo("Deleted", f"Cow ID {id_val} removed.")
            else:
                messagebox.showwarning("Not Found", "ID not found.")

        btn_frame = tk.Frame(self.main_container)
        btn_frame.pack(pady=15)
        tk.Button(btn_frame, text="Back to Menu", command=self.show_home).grid(row=0, column=0, padx=5)
        tk.Button(btn_frame, text="Delete", command=delete, bg="#e74c3c", fg="white").grid(row=0, column=1, padx=5)
        tk.Button(btn_frame, text="Save", command=save, bg="#3498db", fg="white").grid(row=0, column=2, padx=5)

    def show_pig_frame(self):
        self.clear_container()
        tk.Label(self.main_container, text="Pig Management", font=("Arial", 12, "bold")).pack(pady=10)
        
        tk.Label(self.main_container, text="Id:").pack()
        spn_id = tk.Spinbox(self.main_container, from_=1, to=1000, width=10)
        spn_id.pack(pady=2)
        
        tk.Label(self.main_container, text="Breed:").pack()
        cmb_breed = ttk.Combobox(self.main_container, values=["Duroc", "Landrace", "Berkshire"], state="readonly")
        cmb_breed.current(0)
        cmb_breed.pack(pady=2)
        
        tk.Label(self.main_container, text="Weight (kg):").pack()
        txt_weight = tk.Entry(self.main_container, width=15)
        txt_weight.pack(pady=2)
        
        lbl_result = tk.Label(self.main_container, text="Result: -", font=("Arial", 11, "bold"), fg="blue")
        lbl_result.pack(pady=10)

        def save():
            try:
                id_val = int(spn_id.get())
                breed = cmb_breed.get()
                weight = float(txt_weight.get())
                
                expected_meat = (weight * 0.15) + (weight * 0.10)
                
                doc = {"id": id_val, "breed": breed, "weight": weight, "expectedMeat": expected_meat, "date": datetime.now()}
                db["pigs"].insert_one(doc)
                
                lbl_result.config(text=f"Result: {expected_meat:.2f} kg")
                messagebox.showinfo("Success", "Pig record saved to Atlas!")
            except ValueError:
                messagebox.showerror("Error", "Invalid numeric data.")

        def delete():
            id_val = int(spn_id.get())
            res = db["pigs"].find_one_and_delete({"id": id_val})
            if res:
                lbl_result.config(text="Result: Deleted")
                messagebox.showinfo("Deleted", f"Pig ID {id_val} removed.")
            else:
                messagebox.showwarning("Not Found", "ID not found.")

        btn_frame = tk.Frame(self.main_container)
        btn_frame.pack(pady=15)
        tk.Button(btn_frame, text="Back to Menu", command=self.show_home).grid(row=0, column=0, padx=5)
        tk.Button(btn_frame, text="Delete", command=delete, bg="#e74c3c", fg="white").grid(row=0, column=1, padx=5)
        tk.Button(btn_frame, text="Save", command=save, bg="#3498db", fg="white").grid(row=0, column=2, padx=5)

    def show_sheep_frame(self):
        self.clear_container()
        tk.Label(self.main_container, text="Sheep Management", font=("Arial", 12, "bold")).pack(pady=10)
        
        tk.Label(self.main_container, text="Id:").pack()
        spn_id = tk.Spinbox(self.main_container, from_=1, to=1000, width=10)
        spn_id.pack(pady=2)
        
        tk.Label(self.main_container, text="Weight (kg):").pack()
        txt_weight = tk.Entry(self.main_container, width=15)
        txt_weight.pack(pady=2)
        
        lbl_result = tk.Label(self.main_container, text="Status: -", font=("Arial", 11, "bold"), fg="blue")
        lbl_result.pack(pady=10)

        def save():
            try:
                id_val = int(spn_id.get())
                weight = float(txt_weight.get())
                
                status = "Ready for Shearing" if (45.0 <= weight <= 80.0) else "Under Evaluation"
                
                doc = {"id": id_val, "weight": weight, "status": status, "date": datetime.now()}
                db["sheeps"].insert_one(doc)
                
                lbl_result.config(text=f"Status: {status}")
                messagebox.showinfo("Success", "Sheep record saved to Atlas!")
            except ValueError:
                messagebox.showerror("Error", "Verify your numeric values.")

        def delete():
            id_val = int(spn_id.get())
            res = db["sheeps"].find_one_and_delete({"id": id_val})
            if res:
                lbl_result.config(text="Deleted")
                messagebox.showinfo("Deleted", f"Sheep ID {id_val} removed.")
            else:
                messagebox.showwarning("Not Found", "ID not found.")

        btn_frame = tk.Frame(self.main_container)
        btn_frame.pack(pady=15)
        tk.Button(btn_frame, text="Back to Menu", command=self.show_home).grid(row=0, column=0, padx=5)
        tk.Button(btn_frame, text="Delete", command=delete, bg="#e74c3c", fg="white").grid(row=0, column=1, padx=5)
        tk.Button(btn_frame, text="Save", command=save, bg="#3498db", fg="white").grid(row=0, column=2, padx=5)

if __name__ == "__main__":
    root = tk.Tk()
    app = FarmSystemApp(root)
    root.mainloop()