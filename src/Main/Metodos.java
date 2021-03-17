package Main;

import Clases.Persona;
import Clases.Vacuna;

import javax.swing.JOptionPane;
import java.util.ArrayList;


/**
 * Esta clase contiene los métodos que constituyen el menú de la aplicación.
 */


public class Metodos {
    ArrayList<Persona> listapersonas = new ArrayList<Persona>();
    ArrayList<Vacuna> listavacunas = new ArrayList<Vacuna>();
    private int edad, num_vac_inyect = 0, vac_quedan;
    private String riesgo;
    private String nombre, apellidos, dni;
    private int opcionmenu;

    /**
     * Método que crea el menu de la aplicacón
     */
    public void menu() {
        try {
            opcionmenu = Integer.parseInt(JOptionPane.showInputDialog("VACUNACIÓN COVID-19 EN ESPAÑA:\n1) Añadir persona.\n2) Añadir vacuna.\n3) Listado de personas.\n4) Buscar persona.\n5) Información vacunas.\n6) Realizar cambios.\n7) Salir."));
            switch (opcionmenu) {
                case 1:
                    añadirpersona();
                    break;
                case 2:
                    añadirvacuna();
                    break;
                case 3:
                    listado();
                    break;
                case 4:
                    buscar();
                    break;
                case 5:
                    informacion();
                    break;
                case 6:
                    editar();
                    break;

            }


        } catch (NumberFormatException ex) {
        }
    }//Cierre del método

    /**
     * Método que añade personas a la lista
     */
    public void añadirpersona() {

        setNombre(JOptionPane.showInputDialog("Nombre: "));
        setApellidos(JOptionPane.showInputDialog("Apellidos: "));
        setDni(JOptionPane.showInputDialog("DNI: "));
        setEdad(Integer.parseInt(JOptionPane.showInputDialog("Edad: ")));
        setRiesgo(JOptionPane.showInputDialog("¿Es persona de riesgo (s/n)?: "));
        Persona obx = new Persona(nombre, apellidos, dni, edad, riesgo);

        int cont=0;

        for(int i=0; i<listapersonas.size(); i++){if(listapersonas.get(i).getDni().equalsIgnoreCase(listapersonas.get(cont+1).getDni())){System.out.println("Hay una persona en la lista con el mismo DNI.");}break;}

        listapersonas.add(obx);


    }//Cierre del método

    /**
     * Método que añade vacunas a la lista
     */
    public void añadirvacuna() {

        Vacuna obx = new Vacuna();
        obx.setNombre(JOptionPane.showInputDialog("Nombre:"));
        obx.setDisponibles(Integer.parseInt(JOptionPane.showInputDialog("Número de dosis disponibles:")));
        obx.setNum_dosis(Integer.parseInt(JOptionPane.showInputDialog("Número de dosis necesarias: ")));

        listavacunas.add(obx);

    }//Cierre del método

    /**
     * Método que visualiza la lista de personas
     */
    public void listado() {

        System.out.println("**** PERSONAS EN LA LISTA ****");
        for (int i = 0; i < listapersonas.size(); i++) {
            System.out.println(listapersonas.get(i).toString());
        }
        if (listapersonas.isEmpty()) {
            System.out.println("No hay personas en la lista.");
        }

    }//Cierre del método

    /**
     * Método que visualiza a una personas determinada
     */
    public void buscar() {if(listapersonas.isEmpty()){System.out.println("**** RESULTADO DE LA BUSQUEDA ****");System.out.println("No hay personas en la lista.");}else{
        int option = Integer.parseInt(JOptionPane.showInputDialog("Elija un criterio de busqueda: \n1) Nombre.\n2) Apellidos.\n3) DNI."));
        switch (option) {
            case 1:
                String nombre = JOptionPane.showInputDialog("Nombre: ");
                System.out.println("**** RESULTADO DE LA BUSQUEDA ****");
                for (int i = 0; i < listapersonas.size(); i++) {
                    if (listapersonas.get(i).getNombre().equalsIgnoreCase(nombre)){

                        System.out.println(listapersonas.get(i).toString());}
                    else{System.out.println("No hay personas en la lista con ese nombre.");}

                }
                break;

            case 2:
                String apellidos = JOptionPane.showInputDialog("Apellidos: ");
                System.out.println("**** RESULTADO DE LA BUSQUEDA ****");

                for (int i = 0; i < listapersonas.size(); i++) {
                    if (listapersonas.get(i).getApellidos().equalsIgnoreCase(apellidos)) {


                        System.out.println(listapersonas.get(i).toString()); }else{System.out.println("No hay personas en la lista con ese apellido.");}
                }
                break;

            case 3:
                String dni = JOptionPane.showInputDialog("DNI: ");
                System.out.println("**** RESULTADO DE LA BUSQUEDA ****");
                for (int i = 0; i < listapersonas.size(); i++) {
                    if (listapersonas.get(i).getDni().equalsIgnoreCase(dni)){

                        System.out.println(listapersonas.get(i).toString());}
                    else{System.out.println("No hay personas en la lista con ese DNI.");}
                }
                break;

        }}
    }//Cierre del método



    public void primerasvacunas(){
        Vacuna obx1 = new Vacuna("Pfizer", 2, 100000, 20000);
        Vacuna obx2 = new Vacuna("Moderna", 2, 100000, 10000);
        Vacuna obx3 = new Vacuna("AstraZeneca/Oxford", 2, 100000, 50000);
        listavacunas.add(obx1);
        listavacunas.add(obx2);
        listavacunas.add(obx3);}

    /**
     * Método que visualiza la lista de vacunas
     */

    public void informacion() {

        System.out.println("**** VACUNAS DISPONIBLES EN ESPAÑA ****");
        for (int i = 0; i < listavacunas.size(); i++) {
            System.out.println(listavacunas.get(i).toString());
        }
        if(listavacunas.isEmpty()){System.out.println("No hay vacunas en la lista.");}

    }//Cierre del método

    /**
     * Método para cambiar los datos acerca de una vacuna o persona.
     */

    public void editar() {
        int option = Integer.parseInt(JOptionPane.showInputDialog("1) Editar personas\n2) Editar vacunas"));
        switch (option) {
            case 1:String option1 = JOptionPane.showInputDialog("Escriba el DNI de la persona que quiere editar:");
                for (int i = 0; i < listapersonas.size(); i++) {
                    if (listapersonas.get(i).getDni().equalsIgnoreCase(option1)){

                        int option2 = Integer.parseInt(JOptionPane.showInputDialog("1) Cambiar nombre.\n2) Cambiar apellidos.\n3) Cambiar DNI.\n4) Cambiar edad.\n5) Cambiar riesgo.\n6) Cambiar número de vacunas inyectadas."));
                        switch(option2){

                            case 1:listapersonas.get(i).setNombre(JOptionPane.showInputDialog("Nuevo nombre:"));
                                System.out.println("**** CAMBIOS REALIZADOS ****");
                                System.out.println(listapersonas.get(i).toString());
                                break;

                            case 2:listapersonas.get(i).setApellidos(JOptionPane.showInputDialog("Nuevos apellidos:"));
                                System.out.println("**** CAMBIOS REALIZADOS ****");
                                System.out.println(listapersonas.get(i).toString());
                                break;
                            case 3:listapersonas.get(i).setDni(JOptionPane.showInputDialog("Nuevo DNI:"));
                                System.out.println("**** CAMBIOS REALIZADOS ****");
                                System.out.println(listapersonas.get(i).toString());
                                break;
                            case 4:listapersonas.get(i).setEdad(Integer.parseInt(JOptionPane.showInputDialog("Nueva edad:")));
                                System.out.println("**** CAMBIOS REALIZADOS ****");
                                System.out.println(listapersonas.get(i).toString());
                                break;
                            case 5:listapersonas.get(i).setRiesgo(JOptionPane.showInputDialog("Nuevo riesgo:"));
                                System.out.println("**** CAMBIOS REALIZADOS ****");
                                System.out.println(listapersonas.get(i).toString());
                                break;
                            case 6:listapersonas.get(i).setNum_vac_inyect(Integer.parseInt(JOptionPane.showInputDialog("Nuevo número de vacunas inyectadas:")));
                                System.out.println("**** CAMBIOS REALIZADOS ****");
                                System.out.println(listapersonas.get(i).toString());
                                break;
                        }
                    }
                    else{System.out.println("No hay personas en la lista con ese DNI.");break;}
                }break;


            case 2:String option3 = JOptionPane.showInputDialog("Escriba el nombre de la vacuna que quiere editar:");
                for (int i = 0; i < listavacunas.size(); i++) {
                    if (listavacunas.get(i).getNombre().equalsIgnoreCase(option3)){

                        int option2 = Integer.parseInt(JOptionPane.showInputDialog("1) Cambiar nombre.\n2) Cambiar número de dosis disponibles.\n3) Cambiar número de dosis necesarias."));
                        switch(option2){

                            case 1:listavacunas.get(i).setNombre(JOptionPane.showInputDialog("Nuevo nombre:"));
                                System.out.println("**** CAMBIOS REALIZADOS ****");
                                System.out.println(listavacunas.get(i).toString());
                                break;

                            case 2:listavacunas.get(i).setDisponibles(Integer.parseInt(JOptionPane.showInputDialog("Nuevo número de dosis disponibles:")));
                                System.out.println("**** CAMBIOS REALIZADOS ****");
                                System.out.println(listavacunas.get(i).toString());
                                break;
                            case 3:listavacunas.get(i).setNum_dosis(Integer.parseInt(JOptionPane.showInputDialog("Nuevo número de dosis necesarias:")));
                                System.out.println("**** CAMBIOS REALIZADOS ****");
                                System.out.println(listavacunas.get(i).toString());
                                break;

                        }

                    }
                    else{System.out.println("No hay vacunas en la lista con ese nombre.");break;}
                }





                ; break;


        }


    }//Cierre del método


    public int getOpcionmenu() {
        return opcionmenu;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNum_vac_inyect(int num_vac_inyect) {
        this.num_vac_inyect = num_vac_inyect;
    }

    public void setVac_quedan(int vac_quedan) {
        this.vac_quedan = vac_quedan;
    }

    public void setRiesgo(String riesgo) {
        this.riesgo = riesgo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

}
//Cierre de la clase