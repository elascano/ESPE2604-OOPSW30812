import tkinter as tk

class MotherView(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("MothersApp (Python MVC Version)")
        self.geometry("850x550")
        self.configure(bg="#d3d3d3")

        top_frame = tk.Frame(self, bg="#d3d3d3")
        top_frame.pack(fill="x", padx=15, pady=10)

        # ==========================================
        # PANEL 1: MADRE
        # ==========================================
        self.frame_mother = tk.LabelFrame(top_frame, text=" Mother ", font=("Arial", 10, "bold"), padx=15, pady=15, bg="#e0e0e0")
        self.frame_mother.pack(side="left", fill="both", expand=True, padx=(0, 10))
        self.frame_mother.columnconfigure(1, weight=1)

        tk.Label(self.frame_mother, text="Name:", bg="#e0e0e0").grid(row=0, column=0, sticky="w", pady=4)
        self.txt_mother_name = tk.Entry(self.frame_mother, font=("Arial", 10))
        self.txt_mother_name.grid(row=0, column=1, sticky="ew", pady=4)

        tk.Label(self.frame_mother, text="LastName:", bg="#e0e0e0").grid(row=1, column=0, sticky="w", pady=4)
        self.txt_mother_lastname = tk.Entry(self.frame_mother, font=("Arial", 10))
        self.txt_mother_lastname.grid(row=1, column=1, sticky="ew", pady=4)

        tk.Label(self.frame_mother, text="Id:", bg="#e0e0e0").grid(row=2, column=0, sticky="w", pady=4)
        self.txt_mother_id = tk.Entry(self.frame_mother, font=("Arial", 10))
        self.txt_mother_id.grid(row=2, column=1, sticky="ew", pady=4)

        tk.Label(self.frame_mother, text="WeightKg:", bg="#e0e0e0").grid(row=3, column=0, sticky="w", pady=4)
        self.txt_mother_weight = tk.Entry(self.frame_mother, font=("Arial", 10))
        self.txt_mother_weight.grid(row=3, column=1, sticky="ew", pady=4)

        tk.Label(self.frame_mother, text="BirthDate:", bg="#e0e0e0").grid(row=4, column=0, sticky="w", pady=4)
        self.txt_mother_birthdate = tk.Entry(self.frame_mother, font=("Arial", 10))
        self.txt_mother_birthdate.grid(row=4, column=1, sticky="ew", pady=4)

        tk.Label(self.frame_mother, text="Height:", bg="#e0e0e0").grid(row=5, column=0, sticky="w", pady=4)
        self.txt_mother_height = tk.Entry(self.frame_mother, font=("Arial", 10))
        self.txt_mother_height.grid(row=5, column=1, sticky="ew", pady=4)

        # Botones Madre (Save y Load)
        self.btn_load_mother = tk.Button(self.frame_mother, text="Load Mother", font=("Arial", 9, "bold"))
        self.btn_load_mother.grid(row=6, column=1, pady=10, sticky="w")
        self.btn_save_mother = tk.Button(self.frame_mother, text="Save Mother", font=("Arial", 9, "bold"))
        self.btn_save_mother.grid(row=6, column=1, pady=10, sticky="e")

        # ==========================================
        # PANEL 2: BEBÉ
        # ==========================================
        self.frame_baby = tk.LabelFrame(top_frame, text=" Baby ", font=("Arial", 10, "bold"), padx=15, pady=15, bg="#e0e0e0")
        self.frame_baby.pack(side="right", fill="both", expand=True, padx=(10, 0))
        self.frame_baby.columnconfigure(1, weight=1)

        tk.Label(self.frame_baby, text="Name:", bg="#e0e0e0").grid(row=0, column=0, sticky="w", pady=4)
        self.txt_baby_name = tk.Entry(self.frame_baby, font=("Arial", 10))
        self.txt_baby_name.grid(row=0, column=1, sticky="ew", pady=4)

        tk.Label(self.frame_baby, text="LastName:", bg="#e0e0e0").grid(row=1, column=0, sticky="w", pady=4)
        self.txt_baby_lastname = tk.Entry(self.frame_baby, font=("Arial", 10))
        self.txt_baby_lastname.grid(row=1, column=1, sticky="ew", pady=4)

        tk.Label(self.frame_baby, text="Weightg:", bg="#e0e0e0").grid(row=2, column=0, sticky="w", pady=4)
        self.txt_baby_weight = tk.Entry(self.frame_baby, font=("Arial", 10))
        self.txt_baby_weight.grid(row=2, column=1, sticky="ew", pady=4)

        tk.Label(self.frame_baby, text="BirthDate:", bg="#e0e0e0").grid(row=3, column=0, sticky="w", pady=4)
        self.txt_baby_birthdate = tk.Entry(self.frame_baby, font=("Arial", 10))
        self.txt_baby_birthdate.grid(row=3, column=1, sticky="ew", pady=4)

        tk.Label(self.frame_baby, text="Height:", bg="#e0e0e0").grid(row=4, column=0, sticky="w", pady=4)
        self.txt_baby_height = tk.Entry(self.frame_baby, font=("Arial", 10))
        self.txt_baby_height.grid(row=4, column=1, sticky="ew", pady=4)

        # Botones Bebé (Save y Load)
        self.btn_load_baby = tk.Button(self.frame_baby, text="Load Baby", font=("Arial", 9, "bold"))
        self.btn_load_baby.grid(row=5, column=1, pady=10, sticky="w")
        self.btn_save_baby = tk.Button(self.frame_baby, text="Save Baby", font=("Arial", 9, "bold"))
        self.btn_save_baby.grid(row=5, column=1, pady=10, sticky="e")

        # ==========================================
        # PANEL 3: CITAS MÉDICAS
        # ==========================================
        self.frame_appointment = tk.LabelFrame(self, text=" Medical appointment reminder ", font=("Arial", 10, "bold"), padx=15, pady=15, bg="#e0e0e0")
        self.frame_appointment.pack(fill="x", padx=15, pady=15)

        tk.Label(self.frame_appointment, text="AppointmentDate:", bg="#e0e0e0").grid(row=0, column=0, sticky="w", pady=4)
        self.txt_app_date = tk.Entry(self.frame_appointment, font=("Arial", 10))
        self.txt_app_date.grid(row=0, column=1, padx=(5, 20), pady=4)

        tk.Label(self.frame_appointment, text="Recommendations:", bg="#e0e0e0").grid(row=1, column=0, sticky="w", pady=4)
        self.txt_app_recom = tk.Entry(self.frame_appointment, font=("Arial", 10), width=40)
        self.txt_app_recom.grid(row=1, column=1, padx=(5, 20), pady=4)

        # Botones Cita (Save y Load)
        self.btn_load_appointment = tk.Button(self.frame_appointment, text="Load Appointment", font=("Arial", 9, "bold"))
        self.btn_load_appointment.grid(row=1, column=2, padx=5, pady=4)
        self.btn_save_appointment = tk.Button(self.frame_appointment, text="Save Appointment", font=("Arial", 9, "bold"))
        self.btn_save_appointment.grid(row=1, column=3, padx=5, pady=4)