import tkinter as tk
from tkinter import messagebox, simpledialog
from model.doctor_model import DoctorModel

class FrmDoctor:
    def __init__(self, root):
        self.root = root
        self.root.title("MothersApp (Python Version - Doctor)")
        self.root.geometry("620x340")
        self.root.configure(bg="#f5f5f5")
        
        self.model = DoctorModel()

        pnl_title = tk.Frame(self.root, bg="#e6ebf0", bd=1, relief="groove")
        pnl_title.pack(fill="x", ipady=8, padx=5, pady=5)
        
        lbl_title = tk.Label(pnl_title, text="DOCTOR CONTROL INTERFACE", font=("Segoe UI", 14, "bold"), bg="#e6ebf0", fg="#000000")
        lbl_title.pack()

        self.pnl_form = tk.LabelFrame(self.root, text=" Doctor Attributes ", font=("Segoe UI", 9, "bold"), bg="#f5f5f5", padx=10, pady=10)
        self.pnl_form.place(x=10, y=70, width=400, height=250)

        tk.Label(self.pnl_form, text="Doctor ID (Numbers):", bg="#f5f5f5").grid(row=0, column=0, sticky="w", pady=15)
        self.txt_id = tk.Entry(self.pnl_form, width=30)
        self.txt_id.grid(row=0, column=1, pady=15, padx=10)

        tk.Label(self.pnl_form, text="Full Name:", bg="#f5f5f5").grid(row=1, column=0, sticky="w", pady=15)
        self.txt_name = tk.Entry(self.pnl_form, width=30)
        self.txt_name.grid(row=1, column=1, pady=15, padx=10)

        tk.Label(self.pnl_form, text="Speciality:", bg="#f5f5f5").grid(row=2, column=0, sticky="w", pady=15)
        self.cmb_speciality = tk.StringVar()
        self.cmb_speciality.set("Obstetrics")
        options = ["Obstetrics", "Gynecology", "Pediatrics", "Neonatology", "General Medicine"]
        self.drop_speciality = tk.OptionMenu(self.pnl_form, self.cmb_speciality, *options)
        self.drop_speciality.config(width=26)
        self.drop_speciality.grid(row=2, column=1, pady=15, padx=10)

        pnl_actions = tk.LabelFrame(self.root, text=" Operations ", font=("Segoe UI", 9, "bold"), bg="#f5f5f5", padx=10, pady=5)
        pnl_actions.place(x=425, y=70, width=185, height=250)

        btn_save = tk.Button(pnl_actions, text="Save Profile", width=20, command=self.btn_save_action)
        btn_save.pack(pady=6)

        btn_view = tk.Button(pnl_actions, text="View Patient History", width=20, command=self.btn_view_history_action)
        btn_view.pack(pady=6)

        btn_note = tk.Button(pnl_actions, text="Add Medical Note", width=20, command=self.btn_add_note_action)
        btn_note.pack(pady=6)

        btn_follow = tk.Button(pnl_actions, text="Recommend Follow-Up", width=20, command=self.btn_follow_up_action)
        btn_follow.pack(pady=6)

        btn_back = tk.Button(pnl_actions, text="Back to Menu", width=20, command=self.root.destroy)
        btn_back.pack(pady=6)

    def btn_save_action(self):
        id_str = self.txt_id.get().strip()
        name = self.txt_name.get().strip()
        speciality = self.cmb_speciality.get()

        result = self.model.save_doctor(id_str, name, speciality)

        if result["status"] == "success":
            messagebox.showinfo("Success", result["message"])
            self.txt_id.delete(0, tk.END)
            self.txt_name.delete(0, tk.END)
        else:
            messagebox.showerror("Error", result["message"])

    def btn_view_history_action(self):
        baby_id_str = simpledialog.askstring("viewPatientHistory", "Enter Baby ID (int):", parent=self.root)
        if baby_id_str and baby_id_str.strip():
            try:
                baby_id = int(baby_id_str.strip())
                messagebox.showinfo("Method Success", f"Invoking viewPatientHistory() routine for Baby ID: {baby_id}")
            except ValueError:
                messagebox.showerror("Input Error", "Baby ID must be a valid integer number.")

    def btn_add_note_action(self):
        baby_id_str = simpledialog.askstring("addMedicalNote", "Enter Baby ID (int):", parent=self.root)
        if baby_id_str and baby_id_str.strip():
            try:
                baby_id = int(baby_id_str.strip())
                note = simpledialog.askstring("addMedicalNote", "Enter Medical Note (String):", parent=self.root)
                if note and note.strip():
                    messagebox.showinfo("Method Success", f"Note successfully added for Baby ID: {baby_id}")
            except ValueError:
                messagebox.showerror("Input Error", "Baby ID must be a valid integer number.")

    def btn_follow_up_action(self):
        baby_id_str = simpledialog.askstring("recommendFollowUp", "Enter Baby ID (int):", parent=self.root)
        if baby_id_str and baby_id_str.strip():
            try:
                baby_id = int(baby_id_str.strip())
                messagebox.showinfo("Method Success", f"Recommend Follow-Up logic executed on target date for Baby ID: {baby_id}")
            except ValueError:
                messagebox.showerror("Input Error", "Baby ID must be a valid integer number.")