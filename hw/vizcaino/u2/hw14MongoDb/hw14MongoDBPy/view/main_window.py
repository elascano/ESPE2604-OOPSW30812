import tkinter as tk
from tkinter import ttk

from view.backup_panel import BackupPanel
from view.combo_panel import ComboPanel
from view.reservation_panel import ReservationPanel

class MainWindow:

    def __init__(self, root):

        root.title("Management System")
        root.geometry("1000x700")

        tabs = ttk.Notebook(root)

        tabs.add(BackupPanel(tabs), text="Backups")
        tabs.add(ReservationPanel(tabs), text="Reservations")
        tabs.add(ComboPanel(tabs), text="Combos")

        tabs.pack(fill="both", expand=True)