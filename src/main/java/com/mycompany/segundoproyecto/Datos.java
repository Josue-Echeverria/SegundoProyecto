
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.segundoproyecto;

import com.mycompany.segundoproyecto.funciones.Defensa;
import com.mycompany.segundoproyecto.funciones.Modelo;
import com.mycompany.segundoproyecto.funciones.Personaje;

import com.mycompany.segundoproyecto.funciones.Zombie;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
    static public Personaje[][] matrizPersonajes;
    static public JButton[] matrizBotonesApareceZombies;
    static public ArrayList<Personaje> personajes;
    static public ArrayList<Defensa> defensas;
    static public ArrayList<Defensa> defensasDisponibles;
    static public ArrayList<Zombie> zombies;
    static public EstadoHaciendoMouse accionMouse;
    static public String personajeCargando;
    static public String ruta = "C:\\Users\\Jecheverria\\Personajes\\";//Modificar 
    static public Defensa Pilar;
    static public int[] coordsPilar;
    public Datos() {
        accionMouse = EstadoHaciendoMouse.NADA;
        personajeCargando = null;
        matrizBotonesInterfaz = new JButton[27][27];
        matrizPersonajes = new Personaje[27][27];
        matrizBotonesApareceZombies = new JButton[104];
        defensasDisponibles = new ArrayList<>();
       
        
        
        
        //***************
        
        
        
        try {
            personajes =  new Modelo().read_personajes();
            zombies =  new Modelo().read_Zombies();
            defensas =  new Modelo().read_Defensas();
        } catch (IOException ex) {
           
           System.out.println("Error");
         Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void ponePilar(int j,int i){
         //***********************
        ArrayList<ImageIcon> images = new ArrayList();
        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(new File(ruta+"Defensa6.png"));
            Image image = bufferedImage.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
            images.add(new ImageIcon(image));
            Pilar= new Defensa("Pilar",1,0,1,0,images,Personaje.tipoPilar);
            coordsPilar = new int[2];
            coordsPilar[0] = j;
            coordsPilar[1] = i;
            matrizBotonesInterfaz[coordsPilar[1]][coordsPilar[0]].setIcon(Pilar.getApariencia().get(0));
            matrizPersonajes[coordsPilar[1]][coordsPilar[0]] = Pilar;
            
        } catch (IOException ex) {
            System.out.println("no cargo la imagen del pilar");
        }
        
    }
    
    
}
