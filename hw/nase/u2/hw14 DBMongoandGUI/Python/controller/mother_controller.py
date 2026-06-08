import tkinter as tk
from tkinter import messagebox
from model.mother_model import MotherModel
from model.baby_model import BabyModel
from model.appointment_model import AppointmentModel

class MotherController:
    def __init__(self, view):
        self.view = view
        self.mother_model = MotherModel()
        self.baby_model = BabyModel()
        self.appointment_model = AppointmentModel()

        # Vinculación de botones de Subida (Save)
        self.view.btn_save_mother.config(command=self.save_mother)
        self.view.btn_save_baby.config(command=self.save_baby)
        self.view.btn_save_appointment.config(command=self.save_appointment)

        # Vinculación de botones de Bajada (Load)
        self.view.btn_load_mother.config(command=self.load_mother)
        self.view.btn_load_baby.config(command=self.load_baby)
        self.view.btn_load_appointment.config(command=self.load_appointment)

    # --- FUNCIÓN AUXILIAR PARA RELLENAR CAJAS DE TEXTO ---
    def fill_entry(self, entry_widget, value):
        entry_widget.delete(0, tk.END)
        entry_widget.insert(0, str(value) if value is not None else "")

    # ==================================================
    # LOGICA DE BAJADA (LOAD DATA)
    # ==================================================
    def load_mother(self):
        mother_id = self.view.txt_mother_id.get().strip()
        if not mother_id:
            messagebox.showwarning("Required ID", "Please write a Mother ID first to search.")
            return
        
        try:
            mother = self.mother_model.get_mother(mother_id)
            if mother:
                self.fill_entry(self.view.txt_mother_name, mother.get("firstName", ""))
                self.fill_entry(self.view.txt_mother_lastname, mother.get("lastName", ""))
                self.fill_entry(self.view.txt_mother_weight, mother.get("weight", ""))
                self.fill_entry(self.view.txt_mother_birthdate, mother.get("birthDate", ""))
                self.fill_entry(self.view.txt_mother_height, mother.get("height", ""))
                messagebox.showinfo("Cloud Sync", "Mother data successfully downloaded!")
            else:
                messagebox.showwarning("Not Found", f"No mother found with ID: {mother_id}")
        except Exception as e:
            messagebox.showerror("Error", f"Could not download data: {e}")

    def load_baby(self):
        mother_id = self.view.txt_mother_id.get().strip()
        if not mother_id:
            messagebox.showwarning("Required ID", "Please write the Mother ID to find her linked baby.")
            return

        try:
            baby = self.baby_model.get_baby_by_mother(mother_id)
            if baby:
                self.fill_entry(self.view.txt_baby_name, baby.get("firstName", ""))
                self.fill_entry(self.view.txt_baby_lastname, baby.get("lastName", ""))
                self.fill_entry(self.view.txt_baby_weight, baby.get("weight", ""))
                self.fill_entry(self.view.txt_baby_birthdate, baby.get("birthDate", ""))
                self.fill_entry(self.view.txt_baby_height, baby.get("height", ""))
                messagebox.showinfo("Cloud Sync", "Baby data successfully downloaded!")
            else:
                messagebox.showwarning("Not Found", "No baby found linked to this Mother ID.")
        except Exception as e:
            messagebox.showerror("Error", f"Could not download data: {e}")

    def load_appointment(self):
        mother_id = self.view.txt_mother_id.get().strip()
        if not mother_id:
            messagebox.showwarning("Required ID", "Please write the Mother ID to find her medical appointments.")
            return

        try:
            app = self.appointment_model.get_appointment_by_mother(mother_id)
            if app:
                self.fill_entry(self.view.txt_app_date, app.get("appointmentDate", ""))
                self.fill_entry(self.view.txt_app_recom, app.get("recommendations", ""))
                messagebox.showinfo("Cloud Sync", "Latest appointment downloaded!")
            else:
                messagebox.showwarning("Not Found", "No appointments found for this Mother ID.")
        except Exception as e:
            messagebox.showerror("Error", f"Could not download data: {e}")


    # ==================================================
    # LOGICA DE SUBIDA (SAVE DATA - YA PROGRAMADA)
    # ==================================================
    def save_mother(self):
        try:
            mother_data = {
                "id": self.view.txt_mother_id.get().strip(),
                "firstName": self.view.txt_mother_name.get().strip(),
                "lastName": self.view.txt_mother_lastname.get().strip(),
                "birthDate": self.view.txt_mother_birthdate.get().strip(),
                "weight": float(self.view.txt_mother_weight.get().strip()),
                "height": float(self.view.txt_mother_height.get().strip())
            }
            baby_data = {
                "firstName": self.view.txt_baby_name.get().strip(),
                "lastName": self.view.txt_baby_lastname.get().strip(),
                "weight": int(self.view.txt_baby_weight.get().strip()),
                "height": int(self.view.txt_baby_height.get().strip()),
                "birthDate": self.view.txt_baby_birthdate.get().strip()
            }
            if not mother_data["id"]:
                messagebox.showerror("Error", "Please fill in the Mother's ID.")
                return
            self.mother_model.save_mother(mother_data, baby_data)
            messagebox.showinfo("Success", "Mother data successfully uploaded to MongoDB Atlas!")
        except ValueError:
            messagebox.showerror("Format Error", "Please check Mother numbers (decimals with '.') and Baby numbers (integers).")
        except Exception as e:
            messagebox.showerror("Error", f"Error: {e}")

    def save_baby(self):
        try:
            baby_data = {
                "firstName": self.view.txt_baby_name.get().strip(),
                "lastName": self.view.txt_baby_lastname.get().strip(),
                "weight": int(self.view.txt_baby_weight.get().strip()),
                "height": int(self.view.txt_baby_height.get().strip()),
                "birthDate": self.view.txt_baby_birthdate.get().strip(),
                "motherId": self.view.txt_mother_id.get().strip()
            }
            if not baby_data["motherId"]:
                messagebox.showerror("Error", "Please provide a Mother ID first to link the Baby.")
                return
            self.baby_model.save_baby(baby_data)
            messagebox.showinfo("Success", "Baby data successfully uploaded to MongoDB Atlas!")
        except ValueError:
            messagebox.showerror("Format Error", "Please ensure Baby weight and height are valid integers.")
        except Exception as e:
            messagebox.showerror("Error", f"Error: {e}")

    def save_appointment(self):
        try:
            app_data = {
                "appointmentDate": self.view.txt_app_date.get().strip(),
                "recommendations": self.view.txt_app_recom.get().strip(),
                "motherId": self.view.txt_mother_id.get().strip()
            }
            if not app_data["motherId"]:
                messagebox.showerror("Error", "Please provide a Mother ID to link the Appointment.")
                return
            self.appointment_model.save_appointment(app_data)
            messagebox.showinfo("Success", "Appointment successfully scheduled in MongoDB Atlas!")
        except Exception as e:
            messagebox.showerror("Error", f"Error: {e}")