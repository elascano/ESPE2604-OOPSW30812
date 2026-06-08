import sys
import os


sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))


from model.product import Product

import jpype
import jpype.imports


jvm_dll_path = None
java_base_dir = r"C:\Program Files\Java"

if os.path.exists(java_base_dir):
   
    available_jdks = [d for d in os.listdir(java_base_dir) if "jdk" in d.lower()]
    if available_jdks:
        
        available_jdks.sort(reverse=True)
        chosen_jdk = available_jdks[0]
        potential_path = os.path.join(java_base_dir, chosen_jdk, "bin", "server", "jvm.dll")
        if os.path.exists(potential_path):
            jvm_dll_path = potential_path


jar_path = os.path.abspath(os.path.join(os.path.dirname(__file__), '../Sources/Libraries/TaxesLib.jar'))

try:
    if not jpype.isJVMStarted():
        if jvm_dll_path:
            jpype.startJVM(jvm_dll_path, classpath=[jar_path])
        else:
            jpype.startJVM(classpath=[jar_path])
except Exception:
    
    pass


TaxJar = None
try:
    from ec.edu.espe.taxes import Tax
    TaxJar = Tax
except ImportError:
   
    pass

def main():
  
    id_1 = 1
    description_1 = "Computer"
    price_1 = 100.0


    pvp_1 = price_1 * 1.15  
    if TaxJar is not None:
        try:
            pvp_1 = TaxJar.computeIva(price_1)
        except Exception:
            pass

    product_1 = Product(id_1, description_1, pvp_1)
    print("product---> " + str(product_1))


    id_2 = 2
    description_2 = "Mouse"
    price_2 = 1000.0

    
    pvp_2 = price_2 * 1.15 
    if TaxJar is not None:
        try:
            pvp_2 = TaxJar.computeIva(price_2)
        except Exception:
            pass

    product_2 = Product(id_2, description_2, pvp_2)
    print("product---> " + str(product_2))

if __name__ == "__main__":
    main()
