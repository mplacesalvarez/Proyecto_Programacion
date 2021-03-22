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

    File listper = new File("Listado personas.txt");


    File listvac = new File("Listado vacunas.txt");


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
        int cont=0;


        setNombre(JOptionPane.showInputDialog("Nombre: "));
        setApellidos(JOptionPane.showInputDialog("Apellidos: "));
        setDni(JOptionPane.showInputDialog("DNI: "));
        String[] palabra;
        try {


            sc = new Scanner(new File("Listado personas.txt"));
try{
            while(sc.hasNextLine()){
                String s= sc.nextLine();
                palabra= s.split(" ");
                for(int i=0; i< palabra.length;i++){if(palabra[i].equalsIgnoreCase(dni)){
                   cont++;
                }}

        }

    }catch(ArrayIndexOutOfBoundsException ex){}


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

if(cont!=0){System.out.println("Ya hay una persona en la lista con ese DNI.");return;}

            setEdad(Integer.parseInt(JOptionPane.showInputDialog("Edad: ")));
        setRiesgo(JOptionPane.showInputDialog("¿Es persona de riesgo (Si/No)?: "));






        String nombre_vac= " ";



       if (listvac.length()==0){nombre_vac = "No hay vacunas";}else{

            try {

                String[] palabras;
                sc = new Scanner(new File("Listado vacunas.txt"));
                ArrayList <String> nombre_vacunas=new ArrayList<String>();

                while(sc.hasNextLine()){
                    String s= sc.nextLine();
                    palabras= s.split(" ");

                    try {

                      nombre_vacunas.add(palabras[1]);

                    } catch (IndexOutOfBoundsException ex) {
                    }


                }
                int numero = (int) (Math.random() * nombre_vacunas.size());

                 try {
                 nombre_vac = nombre_vacunas.get(numero);
                 } catch (IndexOutOfBoundsException ex) {
                 }




            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }




        }





        Persona obx = new Persona(nombre, apellidos, dni, edad, riesgo, nombre_vac);

        listapersonas.add(obx);
        FileWriter wrtp = null;

        {
            try {
                wrtp = new FileWriter(listper, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {

            wrtp.write("\n" + obx.toString());
            wrtp.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n");}//Cierre del método

    /**
     * Método que añade vacunas a la lista
     */
    public void añadirvacuna() {

        Vacuna obx = new Vacuna();
        obx.setNombre(JOptionPane.showInputDialog("Nombre:"));
        obx.setDisponibles(Integer.parseInt(JOptionPane.showInputDialog("Número de dosis disponibles:")));
        obx.setNum_dosis(Integer.parseInt(JOptionPane.showInputDialog("Número de dosis necesarias: ")));

        listavacunas.add(obx);
        FileWriter wrtv=null;

        {
            try {
                wrtv = new FileWriter(listvac, true);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            wrtv.write(obx.toString());
            wrtv.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n");}//Cierre del método

    /**
     * Método que visualiza la lista de personas
     */
    public void listado() {

        System.out.println("**** PERSONAS EN LA LISTA ****");

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

        System.out.println("\n");
    }

    public void buscar() {
        if (listper.length()==0) {
            metobx.mensaje3();
            metobx.mensaje2();
        } else {
            int option = Integer.parseInt(JOptionPane.showInputDialog("Elija un criterio de busqueda: \n1) Nombre.\n2) Apellidos.\n3) DNI."));
            switch (option) {
                case 1:
                   String nombre = JOptionPane.showInputDialog("Nombre: ");
                   metobx.mensaje3();

                    
                    try {
                        sc = new Scanner(new File("Listado personas.txt"));
                        String[] palabras;

                        int cont=0;
                        while (sc.hasNextLine()) {
                            String s = sc.nextLine();

                            palabras = s.split(" ");

                            for(int i=0; i<palabras.length; i++){
                                if(nombre.equalsIgnoreCase(palabras[i])){for(i=0; i<palabras.length; i++){System.out.print(palabras[i]+" ");cont++;}
                                    System.out.println("\n");
                            }

                        }

                        }if(cont==0){metobx.mensaje4();}

                        sc.close();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }


                    break;

                case 2:
                    String apellidos = JOptionPane.showInputDialog("Apellidos: ");

                    metobx.mensaje3();

                    try {
                        sc = new Scanner(new File("Listado personas.txt"));
                        String[] palabras;
                        int cont=0;
                        while (sc.hasNextLine()) {
                            String s = sc.nextLine();

                            palabras = s.split(" ");

                            for(int i=0; i<palabras.length; i++){
                                if(apellidos.equalsIgnoreCase(palabras[i])){for(i=0; i<palabras.length; i++){System.out.print(palabras[i]+" ");cont++;}
                                    System.out.println("\n");
                                }




                            }



                        }if(cont==0){metobx.mensaje5();}


                        sc.close();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }


                    break;



                case 3:
                    String dni = JOptionPane.showInputDialog("DNI: ");

                    metobx.mensaje3();






                    try {
                        sc = new Scanner(new File("Listado personas.txt"));
                        String[] palabras;
                        int cont=0;
                        while (sc.hasNextLine()) {
                            String s = sc.nextLine();

                            palabras = s.split(" ");

                            for(int i=0; i<palabras.length; i++){
                                if(dni.equalsIgnoreCase(palabras[i])){for(i=0; i<palabras.length; i++){System.out.print(palabras[i]+" ");cont++;}
                                    System.out.println("\n");
                                }




                            }

                        }if(cont==0){metobx.mensaje6();}


                        sc.close();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }


                    break;

            }
        }
    }//Cierre del método





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

        System.out.println("\n");
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