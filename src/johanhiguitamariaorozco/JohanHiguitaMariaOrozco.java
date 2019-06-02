
package johanhiguitamariaorozco;


import modelo.MatrizDispersa;


public class JohanHiguitaMariaOrozco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        // Falta programa interactivo
        MatrizDispersa matrizDispersa = new MatrizDispersa(6, 9);
           
        System.out.println(matrizDispersa.agregar(0, 3, 9));
        System.out.println(matrizDispersa.agregar(2, 4, 8));
        System.out.println(matrizDispersa.agregar(1, 5, 4));
        System.out.println(matrizDispersa.agregar(5, 2, 4));
        System.out.println(matrizDispersa.agregar(4, 8, 11));
        System.out.println(matrizDispersa.agregar(1, 6, 4));
        
        System.out.println("Tripletas: ");
        System.out.println(matrizDispersa);
//        System.out.println("Eliminar tripleta: " + matrizDispersa.eliminar(4, 8));
//        System.out.println(matrizDispersa);
//        System.out.println("Eliminar valor: " + matrizDispersa.eliminar(4));
//        System.out.println(matrizDispersa);
//        System.out.println("Eliminar valores: " + matrizDispersa.eliminarTodos(4));
//        System.out.println(matrizDispersa);
//        System.out.println("Eliminar pares: " + matrizDispersa.eliminarPares());
//        System.out.println(matrizDispersa);
        System.out.println("Modificar valor: " + matrizDispersa.modificar(1, 6, 9));
        System.out.println(matrizDispersa);
        System.out.println("Dispersion: " + matrizDispersa.dispersion());
//        System.out.println("Obtener valor: " + matrizDispersa.getValor(1, 8));
        
        
        //Falta metodo sumar
        
    }
    
}
