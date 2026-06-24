import os
import tkinter as tk

class ImageLoader:
    _images = {}

    @classmethod
    def get_image(cls, filename: str, max_size: int = 70) -> tk.PhotoImage:
        cache_key = f"{filename}_{max_size}"
        if cache_key not in cls._images:
            base_path = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', '..', 'resources', 'images'))
            full_path = os.path.join(base_path, filename)
            
            if not os.path.exists(full_path):
                cls._images[cache_key] = tk.PhotoImage()
                return cls._images[cache_key]
                
            img = tk.PhotoImage(file=full_path)
            
            w = img.width()
            h = img.height()
            
            if w > max_size or h > max_size:
                factor = max(w // max_size, h // max_size)
                if factor > 1:
                    img = img.subsample(factor, factor)
            
            cls._images[cache_key] = img
            
        return cls._images[cache_key]
