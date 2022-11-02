/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.segundoproyecto.funciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;


/**
 *
 * @author jecheverria
 */

enum Tipo{
    AEREO(1),
    CONTACTO(1),
    MEDIOALCANCE(1),
    IMPACTO(1),
    BLOQUE(1),
    ATAQUEMULTIPLE(1);

    private final int campos;

    private Tipo() {
        this.campos = 0;
    }

    private Tipo(int campos) {
        this.campos = campos;
    }


}

public class Personaje {
    private int Vida;
    private int DañoPorSegundo;
    private String Nombre;
    private ArrayList<ImageIcon> Apariencia;
    private Tipo TipoDeAtaque;
    private int Nivel;
    private int Campos;
    private int NivelAparicion;

    public Tipo getTipoDeAtaque(){
        return this.TipoDeAtaque;
    }

    public Personaje(int Vida, int DañoPorSegundo, String Nombre, ArrayList<ImageIcon> Apariencia, Tipo TipoDeAtaque, int NivelAparicion) {
        this.Vida = Vida;
        this.DañoPorSegundo = DañoPorSegundo;
        this.Nombre = Nombre;
        this.Apariencia = Apariencia;
        this.TipoDeAtaque = TipoDeAtaque;
        this.NivelAparicion = NivelAparicion;
    }
    public String getTipoDeAtaqueString(){
        if(this.TipoDeAtaque == Tipo.AEREO)
            return "Aereo";
        if(this.TipoDeAtaque == Tipo.ATAQUEMULTIPLE)
            return "Ataque multiple";
        if(this.TipoDeAtaque == Tipo.BLOQUE)
            return "Bloque";
        if(this.TipoDeAtaque == Tipo.CONTACTO)
            return "Contacto";
        if(this.TipoDeAtaque == Tipo.IMPACTO)
            return "Impacto";
        else
            return "Medio alcance";
        
    }
    
    public void setTipoDeAtaque(Tipo tipodeataque){
        this.TipoDeAtaque = tipodeataque;
    }
    
    public int getVida() {
        return Vida;
    }

    public void setVida(int Vida) {
        this.Vida = Vida;
    }

    public int getDañoPorSegundo() {
        return DañoPorSegundo;
    }

    public void setDañoPorSegundo(int DañoPorSegundo) {
        this.DañoPorSegundo = DañoPorSegundo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public ArrayList<ImageIcon> getApariencia() {
        return Apariencia;
    }

    public void setApariencia(ArrayList<ImageIcon> Apariencia) {
        this.Apariencia = Apariencia;
    }

    public int getNivel() {
        return Nivel;
    }

    public void setNivel(int Nivel) {
        this.Nivel = Nivel;
    }

    public int getCampos() {
        return Campos;
    }

    public void setCampos(int Campos) {
        this.Campos = Campos;
    }

    public int getNivelAparicion() {
        return NivelAparicion;
    }

    public void setNivelAparicion(int NivelAparicion) {
        this.NivelAparicion = NivelAparicion;
    }
    
    public void tostring(){
        System.out.println("Hola soy "+ this.Nombre + " y ataco " +this.TipoDeAtaque);
    }
    


}