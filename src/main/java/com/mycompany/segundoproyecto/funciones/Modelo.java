/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.segundoproyecto.funciones;

import com.mycompany.segundoproyecto.Datos;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author jecheverria
 */
public class Modelo implements Serializable {
    

 public ArrayList<Personaje> read_personajes() throws FileNotFoundException, IOException{
        ArrayList<Personaje> personajes = new ArrayList();
        ArrayList<Defensa> defensas = new ArrayList();
        ArrayList<Zombie> zombies = new ArrayList();
        File file = new File("Personajes.txt");
        BufferedReader Lector = new BufferedReader(new FileReader(file));
        String archivo;
        archivo = Lector.readLine();
        
        String[] personajes_archivo = archivo.split("%");
        for (String personaje : personajes_archivo){
            
            String[] atributos = personaje.split("/");
            
            Tipo tipo_personaje = null;
            if (atributos.length == 9){
                //System.out.println(atributos[7]);
                
                ArrayList<ImageIcon> images = new ArrayList();
                BufferedImage bufferedImage= ImageIO.read(new File(atributos[7]));
                Image image = bufferedImage.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
                images.add(new ImageIcon(image));
                bufferedImage= ImageIO.read(new File(atributos[8]));;
                image = bufferedImage.getScaledInstance(30, 30, Image.SCALE_DEFAULT);

                if (atributos[0].equals("D")){
                    switch(atributos[1]){
                            case "C":
                                tipo_personaje = Tipo.CONTACTO;
                                break;
                            case "MA":
                                tipo_personaje = Tipo.MEDIOALCANCE;                   
                                break;
                            case "A":
                                tipo_personaje = Tipo.AEREO;
                                break;
                            case "I":      
                                tipo_personaje = Tipo.IMPACTO;
                                break;         
                            case "AM":
                                tipo_personaje = Tipo.ATAQUEMULTIPLE;
                                break;
                            case "B":      
                                tipo_personaje = Tipo.BLOQUE;
                                break;
                    }
                    personajes.add(new Defensa(atributos[2],Integer.parseInt(atributos[3]),Integer.parseInt(atributos[4])
                        ,Integer.parseInt(atributos[5]),Integer.parseInt(atributos[6]),images ,tipo_personaje));
                    defensas.add(new Defensa(atributos[2],Integer.parseInt(atributos[3]),Integer.parseInt(atributos[4])
                        ,Integer.parseInt(atributos[5]),Integer.parseInt(atributos[6]),images,tipo_personaje));
                }

                if (atributos[0].equals("Z")){
                    switch(atributos[1]){
                        case "C":
                            tipo_personaje = Tipo.CONTACTO;
                            break;
                        case "MA":
                            tipo_personaje = Tipo.MEDIOALCANCE;                   
                            break;
                        case "A":
                            tipo_personaje = Tipo.AEREO;
                            break;
                        case "I":      
                            tipo_personaje = Tipo.IMPACTO;
                            break;
                    }
                    personajes.add(new Zombie(atributos[2],Integer.parseInt(atributos[3]),Integer.parseInt(atributos[4])
                        ,Integer.parseInt(atributos[5]),Integer.parseInt(atributos[6]),images,tipo_personaje));
                    zombies.add(new Zombie(atributos[2],Integer.parseInt(atributos[3]),Integer.parseInt(atributos[4])
                        ,Integer.parseInt(atributos[5]) ,Integer.parseInt(atributos[6]),images,tipo_personaje));
                }
            }
            else{}
        }
        return personajes;
    }

    public Modelo() {
    }


public ArrayList<Defensa> read_Defensas() throws FileNotFoundException, IOException{
        ArrayList<Defensa> defensas = new ArrayList(); 
        File file = new File("Personajes.txt");
        BufferedReader Lector = new BufferedReader(new FileReader(file));
        String archivo;
        archivo = Lector.readLine();
        String[] personajes_archivo = archivo.split("%");
        for (String personaje : personajes_archivo){
            String[] atributos = personaje.split("/");
            
            
            Tipo tipo_personaje = null;
            if (atributos.length == 9){
                ArrayList<ImageIcon> images = new ArrayList();  
                BufferedImage bufferedImage= ImageIO.read(new File(atributos[7]));;
                Image image = bufferedImage.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
                images.add(new ImageIcon(image));
                bufferedImage= ImageIO.read(new File(atributos[8]));;
                image = bufferedImage.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
            
                if (atributos[0].equals("D")){
                    switch(atributos[1]){
                            case "C":
                                tipo_personaje = Tipo.CONTACTO;
                                break;
                            case "MA":
                                tipo_personaje = Tipo.MEDIOALCANCE;                   
                                break;
                            case "A":
                                tipo_personaje = Tipo.AEREO;
                                break;
                            case "I":      
                                tipo_personaje = Tipo.IMPACTO;
                                break;         
                            case "AM":
                                tipo_personaje = Tipo.ATAQUEMULTIPLE;
                                break;
                            case "B":      
                                tipo_personaje = Tipo.BLOQUE;
                                break;
                    }
                    
                    defensas.add(new Defensa(atributos[2],Integer.parseInt(atributos[3]),Integer.parseInt(atributos[4])
                        ,Integer.parseInt(atributos[5]),Integer.parseInt(atributos[6]),images,tipo_personaje));
                }
            }
            else{}
        }
        return defensas;
    }

public ArrayList<Zombie> read_Zombies() throws FileNotFoundException, IOException{
        ArrayList<Zombie> zombies = new ArrayList();
        File file = new File("Personajes.txt");
        BufferedReader Lector = new BufferedReader(new FileReader(file));
        String archivo;
        archivo = Lector.readLine();
        String[] personajes_archivo = archivo.split("%");
        for (String personaje : personajes_archivo){
            
            String[] atributos = personaje.split("/");
            
            Tipo tipo_personaje = null;
            if (atributos.length == 9){

                ArrayList<ImageIcon> images = new ArrayList();  
                BufferedImage bufferedImage= ImageIO.read(new File(atributos[7]));;
                Image image = bufferedImage.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
                images.add(new ImageIcon(image));
                bufferedImage= ImageIO.read(new File(atributos[8]));;
                image = bufferedImage.getScaledInstance(30, 30, Image.SCALE_DEFAULT);

                if (atributos[0].equals("Z")){
                    switch(atributos[1]){
                        case "C":
                            tipo_personaje = Tipo.CONTACTO;
                            break;
                        case "MA":
                            tipo_personaje = Tipo.MEDIOALCANCE;                   
                            break;
                        case "A":
                            tipo_personaje = Tipo.AEREO;
                            break;
                        case "I":      
                            tipo_personaje = Tipo.IMPACTO;
                            break;
                    }

                    zombies.add(new Zombie(atributos[2],Integer.parseInt(atributos[3]),Integer.parseInt(atributos[4])
                        ,Integer.parseInt(atributos[5]),Integer.parseInt(atributos[6]),images,tipo_personaje));
                }
            }
            else{}
        }
        
        return zombies;
    }
    //Calcula averigua las cordenadas de la defensa mas cercana usando teorema de pitagoras
    //Retorna las cordenadas mas cercanas al zombie_actual

    public int[] calcular_objetivo(Zombie zombie_actual, ArrayList<Defensa> Defensas){
        
        int[] objetivo = {0,0};
        double distancia = 1000; //Distancia imposible para poder almacenar la primera distancia 
        int x_zombie = zombie_actual.getPosicion()[0];
        int y_zombie = zombie_actual.getPosicion()[1];
        for (int i = 0; i < Defensas.size(); i++){ //Recorre todas las defensas
            if (zombie_actual.EsAereo()  == Defensas.get(i).EsAereo()){
                int[] cordenadas_defensa = Defensas.get(i).getPosicion();
                int x_defensa= cordenadas_defensa[0];
                int y_defensa= cordenadas_defensa[1];
                int desplazamiento_horizontal = x_zombie - x_defensa;
                int desplazamiento_vertical = y_zombie - y_defensa;
                double pitagoras = calcular_distancia(desplazamiento_horizontal, desplazamiento_vertical);
                if (pitagoras <= distancia){
                    distancia = pitagoras;
                    objetivo = cordenadas_defensa;
                }
            }
        }
        return objetivo;
    }
    
    public void recibe_daño(Zombie zombie_actual, ArrayList<Defensa> Defensas){
            int x_zombie = zombie_actual.getPosicion()[0];
            int y_zombie = zombie_actual.getPosicion()[1];
            for (int i = 0; i < Defensas.size(); i++){ //Recorre todas las defensas
                if (zombie_actual.EsAereo()  == Defensas.get(i).EsAereo()){
                    int[] cordenadas_defensa = Defensas.get(i).getPosicion();
                    int x_defensa= cordenadas_defensa[0];
                    int y_defensa= cordenadas_defensa[1];
                    int desplazamiento_horizontal = x_zombie - x_defensa;
                    int desplazamiento_vertical = y_zombie - y_defensa;
                    double pitagoras = calcular_distancia(desplazamiento_horizontal, desplazamiento_vertical);
                    if(pitagoras <= Defensas.get(i).getAlcance()){//Si la defensa tien rango para pegarlo
                        if (!Defensas.get(i).EsImpacto()){
                            if(!Defensas.get(i).EsAtaqueMultiple()){
                                zombie_actual.setVida(zombie_actual.getVida()-Defensas.get(i).getDañoPorSegundo());

                                Defensas.get(i).setRegistro(Defensas.get(i).getRegistro()+ "\nAtacó a: "+ zombie_actual.getNombre() +
                                        "\nRealizando "+Defensas.get(i).getDañoPorSegundo()+" de daño"+
                                        "\nDejandolo a "+zombie_actual.getVida() + "/"+zombie_actual.getVidaOriginal()+ " de vida");

                                zombie_actual.setRegistro(zombie_actual.getRegistro()+ "\nFue atacado por "+Defensas.get(i).getNombre()+
                                        "\nLe bajo "+Defensas.get(i).getDañoPorSegundo()+" puntos de vida"+
                                        "\nQuedando a "+zombie_actual.getVida() + "/"+zombie_actual.getVidaOriginal()+ " de vida");
                                if (zombie_actual.getVida()<=0){
                                    Datos.ZombiesEnJuego.remove(zombie_actual);
                                    break;
                                }
                            }
                            else{
                                zombie_actual.setVida(zombie_actual.getVida()-Defensas.get(i).getDañoPorSegundo());
                                zombie_actual.setVida(zombie_actual.getVida()-Defensas.get(i).getDañoPorSegundo());

                                Defensas.get(i).setRegistro(Defensas.get(i).getRegistro()+ "\nAtacó a en 2 ocasiones a:"+ zombie_actual.getNombre() +
                                        "\nRealizando "+Defensas.get(i).getDañoPorSegundo()+"*2 de daño"+
                                        "\nDejandolo a "+zombie_actual.getVida() + "/"+zombie_actual.getVidaOriginal()+ " de vida");

                                zombie_actual.setRegistro(zombie_actual.getRegistro()+ "\nFue atacado en 2 ocasiones por "+Defensas.get(i).getNombre()+
                                        "\nLe bajo "+Defensas.get(i).getDañoPorSegundo()+"*2 puntos de vida"+
                                        "\nQuedando a "+zombie_actual.getVida() + "/"+zombie_actual.getVidaOriginal()+ " de vida");
                                
                                if (zombie_actual.getVida()<=0){
                                    Datos.ZombiesEnJuego.remove(zombie_actual);
                                    break;
                                }
                            
                            }
                        }else{
                            zombie_actual.setVida(0);
                            Defensas.get(i).setVida(0);
                            Defensas.get(i).setRegistro(Defensas.get(i).getRegistro()+ "\nExplotó contra: "+ zombie_actual.getNombre() +
                                    "\nRealizando "+Defensas.get(i).getDañoPorSegundo()+" de daño"+
                                    "\nDejandolo a "+zombie_actual.getVida() + "/"+zombie_actual.getVidaOriginal()+ " de vida");

                            zombie_actual.setRegistro(zombie_actual.getRegistro()+ "\nExplotó por "+Defensas.get(i).getNombre());
                            break;
                        }
                    }
                }
            }
        }


    public void aereo_recibe_daño(Personaje personaje_actual, ArrayList<Defensa> Defensas,ArrayList<Zombie> zombies){
        try{
            Zombie zombie_actual = (Zombie)personaje_actual;
            int x_zombie = zombie_actual.getPosicion()[0];
            int y_zombie = zombie_actual.getPosicion()[1];
            for (int i = 0; i < Defensas.size(); i++){ //Recorre todas las defensas
                if (Defensas.get(i).EsAereo()){
                    int[] cordenadas_defensa = Defensas.get(i).getPosicion();
                    int x_defensa= cordenadas_defensa[0];
                    int y_defensa= cordenadas_defensa[1];
                    int desplazamiento_horizontal = x_zombie - x_defensa;
                    int desplazamiento_vertical = y_zombie - y_defensa;
                    double pitagoras = calcular_distancia(desplazamiento_horizontal, desplazamiento_vertical);
                    if(pitagoras <= Defensas.get(i).getAlcance()){//Si la defensa tien rango para pegarlo
                        zombie_actual.setVida(zombie_actual.getVida()-Defensas.get(i).getDañoPorSegundo());

                        Defensas.get(i).setRegistro(Defensas.get(i).getRegistro()+ "\nAtacó a: "+ zombie_actual.getNombre() +
                                "\nRealizando "+Defensas.get(i).getDañoPorSegundo()+" de daño"+
                                "\nDejandolo a "+zombie_actual.getVida() + "/"+zombie_actual.getVidaOriginal()+ " de vida");

                        zombie_actual.setRegistro(zombie_actual.getRegistro()+ "\nFue atacado por "+Defensas.get(i).getNombre()+
                                "\nLe bajo "+Defensas.get(i).getDañoPorSegundo()+" puntos de vida"+
                                "\nQuedando a "+zombie_actual.getVida() + "/"+zombie_actual.getVidaOriginal()+ " de vida");

                        if (zombie_actual.getVida()<=0){
                            break;
                        }
                    }
                }
            }
        }catch(Exception e){
            Defensa defensa_actual = (Defensa)personaje_actual;
            int x_defensa = defensa_actual.getPosicion()[0];
            int y_defensa = defensa_actual.getPosicion()[1];
            for (int i = 0; i < zombies.size(); i++){ //Recorre todas las defensas
                if (zombies.get(i).EsAereo()){
                    int[] cordenadas_zombie = zombies.get(i).getPosicion();
                    int x_zombie= cordenadas_zombie[0];
                    int y_zombie= cordenadas_zombie[1];
                    int desplazamiento_horizontal = x_zombie - x_defensa;
                    int desplazamiento_vertical = y_zombie - y_defensa;
                    double pitagoras = calcular_distancia(desplazamiento_horizontal, desplazamiento_vertical);
                    if(pitagoras <= zombies.get(i).getAlcance()){//Si la defensa tien rango para pegarlo
                        defensa_actual.setVida(defensa_actual.getVida()-Defensas.get(i).getDañoPorSegundo());

                        zombies.get(i).setRegistro(zombies.get(i).getRegistro()+ "\nAtacó a: "+ defensa_actual.getNombre() +
                                "\nRealizando "+zombies.get(i).getDañoPorSegundo()+" de daño"+
                                "\nDejandolo a "+defensa_actual.getVida() + "/"+defensa_actual.getVidaOriginal()+ " de vida");

                        defensa_actual.setRegistro(defensa_actual.getRegistro()+ "\nFue atacado por "+zombies.get(i).getNombre()+
                                "\nLe bajo "+Defensas.get(i).getDañoPorSegundo()+" puntos de vida"+
                                "\nQuedando a "+defensa_actual.getVida() + "/"+defensa_actual.getVidaOriginal()+ " de vida");


                        if (defensa_actual.getVida()<=0){
                            break;
                        }
                    }
                }
            }
        }
    }  


    public int[] calcular_objetivo_aereo(Personaje personaje_actual, ArrayList<Defensa> Defensas,ArrayList<Zombie> zombies){
        try{
            Zombie zombie_actual = (Zombie)personaje_actual;    

            int[] objetivo = {0,0};
            double distancia = 1000; //Distancia imposible para poder almacenar la primera distancia 
            int x_zombie = zombie_actual.getPosicion()[0];
            int y_zombie = zombie_actual.getPosicion()[1];
            for (int i = 0; i < Defensas.size(); i++){ //Recorre todas las defensas
               // if (zombie_actual.EsAereo()  == Defensas.get(i).EsAereo()){
                int[] cordenadas_defensa = Defensas.get(i).getPosicion();
                int x_defensa= cordenadas_defensa[0];
                int y_defensa= cordenadas_defensa[1];
                int desplazamiento_horizontal = x_zombie - x_defensa;
                int desplazamiento_vertical = y_zombie - y_defensa;
                double pitagoras = calcular_distancia(desplazamiento_horizontal, desplazamiento_vertical);
                if (pitagoras <= distancia){
                    distancia = pitagoras;
                    objetivo = cordenadas_defensa;
                }
            }
            return objetivo;
        }catch(Exception e){
            Defensa defensa_actual = (Defensa)personaje_actual;
            int[] objetivo = {0,0};
            double distancia = 1000; //Distancia imposible para poder almacenar la primera distancia 
            int x_defensa = defensa_actual.getPosicion()[0];
            int y_defensa = defensa_actual.getPosicion()[1];
            for (int i = 0; i < zombies.size(); i++){ //Recorre todas las defensas
                //if (defensa_actual.EsAereo()  == Defensas.get(i).EsAereo()){
                    int[] cordenadas_zombie = zombies.get(i).getPosicion();
                    int x_zombie= cordenadas_zombie[0];
                    int y_zombie= cordenadas_zombie[1];
                    int desplazamiento_horizontal = x_zombie - x_defensa;
                    int desplazamiento_vertical = y_zombie - y_defensa;
                    double pitagoras = calcular_distancia(desplazamiento_horizontal, desplazamiento_vertical);
                    if (pitagoras <= distancia){
                        distancia = pitagoras;
                        objetivo = cordenadas_zombie;
                    }
                
            }
        return objetivo;
        }
    }
    
    
    
    public double calcular_distancia(int a, int b){
        double distancia = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
        return distancia;
    }
    
}
