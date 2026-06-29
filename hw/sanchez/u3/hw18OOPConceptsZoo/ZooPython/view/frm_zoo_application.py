import tkinter as tk
from tkinter import ttk, messagebox, scrolledtext, simpledialog
from datetime import datetime
import sys
import os


sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.abspath(__file__))))


from controller.animal_controller import AnimalController
from model.cow import Cow
from model.chicken import Chicken
from model.pig import Pig
from model.sheep import Sheep

class FrmZooApplication:
    def __init__(self):
        self.controller = AnimalController()
        self.root = tk.Tk()
        self.root.title("OOP Concepts Zoo - Animal Management System")
        self.root.geometry("1200x800")
        self.root.configure(bg='#f0f0f0')
        
        self.setup_ui()
        self.refresh_animal_list()
    
    def setup_ui(self):
        header_frame = tk.Frame(self.root, bg='#2c3e50', height=80)
        header_frame.pack(fill=tk.X)
        header_frame.pack_propagate(False)
        
        title = tk.Label(header_frame, text="🐾 Zoo Management System", 
                         font=('Arial', 24, 'bold'), bg='#2c3e50', fg='white')
        title.pack(pady=10)
        
        status = tk.Label(header_frame, text="✅ Connected to MongoDB Atlas", 
                         font=('Arial', 10), bg='#2c3e50', fg='#2ecc71')
        status.pack()
        
        self.notebook = ttk.Notebook(self.root)
        self.notebook.pack(fill=tk.BOTH, expand=True, padx=10, pady=10)
        
        self.register_tab = self.create_register_tab()
        self.list_tab = self.create_list_tab()
        self.business_tab = self.create_business_tab()
        self.stats_tab = self.create_stats_tab()
        
        self.notebook.add(self.register_tab, text="📝 Register Animal")
        self.notebook.add(self.list_tab, text="📋 List Animals")
        self.notebook.add(self.business_tab, text="💼 Business Operations")
        self.notebook.add(self.stats_tab, text="📊 Statistics")
    
    def create_register_tab(self):
        tab = tk.Frame(self.root, bg='#f0f0f0')
        
        form_frame = tk.LabelFrame(tab, text="Register New Animal", 
                                   font=('Arial', 14, 'bold'), bg='#f0f0f0')
        form_frame.pack(padx=20, pady=20, fill=tk.BOTH, expand=True)
        
        fields_frame = tk.Frame(form_frame, bg='#f0f0f0')
        fields_frame.pack(padx=20, pady=20)
        
        tk.Label(fields_frame, text="Animal Type:", font=('Arial', 11), 
                bg='#f0f0f0').grid(row=0, column=0, sticky='w', pady=5, padx=5)
        self.animal_type_var = tk.StringVar()
        self.animal_type_combo = ttk.Combobox(fields_frame, textvariable=self.animal_type_var,
                                               values=['Cow', 'Chicken', 'Pig', 'Sheep'],
                                               state='readonly', width=20)
        self.animal_type_combo.grid(row=0, column=1, pady=5, padx=5)
        self.animal_type_combo.bind('<<ComboboxSelected>>', self.update_extra_fields)
        self.animal_type_combo.set('Cow')
        
        tk.Label(fields_frame, text="ID:", font=('Arial', 11), 
                bg='#f0f0f0').grid(row=1, column=0, sticky='w', pady=5, padx=5)
        self.id_entry = tk.Entry(fields_frame, width=25, font=('Arial', 11))
        self.id_entry.grid(row=1, column=1, pady=5, padx=5)
        
        tk.Label(fields_frame, text="Breed:", font=('Arial', 11), 
                bg='#f0f0f0').grid(row=2, column=0, sticky='w', pady=5, padx=5)
        self.breed_entry = tk.Entry(fields_frame, width=25, font=('Arial', 11))
        self.breed_entry.grid(row=2, column=1, pady=5, padx=5)
        
        tk.Label(fields_frame, text="Born On (YYYY-MM-DD):", font=('Arial', 11), 
                bg='#f0f0f0').grid(row=3, column=0, sticky='w', pady=5, padx=5)
        self.born_on_entry = tk.Entry(fields_frame, width=25, font=('Arial', 11))
        self.born_on_entry.grid(row=3, column=1, pady=5, padx=5)
        self.born_on_entry.insert(0, datetime.now().strftime("%Y-%m-%d"))
        
        tk.Label(fields_frame, text="Weight (kg):", font=('Arial', 11), 
                bg='#f0f0f0').grid(row=4, column=0, sticky='w', pady=5, padx=5)
        self.weight_entry = tk.Entry(fields_frame, width=25, font=('Arial', 11))
        self.weight_entry.grid(row=4, column=1, pady=5, padx=5)
        
        self.extra_frame = tk.LabelFrame(fields_frame, text="Specific Information",
                                        font=('Arial', 11), bg='#f0f0f0')
        self.extra_frame.grid(row=5, column=0, columnspan=2, pady=15, padx=5, sticky='ew')
        
        self.extra_label1 = tk.Label(self.extra_frame, text="Produces Milk:", font=('Arial', 10), bg='#f0f0f0')
        self.extra_label1.grid(row=0, column=0, sticky='w', pady=3, padx=5)
        self.extra_entry1 = tk.Entry(self.extra_frame, width=25, font=('Arial', 10))
        self.extra_entry1.grid(row=0, column=1, pady=3, padx=5)
        self.extra_entry1.insert(0, "true")
        
        self.extra_label2 = tk.Label(self.extra_frame, text="Milk Produced (liters):", font=('Arial', 10), bg='#f0f0f0')
        self.extra_label2.grid(row=1, column=0, sticky='w', pady=3, padx=5)
        self.extra_entry2 = tk.Entry(self.extra_frame, width=25, font=('Arial', 10))
        self.extra_entry2.grid(row=1, column=1, pady=3, padx=5)
        self.extra_entry2.insert(0, "25.5")
        
        btn_frame = tk.Frame(form_frame, bg='#f0f0f0')
        btn_frame.pack(pady=15)
        register_btn = tk.Button(btn_frame, text="✅ Register Animal", 
                                font=('Arial', 14, 'bold'), bg='#2ecc71', fg='white',
                                command=self.register_animal, padx=30, pady=10)
        register_btn.pack()
        
        return tab
    
    def create_list_tab(self):
        tab = tk.Frame(self.root, bg='#f0f0f0')
        
        filter_frame = tk.LabelFrame(tab, text="Filters and Actions", bg='#f0f0f0')
        filter_frame.pack(fill=tk.X, padx=10, pady=10)
        
        filter_inner = tk.Frame(filter_frame, bg='#f0f0f0')
        filter_inner.pack(pady=10, padx=10)
        
        tk.Label(filter_inner, text="Filter by type:", font=('Arial', 11), 
                bg='#f0f0f0').grid(row=0, column=0, padx=5)
        
        self.filter_var = tk.StringVar()
        self.filter_combo = ttk.Combobox(filter_inner, textvariable=self.filter_var,
                                         values=['All', 'Cow', 'Chicken', 'Pig', 'Sheep'],
                                         state='readonly', width=15)
        self.filter_combo.grid(row=0, column=1, padx=5)
        self.filter_combo.set('All')
        
        filter_btn = tk.Button(filter_inner, text="🔍 Filter", 
                              command=self.filter_animals, bg='#3498db', fg='white')
        filter_btn.grid(row=0, column=2, padx=5)
        
        refresh_btn = tk.Button(filter_inner, text="🔄 Refresh", 
                               command=self.refresh_animal_list, bg='#f39c12', fg='white')
        refresh_btn.grid(row=0, column=3, padx=5)
        
        delete_btn = tk.Button(filter_inner, text="🗑️ Delete Selected", 
                              command=self.delete_selected_animal, bg='#e74c3c', fg='white')
        delete_btn.grid(row=0, column=4, padx=5)
        
        table_frame = tk.Frame(tab, bg='#f0f0f0')
        table_frame.pack(fill=tk.BOTH, expand=True, padx=10, pady=10)
        
        columns = ('ID', 'Type', 'Breed', 'Born On', 'Weight (kg)', 'Age (months)', 'Extra Info')
        self.tree = ttk.Treeview(table_frame, columns=columns, show='headings', height=20)
        
        for col in columns:
            self.tree.heading(col, text=col)
            width = 150 if col != 'Extra Info' else 300
            self.tree.column(col, width=width, anchor='center')
        
        scrollbar = ttk.Scrollbar(table_frame, orient=tk.VERTICAL, command=self.tree.yview)
        self.tree.configure(yscrollcommand=scrollbar.set)
        
        self.tree.pack(side=tk.LEFT, fill=tk.BOTH, expand=True)
        scrollbar.pack(side=tk.RIGHT, fill=tk.Y)
        
        return tab
    
    def create_business_tab(self):
        tab = tk.Frame(self.root, bg='#f0f0f0')
        
        btn_frame = tk.LabelFrame(tab, text="Business Operations", bg='#f0f0f0')
        btn_frame.pack(fill=tk.X, padx=10, pady=10)
        
        btn_inner = tk.Frame(btn_frame, bg='#f0f0f0')
        btn_inner.pack(pady=10, padx=10)
        
        buttons = [
            ("1. Calculate Total Milk Production", self.calculate_milk_production, '#3498db'),
            ("2. Calculate Total Eggs Per Week", self.calculate_egg_production, '#2ecc71'),
            ("3. View Pigs Ready for Slaughter", self.show_ready_pigs, '#e67e22'),
            ("4. Search Animal by ID", self.search_animal_by_id, '#9b59b6')
        ]
        
        for i, (text, command, color) in enumerate(buttons):
            btn = tk.Button(btn_inner, text=text, command=command, 
                           bg=color, fg='white', font=('Arial', 11),
                           padx=20, pady=10)
            btn.grid(row=i//2, column=i%2, padx=10, pady=5, sticky='ew')
        
        btn_inner.grid_columnconfigure(0, weight=1)
        btn_inner.grid_columnconfigure(1, weight=1)
        
        result_frame = tk.LabelFrame(tab, text="Results", bg='#f0f0f0')
        result_frame.pack(fill=tk.BOTH, expand=True, padx=10, pady=10)
        
        self.result_text = scrolledtext.ScrolledText(result_frame, font=('Courier', 11), 
                                                     bg='white', height=20)
        self.result_text.pack(fill=tk.BOTH, expand=True, padx=10, pady=10)
        
        clear_btn = tk.Button(result_frame, text="🧹 Clear Results", 
                             command=lambda: self.result_text.delete('1.0', tk.END),
                             bg='#95a5a6', fg='white')
        clear_btn.pack(pady=5)
        
        return tab
    
    def create_stats_tab(self):
        tab = tk.Frame(self.root, bg='#f0f0f0')
        
        stats_frame = tk.LabelFrame(tab, text="Zoo Statistics", bg='#f0f0f0')
        stats_frame.pack(fill=tk.BOTH, expand=True, padx=10, pady=10)
        
        self.stats_text = scrolledtext.ScrolledText(stats_frame, font=('Courier', 14), 
                                                    bg='#f8f9fa', height=20)
        self.stats_text.pack(fill=tk.BOTH, expand=True, padx=10, pady=10)
        
        btn_frame = tk.Frame(stats_frame, bg='#f0f0f0')
        btn_frame.pack(pady=10)
        
        generate_btn = tk.Button(btn_frame, text="📊 Generate Statistics", 
                                command=self.generate_statistics,
                                bg='#2c3e50', fg='white', font=('Arial', 12, 'bold'),
                                padx=30, pady=10)
        generate_btn.pack()
        
        return tab
    
    def update_extra_fields(self, event=None):
        animal_type = self.animal_type_var.get()
        
        if animal_type == "Cow":
            self.extra_label1.config(text="Produces Milk (true/false):")
            self.extra_entry1.delete(0, tk.END)
            self.extra_entry1.insert(0, "true")
            self.extra_label2.config(text="Milk Produced (liters):")
            self.extra_entry2.delete(0, tk.END)
            self.extra_entry2.insert(0, "25.5")
            self.extra_label2.grid()
            self.extra_entry2.grid()
        elif animal_type == "Chicken":
            self.extra_label1.config(text="Is Molting (true/false):")
            self.extra_entry1.delete(0, tk.END)
            self.extra_entry1.insert(0, "false")
            self.extra_label2.config(text="Eggs Per Week:")
            self.extra_entry2.delete(0, tk.END)
            self.extra_entry2.insert(0, "5")
            self.extra_label2.grid()
            self.extra_entry2.grid()
        elif animal_type == "Pig":
            self.extra_label1.config(text="Ideal Weight (kg):")
            self.extra_entry1.delete(0, tk.END)
            self.extra_entry1.insert(0, "130")
            self.extra_label2.config(text="Ready for Slaughter (true/false):")
            self.extra_entry2.delete(0, tk.END)
            self.extra_entry2.insert(0, "false")
            self.extra_label2.grid()
            self.extra_entry2.grid()
        elif animal_type == "Sheep":
            self.extra_label1.config(text="Last Sheering Date (YYYY-MM-DD):")
            self.extra_entry1.delete(0, tk.END)
            self.extra_entry1.insert(0, datetime.now().strftime("%Y-%m-%d"))
            self.extra_label2.grid_remove()
            self.extra_entry2.grid_remove()
    
    def register_animal(self):
        try:
            animal_type = self.animal_type_var.get()
            id = int(self.id_entry.get())
            breed = self.breed_entry.get()
            born_on = datetime.strptime(self.born_on_entry.get(), "%Y-%m-%d")
            weight = float(self.weight_entry.get())
            
            if not breed:
                messagebox.showwarning("Incomplete Fields", "Breed is required")
                return
            
            if self.controller.get_animal_by_id(id):
                messagebox.showwarning("Duplicate ID", f"Animal with ID {id} already exists")
                return
            
            field1 = self.extra_entry1.get()
            field2 = self.extra_entry2.get()
            
            animal = None
            
            if animal_type == "Cow":
                produces_milk = field1.lower() == 'true'
                milk_produced = float(field2) if field2 else 0
                cow = Cow(id, breed, born_on, weight, produces_milk)
                cow.milk()
                animal = cow
                
                self.result_text.insert(tk.END, "=== COW REGISTERED ===\n")
                self.result_text.insert(tk.END, f"ID: {id}\n")
                self.result_text.insert(tk.END, f"Breed: {breed}\n")
                self.result_text.insert(tk.END, f"Born On: {born_on.strftime('%Y-%m-%d')}\n")
                self.result_text.insert(tk.END, f"Weight: {weight} kg\n")
                self.result_text.insert(tk.END, f"Produces milk: {produces_milk}\n")
                self.result_text.insert(tk.END, f"Milk produced: {milk_produced} liters\n")
                self.result_text.insert(tk.END, "---------------------------------------\n\n")
                
            elif animal_type == "Chicken":
                is_molting = field1.lower() == 'true'
                eggs_per_week = int(field2) if field2 else 0
                chicken = Chicken(id, breed, born_on, weight, is_molting)
                chicken.number_of_eggs_per_week = eggs_per_week
                animal = chicken
                
                self.result_text.insert(tk.END, "=== CHICKEN REGISTERED ===\n")
                self.result_text.insert(tk.END, f"ID: {id}\n")
                self.result_text.insert(tk.END, f"Breed: {breed}\n")
                self.result_text.insert(tk.END, f"Born On: {born_on.strftime('%Y-%m-%d')}\n")
                self.result_text.insert(tk.END, f"Weight: {weight} kg\n")
                self.result_text.insert(tk.END, f"Is molting: {is_molting}\n")
                self.result_text.insert(tk.END, f"Eggs per week: {eggs_per_week}\n")
                self.result_text.insert(tk.END, "---------------------------------------\n\n")
                
            elif animal_type == "Pig":
                ideal_weight = float(field1) if field1 else 0
                is_ready = field2.lower() == 'true'
                pig = Pig(id, breed, born_on, weight, ideal_weight)
                animal = pig
                
                self.result_text.insert(tk.END, "=== PIG REGISTERED ===\n")
                self.result_text.insert(tk.END, f"ID: {id}\n")
                self.result_text.insert(tk.END, f"Breed: {breed}\n")
                self.result_text.insert(tk.END, f"Born On: {born_on.strftime('%Y-%m-%d')}\n")
                self.result_text.insert(tk.END, f"Weight: {weight} kg\n")
                self.result_text.insert(tk.END, f"Ideal weight: {ideal_weight} kg\n")
                self.result_text.insert(tk.END, f"Ready for slaughter: {is_ready}\n")
                self.result_text.insert(tk.END, "---------------------------------------\n\n")
                
            elif animal_type == "Sheep":
                last_sheering = datetime.strptime(field1, "%Y-%m-%d") if field1 else datetime.now()
                sheep = Sheep(id, breed, born_on, weight, last_sheering)
                animal = sheep
                
                self.result_text.insert(tk.END, "=== SHEEP REGISTERED ===\n")
                self.result_text.insert(tk.END, f"ID: {id}\n")
                self.result_text.insert(tk.END, f"Breed: {breed}\n")
                self.result_text.insert(tk.END, f"Born On: {born_on.strftime('%Y-%m-%d')}\n")
                self.result_text.insert(tk.END, f"Weight: {weight} kg\n")
                self.result_text.insert(tk.END, f"Last sheering: {last_sheering.strftime('%Y-%m-%d')}\n")
                self.result_text.insert(tk.END, "---------------------------------------\n\n")
            
            if animal and self.controller.register_animal(animal):
                messagebox.showinfo("Registration Successful", 
                    f"Animal registered successfully!\n"
                    f"Type: {animal_type}\n"
                    f"ID: {id}\n"
                    f"Breed: {breed}")
                self.clear_fields()
                self.refresh_animal_list()
            
        except ValueError as e:
            messagebox.showerror("Format Error", 
                f"Error: Please enter valid values\n{str(e)}")
        except Exception as e:
            messagebox.showerror("Error", f"Error registering: {str(e)}")
    
    def refresh_animal_list(self):
        for item in self.tree.get_children():
            self.tree.delete(item)
        
        animals = self.controller.get_all_animals()
        if not animals:
            self.tree.insert('', tk.END, values=('--', 'No animals', '--', '--', '--', '--', 'Register a new animal'))
            return
        
        for animal in animals:
            extra_info = self.get_extra_info(animal)
            born_on_str = animal.born_on.strftime('%Y-%m-%d') if animal.born_on else '--'
            self.tree.insert('', tk.END, values=(
                animal.id,
                animal.__class__.__name__,
                animal.breed,
                born_on_str,
                f"{animal.weight:.1f}",
                animal.get_age_in_months(),
                extra_info
            ))
    
    def filter_animals(self):
        selected = self.filter_var.get()
        for item in self.tree.get_children():
            self.tree.delete(item)
        
        if selected == 'All':
            self.refresh_animal_list()
            return
        
        animals = self.controller.get_animals_by_type(selected)
        if not animals:
            self.tree.insert('', tk.END, values=('--', f'No {selected}s', '--', '--', '--', '--', 'Register one'))
            return
        
        for animal in animals:
            extra_info = self.get_extra_info(animal)
            born_on_str = animal.born_on.strftime('%Y-%m-%d') if animal.born_on else '--'
            self.tree.insert('', tk.END, values=(
                animal.id,
                animal.__class__.__name__,
                animal.breed,
                born_on_str,
                f"{animal.weight:.1f}",
                animal.get_age_in_months(),
                extra_info
            ))
    
    def delete_selected_animal(self):
        selection = self.tree.selection()
        if not selection:
            messagebox.showwarning("No Selection", "Select an animal from the table to delete")
            return
        
        values = self.tree.item(selection[0])['values']
        id = values[0]
        type_name = values[1]
        
        confirm = messagebox.askyesno("Confirm Deletion", 
            f"Are you sure you want to delete this animal?\n"
            f"ID: {id}\n"
            f"Type: {type_name}")
        
        if confirm:
            if self.controller.delete_animal(id):
                messagebox.showinfo("Deleted", "Animal deleted successfully")
                self.refresh_animal_list()
            else:
                messagebox.showerror("Error", "Could not delete the animal")
    
    def get_extra_info(self, animal):
        if isinstance(animal, Cow):
            return f"Produces milk: {'Yes' if animal.is_producing_milk else 'No'} | Milk: {animal.milk_produced:.2f}L"
        elif isinstance(animal, Chicken):
            return f"Eggs/week: {animal.number_of_eggs_per_week}{' (Molting)' if animal.is_molting else ''}"
        elif isinstance(animal, Pig):
            return f"Ideal weight: {animal.ideal_weight}kg{' (Ready!)' if animal.is_ready_for_slaughter() else ''}"
        elif isinstance(animal, Sheep):
            return f"Last sheering: {animal.last_sheering.strftime('%Y-%m-%d') if animal.last_sheering else '--'}"
        return ''
    
    def clear_fields(self):
        self.id_entry.delete(0, tk.END)
        self.breed_entry.delete(0, tk.END)
        self.born_on_entry.delete(0, tk.END)
        self.born_on_entry.insert(0, datetime.now().strftime("%Y-%m-%d"))
        self.weight_entry.delete(0, tk.END)
        self.extra_entry1.delete(0, tk.END)
        self.extra_entry2.delete(0, tk.END)
        self.id_entry.focus()
    
    def calculate_milk_production(self):
        total_milk = self.controller.calculate_total_milk_production()
        self.result_text.insert(tk.END, "=== TOTAL MILK PRODUCTION ===\n")
        self.result_text.insert(tk.END, f"Total milk produced: {total_milk:.2f} liters\n")
        self.result_text.insert(tk.END, "---------------------------------------\n\n")
    
    def calculate_egg_production(self):
        total_eggs = self.controller.calculate_total_eggs_per_week()
        self.result_text.insert(tk.END, "=== TOTAL EGG PRODUCTION ===\n")
        self.result_text.insert(tk.END, f"Total eggs per week: {total_eggs}\n")
        self.result_text.insert(tk.END, "---------------------------------------\n\n")
    
    def show_ready_pigs(self):
        ready_pigs = self.controller.get_pigs_ready_for_slaughter()
        self.result_text.insert(tk.END, "=== PIGS READY FOR SLAUGHTER ===\n")
        if not ready_pigs:
            self.result_text.insert(tk.END, "No pigs ready for slaughter.\n")
        else:
            for pig in ready_pigs:
                self.result_text.insert(tk.END, 
                    f"ID: {pig.id}, Breed: {pig.breed}, Weight: {pig.weight}kg, Ideal Weight: {pig.ideal_weight}kg\n")
        self.result_text.insert(tk.END, "---------------------------------------\n\n")
    
    def search_animal_by_id(self):
        id_str = simpledialog.askstring("Search Animal", "Enter the animal ID to search:")
        if id_str and id_str.strip():
            try:
                id = int(id_str.strip())
                animal = self.controller.get_animal_by_id(id)
                
                if animal:
                    self.result_text.insert(tk.END, "=== ANIMAL FOUND ===\n")
                    born_on_str = animal.born_on.strftime('%Y-%m-%d') if animal.born_on else '--'
                    self.result_text.insert(tk.END, f"ID: {animal.id}\n")
                    self.result_text.insert(tk.END, f"Type: {animal.__class__.__name__}\n")
                    self.result_text.insert(tk.END, f"Breed: {animal.breed}\n")
                    self.result_text.insert(tk.END, f"Born On: {born_on_str}\n")
                    self.result_text.insert(tk.END, f"Weight: {animal.weight:.1f} kg\n")
                    self.result_text.insert(tk.END, f"Age: {animal.get_age_in_months()} months\n")
                    self.result_text.insert(tk.END, f"Extra: {self.get_extra_info(animal)}\n")
                    self.result_text.insert(tk.END, "---------------------------------------\n\n")
                else:
                    self.result_text.insert(tk.END, "=== ANIMAL NOT FOUND ===\n")
                    self.result_text.insert(tk.END, f"No animal found with ID: {id}\n")
                    self.result_text.insert(tk.END, "---------------------------------------\n\n")
            except ValueError:
                messagebox.showerror("Invalid Input", "Please enter a valid number")
    
    def generate_statistics(self):
        stats = self.controller.get_zoo_statistics()
        self.stats_text.delete('1.0', tk.END)
        self.stats_text.insert('1.0', stats)
    
    def run(self):
        self.root.mainloop()

if __name__ == "__main__":
    app = FrmZooApplication()
    app.run()