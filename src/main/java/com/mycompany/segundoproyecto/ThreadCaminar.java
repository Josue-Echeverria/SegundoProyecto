
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.segundoproyecto;

import com.mycompany.segundoproyecto.funciones.Personaje;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author deyla
 */
    enum Cordenada{
    x,
    y;
}
public class ThreadCaminar extends Thread {
    private boolean isRunning = true;
    private boolean isPaused = false;
    ImageIcon imagen;

    String imagen2;
    public Personaje personaje;
    int iinicio;
    int jinicio;
    int ifinal;
    int jfinal;
    private Cordenada quienResta;
    private Boolean borde = true;
    public int coordsanterior[];
    


    public ThreadCaminar(Personaje personaje, int iinicio, int jinicio, int ifinal, int jfinal) {
        this.imagen = personaje.getApariencia().get(0);
        this.iinicio = iinicio;
        this.jinicio = jinicio;
        this.ifinal = ifinal;
        this.jfinal = jfinal;
        quienResta = Cordenada.x;
        this.personaje = personaje;
        
        Datos.matrizBotonesInterfaz[jfinal][ifinal].setIcon(new javax.swing.ImageIcon(Datos.ruta+"Japón.png"));
        
        
        
    }
    
    
    
    @Override
    public void run(){
        while (isRunning){
            try {
                // Definir nuevas dimensiones
                
                
                coordsanterior = new int[]{jinicio,iinicio};
                Icon icono = Datos.matrizBotonesInterfaz[jinicio][iinicio].getIcon();
                Datos.matrizBotonesInterfaz[jinicio][iinicio].setIcon(imagen);
                String coordInicio = ""+ iinicio+"-"+jinicio;
                sleep(1000);
                if (iinicio == ifinal && jinicio == jfinal){
                    System.out.println("********");
                    System.out.println(coordInicio);
                    finish();
                }else if(quienResta == Cordenada.x){
                    if(jinicio == jfinal ){
                        quienResta = Cordenada.y;
                        continue;
                    }else{
                        if(jinicio > jfinal ){
                            jinicio -= 1;
                        }else{
                            jinicio += 1;
                        }
                    }
                    quienResta = Cordenada.y;
                }else{
                    if(iinicio == ifinal){
                        quienResta = Cordenada.x;
                        continue;
                    }if(iinicio > ifinal ){
                            iinicio -= 1;
                        }else{
                            iinicio += 1;
                    }
                    quienResta = Cordenada.x;
                          
                }
                
                
                
                try {
                    if (Datos.matrizBotonesInterfaz[jinicio][iinicio].getIcon().toString().equals(null) ){
                        System.out.println("Es la base");
                    }else{
                        System.out.println("no es la base");
                        pausa();
                        /*System.out.println(Datos.matrizBotonesInterfaz[jinicio][iinicio].getIcon().toString());
                        System.out.println(Datos.ruta+"Base.png");*/
                    }
                } catch (Exception e) {
                   
                }
                
                
                
                
            } catch (InterruptedException ex) {
            }
            
            while (isPaused) {                
                try {
                    sleep(500);
                    System.out.println("Atacando");
                    Datos.matrizPersonajes[jinicio][iinicio].setVida(Datos.matrizPersonajes[jinicio][iinicio].getVida()-Datos.matrizPersonajes[jinicio][iinicio].getDañoPorSegundo());
                    if(Datos.matrizPersonajes[jinicio][iinicio].getVida() <= 0){
                        pausa();
                    }
                } catch (InterruptedException ex) {
                }
            }
               Datos.matrizBotonesInterfaz[coordsanterior[0]][coordsanterior[1]].setIcon(null);
               Datos.matrizPersonajes[coordsanterior[0]][coordsanterior[1]] = (null);
                //String hola = Datos.matrizBotonesInterfaz[jinicio][iinicio].getIcon();
                /*if(borde){
                    int contador = 0;
                    for (JButton bt : Datos.matrizBotonesApareceZombies) {
                        contador += 1;
                        
                        if (Datos.matrizBotonesInterfaz[coordsanterior[0]][coordsanterior[1]].equals(bt)){
                            Datos.matrizBotonesInterfaz[coordsanterior[0]][coordsanterior[1]].setIcon(new javax.swing.ImageIcon(Datos.ruta+"BaseBloqueada.png"));
                            break;
                        }
                        if(contador == 53){
                            borde = false;
                        }
                    }
                }*/
            Datos.matrizBotonesInterfaz[jinicio][iinicio].setIcon(new javax.swing.ImageIcon(Datos.ruta+imagen));
            Datos.matrizPersonajes[jinicio][iinicio] = personaje;
            
        }
        
    }
    public boolean pausa(){
        this.isPaused = !this.isPaused;
        return this.isPaused;
    }
    
    public void finish(){
        this.isRunning = false;
        this.isPaused = false;
    }
    
}

