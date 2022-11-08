/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.segundoproyecto.configuracion;

import com.mycompany.segundoproyecto.Datos;
import static com.mycompany.segundoproyecto.Datos.ponePilar;
import com.mycompany.segundoproyecto.Funciones;
import com.mycompany.segundoproyecto.ThreadCaminar;
import com.mycompany.segundoproyecto.funciones.Defensa;
import com.mycompany.segundoproyecto.funciones.Personaje;
import com.mycompany.segundoproyecto.funciones.Zombie;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.event.*;
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
public class VentanaJuego extends javax.swing.JFrame {
    public int tamañobotones = 30;
    public int XbotonesJugables = 30;
    public int YbotonesJugables = 30;
    /**
     * Creates new form VentanaJuego
     */
    public VentanaJuego() {
        Datos ha = new Datos();
        initComponents();
        creaMatrizJugable();
        creaMatrixPersonaje();
        Datos.labelResultado = lbPerdiste;
        Datos.label_campos_disponibles = lbl_disponibles;

        
        
        //PRUEBAS(BORRARME DEL ARCHIVO)
        

        //FIN DE LAS PRUEBAS
        ponePilar(10,10);
        
        
        
    }
    public void creaMatrixPersonaje(){
        int contadorfila = 1;
        int contadorColumna = 1;
        int largo = Datos.defensas.size();
        for (int i = 0;i< largo;i++) {
            JButton boton = new javax.swing.JButton();
            
            boton.setLocation(contadorColumna*tamañobotones, contadorfila*tamañobotones);


            boton.setText(Datos.defensas.get(i).getApariencia()+ "%"+i);
            

            ImageIcon apariencia1 = Datos.defensas.get(i).getApariencia().get(0);

            boton.setIcon(apariencia1);
            System.out.println(Datos.nivel);
            System.out.println(Datos.defensas.get(i).getNivelAparicion());
            if (Datos.defensas.get(i).getNivelAparicion()> Datos.nivel){
                boton.setBackground(Color.red);
                boton.setEnabled(false);
            }

            boton.addActionListener(al2);
            boton.resize(tamañobotones, tamañobotones);
            boton.setSize(tamañobotones,tamañobotones);
            pnlDisponibles.add(boton);
            
            if(contadorColumna == 4 ){
                contadorfila += 1;
                contadorColumna = 0;
            }
            contadorColumna += 1;
        }
    }
   
    public void creaMatrizJugable(){
        int contador = 0;
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                JButton boton = new javax.swing.JButton();
                boton.setSize(tamañobotones,tamañobotones);
                boton.setLocation(j*tamañobotones, i*tamañobotones);
                boton.setText(j+"-"+i);

                //boton.setIcon(new javax.swing.ImageIcon(Datos.ruta+"Base.png"));

                Datos.matrizBotonesInterfaz[j][i] = boton;
                if (i == 0 || i == 26){
                    boton.setBackground(Color.red);
                    Datos.matrizBotonesApareceZombies[contador] = boton;
                    contador+=1;
                    //boton.setIcon(new javax.swing.ImageIcon(Datos.ruta+"BaseBloqueada.png"));
                    
                }else{
                    if(j == 0 || j == 26){
                        boton.setBackground(Color.red);
                        Datos.matrizBotonesApareceZombies[contador] = boton;
                        contador+=1;
                        //boton.setIcon(new javax.swing.ImageIcon(Datos.ruta+"BaseBloqueada.png"));
                    }
                }
                boton.addActionListener(al);
                pnlFondo.add(boton);
            }
        }
    }
    
    ActionListener al2=new ActionListener(){
        public void actionPerformed (){
            System.out.println("holaaaaaaaaaaaa");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!Datos.jugando){
                JButton boton = (JButton) e.getSource();
                Datos.accionMouse = Datos.EstadoHaciendoMouse.CARGANDOPERSONAJE;
                Datos.personajeCargando = boton.getText();
                System.out.println(boton.getText());
            }
        }
      };
    ActionListener al=new ActionListener(){
        public void actionPerformed (){
            System.out.println("holaaaaaaaaaaaa");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
            for (int i = 0; i < 27; i++) {
                for (int j = 0; j < 27; j++) {                    
                    if (e.getSource() == Datos.matrizBotonesInterfaz[j][i]){
                        Funciones.FuncionBotones(j, i);
                        break;
                    }                    
                }
            }
        }
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        pnlDisponibles = new javax.swing.JPanel();
        lbPerdiste = new javax.swing.JLabel();
        lbl_campos_disponibles = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btJugar = new javax.swing.JButton();
        lbl_disponibles = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlFondo.setBackground(new java.awt.Color(153, 51, 0));
        pnlFondo.setPreferredSize(new java.awt.Dimension(830, 830));

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );

        pnlDisponibles.setBackground(new java.awt.Color(0, 255, 0));

        lbPerdiste.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDisponiblesLayout = new javax.swing.GroupLayout(pnlDisponibles);
        pnlDisponibles.setLayout(pnlDisponiblesLayout);
        pnlDisponiblesLayout.setHorizontalGroup(
            pnlDisponiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDisponiblesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDisponiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPerdiste, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDisponiblesLayout.createSequentialGroup()
                        .addComponent(lbl_campos_disponibles)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDisponiblesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(43, 43, 43))
        );
        pnlDisponiblesLayout.setVerticalGroup(
            pnlDisponiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDisponiblesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_campos_disponibles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbPerdiste, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(jButton1)
                .addGap(21, 21, 21))
        );

        btJugar.setText("Jugar");
        btJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btJugarActionPerformed(evt);
            }
        });

        lbl_disponibles.setText("EspacioDisponible: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbl_disponibles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btJugar)
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btJugar)
                    .addComponent(lbl_disponibles))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlDisponibles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btJugarActionPerformed
       Funciones.generaJuego();
    }//GEN-LAST:event_btJugarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Funciones.subirnivel();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btJugar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lbPerdiste;
    private javax.swing.JLabel lbl_campos_disponibles;
    private javax.swing.JLabel lbl_disponibles;
    private javax.swing.JPanel pnlDisponibles;
    private javax.swing.JPanel pnlFondo;
    // End of variables declaration//GEN-END:variables
}
