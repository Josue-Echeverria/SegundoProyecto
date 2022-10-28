<<<<<<< Updated upstream
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.segundoproyecto;

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
    String imagen;
    int iinicio;
    int jinicio;
    int ifinal;
    int jfinal;
    private Cordenada quienResta;
    

    public ThreadCaminar(String imagen, int iinicio, int jinicio, int ifinal, int jfinal) {
        this.imagen = imagen;
        this.iinicio = iinicio;
        this.jinicio = jinicio;
        this.ifinal = ifinal;
        this.jfinal = jfinal;
        quienResta = Cordenada.x;
        Datos.matrizBotonesInterfaz[jfinal][ifinal].setIcon(new javax.swing.ImageIcon(Datos.ruta+"Japón.png"));
        Datos.matrizBotonesInterfaz[jinicio][iinicio].setIcon(new javax.swing.ImageIcon(Datos.ruta+"Gales.png"));
        System.out.println(Datos.matrizBotonesInterfaz[jinicio][iinicio].getIcon());
    }
    
    
    
    @Override
    public void run(){
        while (isRunning){
            
            try {
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
                System.out.println(coordInicio);
                
                Datos.matrizBotonesInterfaz[jinicio][iinicio].setIcon(new javax.swing.ImageIcon(Datos.ruta+"Gales.png"));
                
                
            } catch (InterruptedException ex) {
            }
            
            while (isPaused) {                
                try {
                    sleep(500);
                } catch (InterruptedException ex) {
                }
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
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.segundoproyecto;

import javax.swing.Icon;
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
    String imagen;
    int iinicio;
    int jinicio;
    int ifinal;
    int jfinal;
    private Cordenada quienResta;
    private Boolean borde = true;
    public int coordsanterior[];
    

    public ThreadCaminar(String imagen, int iinicio, int jinicio, int ifinal, int jfinal) {
        this.imagen = imagen;
        this.iinicio = iinicio;
        this.jinicio = jinicio;
        this.ifinal = ifinal;
        this.jfinal = jfinal;
        quienResta = Cordenada.x;
        
        Datos.matrizBotonesInterfaz[jfinal][ifinal].setIcon(new javax.swing.ImageIcon(Datos.ruta+"Japón.png"));
        Datos.matrizBotonesInterfaz[10][10].setIcon(new javax.swing.ImageIcon(Datos.ruta+"Japón.png"));
        
        System.out.println(Datos.matrizBotonesInterfaz[jinicio][iinicio].getIcon());
    }
    
    
    
    @Override
    public void run(){
        while (isRunning){
            
            try {
                coordsanterior = new int[]{jinicio,iinicio};
                Icon icono = Datos.matrizBotonesInterfaz[jinicio][iinicio].getIcon();
                Datos.matrizBotonesInterfaz[jinicio][iinicio].setIcon(new javax.swing.ImageIcon(Datos.ruta+imagen));
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
                System.out.println(coordInicio);
                
                
                
                if (Datos.matrizBotonesInterfaz[jinicio][iinicio].getIcon().toString().equals(Datos.ruta+"Base.png") || Datos.matrizBotonesInterfaz[jinicio][iinicio].getIcon().toString().equals(Datos.ruta+"BaseBloqueada.png")){
                    System.out.println("Es la base");
                }else{
                    System.out.println("no es la base");
                    pausa();
                    /*System.out.println(Datos.matrizBotonesInterfaz[jinicio][iinicio].getIcon().toString());
                    System.out.println(Datos.ruta+"Base.png");*/
                }
                
                
                
            } catch (InterruptedException ex) {
            }
            
            while (isPaused) {                
                try {
                    sleep(500);
                    System.out.println("Atacando");
                } catch (InterruptedException ex) {
                }
            }
                Datos.matrizBotonesInterfaz[coordsanterior[0]][coordsanterior[1]].setIcon(new javax.swing.ImageIcon(Datos.ruta+"Base.png"));
                //String hola = Datos.matrizBotonesInterfaz[jinicio][iinicio].getIcon();
                if(borde){
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
                }
            Datos.matrizBotonesInterfaz[jinicio][iinicio].setIcon(new javax.swing.ImageIcon(Datos.ruta+imagen));
            
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
>>>>>>> Stashed changes
