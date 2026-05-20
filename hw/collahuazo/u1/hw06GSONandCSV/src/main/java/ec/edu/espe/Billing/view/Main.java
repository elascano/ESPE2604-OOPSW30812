/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ec.edu.espe.Billing.view;
import ec.edu.espe.Billing.model.Product;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author Didier Elbay  <Code_Bros , @ESPE>
 */
public class Main {
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        
        int option;
        String id;
        String name;
        double unitPrice;
        int stock;
        String deleteId;
        boolean found;
        do{
            System.out.println("* * * * * * * * * * * * * * * M  E  N  U * * * * * * * * * * * * * * *");
            System.out.println("");
            System.out.println("1. Ingresar producto");
            System.out.println("2. Mostrar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4 Salir");
            System.out.println("");
            System.out.println("Seleccione una opcion");
            option=entrada.nextInt();
            entrada.nextLine();
            
            switch(option){
                case 1:
                    System.out.println("Ingrese el id :");
                    id=entrada.nextLine();
                    System.out.println("Ingrese el nombre :");
                    name=entrada.nextLine();
                    System.out.println("Ingrese el precio del producto :");
                    unitPrice=entrada.nextDouble();
                    System.out.println("Ingrese el numero de stock :");
                    stock=entrada.nextInt();
                    Product product=new Product(id,name,unitPrice,stock);
                    products.add(product);
                    System.out.println("Ingresado correctamente");
                    break;
                case 2 :
                    System.out.println("Lista de productos");
                    System.out.println("");
                    if(products.isEmpty()){
                        System.out.println("No hay ningun producto registrado");  
                    }else{
                        for(Product producto:products){
                            System.out.println("ID :"+producto.getId());
                            System.out.println("Nombre :"+producto.getName());
                            System.out.println("Sotck:"+producto.getStock());
                            System.out.println("Precio :"+producto.getUnitPrice());
                        }
                    }
                    break;
                case 3 :
                    if(products.isEmpty()){
                        System.out.println("No hay productos para eliminar");
                        
                    }else{
                        System.out.println("Ingrese el ID del producto que desea eliminar ");
                        deleteId=entrada.nextLine();
                        found =false;
                        for(int i=0;i<products.size();i++){
                            if(products.get(i).getId().equals(deleteId)){
                                products.remove(i);
                                found=true;
                                System.out.println("Producto eliminado correctamente");
                                break;
                            }
                        }
                        if(!found){
                            System.out.println("Producto no encontrado");
                        }
                    }break;
                case 4:
                    
                    try (FileWriter writer = new FileWriter("products.csv")) {
                        writer.write("ID,Nombre,Precio,Stock\n"); 
                        for (Product p : products) {
                            writer.write(p.getId() + "," + p.getName() + "," + p.getUnitPrice() + "," + p.getStock() + "\n");
                        }
                        System.out.println("Archivo 'products.csv' generado con exito.");
                    } catch (IOException e) {
                        System.err.println("Error al guardar CSV: " + e.getMessage());
                    }

                   
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    try (FileWriter writer = new FileWriter("products.json")) {
                        gson.toJson(products, writer);
                        System.out.println("Archivo 'products.json' generado con exito.");
                    } catch (IOException e) {
                        System.err.println("Error al guardar JSON: " + e.getMessage());
                    }
                    break;
                default :
                    System.out.println("Opcion incorrecta");
                    
                    
            }
        }while(option !=4 );
        entrada.close();
        
    }
    
}
