
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.segundoproyecto;

import com.mycompany.segundoproyecto.funciones.Defensa;
import com.mycompany.segundoproyecto.funciones.Modelo;
import com.mycompany.segundoproyecto.funciones.Personaje;
import com.mycompany.segundoproyecto.funciones.Zombie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author deyla
 */

public class Datos {
    static public enum EstadoHaciendoMouse{
    CARGANDOPERSONAJE,
    NADA;
    }
    static public JButton[][] matrizBotonesInterfaz;
    static public JButton[] matrizBotonesApareceZombies;
    static public ArrayList<Personaje> personajes;
    static public ArrayList<Defensa> defensas;
    static public ArrayList<Zombie> zombies;
    static public EstadoHaciendoMouse accionMouse;
    static public String personajeCargando;
    static public String ruta = "C:\\Users\\PC\\Documents\\ImagenesSegundoProyecto\\";
    public Datos() {
        accionMouse = EstadoHaciendoMouse.NADA;
        personajeCargando = null;
        matrizBotonesInterfaz = new JButton[27][27];
        matrizBotonesApareceZombies = new JButton[104];
        try {
            personajes =  new Modelo().read_personajes();
            defensas =  new Modelo().read_Defensas();
            zombies =  new Modelo().read_Zombies();
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }
    
    
}
