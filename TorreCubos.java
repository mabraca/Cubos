import java.io.*;
import java.util.*;
public class TorreCubos {  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) throws IOException{  
      String file = args[0];
      BufferedReader in = new BufferedReader(new FileReader(file));
      int k = 0;//Variable auxiliar para las iteraciones
      int dados = Integer.parseInt(in.readLine());//Numero de cubos
      if (dados < 1 || dados > 500) throw new IllegalArgumentException("Numero de cubos debe ser entre 1 y 500");
      int lado=1;  
      Cubo[][] cubos = new Cubo[6][dados];
      for (int i=0; i<dados; i++) {   
                String[] caras = (in.readLine()).split(" ");
                cubos[0][i] = new Cubo(caras[0], caras[1], "frente", i+1);  
                cubos[1][i] = new Cubo(caras[1], caras[0], "detras", i+1);  
                cubos[2][i] = new Cubo(caras[2], caras[3], "izquierda", i+1);  
                cubos[3][i] = new Cubo(caras[3], caras[2], "derecha", i+1);  
                cubos[4][i] = new Cubo(caras[4], caras[5], "arriba", i+1);  
                cubos[5][i] = new Cubo(caras[5], caras[4], "abajo", i+1);  
      } 
            for (int i=1; i<dados; i++) {  
                for (int j=0; j<i; j++) {  
                    for (int m=0; m<6; m++)  
                        for (int n=0; n<6; n++) {  
                            if (cubos[m][j].abajo==cubos[n][i].arriba && cubos[n][i].peso<cubos[m][j].peso+1) {  
                                cubos[n][i].peso = cubos[m][j].peso+1;  
                                cubos[n][i].anterior = cubos[m][j];  
                            }  
                        }  
                }  
            }  
            int maxi=0, maxj=0;  
            for (int i=0; i<dados; i++) {  
                for (int j=0; j<6; j++) {  
                    if (cubos[j][i].peso > cubos[maxj][maxi].peso) {  
                        maxi = i;  
                        maxj = j;  
                    }  
                }  
            }  
            //Imprimir  
            Cubo destino = cubos[maxj][maxi];  
            System.out.println(destino.peso);  
            List<Cubo> camino = new ArrayList<Cubo>();  
            while (destino != null) {  
                camino.add(destino);  
                destino = destino.anterior;  
            }  
            for (int i=camino.size()-1; i>=0; i--)  
                System.out.println(camino.get(i).lado + " " + camino.get(i).cara);  
        
    }  
  
}  
