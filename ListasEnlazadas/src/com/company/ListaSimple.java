package com.company;

import javafx.scene.control.Button;

/**
 * Created by Susan on 23/10/2017.
 */
public class ListaSimple {
    //Declaración de variables.
    private Nodo head;//Punto de inicio de la lista
    private int size;

    //Método para inicializar las variables head y size como vacios.
    public ListaSimple() {
        head = null;
        size = 0;
    }

    //Método para mostrar el menú.
    public void Menu() {
        System.out.println("\nElija una opción: \n\n" +
                "1.-Insertar\n" +
                "2.-Mostrar\n" +
                "3.-Buscar\n" +
                "4.-Eliminar\n" +
                "5.-Contar\n" +
                "6.-Terminar");
    }

    //Método para agregar elementos al inicio de la lista.
    public void agregarInicio(Object obj) {
//Se crea un objeto nuevo de la clase Nodo con el valor que se esta agregando.
        Nodo nuevo = new Nodo(obj);
//Si la abeza esta vacia se le asigna el nuevo elemento ingresado.
        if (head == null) {
            head = nuevo;
        } else {
/*En otro caso se declaracion de la variable temporal que sera igual a la cabeza actual*/
            Nodo temporal = head;
//Se enlaza el nuevo nodo con la cabeza actual quedando este en su lugar de inicio.
            nuevo.enlazarSiguiente(temporal);
//La nueva cabeza seria el nuevo nodo
            head = nuevo;
        }
//Se aumenta el tamaño de la lista cada ves que se agrega un nuevo elemento.
        size++;
    }

    //Método para obtener la longitud de la lista.
    public int size() {
//Retorno el tamño de la lista que se registro en el metodo agregarInicio.
        return size;
    }

    //Método para mostrar la lista.
    public void Mostrar() {

        Nodo temporal = head;
        if (temporal != null) {
            System.out.println("\nLos datos de la lista son: ");
            //Mientras el nodo temporal contenga un elemento es decir que sea distinto de nulo.
            while (temporal != null) {
                //Se imprime todo la lista.
                System.out.println(temporal.obtenerValor().toString() + " ");
                //Se le asigna el valor del siguiente nodo, esto hasta recorrer toda la lista
                temporal = temporal.obtenerSiguiente();
            }
        }
    }

    //Método para buscar el elemento en la lista por posición
    // del 1 al tamaño de la lista.
    public void BuscarPos(int indice) {
        //Si la posición ingresda por el usuario
        if (indice == 1) {
            //Entoonces imprimira el elemento que contenga head.
            System.out.printf("Valor encontrado: " + head.obtenerValor());
        } else {
            //En otro caso se declara una nueva variable a la cual se le asignara head.
            Nodo temporal = head;
            //Se declara e inicializa un contaor en 1;
            int i = 1;
            //Mientras la posición ingresada por el usuario se distinta al contador en su posición actual.
            while (indice != i) {
                //temporal obtendra el valor del siguiente nodo.
                temporal = temporal.obtenerSiguiente();
                //el contdor que recorre la lista va aumentando.
                i++;
            }
            System.out.println("Valor: " + temporal.obtenerValor());
        }
    }

    //Método para buscar el elemento en la lista por valor.
    public Object BuscarValor(Object val) {
        Nodo temporal = head;
        //Se declara e inicializa un contador en 0;
        int i = 0;
        //Mientras el valor u elemento que tenga temporal sea distinto al valor buscado.
        while (!temporal.obtenerValor().equals(val)) {
            //temporal obtendra el valor del siguiente nodo.
            temporal = temporal.obtenerSiguiente();
            //el contdor que recorre la lista va aumentando.
            i++;
        }
    /*Se imprime o retorna la posición del valor buscado de acuerdo al indice
    o posición obtenida con el método declarado anteriormente.*/
        return System.out.printf("Valor encontrado en la posicion " + (i + 1));
    }

    //Método para eliminar por valor.
    public void EliminarValor(Object val) {
/*Este método funciona igual que el método de busqueda por valor ya que
* primero se comprueba que el elemento realmente se encuentre en la lista
* para finalmente pasarle como parametro la posicion del elemento al metodo
* eliminar por posición*/
        Nodo temporal = head;
        int i = 0;
        while (!temporal.obtenerValor().equals(val)) {
            temporal = temporal.obtenerSiguiente();
            i++;
        }
        EliminarPosVal((i));
    }

    //Método para eliminar por indice del 1 al tamaño de la lista.
    public void EliminarPos(int indice) {
        //Si la posición ingresada por el usuario es la 1.
        if (indice == 1) {
    /*Entonces a head se le asignara el siguiente elemento de
    la lista quedando este como el inicio de la lista.*/
            head = head.obtenerSiguiente();
        } else {
            //En otro caso, una ves más se declara una variable temporal.
            Nodo temporal = head;
            //Se declara e inicializa un contador dentro del ciclo.
     /*Para cuando el contador sea menor al indice ingresado por el usuario menos 2
     * a temporal se le asigna lo que temporal en su posició actual deacuerdo al contador
     * obtiene del siguiente nodo aumentando el contador que recorre la lista con i++*/
            for (int i = 0; i < indice - 2; i++) {
                temporal = temporal.obtenerSiguiente();
            }
     /*temporal en su posición actual se enlazará con el siguiente del siguiente nodo y obtendra
     * con esto el valor del nodo enlazado; ejemplo: 1-2-3-4-5 si se desea eliminar el 3 la lista
     * quedaria de la siguiente manera 1-2-4-5*/
            temporal.enlazarSiguiente(temporal.obtenerSiguiente().obtenerSiguiente());
        }
        //Se disminuye el tamaño de la lista.
        size--;
    }

    //Método que elimina la posición del índice obtenido del método Eliminar por Valor.
    public void EliminarPosVal(int indice) {
  /*Este método funciona de la misma manera que el de eliminar por posición, la unica
  * diferencia es que este inici su indice en 0 y es menor por uno al tamaño de la lista
  * ya que de esta manera trabajan las listas el anterior es para cuando el usuario elige
  * posicion puede ser desde el 1 asta la n posicón de la lista que desee.
  * Mostarndo la posición 0 como la 1 y asi susesivamente*/
        if (indice == 0) {
            head = head.obtenerSiguiente();
        } else {
            Nodo temporal = head;
            for (int i = 0; i < indice - 1; i++) {
                temporal = temporal.obtenerSiguiente();
            }
            temporal.enlazarSiguiente(temporal.obtenerSiguiente().obtenerSiguiente());
        }
        size--;
    }

}
    /*



    public void agregarFin(Object valor) {
        Nodo nodo = new Nodo(valor);
        if (size == 0) {
            head = nodo;
        } else {
            Nodo temporal = head;
            while (temporal.obtenerSiguiente() != null) {
                temporal = temporal.obtenerSiguiente();
            }
            temporal.enlazarSiguiente(nodo);
        }
        size++;
    }
    //Método para saber si la lista esta vacia.
    public boolean estaVacio() {
        return (head == null) ? true : false;
    }
    public Object obtener(int index) {
        int contador = 0;
        Nodo temporal = head;
        while (contador < index) {
            temporal = temporal.obtenerSiguiente();
            contador++;
        }
        return temporal.obtenerValor();
    }
    public Object getValor(int posicion) {
        if (posicion >= 0 && posicion < size) {
            if (posicion == 0) {
                return head.obtenerValor();
            } else {
                Nodo temporal = head;
                for (int i = 0; i < posicion; i++) {
                    temporal = temporal.obtenerSiguiente();
                }
                return temporal.obtenerValor();
            }
        }
        return null;
    }
}


    /*____________________________________________________________________*/


          /*  for (int i = 0; i < size()-1; i++) {
               if (i==indice){

                 //  temporal=Integer.parseInt(temporal.obtenerValor().toString())
                   System.out.printf("Valorp2: "+temporal);

               }
                //temporal=temporal.enlazarSiguiente(temporal.obtenerSiguiente());
            }
           // System.out.printf("Valorp2.1: " );
           // temporal.obtenerSiguiente();
        }*/
       // size--;


 /*
    public void EliminarV(int valn) {
       // boolean encontrado=false;

        if (head.equals(Buscar(valn))){
            head= head.obtenerSiguiente();
            System.out.printf("segundo");
        }else {
            Nodo temp=head;
            int i=0;
         while (Buscar(valn).equals(valn)) {
             temp=temp.obtenerSiguiente();
         i++;
         }
        temp.enlazarSiguiente(temp.obtenerSiguiente().obtenerSiguiente());
      }
      size--;
    }
    public Object EliminarValor(int valor) {
        Nodo temporal = head;
       int i=0;
       while (Integer.parseInt(temporal.obtenerValor().toString()) != valor){
          //  if (Integer.parseInt(temporal.obtenerValor().toString()) == valor) {
               return temporal=temporal.obtenerSiguiente();
                i++;
    //            temporal = temporal.obtenerSiguiente();
            }
            return temporal.(enlazarSiguiente(temporal.obtenerSiguiente().obtenerSiguiente());

    }
     public void buscar(Object referencia) {
        if (size == 0) {
            System.out.println("La lista no contiene elementos");
        } else {
            Nodo temporal = head;
            boolean encontrado = false;
                while (temporal != null && encontrado != true) {
                    if (referencia == temporal.obtenerValor()) {
                        encontrado = true;
                    } else {
                        temporal = temporal.obtenerSiguiente();
                    }
                }
                 return encontrado;
        }
        return false;
    }*/
    /*public int getPosicion(Object obj) {
        if (buscar(obj)) {
            Nodo temporal = head;
            int i = 0;
            System.out.println("El valor buscado esta en el indice: ");
            while (obj != temporal.obtenerValor()){
                i++;
                temporal = temporal.obtenerSiguiente();
            }
            return i;

        } else {
            System.out.println("Valor inexistente en la lista.");

            return (0);
        }
    }
    /*public Object getEliminar(Object obj) {
        if (buscar(obj)) {
            Nodo temporal = head;
            int i = 0;
            System.out.println("El valor buscado esta en el indice: ");
            while (obj != temporal.obtenerValor()){
                i++;
                temporal = temporal.obtenerSiguiente();
            }
            return i;
        } else {
            System.out.println("Valor inexistente en la lista.");
            return (0);
        }
        if (buscar(obj)){
            Nodo temp=head;
            int j=0;
        }
    }
    public void Eliminar2(Object obj){
        if (buscar(head)==buscar(obj)){
            head=head.obtenerSiguiente();
        }else{
            Nodo temporal=head;
            for (int i=0; i<size;i++){
                if (buscar(temporal) == buscar(obj)) {
                    temporal=temporal.obtenerSiguiente();
                }
                temporal.enlazarSiguiente(temporal.obtenerSiguiente().obtenerSiguiente());
            }

        }
        size--;
    }
    public Object eliminar2(int val){
        Nodo temporal=head;
        int i=0;
        while (Integer.parseInt(temporal.obtenerValor().toString())!=val){
            temporal = temporal.obtenerSiguiente();
            i++;
        }
        return System.out.printf("Valor encontrado en la posicion "+i);
    }*/

