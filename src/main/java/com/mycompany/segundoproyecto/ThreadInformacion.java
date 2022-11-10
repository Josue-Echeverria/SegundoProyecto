/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.segundoproyecto;

import com.mycompany.segundoproyecto.configuracion.VentanaJuego;
import com.mycompany.segundoproyecto.configuracion.VentanaInformacion;
import com.mycompany.segundoproyecto.funciones.Personaje;
import java.io.Serializable;

/**
 *
 * @author PC
 */
public class ThreadInformacion extends Thread implements Serializable {
    private boolean isRunning = true;
    int i;
    int j;
    
    VentanaInformacion ventana;

    public ThreadInformacion(VentanaInformacion ventana,int i,int j) {
        this.i = i;
        this.j = j;
        this.ventana = ventana;
    }
    
    @Override
    public void run(){
        while (isRunning){
            if ( Datos.matrizPersonajes[i][j] != null){
                Personaje personajeConsulta = Datos.matrizPersonajes[i][j];
                ventana.getLbl_TipoAtaqueDato().setText(personajeConsulta.getTipoDeAtaqueString());
                ventana.getLbl_vidaDato().setText(Integer.toString(personajeConsulta.getVida()));

                ventana.getLbl_dañoDato().setText(Integer.toString(personajeConsulta.getDañoPorSegundo()));

                ventana.getLbl_nombreDato().setText(personajeConsulta.getNombre());

                ventana.getLbl_nvlAparicionDato().setText(Integer.toString(personajeConsulta.getNivelAparicion()));
            }else{
                break;
            } 
        }
    }
}
