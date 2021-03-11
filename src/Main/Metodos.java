package Main;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Metodos {
ArrayList<Persona> listapersonas=new ArrayList <Persona>();

    private int edad, num_vac_inyect=0, vac_quedan;
    private char riesgo;
    private String nombre, apellidos, dni;
    public void menu(){
        int opcion;
        do{
            opcion= Integer.parseInt(JOptionPane.showInputDialog("MENU:\n1) Añadir persona.\n2) Buscar persona.\n3) Vacunas disponibles.\n4) Información vacunas.\n5) Salir."));
            switch(opcion){
                case 1:engadir(); break;
                case 2: buscar(); break;
                case 3: amosar_vacunas(); break;
               case 4: informacion(); break;
               case 5: salir(); break;


            }}
        while(opcion!=6);

    }

    public void engadir(){
 Persona obx=new Persona(nombre,apellidos,dni,edad,riesgo);



    }



obx.setNombre(JOptionPane.showInputDialog("Introduzca el nombre: ")),obx.setApellidos(JOptionPane.showInputDialog("Introduzca los apellidos: ")),obx.setDni(JOptionPane.showInputDialog("Introduzca el DNI: ")),obx.setEdad(Integer.parseInt(JOptionPane.showInputDialog("Introduzca la edad: "))),obx.setRiesgo(JOptionPane.showInputDialog("¿Es persona de riesgo (s/n)?: "))
}
