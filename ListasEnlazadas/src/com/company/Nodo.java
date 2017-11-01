package com.company;

/**
 * Created by Susan on 23/10/2017.
 */
public class Nodo {
 //Declaración de variables.
   private Object valor;//Tipo object para poder obtener cualquier elemento.
   private Nodo next;
    /*Constructor en el cual se inicializan o
    asigna un valor*/
    public  Nodo(Object valor){
      //Se leasigna el nuevo valor que se ingrese.
        this.valor=valor;
     //Se iniciliza en null o vacia la varable.
        this.next=null;
    }
    /*Método que servira para obtener y/o mostar el valor
    que el nodo almacenara*/
    public Object obtenerValor(){
        return valor;
    }
    /*Método para apuntar y/o enlazar con el siguiente nodo*/
    public void enlazarSiguiente(Nodo nod){
        next=nod;
    }
    /*Método que obtendra elemento del siguiente nodo*/
    public Nodo obtenerSiguiente(){
        //Regresa el valor siguiente
        return next;
    }
}
