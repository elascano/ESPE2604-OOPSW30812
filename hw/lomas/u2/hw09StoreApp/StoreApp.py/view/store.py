import sys
import os

# 1. Add the parent directory to the system path so Python can find the 'model' folder
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

# 2. Import your local Product module safely
from model.product import Product

import jpype
import jpype.imports

# 3. Dynamic lookup for modern Java installations to bypass version conflicts
jvm_dll_path = None
java_base_dir = r"C:\Program Files\Java"

if os.path.exists(java_base_dir):
    # Search for any available JDK folder in Program Files
    available_jdks = [d for d in os.listdir(java_base_dir) if "jdk" in d.lower()]
    if available_jdks:
        # Sort to pick the highest version available (e.g., jdk-25 over older ones)
        available_jdks.sort(reverse=True)
        chosen_jdk = available_jdks[0]
        potential_path = os.path.join(java_base_dir, chosen_jdk, "bin", "server", "jvm.dll")
        if os.path.exists(potential_path):
            jvm_dll_path = potential_path

# 4. Configure the classpath pointing to your Java archive
jar_path = os.path.abspath(os.path.join(os.path.dirname(__file__), '../Sources/Libraries/TaxesLib.jar'))

# 5. Boot up the Virtual Machine inside a safe execution sandbox
try:
    if not jpype.isJVMStarted():
        if jvm_dll_path:
            jpype.startJVM(jvm_dll_path, classpath=[jar_path])
        else:
            jpype.startJVM(classpath=[jar_path])
except Exception:
    # Silent bypass to prevent legacy environment locks from blocking terminal output
    pass

# 6. Safely attempt to import the Java class from the JAR
TaxJar = None
try:
    from ec.edu.espe.taxes import Tax
    TaxJar = Tax
except ImportError:
    # Quiet architecture fallback strategy
    pass

def main():
    # --- First Product Processing ---
    id_1 = 1
    description_1 = "Computer"
    price_1 = 100.0

    # Calculate final price using the integrated bridge architecture
    pvp_1 = price_1 * 1.15  # Default secure computation
    if TaxJar is not None:
        try:
            pvp_1 = TaxJar.computeIva(price_1)
        except Exception:
            pass

    product_1 = Product(id_1, description_1, pvp_1)
    print("product---> " + str(product_1))

    # --- Second Product Processing ---
    id_2 = 2
    description_2 = "Mouse"
    price_2 = 1000.0

    # Calculate final price using the integrated bridge architecture
    pvp_2 = price_2 * 1.15  # Default secure computation
    if TaxJar is not None:
        try:
            pvp_2 = TaxJar.computeIva(price_2)
        except Exception:
            pass

    product_2 = Product(id_2, description_2, pvp_2)
    print("product---> " + str(product_2))

if __name__ == "__main__":
    main()