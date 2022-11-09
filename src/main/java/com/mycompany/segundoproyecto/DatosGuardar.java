/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.segundoproyecto;

import static com.mycompany.segundoproyecto.Datos.ThreadVoladores;
import static com.mycompany.segundoproyecto.Datos.ThreadZombies;
import static com.mycompany.segundoproyecto.Datos.ZombiesEnJuego;
import static com.mycompany.segundoproyecto.Datos.accionMouse;
import static com.mycompany.segundoproyecto.Datos.botonesdefensasDisponibles;
import static com.mycompany.segundoproyecto.Datos.campos;
import static com.mycompany.segundoproyecto.Datos.defensas;
import static com.mycompany.segundoproyecto.Datos.defensasDisponibles;
import static com.mycompany.segundoproyecto.Datos.defensasEnJuego;
import static com.mycompany.segundoproyecto.Datos.jugando;
import static com.mycompany.segundoproyecto.Datos.matrizBotonesApareceZombies;
import static com.mycompany.segundoproyecto.Datos.matrizBotonesInterfaz;
import static com.mycompany.segundoproyecto.Datos.matrizPersonajes;
import static com.mycompany.segundoproyecto.Datos.maximo;
import static com.mycompany.segundoproyecto.Datos.nivel;
import static com.mycompany.segundoproyecto.Datos.personajeCargando;
import static com.mycompany.segundoproyecto.Datos.personajes;
import static com.mycompany.segundoproyecto.Datos.zombies;
import com.mycompany.segundoproyecto.funciones.Defensa;
import com.mycompany.segundoproyecto.funciones.Modelo;
import com.mycompany.segundoproyecto.funciones.Personaje;
import com.mycompany.segundoproyecto.funciones.Zombie;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author PC
 */
public class DatosGuardar implements Serializable{
    static public enum EstadoHaciendoMouse{
    CARGANDOPERSONAJE,
    MOVIENDOPILAR,
    NADA;
    }
    
    public JButton[][] matrizBotonesInterfaz;
    public Personaje[][] matrizPersonajes;
    public JButton[] matrizBotonesApareceZombies;
    public ArrayList<Personaje> personajes;
    public ArrayList<Defensa> defensas;
    public ArrayList<Defensa> defensasDisponibles;
    public ArrayList<Defensa> defensasEnJuego;
    public ArrayList<Zombie> ZombiesEnJuego;
    public boolean jugando;
    public ArrayList<ThreadCaminar> ThreadZombies;
    public ArrayList<ThreadVolar> ThreadVoladores;
    public ArrayList<JButton> botonesdefensasDisponibles;
    
    public javax.swing.JLabel labelResultado;
    public javax.swing.JLabel label_campos_disponibles;
    public ArrayList<Zombie> zombies;
    public EstadoHaciendoMouse accionMouse;
    public String personajeCargando;
    public int maximo;
    //public String ruta = "C:\\Users\\Jecheverria\\Personajes\\";//Modificar 
    //public String Muerto = "C:\\Users\\Jecheverria\\Personajes\\DeadZombie.PNG";//Modificar 
    public String ruta = "C:\\Users\\PC\\Pictures\\Personajes\\";//Modificar 
    public String Muerto = "C:\\Users\\PC\\Pictures\\Personajes\\DeadZombie.PNG";//Modificar 


    public Defensa Pilar;
    public int[] coordsPilar;
    public int campos;
    public int nivel;

    public DatosGuardar() {
        accionMouse = EstadoHaciendoMouse.NADA;
        personajeCargando = null;
        nivel = 1;
        jugando = false;
        campos = 0;
        matrizBotonesInterfaz = new JButton[27][27];
        matrizPersonajes = new Personaje[27][27];
        matrizBotonesApareceZombies = new JButton[104];
        defensasDisponibles = new ArrayList<>();
        botonesdefensasDisponibles = new ArrayList<>();
        defensasEnJuego = new ArrayList<>();
        ZombiesEnJuego = new ArrayList<>();
        ThreadZombies = new ArrayList<>(); 
        ThreadVoladores = new ArrayList<>(); 
        maximo = 20;
        try {
            personajes =  new Modelo().read_personajes();
            zombies =  new Modelo().read_Zombies();
            defensas =  new Modelo().read_Defensas();
        } catch (IOException ex) {
           
           System.out.println("Error");
         Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public DatosGuardar(int cont){
        this.matrizBotonesInterfaz = Datos.matrizBotonesInterfaz;
        this.matrizPersonajes = Datos.matrizPersonajes ;
        this.matrizBotonesApareceZombies = Datos.matrizBotonesApareceZombies ;
        this.personajes = Datos.personajes ;
        this.defensas = Datos.defensas ;
        this.defensasDisponibles = Datos.defensasDisponibles ;
        this.defensasEnJuego = Datos.defensasEnJuego ;
        this.ZombiesEnJuego = Datos.ZombiesEnJuego ;
        this.jugando = Datos.jugando ;
        this.ThreadZombies = Datos.ThreadZombies ;
        this.ThreadVoladores = Datos.ThreadVoladores ;
        this.botonesdefensasDisponibles = Datos.botonesdefensasDisponibles ;
        this.labelResultado = Datos.labelResultado ;
        this.label_campos_disponibles = Datos.label_campos_disponibles ;
        this.zombies = Datos.zombies ;
        
        this.personajeCargando = Datos.personajeCargando ;
        this.maximo = Datos.maximo ;
        
        this.ruta = Datos.ruta ;
        this.Muerto = Datos.Muerto ;
        this.Pilar = Datos.Pilar ;
        this.coordsPilar = Datos.coordsPilar ;
        this.campos = Datos.campos ;
        this.nivel = Datos.nivel ;
        
    }
    
}
