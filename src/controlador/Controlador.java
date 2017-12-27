package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JTextField;
import modelo.*;
import vista.*;

public class Controlador implements ActionListener, WindowListener, MouseListener {
    
    Agregar agre;
    Eliminar eli;
    Modificar modi;
    Listar list;
    MenuPrincipal menu;
    Modelo model;
    ConsultasModelo Cmodel;

    public Controlador(Agregar agre, Eliminar eli, Modificar modi, Listar list, MenuPrincipal menu, Modelo model, ConsultasModelo Cmodel) {
        this.agre = agre;
        this.eli = eli;
        this.modi = modi;
        this.list = list;
        this.menu = menu;
        this.model = model;
        this.Cmodel = Cmodel;
    }
    
    public void inicializar(){
        menu.setTitle("SISTEMA TRABAJADORES");
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        
        agre.setTitle("AGREGAR");
        agre.setLocationRelativeTo(null);
        agre.setVisible(false);
        
        eli.setTitle("ELIMINAR");
        eli.setLocationRelativeTo(null);
        eli.setVisible(false);
        
        modi.setTitle("MODIFICAR DATOS");
        modi.setLocationRelativeTo(null);
        modi.setVisible(false);
        
        list.setTitle("LISTAR TRABAJADORES");
        list.setLocationRelativeTo(null);
        list.setVisible(false); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {   
    }

    @Override
    public void windowOpened(WindowEvent e) {       
    }

    @Override
    public void windowClosing(WindowEvent e) {       
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    //MÉTODO PARA INGRESAR SÓLO LETRAS Y QUE SE BLOQUEEN LOS NÚMEROS
    public void validarSoloLetras(JTextField campo){
        campo.addKeyListener(new KeyAdapter() {
            
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                int k = (int)e.getKeyChar();
                if(Character.isDigit(c) || k=='/' || k=='*' || k=='-' || k=='+'){
                    e.consume();
                }
            }
        });
    }
    
    //MÉTODO PARA INGRESAR SÓLO NÚMEROS Y QUE SE BLOQUEEN LAS LETRAS
    public void validarSoloNumeros(JTextField campo){
        campo.addKeyListener(new KeyAdapter() {
            
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });
    }
    
    //CON ESTE METODO LIMITO LA CANTIDAD DE CARACTERES A UN JTEXTFIELD PARA NO EXCEDERME Y GENERAR PROBLEMAS CON LA BBDD
    public void LimitarCaracteres(JTextField campo, int cantidad){
        campo.addKeyListener(new KeyAdapter() {
            
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                int tam = campo.getText().length();
                if(tam>=cantidad){
                    e.consume();
                }
            }
        });
    }

}
