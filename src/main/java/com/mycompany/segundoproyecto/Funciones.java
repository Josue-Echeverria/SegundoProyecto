
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.segundoproyecto;

import com.mycompany.segundoproyecto.configuracion.VentanaInformacion;
import com.mycompany.segundoproyecto.funciones.Personaje;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author deyla
 */
public class Funciones {
    
    
    
    static public void FuncionBotones(int i,int j){
        
        
        
        
        System.out.println(j);
        System.out.println(i);  
        if (Datos.accionMouse == Datos.EstadoHaciendoMouse.CARGANDOPERSONAJE){
            BufferedImage bufferedImage;
            try {
                String[] datosboton = Datos.personajeCargando.split("%");
                
                int indice = Integer.parseInt(datosboton[1]);
                bufferedImage = ImageIO.read(new File(datosboton[0]));
                
                Image image = bufferedImage.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
                ImageIcon icon = new ImageIcon(image);
                Datos.matrizBotonesInterfaz[i][j].setIcon(icon);
                
                Datos.matrizPersonajes[i][j] = Datos.defensas.get(indice);
                Datos.accionMouse = Datos.EstadoHaciendoMouse.NADA;
                Datos.personajeCargando = null;
            } catch (IOException ex) {
                System.out.println("Error en la imagen cargando personaje");
            }
        }
        if (Datos.accionMouse == Datos.EstadoHaciendoMouse.NADA){
            
            Personaje personajeConsulta = Datos.matrizPersonajes[i][j];
            if (personajeConsulta != null){
                VentanaInformacion ventana = new VentanaInformacion(i, j);
                ventana.setVisible(true);
            }
            
        }
    }


}
