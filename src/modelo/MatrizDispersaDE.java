
package modelo;

public class MatrizDispersaDE {

    private int filas;
    private int columnas;
    private NodoDE primeroPorFilas;
    private NodoDE primeroPorColumnas;

    public MatrizDispersaDE(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        primeroPorFilas = primeroPorColumnas = null;
    }
    
     public boolean agregar(int fila, int columna, int valor) {
        if (valor == 0 || fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            return false;
        }
        NodoDE actual = primeroPorFilas;
        NodoDE anterior = null;

        while (actual != null && fila > actual.getFila()) {
            anterior = actual;
            actual = actual.getSiguientePorFilas();
        }
        while (actual != null && fila == actual.getFila() && columna > actual.getColumna()) {
            anterior = actual;
            actual = actual.getSiguientePorFilas();
        }
        if (actual != null && fila == actual.getFila() && columna == actual.getColumna()) {
            return false; // No se permiten posiciones repetidas
        }
        NodoDE nuevoNodo = new NodoDE(fila, columna, valor, actual);

        if (anterior == null) {
            primeroPorFilas = nuevoNodo;
        } else {
            anterior.setSiguientePorFilas(nuevoNodo);
        }
        // Insertar por columnas
        actual = primeroPorColumnas;
        anterior = null;

        while (actual != null && columna > actual.getColumna()) {
            anterior = actual;
            actual = actual.getSiguientePorColumnas();
        }
        while (actual != null && columna == actual.getColumna() && fila > actual.getFila()) {
            anterior = actual;
            actual = actual.getSiguientePorColumnas();
        }
        nuevoNodo.setSiguientePorColumnas(actual);
        
        if (anterior == null) {
            primeroPorColumnas = nuevoNodo;
        } else {
            anterior.setSiguientePorColumnas(nuevoNodo);
        }

        return true;
    }
     
    public MatrizDispersaDE sumar (MatrizDispersaDE otra){
        MatrizDispersaDE resultado = new MatrizDispersaDE(filas, columnas);
        
        return resultado;
    }

    @Override
    public String toString() {
        String cadena = "";
        NodoDE actual = primeroPorFilas;

        int maximaLongitud = 0;
        while (actual != null) {
            int numero = actual.getFila();
            String numeroCadena = numero + "";

            if (numeroCadena.length() > maximaLongitud) {
                maximaLongitud = numeroCadena.length();
            }

            numero = actual.getColumna();
            numeroCadena = numero + "";

            if (numeroCadena.length() > maximaLongitud) {
                maximaLongitud = numeroCadena.length();
            }

            numero = actual.getValor();
            numeroCadena = numero + "";

            if (numeroCadena.length() > maximaLongitud) {
                maximaLongitud = numeroCadena.length();
            }

            actual = actual.getSiguientePorFilas();
        }
        actual = primeroPorFilas;
        maximaLongitud++;

        while (actual != null) {
            int numero = actual.getFila();
            String numeroCadena = numero + "";
            cadena += darFormato(numeroCadena, maximaLongitud - numeroCadena.length());

            numero = actual.getColumna();
            numeroCadena = numero + "";

            cadena += darFormato(numeroCadena, maximaLongitud - numeroCadena.length());

            numero = actual.getValor();
            numeroCadena = numero + "";

            cadena += darFormato(numeroCadena, maximaLongitud - numeroCadena.length()) + "\n";

            actual = actual.getSiguientePorFilas();
        }

        return cadena;
    }

    private String darFormato(String cadena, int espacios) {
        String formato = "";

        for (int i = 0; i < espacios; i++) {
            formato += " ";
        }
        return formato + cadena;
    }
    
}
