package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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

    public Controlador() {
        Cmodel = new ConsultasModelo();
        
        //Seteo de ventana Principal
        menu = new MenuPrincipal();
        menu.setTitle("SISTEMA TRABAJADORES");
        menu.setLocationRelativeTo(null);
        menu.setResizable(false);
        
        //Visibilidad ventana Principal
        menu.setVisible(true);

        //Seteo de ventana Agregar
        agre = new Agregar();
        agre.setTitle("AGREGAR");
        agre.setLocationRelativeTo(null);
        agre.setResizable(false);

        //Seteo de ventana Eliminar
        eli = new Eliminar();
        eli.setTitle("ELIMINAR");
        eli.setLocationRelativeTo(null);
        eli.setResizable(false);

        //Seteo de ventana Modificar
        modi = new Modificar();
        modi.setTitle("MODIFICAR DATOS");
        modi.setLocationRelativeTo(null);
        modi.setResizable(false);

        //Seteo de ventana Listar
        list = new Listar();
        list.setTitle("LISTAR TRABAJADORES");
        list.setLocationRelativeTo(null);
        list.setResizable(false);
        actualizarMostrar();
        
        //Escuchas con eventos de Ventana para programar cierres de todas las ventanas
        menu.addWindowListener(this);
        agre.addWindowListener(this);
        eli.addWindowListener(this);
        modi.addWindowListener(this);
        list.addWindowListener(this);
        
        //Escuchas del menu Vista menu Principal
        menu.menu_agregar.addActionListener(this);
        menu.menu_modificar.addActionListener(this);
        menu.menu_eliminar.addActionListener(this);
        menu.menu_listar.addActionListener(this);
        menu.menu_salir.addActionListener(this);
        //Escuchas del menu Vista Agregar
        agre.menu_agregar.addActionListener(this);
        agre.menu_modificar.addActionListener(this);
        agre.menu_eliminar.addActionListener(this);
        agre.menu_listar.addActionListener(this);
        agre.menu_salir.addActionListener(this);
        //Escuchas del menu Vista Eliminar
        eli.menu_agregar.addActionListener(this);
        eli.menu_modificar.addActionListener(this);
        eli.menu_eliminar.addActionListener(this);
        eli.menu_listar.addActionListener(this);
        eli.menu_salir.addActionListener(this);
        //Escuchas del menu Vista Modificar
        modi.menu_agregar.addActionListener(this);
        modi.menu_modificar.addActionListener(this);
        modi.menu_eliminar.addActionListener(this);
        modi.menu_listar.addActionListener(this);
        modi.menu_salir.addActionListener(this);
        //Escuchas del menu Vista Listar
        list.menu_agregar.addActionListener(this);
        list.menu_modificar.addActionListener(this);
        list.menu_eliminar.addActionListener(this);
        list.menu_listar.addActionListener(this);
        list.menu_salir.addActionListener(this);
        
        //Escuchas de los elementos de la Vista Agregar
        agre.btnagregar.addActionListener(this);
        agre.btn_volver_agregar.addActionListener(this);
        
        //Escuchas de los elementos de la Vista Eliminar
        eli.btneliminar.addActionListener(this);
        eli.btnbuscar_eliminar.addActionListener(this);
        eli.btn_volver_eliminar.addActionListener(this);
        
        //Escuchas de los elementos de la Vista Modificar
        modi.btnbuscar_modificar.addActionListener(this);
        modi.btnmodificar.addActionListener(this);
        modi.btn_volver_modificar.addActionListener(this);
        
        //Escuchas de los elementos de la Vista Listar
        list.btn_volver_listar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Eventos de Menu de la ventana Agregar
        if(e.getSource()==menu.menu_agregar){
            menu.setVisible(false);
            agre.setVisible(true);
        }else if(e.getSource()==menu.menu_eliminar){
            menu.setVisible(false);
            eli.setVisible(true);
        }else if(e.getSource()==menu.menu_modificar){
            menu.setVisible(false);
            modi.setVisible(true);
        }else if(e.getSource()==menu.menu_salir){
            int msje=JOptionPane.showConfirmDialog(menu,"¿DESEA SALIR DE LA APLICACIÓN?", "SALIR", JOptionPane.YES_NO_OPTION);
            if(msje==JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }else if(e.getSource()==menu.menu_listar){
            menu.setVisible(false);
            list.setVisible(true);
        }
        
        //Action Event de Ventana Eliminar
        if(e.getSource()==eli.menu_agregar){
            eli.setVisible(false);
            agre.setVisible(true);
        }else if(e.getSource()==eli.menu_eliminar){
            JOptionPane.showMessageDialog(eli, "YA ESTÁ EN LA VENTANA ELIMINAR", "", JOptionPane.INFORMATION_MESSAGE);
        }else if(e.getSource()==eli.menu_modificar){
            eli.setVisible(false);
            modi.setVisible(true);
        }else if(e.getSource()==eli.menu_salir){
            int msje=JOptionPane.showConfirmDialog(menu,"¿DESEA SALIR DE LA APLICACIÓN?", "SALIR", JOptionPane.YES_NO_OPTION);
            if(msje==JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }else if(e.getSource()==eli.menu_listar){
            eli.setVisible(false);
            list.setVisible(true);
        }
        
        //Action Event de Ventana Modificar
        if(e.getSource()==modi.menu_agregar){
            modi.setVisible(false);
            agre.setVisible(true);
        }else if(e.getSource()==modi.menu_eliminar){
            modi.setVisible(false);
            eli.setVisible(true);
        }else if(e.getSource()==modi.menu_modificar){
            JOptionPane.showMessageDialog(modi, "YA ESTÁ EN LA VENTANA MODIFICAR", "", JOptionPane.INFORMATION_MESSAGE);
        }else if(e.getSource()==modi.menu_salir){
            int msje=JOptionPane.showConfirmDialog(menu,"¿DESEA SALIR DE LA APLICACIÓN?", "SALIR", JOptionPane.YES_NO_OPTION);
            if(msje==JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }else if(e.getSource()==modi.menu_listar){
            modi.setVisible(false);
            list.setVisible(true);
        }
        
        //Action Event de Ventana Listar
        if(e.getSource()==list.menu_agregar){
            list.setVisible(false);
            agre.setVisible(true);
        }else if(e.getSource()==list.menu_eliminar){
            list.setVisible(false);
            eli.setVisible(true);
        }else if(e.getSource()==list.menu_modificar){
            list.setVisible(false);
            modi.setVisible(true);
        }else if(e.getSource()==list.menu_salir){
            int msje=JOptionPane.showConfirmDialog(menu,"¿DESEA SALIR DE LA APLICACIÓN?", "SALIR", JOptionPane.YES_NO_OPTION);
            if(msje==JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }else if(e.getSource()==list.menu_listar){
            JOptionPane.showMessageDialog(list, "YA ESTÁ EN LA VENTANA LISTAR", "", JOptionPane.INFORMATION_MESSAGE);
        }
        
        //Action Event de Ventana Agregar
        if(e.getSource()==agre.menu_agregar){
            JOptionPane.showMessageDialog(agre, "YA ESTÁ EN LA VENTANA AGREGAR", "", JOptionPane.INFORMATION_MESSAGE);
        }else if(e.getSource()==agre.menu_eliminar){
            agre.setVisible(false);
            eli.setVisible(true);
        }else if(e.getSource()==agre.menu_modificar){
            agre.setVisible(false);
            modi.setVisible(true);
        }else if(e.getSource()==agre.menu_salir){
            int msje=JOptionPane.showConfirmDialog(menu,"¿DESEA SALIR DE LA APLICACIÓN?", "SALIR", JOptionPane.YES_NO_OPTION);
            if(msje==JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }else if(e.getSource()==agre.menu_listar){
            agre.setVisible(false);
            list.setVisible(true);
        }
        
         //Action Event de los botones volver de todas las ventanas
        if(e.getSource()==eli.btn_volver_eliminar){
            menu.setVisible(true);
            eli.setVisible(false);
        }else if(e.getSource()==modi.btn_volver_modificar){
            menu.setVisible(true);
            modi.setVisible(false);
        }else if(e.getSource()==list.btn_volver_listar){
            menu.setVisible(true);
            list.setVisible(false);
        }else if(e.getSource()==agre.btn_volver_agregar){
            menu.setVisible(true);
            agre.setVisible(false);
        }
       
    }

    @Override
    public void windowOpened(WindowEvent e) {       
    }

    @Override
    public void windowClosing(WindowEvent we) {
        if(we.getSource()== menu){
            int msje=JOptionPane.showConfirmDialog(menu,"¿DESEA SALIR DE LA APLICACIÓN?", "SALIR", JOptionPane.YES_NO_OPTION);
            if(msje==JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }
        if(we.getSource()== agre){
            int msje=JOptionPane.showConfirmDialog(menu,"¿DESEA SALIR DE LA APLICACIÓN?", "SALIR", JOptionPane.YES_NO_OPTION);
            if(msje==JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }
        if(we.getSource()== modi){
            int msje=JOptionPane.showConfirmDialog(menu,"¿DESEA SALIR DE LA APLICACIÓN?", "SALIR", JOptionPane.YES_NO_OPTION);
            if(msje==JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }
        if(we.getSource()== eli){
            int msje=JOptionPane.showConfirmDialog(menu,"¿DESEA SALIR DE LA APLICACIÓN?", "SALIR", JOptionPane.YES_NO_OPTION);
            if(msje==JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }
        if(we.getSource()== list){
            int msje=JOptionPane.showConfirmDialog(menu,"¿DESEA SALIR DE LA APLICACIÓN?", "SALIR", JOptionPane.YES_NO_OPTION);
            if(msje==JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }
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
    
    //Método para actualizar datos en jTable
    public void actualizarMostrar() {
        try {
            list.tbl_listar.setModel(Cmodel.MostrarEmpleados());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
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
