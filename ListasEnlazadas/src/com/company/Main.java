package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
     /*Se crea un nuevo objeto llamado lista de la clase ListaSimple
     el cual ayudara cuando sea nesesario mandar a llamar los métodos
     declarados en la misma clase*/
        ListaSimple lista = new ListaSimple();
     //Se crea un nuevo objeto de la clase Scanner.
        Scanner sc=new Scanner(System.in);
     //Declaración de variable boolean inicializada en true.
        boolean seguir=true;
/*Ciclo mientras seguir continue como true hacer...*/
        while(seguir) {
/*Se manda a traer el método menú que mostrara todas las funciones que se podran realizar con la lista*/
            lista.Menu();
/*Declaración de la variable que almacenara lo que el usuario ingrese y/o elija*/
            String op = sc.next();
/*Declaración de la condición de selección switch la cual recibe la opción seleccionada por el
* usuario.*/
            switch (op) {
/*en caso de que ingrese alguna de las opciones de la siguiente manera realizara las siguientes funciones segun sea la opción
* que se elija se mandara a traer el método que le corresponda declarados en la clase ListaSimple*/
                case "1":
                case "Insertar":
                case "insertar":
                    System.out.println("Usted eligio la opción Insertar\n¿Cuantos valores desea insertar?");
//Se almacena lo que el usuario ingresa en la variable num.
                    int num = sc.nextInt();
//Ciclo que repetira la peticón de valores segun los que el usuario pidio ingresar.
                    for (int i=0; i<num; i++){
                        System.out.println("Valor "+(i+1)+": ");
                 //Variable que almacenara los valores solicitados.
                        Object valor=sc.next();
                        //Se manda a llamar al método correspondiente a la selección del usuario
/*Se le pasan como parametros los valores ingresados al método agregarInicio.  */
                        lista.agregarInicio(valor);
                    }
                    break;
                case "2":
                case "Mostrar":
                case "mostrar":
                    System.out.println("Usted eligio la opción Mostrar\n");
                    if (lista.size() == 0) {
                        System.out.println("La lista esta vacia, no contiene ningun elemento");
                    } else {
                        //Se manda a llamar al método correspondiente a la selección del usuario
                        lista.Mostrar();
                    }
                    break;
                case "3":
                case "Buscar":
                case "buscar":
                    System.out.println("Usted eligio la opción Buscar\n");
                    //Si la lista no contiene elementos.
                    if (lista.size() == 0) {
                        //Se imprimira un mensaje que le informra al usuario lo ya mensionado.
                        System.out.println("La lista esta vacia, no contiene ningun elemento");
                    }else {
                        System.out.println("Desea buscar por 1.Valor 2.Posición");
                        Object elecion = sc.next();

                        if (elecion.equals("valor") || elecion.equals("1")) {
                            System.out.println("Ingrese un valor: ");
                            Object Buscarval = sc.next();
                            //Se manda a llamar al método correspondiente a la selección del usuario
                            lista.BuscarValor(Buscarval);
                            lista.Mostrar();
                        } else if (elecion.equals("posicion") || elecion.equals("2")) {
                            System.out.println("Ingrese la posición a buscar: ");
                            int BuscarPos = sc.nextInt();
                            //Se manda a llamar al método correspondiente a la selección del usuario
                            lista.BuscarPos(BuscarPos);
                            lista.Mostrar();
                        }
                    }
                    break;
                case "4":
                case "Eliminar":
                case "eliminar":
                    System.out.println("Usted eligio la opción Eliminar\n");
                    if (lista.size() == 0) {
                        //Se imprimira un mensaje que le informra al usuario lo ya mensionado.
                        System.out.println("La lista esta vacia, no contiene ningun elemento");
                    }else {
                        System.out.println("Desea eliminar por \n1.Valor\n2.Posición");
                        Object elecionEli = sc.next();
                        if (elecionEli.equals("valor") || elecionEli.equals("1")) {
                            lista.Mostrar();
                            System.out.println("Ingrese un valor: ");
                            Object Elival = sc.next();
                            //Se manda a llamar al método correspondiente a la selección del usuario
                            lista.EliminarValor(Elival);
                            lista.Mostrar();
                        } else if (elecionEli.equals("posicion") || elecionEli.equals("2")) {
                            lista.Mostrar();
                            System.out.println("Ingrese la posición a eliminar: ");
                            int EliPos = sc.nextInt();
                            //Se manda a llamar al método correspondiente a la selección del usuario
                            lista.EliminarPos(EliPos);
                            lista.Mostrar();
                        }
                    }
                    break;
                case "5":
                case "Contar":
                case "contar":
                    System.out.println("Usted eligio la opción Contar\n");
                    if (lista.size()==0){
                        System.out.println("La lista se encuentra vacia no contiene elementos");
                    }else{
                        System.out.println("La lista contiene "+lista.size()+" elementos");
                    }
                    break;
                case "6":
                case "Terminar":
                case "terminar":
                    System.out.println("Usted eligio la opción Terminar\n\nAdios ...! vuelva pronto XD");
                    //Si se elije la opción terminar el ciclo parara, esto lo logramos poniendo la variable seguir como false.
                    seguir=false;
            }
        }
    }
}
