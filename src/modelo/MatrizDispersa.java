
package modelo;

import java.util.NoSuchElementException;


public class MatrizDispersa {

    private int filas;
    private int columnas;
    private int[][] tripletas;
    private int cantidadTripletas;

 
    // a)Constructor
    public MatrizDispersa(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        tripletas = new int[1][3];
        cantidadTripletas = 0;
    }

    
    public boolean estaLlena() {
        return cantidadTripletas == tripletas.length;
    }

    private void duplicarCapacidad() {
        int[][] auxiliar = new int[2 * tripletas.length][3];

        for (int i = 0; i < cantidadTripletas; i++) {
            auxiliar[i][0] = tripletas[i][0];
            auxiliar[i][1] = tripletas[i][1];
            auxiliar[i][2] = tripletas[i][2];
        }
        tripletas = auxiliar;
    }

    //b) Agrega tripleta de forma ordenada
    public boolean agregar(int fila, int columna, int valor) {
        if (valor == 0 || fila < 0 || columna < 0 || columna >= columnas || fila >= filas) {
            return false;
        }

        if (estaLlena()) {
            duplicarCapacidad();
        }

        int i = 0;

        while (i < cantidadTripletas && tripletas[i][0] < fila) {
            i++;
        }

        while (i < cantidadTripletas && tripletas[i][0] == fila && tripletas[i][1] < columna) {
            i++;
        }

        if (i < cantidadTripletas && tripletas[i][0] == fila && tripletas[i][1] == columna) {
            return false;
        }

        for (int j = cantidadTripletas; j > i; j--) {
            tripletas[j][0] = tripletas[j - 1][0];
            tripletas[j][1] = tripletas[j - 1][1];
            tripletas[j][2] = tripletas[j - 1][2];
        }

        tripletas[i][0] = fila;
        tripletas[i][1] = columna;
        tripletas[i][2] = valor;
        cantidadTripletas++;

        return true;
    }

    //c) Elimina tripleta por fila y columna
    public boolean eliminar(int fila, int columna) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            return false;
        }

        int i = 0;
        while (i < cantidadTripletas && tripletas[i][0] < fila) {
            i++;
        }
        while (i < cantidadTripletas && tripletas[i][0] == fila && tripletas[i][1] < columna) {
            i++;
        }
        if (i < cantidadTripletas && tripletas[i][0] == fila && tripletas[i][1] == columna) {
            cantidadTripletas--;
            for (int j = i; j < cantidadTripletas; j++) {
                tripletas[j][0] = tripletas[j + 1][0];
                tripletas[j][1] = tripletas[j + 1][1];
                tripletas[j][2] = tripletas[j + 1][2];
            }
            return true;
        }
        return false;
    }

    //d) Elimina primera tripleta con el valor indicado
    public boolean eliminar(int valor) {
        if (valor != 0) {
            int i = 0;

            while (i < cantidadTripletas) {

                if (i < cantidadTripletas && tripletas[i][2] == valor) {
                    cantidadTripletas--;
                    for (int j = i; j < cantidadTripletas; j++) {
                        tripletas[j][0] = tripletas[j + 1][0];
                        tripletas[j][1] = tripletas[j + 1][1];
                        tripletas[j][2] = tripletas[j + 1][2];
                    }
                    return true;
                }
                i++;
            }
        }
        return false;

    }

    //e) Elimina todas las tripletas que contengan el valor indicado
    public boolean eliminarTodos(int valor) {
        boolean eliminado = false;
        if (valor != 0) {
            int i = 0;

            while (i < cantidadTripletas) {

                if (i < cantidadTripletas && tripletas[i][2] == valor) {
                    eliminado = true;
                    for (int j = i; j < cantidadTripletas; j++) {
                        tripletas[j][0] = tripletas[j + 1][0];
                        tripletas[j][1] = tripletas[j + 1][1];
                        tripletas[j][2] = tripletas[j + 1][2];
                    }
                    cantidadTripletas--;
                    i--;
                }
                i++;
            }
        }
        return eliminado;
    }

    //f) Elimina tripletas que contengan valores pares
    public boolean eliminarPares() {
        boolean eliminado = false;
        int i = 0;

        while (i < cantidadTripletas) {

            if (i < cantidadTripletas && tripletas[i][2] % 2 == 0) {
                eliminado = true;
                for (int j = i; j < cantidadTripletas; j++) {
                    tripletas[j][0] = tripletas[j + 1][0];
                    tripletas[j][1] = tripletas[j + 1][1];
                    tripletas[j][2] = tripletas[j + 1][2];
                }
                cantidadTripletas--;
                i--;
            }
            i++;
        }

        return eliminado;
    }

    //g) Modifica la tripleta coon el valor indicado
    public boolean modificar(int fila, int columna, int valor) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas || valor == 0) {
            return false;
        }

        int i = 0;
        while (i < cantidadTripletas && tripletas[i][0] < fila) {
            i++;
        }
        while (i < cantidadTripletas && tripletas[i][0] == fila && tripletas[i][1] < columna) {
            i++;
        }
        if (i < cantidadTripletas && tripletas[i][0] == fila && tripletas[i][1] == columna) {
            tripletas[i][2] = valor;

            return true;
        }
        return false;
    }

    //h) Dispersión de la matriz 
    public double dispersion() {

        return (cantidadTripletas * 100) / (filas * columnas);
    }

    //i) Retorna valor de la posición indicada
    public int getValor(int fila, int columna) throws NoSuchElementException{
        if (columna > 0 || columna < columnas || fila > 0 || fila < filas) {
            int i = 0;
            while (i < cantidadTripletas && tripletas[i][0] < fila) {
                i++;
            }
            while (i < cantidadTripletas && tripletas[i][0] == fila && tripletas[i][1] < columna) {
                i++;
            }
            if (i < cantidadTripletas && tripletas[i][0] == fila && tripletas[i][1] == columna) {
                return tripletas[i][2];

            }
        }
        throw new NoSuchElementException(" Tripleta no encontrada");
    }
    
    //j) Suma de matrices 
    public MatrizDispersa sumar(MatrizDispersa  otraMatriz){
        MatrizDispersa resultado = new MatrizDispersa(filas, columnas);
        
        return null;
        
    }
    
    //k) toString
    @Override
    public String toString() {
        String cadena = "";
        int mayorCantidadDigitos = 0;

        // Buscamos el valor de la matriz con más caracteres
        for (int i = 0; i < cantidadTripletas; i++) {
            for (int j = 0; j < tripletas[0].length; j++) {
                String numero = tripletas[i][j] + "";
                if (numero.length() > mayorCantidadDigitos) {
                    mayorCantidadDigitos = numero.length();
                }
            }
        }

        // Formamos la cadena con los valores de la matriz por filas
        for (int i = 0; i < cantidadTripletas; i++) {
            for (int j = 0; j < tripletas[0].length; j++) {
                String numero = tripletas[i][j] + "";
                int delta = mayorCantidadDigitos - numero.length();
                // Espacios
                for (int k = 0; k < delta; k++) {
                    cadena += " ";
                }
                cadena = cadena + tripletas[i][j] + " ";
            }
            cadena = cadena + "\n";
        }
        return cadena;
    }
   

}
