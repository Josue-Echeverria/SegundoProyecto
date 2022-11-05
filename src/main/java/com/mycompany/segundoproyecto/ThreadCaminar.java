
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.segundoproyecto;

import com.mycompany.segundoproyecto.funciones.Modelo;
import com.mycompany.segundoproyecto.funciones.Personaje;
import com.mycompany.segundoproyecto.funciones.Zombie;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
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
    
    


    public ThreadCaminar(Personaje personaje, int iinicio, int jinicio) {
        this.imagen = personaje.getApariencia().get(0);
        
        this.iinicio = iinicio;
        this.jinicio = jinicio;
        quienResta = Cordenada.x;
        this.personaje = personaje;
        int[] pos1 = {iinicio,jinicio};
        personaje.setPosicion(pos1);
        
        //PRUEBAS(BORRARME DEL ARCHIVO)
        

        //FIN DE LAS PRUEBAS        
    }
    
    
    
    @Override
    public void run(){
        while (isRunning){
            try {
                //PRUEBAS(BORRARME DEL ARCHIVO)
                
                int[] objetivo = new Modelo().calcular_objetivo((Zombie)personaje, Datos.defensasEnJuego);
                jfinal = objetivo[0];
                ifinal = objetivo[1];
                personaje.tostring();
                
                //FIN DE LAS PRUEBAS
                
                coordsanterior = new int[]{jinicio,iinicio};
                Icon icono = Datos.matrizBotonesInterfaz[jinicio][iinicio].getIcon();
                Datos.matrizBotonesInterfaz[jinicio][iinicio].setIcon(imagen);
                String coordInicio = ""+ iinicio+"-"+jinicio;
                sleep(1000);
                
                //PRUEBA
                //personaje.tostring();
                int a = iinicio - ifinal;
                int b = jinicio - jfinal;
                //
                if (new Modelo().calcular_distancia(a,b) <= personaje.getAlcance()){
                    //System.out.println(coordInicio);
                    pausa();
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
            } catch (InterruptedException ex) {
            }
            while (isPaused) {                
                try {
                    sleep(500);
                    System.out.println("Atacando");
                    System.out.println(""+jfinal+"-"+ifinal);
                    Personaje PersonajeSiendoAtacado = Datos.matrizPersonajes[jfinal][ifinal];
                    Personaje PersonajeAtacando = Datos.matrizPersonajes[coordsanterior[0]][coordsanterior[1]];
                    //Datos.matrizPersonajes[jinicio][iinicio].setVida(Datos.matrizPersonajes[jinicio][iinicio].getVida()-Datos.matrizPersonajes[jinicio][iinicio].getDañoPorSegundo());
                    if (PersonajeSiendoAtacado != null){
                        if (PersonajeSiendoAtacado.EsAereo()  == PersonajeAtacando.EsAereo()){
                            PersonajeSiendoAtacado.setVida(PersonajeSiendoAtacado.getVida()-PersonajeAtacando.getDañoPorSegundo());
                            PersonajeAtacando.setVida(PersonajeAtacando.getVida()-PersonajeSiendoAtacado.getDañoPorSegundo());
                            if(PersonajeSiendoAtacado.getVida() <= 0){
                            
                                Personaje eliminado = PersonajeSiendoAtacado;
                                Datos.defensasEnJuego.remove(PersonajeSiendoAtacado);
                                PersonajeSiendoAtacado = null;
                                Datos.matrizBotonesInterfaz[jfinal][ifinal].setIcon(null);

                                if(eliminado == Datos.Pilar){
                                    System.out.println("Perdiste");
                                    Datos.labelResultado.setText("Perdiste");
                                    for (ThreadCaminar ThreadZomby : Datos.ThreadZombies) {
                                        ThreadZomby.finish();
                                    }
                                    Datos.ThreadZombies.clear();
                                    finish();
                                }
                                pausa();
                                if(!Datos.defensasEnJuego.isEmpty()){
                                    int[] objetivo = new Modelo().calcular_objetivo((Zombie)personaje, Datos.defensasEnJuego);
                                    jfinal = objetivo[0];
                                    ifinal = objetivo[1];
                                }else{
                                    finish();
                                }
                                break;
                            }
                            else if(PersonajeAtacando.getVida()<=0){
                                Datos.ZombiesEnJuego.remove(PersonajeAtacando);
                                PersonajeAtacando = null;
                                Datos.matrizBotonesInterfaz[coordsanterior[0]][coordsanterior[1]].setIcon(null);
                            }
                        }
                    }
                    else{
                        pausa();
                    }
                    
                } catch (InterruptedException ex) {
                    
                }
            }
               
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
            if (Datos.ZombiesEnJuego.contains(Datos.matrizPersonajes[jinicio][iinicio])){
                jinicio = coordsanterior[0];
                iinicio = coordsanterior[1];
            }else{
                Datos.matrizBotonesInterfaz[coordsanterior[0]][coordsanterior[1]].setIcon(null);
                Datos.matrizPersonajes[coordsanterior[0]][coordsanterior[1]] = (null);
                Datos.matrizBotonesInterfaz[jinicio][iinicio].setIcon(new javax.swing.ImageIcon(Datos.ruta+imagen));
                Datos.matrizPersonajes[jinicio][iinicio] = personaje;
            }
        
                
            
            
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

