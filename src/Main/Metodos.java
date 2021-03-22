package Main;

import metodos.metodos_print;
import Clases.Persona;
import Clases.Vacuna;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Esta clase contiene los métodos que constituyen el menú de la aplicación.
 *
 * @author Manuel Places Alvarez
 */


public class Metodos {

    Scanner sc;

    {

    }

    File listper = new File("Listado personas.txt");
    FileWriter wrtp;

    {
        try {
            wrtp = new FileWriter(listper, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    File listvac = new File("Listado vacunas.txt");
    FileWriter wrtv;

    {
        try {
            wrtv = new FileWriter(listvac, true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    metodos_print metobx = new metodos_print();
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
            opcionmenu = Integer.parseInt(JOptionPane.showInputDialog(metobx.mensaje()));

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
        setRiesgo(JOptionPane.showInputDialog("¿Es persona de riesgo (Si/No)?: "));
        int numero = (int) (Math.random() * listavacunas.size());
        String nombre_vac="" ;

        /**try {
            nombre_vac = listavacunas.get(numero).getNombre();
        } catch (IndexOutOfBoundsException ex) {
        }*/
        if (listvac.length()==0){nombre_vac = "No hay vacunas";}





        Persona obx = new Persona(nombre, apellidos, dni, edad, riesgo, nombre_vac);

        listapersonas.add(obx);
        try {
            wrtp.write("\n" + obx.toString());
            wrtp.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        try {
            wrtv.write(obx.toString());
            wrtv.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }//Cierre del método

    /**
     * Método que visualiza la lista de personas
     */
    public void listado() {

        System.out.println("**** PERSONAS EN LA LISTA ****");
        /**  for (int i = 0; i < listapersonas.size(); i++) {
         System.out.println(listapersonas.get(i).toString());
         */
        try {
            sc = new Scanner(new File("Listado personas.txt"));

            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                System.out.println(s);
            }
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (listper.length() == 0) {
            System.out.println("No hay personas en la lista.");
        }


    }
    /**  if (listapersonas.isEmpty()) {
     metobx.mensaje2();
     }

     }//Cierre del método*/

    /**
     * Método que visualiza a una personas determinada
     */
    public void buscar() {
        if (listapersonas.isEmpty()) {
            metobx.mensaje3();
            metobx.mensaje2();
        } else {
            int option = Integer.parseInt(JOptionPane.showInputDialog("Elija un criterio de busqueda: \n1) Nombre.\n2) Apellidos.\n3) DNI."));
            switch (option) {
                case 1:
                    String nombre = JOptionPane.showInputDialog("Nombre: ");
                    metobx.mensaje3();
                    for (int i = 0; i < listapersonas.size(); i++) {
                        if (listapersonas.get(i).getNombre().equalsIgnoreCase(nombre)) {

                            System.out.println(listapersonas.get(i).toString());
                        } else {
                            metobx.mensaje4();
                        }

                    }
                    break;

                case 2:
                    String apellidos = JOptionPane.showInputDialog("Apellidos: ");
                    metobx.mensaje3();

                    for (int i = 0; i < listapersonas.size(); i++) {
                        if (listapersonas.get(i).getApellidos().equalsIgnoreCase(apellidos)) {


                            System.out.println(listapersonas.get(i).toString());
                        } else {
                            metobx.mensaje5();
                        }
                    }
                    break;

                case 3:
                    String dni = JOptionPane.showInputDialog("DNI: ");
                    metobx.mensaje3();
                    for (int i = 0; i < listapersonas.size(); i++) {
                        if (listapersonas.get(i).getDni().equalsIgnoreCase(dni)) {

                            System.out.println(listapersonas.get(i).toString());
                        } else {
                            metobx.mensaje6();
                        }
                    }
                    break;

            }
        }
    }//Cierre del método


    public void primerasvacunas() {
        Vacuna obx1 = new Vacuna("Pfizer", 2, 100000, 20000);
        Vacuna obx2 = new Vacuna("Moderna", 2, 100000, 10000);
        Vacuna obx3 = new Vacuna("AstraZeneca/Oxford", 2, 100000, 50000);
        listavacunas.add(obx1);
        listavacunas.add(obx2);
        listavacunas.add(obx3);

        try {
            wrtv.write(obx1.toString() + "\n");
            wrtv.write(obx2.toString() + "\n");
            wrtv.write(obx3.toString() + "\n");
            wrtv.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * Método que visualiza la lista de vacunas
     */

    public void informacion() {

        System.out.println("**** VACUNAS DISPONIBLES EN ESPAÑA ****");
        /**for (int i = 0; i < listavacunas.size(); i++) {
         System.out.println(listavacunas.get(i).toString());
         }*/


        try {
            sc = new Scanner(new File("Listado vacunas.txt"));

            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                System.out.println(s);


            }
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (listvac.length() == 0) {
            System.out.println("No hay vacunas en la lista.");
        }

        //if(listavacunas.isEmpty()){System.out.println("No hay vacunas en la lista.");}

    }//Cierre del método

    /**
     * Método para cambiar los datos acerca de una vacuna o persona.
     */

    public void editar() {
        int option = Integer.parseInt(JOptionPane.showInputDialog("1) Editar personas\n2) Editar vacunas"));
        switch (option) {
            case 1:
                String option1 = JOptionPane.showInputDialog("Escriba el DNI de la persona que quiere editar:");
                for (int i = 0; i < listapersonas.size(); i++) {
                    if (listapersonas.get(i).getDni().equalsIgnoreCase(option1)) {

                        int option2 = Integer.parseInt(JOptionPane.showInputDialog("1) Cambiar nombre.\n2) Cambiar apellidos.\n3) Cambiar DNI.\n4) Cambiar edad.\n5) Cambiar riesgo.\n6) Cambiar número de vacunas inyectadas."));
                        switch (option2) {

                            case 1:
                                listapersonas.get(i).setNombre(JOptionPane.showInputDialog("Nuevo nombre:"));
                                metobx.mensaje1();
                                System.out.println(listapersonas.get(i).toString());
                                break;

                            case 2:
                                listapersonas.get(i).setApellidos(JOptionPane.showInputDialog("Nuevos apellidos:"));
                                metobx.mensaje1();
                                System.out.println(listapersonas.get(i).toString());
                                break;
                            case 3:
                                listapersonas.get(i).setDni(JOptionPane.showInputDialog("Nuevo DNI:"));
                                metobx.mensaje1();
                                System.out.println(listapersonas.get(i).toString());
                                break;
                            case 4:
                                listapersonas.get(i).setEdad(Integer.parseInt(JOptionPane.showInputDialog("Nueva edad:")));
                                metobx.mensaje1();
                                System.out.println(listapersonas.get(i).toString());
                                break;
                            case 5:
                                listapersonas.get(i).setRiesgo(JOptionPane.showInputDialog("Nuevo riesgo:"));
                                metobx.mensaje1();
                                System.out.println(listapersonas.get(i).toString());
                                break;
                            case 6:
                                listapersonas.get(i).setNum_vac_inyect(Integer.parseInt(JOptionPane.showInputDialog("Nuevo número de vacunas inyectadas:")));
                                metobx.mensaje1();
                                System.out.println(listapersonas.get(i).toString());
                                break;
                        }
                    } else {
                        metobx.mensaje6();
                        break;
                    }
                }
                break;


            case 2:
                String option3 = JOptionPane.showInputDialog("Escriba el nombre de la vacuna que quiere editar:");
                for (int i = 0; i < listavacunas.size(); i++) {
                    if (listavacunas.get(i).getNombre().equalsIgnoreCase(option3)) {

                        int option2 = Integer.parseInt(JOptionPane.showInputDialog("1) Cambiar nombre.\n2) Cambiar número de dosis disponibles.\n3) Cambiar número de dosis necesarias."));
                        switch (option2) {

                            case 1:
                                listavacunas.get(i).setNombre(JOptionPane.showInputDialog("Nuevo nombre:"));
                                metobx.mensaje1();
                                System.out.println(listavacunas.get(i).toString());
                                break;

                            case 2:
                                listavacunas.get(i).setDisponibles(Integer.parseInt(JOptionPane.showInputDialog("Nuevo número de dosis disponibles:")));
                                metobx.mensaje1();
                                System.out.println(listavacunas.get(i).toString());
                                break;
                            case 3:
                                listavacunas.get(i).setNum_dosis(Integer.parseInt(JOptionPane.showInputDialog("Nuevo número de dosis necesarias:")));
                                metobx.mensaje1();
                                System.out.println(listavacunas.get(i).toString());
                                break;

                        }

                    } else {
                        System.out.println("No hay vacunas en la lista con ese nombre.");
                        break;
                    }
                }


                ;
                break;


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