/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.segundoproyecto.funciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author jecheverria
 */
public class Modelo {
    

 public ArrayList<Personaje> read_personajes() throws FileNotFoundException, IOException{
        ArrayList<Personaje> personajes = new ArrayList();
        File file = new File("Personajes.txt");
        BufferedReader Lector = new BufferedReader(new FileReader(file));
        String archivo;
        archivo = Lector.readLine();
        String[] personajes_archivo = archivo.split("%");
        for (String personaje : personajes_archivo){
            
            String[] atributos = personaje.split("/");
            Tipo tipo_personaje = null;
            if (atributos.length == 7){
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
                        ,Integer.parseInt(atributos[5]),atributos[6],tipo_personaje));
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
                        ,Integer.parseInt(atributos[4]),atributos[5],tipo_personaje));
                }
            }
            else{}
        }
        for (Personaje persona : personajes){
            persona.tostring();}
        return personajes;
    }
}