import java.util.Scanner;
public class App {
    
    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in);
        String MatC[][] = new String[100][100];
        String MatF[][] = new String[100][100];
        String MatP[][] = new String[100][100];
        int filas = 0;
        int decision = 0;

        /*
         *  ======== Archivo de clientes ===========
         * Archivos.Llenar1(leer,"prueba");
         * Archivos.CrearMatriz("prueba", MatC, filas);
         * Metodos.Ordenar_lista1(MatC, Metodos.Contador(MatC));
         * Archivos.Cambiar1("prueba", MatC, Metodos.Contador(MatC) );
         * 
         */
        Archivos.CrearMatriz("prueba", MatC, filas);

         /*
         *  ======== Archivo de facturas ===========
         * Archivos.Llenar2(leer,"facturas");
         * Archivos.CrearMatriz("facturas", MatF, filas);
         * Metodos.Ordenar_lista2(MatF, Metodos.Contador(MatF));
         * Archivos.Cambiar2("facturas", MatF, Metodos.Contador(MatF));  
         * 
         */
        Archivos.CrearMatriz("facturas", MatF, filas);
         /*
         *  ======== Archivo de productos ===========
         * Archivos.Llenar3(leer,"Productos");
         * Archivos.CrearMatriz("productos", MatP, filas);  
         * 
         */
        Archivos.CrearMatriz("productos", MatP, filas); 

         do{
        System.out.println("====================================");
        System.out.println("¿Que quieres hacer?");
        System.out.println("====================================");
        System.out.println("1. informacion sobre sus facturas \n2. Producto con mayor numero de solicitudes \n3. salir ");
        decision = leer.nextInt();
        while(decision > 3 || decision < 1){
            System.out.println("====================================");
            System.out.println("Error");
            System.out.println("====================================");
            System.out.println("¿Que quieres hacer?");
            System.out.println("====================================");
            System.out.println("1. informacion sobre sus facturas \n2. Producto con mayor numero de solicitudes \n 3. salir ");
            decision = leer.nextInt();
        }
        switch(decision){
            case 1:
                String Vcodigo[] = new String[100];
                String Vcantidad[] = new String[100];
                String Vprecio[] = new String[100];
                int Vresultante[] = new int[100];
                int k=-1, l=-1;
                int Total = 0;
                int Cedulainfo, validacionfactura=0;;

                System.out.print("Digite su cedula:");
                Cedulainfo = leer.nextInt();

                //verficar si en efecto tiene factura
                for(int i = 0; i <= Metodos.Contador(MatF); i++){
                    if(Cedulainfo == Integer.parseInt(MatF[i][0])){
                        validacionfactura = 1;
                    }
                }
                if(validacionfactura == 0){
                    System.out.println("========= No tienes facturas =========");
                } else {

                    for(int i = 0; i <= Metodos.Contador(MatF); i++){
                        if(Cedulainfo == Integer.parseInt(MatF[i][0])){
                            k++;
                            Vcantidad[k] = MatF[i][2];
                            Vcodigo[k] = MatF[i][3];
                        }
                    }

                    for(int i = 0; i <= k; i++){
                        for(int j = 0; j <= Metodos.Contador(MatP); j++){
                            if(Integer.parseInt(Vcodigo[i]) == Integer.parseInt(MatP[j][0])){
                                l = l+1;
                                Vprecio[l] = MatP[j][2];
                            }
                        }
                    }

                    for(int i = 0; i <= k; i++){
                        Vresultante[i] = Integer.parseInt(Vprecio[i]) * Integer.parseInt(Vcantidad[i]); 
                    }

                    for(int i = 0; i <= k; i++){
                        Total = Total + Vresultante[i]; 
                    }

                    for(int i = 0; i <= Metodos.Contador(MatC); i++){
                        if(Cedulainfo == Integer.parseInt(MatC[i][0])){
                            System.out.println("======= INFO =======");
                            System.out.println("Cedula: " + Cedulainfo);
                            System.out.println("Nombre: " + MatC[i][1]);
                            System.out.println("Dirección: " + MatC[i][2]);
                            System.out.println("Celular: " + MatC[i][3]);
                            System.out.println("Eamil: " + MatC[i][4]);
                            System.out.println("Total a pagar: " + Total);
                            System.out.println("");
                        }
                    }
                }

            break;

            case 2:
                int mayor;
                int posfactura = 1;
                int posproducto = 1;
                int Vcontador[] = new int[100];
                for(int i = 0; i < 100; i++){
                    Vcontador[i] = 0;
                }

                for(int i = 0; i <= Metodos.Contador(MatF); i++){
                    for(int j = 0; j <= Metodos.Contador(MatF); j++){
                        if ( Integer.parseInt(MatF[i][2]) == Integer.parseInt(MatF[j][2])){
                            Vcontador[i] = Vcontador[i] + 1;
                        }
                    }   
                }
                mayor =Vcontador[0];
                for(int i = 0; i < Metodos.Contador(MatF) ; i++){
                    if(mayor < Vcontador[i+1]){
                        mayor = Vcontador[i+1];
                        posfactura = i+1;
                    }
                }

                for(int i = 0; i < Metodos.Contador(MatP) ; i++){
                    if(Integer.parseInt(MatF[posfactura][2]) == Integer.parseInt(MatP[i][2]) ){
                        posproducto = i;
                    }
                }
                

                System.out.println("======= INFO =======");
                System.out.println("El producto mas solicitado");
                System.out.println("Codigo: " + MatP[posproducto][0]);
                System.out.println("Descripción: " + MatP[posproducto][1]);
                System.out.println("Precio: " + MatP[posproducto][2]);
                System.out.println("");
                
            break;
        }

        }while(decision != 3);

    }
}





