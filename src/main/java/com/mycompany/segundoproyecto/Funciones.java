
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.segundoproyecto;

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
                bufferedImage = ImageIO.read(new File(Datos.personajeCargando));
                Image image = bufferedImage.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
                ImageIcon icon = new ImageIcon(image);
                Datos.matrizBotonesInterfaz[i][j].setIcon(icon);
                Datos.accionMouse = Datos.EstadoHaciendoMouse.NADA;
                Datos.personajeCargando = null;
            } catch (IOException ex) {
                System.out.println("Error en la imagen cargando personaje");
            }
            
                
            
        }
    }


}
