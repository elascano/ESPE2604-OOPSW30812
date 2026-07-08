from __future__ import annotations

import os
import sys

sys.path.insert(0, os.path.join(os.path.dirname(__file__), "src"))

from maze_generator.app import main

if __name__ == "__main__":
    main()
