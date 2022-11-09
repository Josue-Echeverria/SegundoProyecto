/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.segundoproyecto;

import com.mycompany.segundoproyecto.configuracion.VentanaResultados;
import com.mycompany.segundoproyecto.funciones.Defensa;
import com.mycompany.segundoproyecto.funciones.Modelo;
import com.mycompany.segundoproyecto.funciones.Personaje;
import com.mycompany.segundoproyecto.funciones.Zombie;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author jecheverria
 */
public class ThreadVolar extends Thread implements Serializable {
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
    
public ThreadVolar(Personaje personaje, int iinicio, int jinicio) {
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
                new Modelo().aereo_recibe_daño(personaje, Datos.defensasEnJuego,Datos.ZombiesEnJuego);
                if(personaje.getVida() <= 0){
                    break;
                }
                coordsanterior = new int[]{jinicio,iinicio};
                Icon icono = Datos.matrizBotonesInterfaz[jinicio][iinicio].getIcon();
                Datos.matrizBotonesInterfaz[jinicio][iinicio].setIcon(imagen);
                int[] pos = {jinicio, iinicio};
                personaje.setPosicion(pos);
                int[] objetivo = new Modelo().calcular_objetivo_aereo(personaje, Datos.defensasEnJuego,Datos.ZombiesEnJuego);
                jfinal = objetivo[0];
                ifinal = objetivo[1];
                

                sleep(500);
                
                //PRUEBA
                //personaje.tostring();
                int a = iinicio - ifinal;
                int b = jinicio - jfinal;
                //
                if (new Modelo().calcular_distancia(a,b) <= personaje.getAlcance()){
                    //System.out.println(coordInicio);
                    pausa();
                }else if(quienResta == Cordenada.x){
                    if(jinicio == jfinal){
                        quienResta = Cordenada.y;
                        continue;
                    }else{
                        if(jinicio > jfinal){
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
                    Personaje PersonajeSiendoAtacado = Datos.matrizPersonajes[jfinal][ifinal];
                    Personaje PersonajeAtacando = Datos.matrizPersonajes[coordsanterior[0]][coordsanterior[1]];
                    if (PersonajeSiendoAtacado != null & PersonajeAtacando != null & PersonajeAtacando != PersonajeSiendoAtacado){
                //     if (PersonajeSiendoAtacado.EsAereo()  == PersonajeAtacando.EsAereo()){

                         PersonajeSiendoAtacado.setVida(PersonajeSiendoAtacado.getVida()-PersonajeAtacando.getDañoPorSegundo());

                         PersonajeAtacando.setRegistro(PersonajeAtacando.getRegistro()+ "\nAtacó a: "+ PersonajeSiendoAtacado.getNombre() +
                        "\nRealizando "+PersonajeAtacando.getDañoPorSegundo()+" de daño"+
                        "\nDejandolo a "+PersonajeSiendoAtacado.getVida() + "/"+PersonajeSiendoAtacado.getVidaOriginal()+ " de vida");


                        PersonajeSiendoAtacado.setRegistro(PersonajeSiendoAtacado.getRegistro()+ "\nFue atacado por "+PersonajeAtacando.getNombre()+
                        "\nLe bajo "+PersonajeAtacando.getDañoPorSegundo()+" puntos de vida"+
                        "\nQuedando a "+PersonajeSiendoAtacado.getVida() + "/"+PersonajeSiendoAtacado.getVidaOriginal()+ " de vida");



                        new Modelo().aereo_recibe_daño(PersonajeAtacando, Datos.defensasEnJuego, Datos.ZombiesEnJuego);
                        
                        try{
                            PersonajeSiendoAtacado = (Defensa)PersonajeSiendoAtacado;
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
                                    Datos.ThreadVoladores.clear();
                                    new VentanaResultados().setVisible(true);
                                    finish();
                                }
                                pausa();
                                if(!Datos.defensasEnJuego.isEmpty()){
                                    int[] objetivo = new Modelo().calcular_objetivo_aereo(personaje, Datos.defensasEnJuego, Datos.ZombiesEnJuego);
                                    jfinal = objetivo[0];
                                    ifinal = objetivo[1];
                                }else{
                                    finish();
                                }
                                break;
                            }
                        }catch(Exception e){
                            PersonajeSiendoAtacado =(Zombie)PersonajeSiendoAtacado;
                            if(PersonajeSiendoAtacado.getVida() <= 0){
                                Personaje eliminado = PersonajeSiendoAtacado;
                                Datos.ZombiesEnJuego.remove(PersonajeSiendoAtacado);
                                PersonajeSiendoAtacado = null;
                                Datos.matrizBotonesInterfaz[jfinal][ifinal].setIcon(null);

                                pausa();

                                //Puede que este mal:

                                if(!Datos.ZombiesEnJuego.isEmpty()){
                                    int[] objetivo = new Modelo().calcular_objetivo_aereo(personaje, Datos.defensasEnJuego,Datos.ZombiesEnJuego);
                                    jfinal = objetivo[0];
                                    ifinal = objetivo[1];
                                }else{
                                    finish();
                                }
                                break;
                            }
                        }if(personaje.getVida() <= 0){
                            break;
                        }
                    }
                    else{
                        pausa();
                    }
                } catch (InterruptedException ex) {
                }
            }
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
        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(new File(Datos.Muerto));
            Image image = bufferedImage.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
            Datos.matrizBotonesInterfaz[coordsanterior[0]][coordsanterior[1]].setIcon(null);
            Datos.matrizBotonesInterfaz[jinicio][iinicio].setIcon(null);
            Datos.matrizPersonajes[jinicio][iinicio] = null;
        } catch (IOException ex) {
            Logger.getLogger(ThreadCaminar.class.getName()).log(Level.SEVERE, null, ex);
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
