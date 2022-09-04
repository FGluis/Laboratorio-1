
import java.io.*;
import java.util.Scanner;

public class Archivos {
    
    //Se separan los llenar para pedirle informacion diferente en cada archivo 
    
    public static void Llenar1(Scanner leer, String Nombre_Archivo){
        String cedula, nombre, direccion, celular, email;
       
        try {
            FileWriter outFile = new FileWriter(Nombre_Archivo + ".txt", false);  //Archivo.txt
            // if false the file will be deleted and created everytime
            // if true the registers will be appended to the end of the file
            PrintWriter register = new PrintWriter(outFile);
            
            // LOGICA
            String hay_cliente;
            System.out.println("Hay registros? si - no");
            hay_cliente = leer.nextLine();
            while(hay_cliente.equalsIgnoreCase("si")){
                System.out.print("Cedula:");
                cedula = leer.nextLine();
                System.out.print("Nombre:");
                nombre = leer.nextLine();
                System.out.print("Dirección:");
                direccion = leer.nextLine();
                System.out.print("Celular:");
                celular = leer.nextLine();
                System.out.print("Email:");
                email = leer.nextLine();
                if (!cedula.isEmpty() && !nombre.isEmpty() && !direccion.isEmpty() && !celular.isEmpty() && !email.isEmpty()){
                    register.println(cedula +"\t"+ nombre +"\t"+ direccion +"\t"+ celular +"\t"+ email);
                }
                System.out.println("Hay más registos? si - no");
                hay_cliente = leer.nextLine();  
            }
           register.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    }

    public static void Llenar2(Scanner leer, String Nombre_Archivo){
        String cedulaF, nrofactura, cantidad, codproducto;
       
        try {
            FileWriter outFile = new FileWriter(Nombre_Archivo + ".txt", false);  //Archivo.txt
            // if false the file will be deleted and created everytime
            // if true the registers will be appended to the end of the file
            PrintWriter register = new PrintWriter(outFile);
            
            // LOGICA
            String hay_facturas;
            System.out.println("Hay Facturas? si - no");
            hay_facturas = leer.nextLine();
            while(hay_facturas.equalsIgnoreCase("si")){
                System.out.print("Cedula:");
                cedulaF = leer.nextLine();
                System.out.print("Numero de factura:");
                nrofactura = leer.nextLine();
                System.out.print("Codigo del producto:");
                codproducto = leer.nextLine();
                System.out.print("Cantidad:");
                cantidad = leer.nextLine();
                if (!cedulaF.isEmpty() && !nrofactura.isEmpty() && !codproducto.isEmpty() && !cantidad.isEmpty()){
                    register.println(cedulaF +"\t"+ nrofactura +"\t"+ codproducto +"\t"+ cantidad );
                }
                System.out.println("Hay más facturas? si - no");
                hay_facturas = leer.nextLine();  
            }
           register.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    }

    public static void Llenar3(Scanner leer, String Nombre_Archivo){
        String codigo, descripcion, precio;
       
        try {
            FileWriter outFile = new FileWriter(Nombre_Archivo + ".txt", false);  //Archivo.txt
            // if false the file will be deleted and created everytime
            // if true the registers will be appended to the end of the file
            PrintWriter register = new PrintWriter(outFile);
            
            // LOGICA
            String hay_productos;
            System.out.println("Hay Productos? si - no");
            hay_productos = leer.nextLine();
            while(hay_productos.equalsIgnoreCase("si")){
                System.out.print("Codigo:");
                codigo = leer.nextLine();
                System.out.print("Descripcion:");
                descripcion = leer.nextLine();
                System.out.print("precio:");
                precio = leer.nextLine();
                if (!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()){
                    register.println(codigo +"\t"+ descripcion +"\t"+ precio );
                }
                System.out.println("Hay más productos? si - no");
                hay_productos = leer.nextLine();  
            }
           register.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    }

    public static void LeerArchivo(Scanner leer, String Nombre_Archivo){
        boolean hay = false;
        while(hay == false){
            try {
                BufferedReader br = new BufferedReader(new FileReader(Nombre_Archivo + ".txt"));
                String line = null;
                while((line = br.readLine()) != null){
                    String temp[] = line.split("\t");
                    System.out.println(temp[0] + " || "+ temp[1] + " || "+temp[2] + " || "+temp[3] + " || "+temp[4]);
                }
                br.close();
                hay = true;

            } catch (IOException ex) {
                System.out.println("No se encontro archivo");
                hay = false;
                Nombre_Archivo = leer.nextLine(); // Archivo
            }
        }
        
    }
    
    //a cada compoenente del archivo lo asignamos a un elemento de la matriz
    public static void CrearMatriz(String Nombre_Archivo, String Mat[][], int filas) {
        int t = 0;
        try{
            BufferedReader br = new BufferedReader(new FileReader(Nombre_Archivo + ".txt"));
            String line = null;
            while((line = br.readLine()) != null){
                String Temp[] = line.split("\t");

                for (int k = 0 ; k < Temp.length ; k++) {
                    Mat[t][k] = Temp[k];
                }   
                t++;
            }
            filas = t-1;
            br.close();

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void Cambiar2(String Nombre_Archivo, String Mat[][], int f){
        String cedulaF = "", nrofactura="", cantidad="", codproducto="";
       
        try {
            File Productos = new File(Nombre_Archivo + ".txt");
            PrintWriter register = new PrintWriter(Productos);
            
            // LOGICA

            for (int i = 0; i <= f ; i++) {
                for (int j = 0; j <= 3 ; j++) {
                    switch(j){
                        case 0:
                        cedulaF = Mat[i][0];
                        break;
                        case 1:
                        nrofactura = Mat[i][1];
                        break;
                        case 2:
                        cantidad = Mat[i][2];
                        break;
                        case 3:
                        codproducto = Mat[i][3];
                        break;
                    }
                }
                if (!cedulaF.isEmpty() && !nrofactura.isEmpty() && !codproducto.isEmpty() && !cantidad.isEmpty()){
                    register.println(cedulaF +"\t"+ nrofactura +"\t"+ codproducto +"\t"+ cantidad );
                }
            }
            
            
           register.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    }

    public static void Cambiar1(String Nombre_Archivo, String Mat[][], int f){
        String cedula="", nombre="", direccion="", celular="", email="";
       
        try {
            File Productos = new File(Nombre_Archivo + ".txt");
            PrintWriter register = new PrintWriter(Productos);
            
            // LOGICA

            for (int i = 0; i <= f ; i++) {
                for (int j = 0; j <= 4 ; j++) {
                    switch(j){
                        case 0:
                        cedula = Mat[i][0];
                        break;
                        case 1:
                        nombre = Mat[i][1];
                        break;
                        case 2:
                        direccion = Mat[i][2];
                        break;
                        case 3:
                        celular = Mat[i][3];
                        break;
                        case 4:
                        email = Mat[i][3];
                        break;
                    }
                }
                if (!cedula.isEmpty() && !nombre.isEmpty() && !direccion.isEmpty() && !celular.isEmpty() && !email.isEmpty()){
                    register.println(cedula +"\t"+ nombre +"\t"+ direccion +"\t"+ celular +"\t"+ email);
                }
            }
           register.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    }

}
