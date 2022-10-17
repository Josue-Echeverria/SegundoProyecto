/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.segundoproyecto.funciones;

/**
 *
 * @author jecheverria
 */

enum Tipo{
    AEREO,
    CONTACTO,
    MEDIOALCANCE,
    CHOQUE;
}

public class Personaje {
    private int Vida;
    private int DañoPorSegundo;
    private String Nombre;
    private String Apariencia;
    private Tipo TipoDeAtaque;
    private int Nivel;
    private int Campos;
    private int NivelAparicion;

    public Tipo getTipoDeAtaque(){
        return this.TipoDeAtaque;
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

    public String getApariencia() {
        return Apariencia;
    }

    public void setApariencia(String Apariencia) {
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


}