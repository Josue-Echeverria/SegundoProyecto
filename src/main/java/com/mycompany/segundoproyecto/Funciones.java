
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.segundoproyecto;

import static com.mycompany.segundoproyecto.Datos.Pilar;
import static com.mycompany.segundoproyecto.Datos.coordsPilar;
import com.mycompany.segundoproyecto.configuracion.VentanaInformacion;
import com.mycompany.segundoproyecto.funciones.Defensa;
import com.mycompany.segundoproyecto.funciones.Personaje;
import com.mycompany.segundoproyecto.funciones.Zombie;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author deyla
 */
public class Funciones {
    
    
    
    static public void FuncionBotones(int i,int j){
        
        if(!Datos.jugando){
            System.out.println(j);
            System.out.println(i);  
            if (Datos.accionMouse == Datos.EstadoHaciendoMouse.MOVIENDOPILAR){
                Datos.matrizBotonesInterfaz[i][j].setIcon(Datos.Pilar.getApariencia().get(0));
                Datos.matrizPersonajes[i][j] = Datos.Pilar;
                Datos.matrizBotonesInterfaz[coordsPilar[0]][coordsPilar[1]].setIcon(null);
                Datos.matrizPersonajes[coordsPilar[0]][coordsPilar[1]] = null;
                Datos.accionMouse = Datos.EstadoHaciendoMouse.NADA;
                coordsPilar[0] = i;
                coordsPilar[1] = j;
                int[] pos = {j,i};
                Pilar.setPosicion(pos);
            }else if (Datos.accionMouse == Datos.EstadoHaciendoMouse.NADA){

                Personaje personajeConsulta = Datos.matrizPersonajes[i][j]; 
                if (personajeConsulta != null){
                    VentanaInformacion ventana = new VentanaInformacion(i, j);
                    ventana.setVisible(true);
                }
                if(personajeConsulta == Datos.Pilar){
                    Datos.accionMouse = Datos.EstadoHaciendoMouse.MOVIENDOPILAR;
                }
            }else if (Datos.accionMouse == Datos.EstadoHaciendoMouse.CARGANDOPERSONAJE && Datos.matrizPersonajes[i][j] == null ){
                String[] datosboton = Datos.personajeCargando.split("%");
                int indice = Integer.parseInt(datosboton[1]);
                if (Datos.campos+Datos.defensas.get(indice).getCamposTipoDeAtaque() <= 20){
                    BufferedImage bufferedImage;
                    Datos.matrizBotonesInterfaz[i][j].setIcon(Datos.defensas.get(indice).getApariencia().get(0));
                    Defensa nueva = new Defensa(Datos.defensas.get(indice).getNombre(),Datos.defensas.get(indice).getVida(),Datos.defensas.get(indice).getDañoPorSegundo(),Datos.defensas.get(indice).getNivelAparicion(),Datos.defensas.get(indice).getAlcance(),Datos.defensas.get(indice).getApariencia(),Datos.defensas.get(indice).getTipoDeAtaque());
                    int[] pos0 = {i,j};
                    nueva.setPosicion(pos0);
                    Datos.defensasEnJuego.add(nueva);
                    Datos.matrizPersonajes[i][j] = nueva;
                    Datos.accionMouse = Datos.EstadoHaciendoMouse.NADA;
                    Datos.personajeCargando = null;
                    Datos.campos+=Datos.defensas.get(indice).getCamposTipoDeAtaque();
                    Datos.label_campos_disponibles.setText("Espacio disponible: "+Datos.campos + "/20"); 
                }
            }
        }else if (Datos.accionMouse == Datos.EstadoHaciendoMouse.NADA){

                Personaje personajeConsulta = Datos.matrizPersonajes[i][j]; 
                if (personajeConsulta != null){
                    VentanaInformacion ventana = new VentanaInformacion(i, j);
                    ventana.setVisible(true);
                }
                if(personajeConsulta == Datos.Pilar){
                    Datos.accionMouse = Datos.EstadoHaciendoMouse.MOVIENDOPILAR;
                }
         }
        
        
        
        
        
    }


    static public void generaJuego(){
        Datos.jugando = true;
        System.out.println("***");
        System.out.println(Datos.zombies.size());
        System.out.println("***");
        int menor = 1000;
        for (Zombie zomby : Datos.zombies) {
            if(zomby.getCampos()< menor){
                menor = zomby.getCampos();
            }
        }
        int copiacampos = Datos.campos;
        while(copiacampos > 0){
            Random r = new Random();
            int valorDado = r.nextInt(Datos.zombies.size());
            Random r2 = new Random();
            int valorDado2 = r2.nextInt(104);
            System.out.println("############");
            System.out.println(valorDado);
            System.out.println(Datos.zombies.get(valorDado).getTipoDeAtaque());
            System.out.println(copiacampos);
            System.out.println("############");
            
            if(Datos.zombies.get(valorDado).getCampos()<= copiacampos){
                
                copiacampos -= Datos.zombies.get(valorDado).getCampos();
                String[] COORDString = Datos.matrizBotonesApareceZombies[valorDado2].getText().split("-");
                int i = Integer.parseInt(COORDString[1]);
                int j = Integer.parseInt(COORDString[0]);
                Zombie nuevo = new Zombie(Datos.zombies.get(valorDado).getNombre(),Datos.zombies.get(valorDado).getVida(),Datos.zombies.get(valorDado).getDañoPorSegundo(),Datos.zombies.get(valorDado).getNivelAparicion(),Datos.zombies.get(valorDado).getAlcance(),Datos.zombies.get(valorDado).getApariencia(),Datos.zombies.get(valorDado).getTipoDeAtaque());
                
                Datos.ZombiesEnJuego.add(nuevo);
                if(!nuevo.EsAereo()){
                    ThreadCaminar tr = new ThreadCaminar(nuevo, i,j );
                    tr.start();
                    Datos.ThreadZombies.add(tr);
                }
                else{
                    ThreadVolar tr = new ThreadVolar(nuevo, i,j );
                    tr.start();
                    Datos.ThreadVoladores.add(tr);
                
                }
           
            }
            if(copiacampos < menor){
                break;
                
            }  
        } 
        for (Defensa defensa : Datos.defensasEnJuego){
            if (defensa.EsAereo()){
                ThreadVolar tr = new ThreadVolar(defensa, defensa.getPosicion()[1],defensa.getPosicion()[0] );
                tr.start();
                Datos.ThreadVoladores.add(tr);         
            }
        }
    }

    static public void subirnivel(){
        Datos.nivel += 1;
        for (Defensa defensa : Datos.defensas) {
            
        
            Random r = new Random();
            double valorDado = r.nextInt(15)+5;
            double porcentaje = valorDado/100;
            
            defensa.incremetaestadisticas(porcentaje);
            
        }
        for (Zombie zombie : Datos.zombies) {
            Random r = new Random();
            double valorDado = r.nextInt(15)+5;
            double porcentaje = valorDado/100;
           
            zombie.incremetaestadisticas(porcentaje);
        }
        
    }
}

