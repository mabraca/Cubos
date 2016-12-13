class Cubo {  
    public int arriba;  
    public int abajo;  
    public String cara;  
    public int peso;  
    public Cubo anterior;  
    public int lado;  
      
    public Cubo(String arriba, String abajo, String cara, int lado) {  
        this.arriba = Integer.parseInt(arriba);  
	if (this.arriba < 1 || this.arriba > 100) throw new IllegalArgumentException("Numero de color debe ser entre 1 y 100");
        this.abajo = Integer.parseInt(abajo);  
	if (this.abajo < 1 || this.abajo > 100) throw new IllegalArgumentException("Numero de color debe ser entre 1 y 100");
        this.cara = cara;  
        this.peso = 1;  
        this.anterior = null;  
        this.lado = lado;  
    }  
}  
