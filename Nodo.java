public class Nodo {
    private char caractere;
    private Nodo esquerdo;
    private Nodo direito;
    
    public Nodo(char caractere) {
        this.caractere = caractere;
        this.esquerdo = null;
        this.direito = null;
    }
    
    public char getCaractere() {
        return caractere;
    }
    
    public void setCaractere(char caractere) {
        this.caractere = caractere;
    }
    
    public Nodo getEsquerdo() {
        return esquerdo;
    }
    
    public void setEsquerdo(Nodo esquerdo) {
        this.esquerdo = esquerdo;
    }
    
    public Nodo getDireito() {
        return direito;
    }
    
    public void setDireito(Nodo direito) {
        this.direito = direito;
    }
}