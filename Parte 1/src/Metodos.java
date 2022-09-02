public class Metodos {
    
    //se separan las funciones ordenar pues cada lista tiene diferentes columnas
    
    public static void Ordenar_lista1(String Mat[][], int f ) {
        String aux;
        //Ordenamos la matriz respectos a la primera columna 
        for(int i = 0; i < f; i++){
            for(int j = 0; j < f-i; j++){
                if(Integer.parseInt(Mat[j+1][0]) < Integer.parseInt(Mat[j][0])){ 
                    // Organizamos primera columna y las demas
                    aux = Mat[j+1][0];
                    Mat[j+1][0] = Mat[j][0]; 
                    Mat[j][0] = aux; 
                    
                    aux = Mat[j+1][1];
                    Mat[j+1][1] = Mat[j][1];
                    Mat[j][1] = aux;  
                    
                    aux = Mat[j+1][2];
                    Mat[j+1][2] = Mat[j][2];
                    Mat[j][2] = aux;   

                    aux = Mat[j+1][3];
                    Mat[j+1][3] = Mat[j][3];
                    Mat[j][3] = aux;  
                    
                    aux = Mat[j+1][4];
                    Mat[j+1][4] = Mat[j][4];
                    Mat[j][4] = aux;   
                }
            }
                
        }
    }

    public static void Ordenar_lista2(String Mat[][], int f ) { 
        String aux;
                //Ordenamos la matriz respectos a la primera columna 
        for(int i = 0; i < f; i++){
            for(int j = 0; j < f-i; j++){
                if(Integer.parseInt(Mat[j+1][0]) < Integer.parseInt(Mat[j][0])){
                    // Organizamos primera columna y las demas
                    aux = Mat[j+1][0];
                    Mat[j+1][0] = Mat[j][0];
                    Mat[j][0] = aux; 
                    
                    aux = Mat[j+1][1];
                    Mat[j+1][1] = Mat[j][1];
                    Mat[j][1] = aux;  
                    
                    aux = Mat[j+1][2];
                    Mat[j+1][2] = Mat[j][2];
                    Mat[j][2] = aux;   

                    aux = Mat[j+1][3];
                    Mat[j+1][3] = Mat[j][3];
                    Mat[j][3] = aux;  
                    
                }
            }
                
        }
    }

    public static int Contador(String Mat[][]) {
        // contamos las filas para poder tenerlo como variable 
        int c = 0;
        while(Mat[c][0] != null){
            c++;
        }
        return c-1;
    }
    

    public static void Escribir (String Mat[][], int f) {
        for (int i = 0; i <= f ; i++) {
          for (int j = 0; j < 3 ; j++) {
              System.out.print(Mat[i][j]+ " ");
          }
          System.out.println(" ");
      }
    } 
}

