
package modelo;

public class NodoDE {

    private int fila;
    private int columna;
    private int valor;
    private NodoDE siguientePorFilas;
    private NodoDE siguientePorColumnas;

    public NodoDE(int fila, int columna, int valor, NodoDE siguientePorFilas, NodoDE siguientePorColumnas) {
        this.fila = fila;
        this.columna = columna;
        this.valor = valor;
        this.siguientePorFilas = siguientePorFilas;
        this.siguientePorColumnas = siguientePorColumnas;
    }

    

    public NodoDE(int fila, int columna, int valor, NodoDE siguientePorFilas) {
        this.fila = fila;
        this.columna = columna;
        this.valor = valor;
        this.siguientePorFilas = siguientePorFilas;
        siguientePorColumnas = null;
    }
 public NodoDE(int fila, int columna, int valor) {
        this.fila = fila;
        this.columna = columna;
        this.valor = valor;
        siguientePorFilas = null;
        siguientePorColumnas = null;
    }
    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public NodoDE getSiguientePorColumnas() {
        return siguientePorColumnas;
    }

    public void setSiguientePorColumnas(NodoDE siguientePorColumnas) {
        this.siguientePorColumnas = siguientePorColumnas;
    }

    public NodoDE getSiguientePorFilas() {
        return siguientePorFilas;
    }

    public void setSiguientePorFilas(NodoDE siguientePorFilas) {
        this.siguientePorFilas = siguientePorFilas;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

}
