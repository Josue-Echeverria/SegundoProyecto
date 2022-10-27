/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.segundoproyecto;

import com.mycompany.segundoproyecto.funciones.Personaje;
import com.mycompany.segundoproyecto.funciones.Defensa;
import com.mycompany.segundoproyecto.funciones.Zombie;
import com.mycompany.segundoproyecto.configuracion.Principal;
import com.mycompany.segundoproyecto.funciones.Modelo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author jecheverria
 */
public class SegundoProyecto {

    public static void main(String[] args) {
        System.out.println("Hello World!");
       // new Principal().setVisible(true);
        try {
            // 
            new Modelo().read_personajes();
        } catch (IOException ex) {
            Logger.getLogger(SegundoProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
