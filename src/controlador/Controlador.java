package controlador;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import modelo.*;
import vista.*;

public class Controlador implements ActionListener, WindowListener, MouseListener, FocusListener, KeyListener {
    
    Agregar agre;
    Eliminar eli;
    Modificar modi;
    Listar list;
    ListarRedes listR;
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
        
        //Seteo de ventana Listar REDES
        listR = new ListarRedes();
        listR.setTitle("LISTAR TRABAJADORES REDES");
        listR.setLocationRelativeTo(null);
        listR.setResizable(false);
        actualizarMostrarRedes();
        
        //Le agrego un icono a todas las ventanas
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/Icono.png"));
        agre.setIconImage(icon);
        eli.setIconImage(icon);
        menu.setIconImage(icon);
        list.setIconImage(icon);
        modi.setIconImage(icon);
        listR.setIconImage(icon);
        
        //ESTABLEZCO UN COLOR PARA LAS VENTANAS
        menu.getContentPane().setBackground(Color.WHITE);
        agre.getContentPane().setBackground(Color.WHITE);
        eli.getContentPane().setBackground(Color.WHITE);
        modi.getContentPane().setBackground(Color.WHITE);
        list.getContentPane().setBackground(Color.WHITE);
        listR.getContentPane().setBackground(Color.WHITE);
           
        //Escuchas con eventos de Ventana para programar cierres de todas las ventanas
        menu.addWindowListener(this);
        agre.addWindowListener(this);
        eli.addWindowListener(this);
        modi.addWindowListener(this);
        list.addWindowListener(this);
        list.addMouseListener(this);
        list.addFocusListener(this);
        list.addMouseListener(this);
        
        //Escuchas del menu Vista menu Principal
        menu.menu_agregar.addActionListener(this);
        menu.menu_modificar.addActionListener(this);
        menu.menu_eliminar.addActionListener(this);
        menu.menu_listar.addActionListener(this);
        menu.menu_listar_redes.addActionListener(this);
        menu.menu_salir.addActionListener(this);
        //Escuchas del menu Vista Agregar
        agre.menu_agregar.addActionListener(this);
        agre.menu_modificar.addActionListener(this);
        agre.menu_eliminar.addActionListener(this);
        agre.menu_listar.addActionListener(this);
        agre.menu_listar_redes.addActionListener(this);
        agre.menu_salir.addActionListener(this);
        agre.btn_limpiar.addActionListener(this);
        
        agre.txtrut.addFocusListener(this);
        agre.txtemail.addFocusListener(this);
        agre.txtcelular.addFocusListener(this);
        
        //Escuchas del menu Vista Eliminar
        eli.menu_agregar.addActionListener(this);
        eli.menu_modificar.addActionListener(this);
        eli.menu_eliminar.addActionListener(this);
        eli.menu_listar.addActionListener(this);
        eli.menu_listar_redes.addActionListener(this);
        eli.menu_salir.addActionListener(this);
        eli.btn_limpiar.addActionListener(this);
        //Escuchas del menu Vista Modificar
        modi.menu_agregar.addActionListener(this);
        modi.menu_modificar.addActionListener(this);
        modi.menu_eliminar.addActionListener(this);
        modi.menu_listar.addActionListener(this);
        modi.menu_listar_redes.addActionListener(this);
        modi.menu_salir.addActionListener(this);
        modi.btn_limpiar.addActionListener(this);
        //Escuchas del menu Vista Listar
        list.menu_agregar.addActionListener(this);
        list.menu_modificar.addActionListener(this);
        list.menu_eliminar.addActionListener(this);
        list.menu_listar.addActionListener(this);
        list.menu_listar_redes.addActionListener(this);
        list.menu_salir.addActionListener(this);
        list.btn_eliminar120000.addActionListener(this);
        list.btn_aumentar10.addActionListener(this);
                
        
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
        listR.btn_volver_listar.addActionListener(this);
        
        //METODOS PARA LA VENTANA AGREGAR
        validarSoloNumeros(agre.txtcodigo);
        validarSoloNumeros(agre.txtcelular);
        validarSoloNumeros(agre.txtsueldobruto);
        validarSoloNumeros(agre.txtrut);
        validarSoloLetras(agre.txtnombre);
        validarSoloLetras(agre.txtapellido);
        LimitarCaracteres(agre.txtcodigo, 3);
        LimitarCaracteres(agre.txtcelular, 9);
        LimitarCaracteres(agre.txtsueldobruto, 7);
        LimitarCaracteres(agre.txtrut, 9);
        LimitarCaracteres(agre.txtnombre, 20);
        LimitarCaracteres(agre.txtapellido, 20);
        LimitarCaracteres(agre.txtemail, 30);
        
        //METODOS PARA LA VENTANA MODIFICAR
        validarSoloNumeros(modi.txtcodigo);
        validarSoloNumeros(modi.txtcelular);
        validarSoloNumeros(modi.txtsueldobruto);
        validarSoloLetras(modi.txtnombre);
        validarSoloLetras(modi.txtapellido);
        LimitarCaracteres(modi.txtcodigo, 3);
        LimitarCaracteres(modi.txtcelular, 9);
        LimitarCaracteres(modi.txtsueldobruto, 7);
        LimitarCaracteres(modi.txtrut, 9);
        LimitarCaracteres(modi.txtnombre, 20);
        LimitarCaracteres(modi.txtapellido, 20);
        LimitarCaracteres(modi.txtemail, 30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //BOTON QUE PERMITE AUMENTAR SUELDOS EN UN 10%
        if(e.getSource()==list.btn_aumentar10){
            int msje=JOptionPane.showConfirmDialog(list,"¿ESTA SEGURO QUE DESEA AUMENTAR EL SUELDO EN UN 10% A TODOS LOS TRABAJADORES?", "AUMENTAR", JOptionPane.YES_NO_OPTION);
            if(msje==JOptionPane.YES_OPTION){
                Cmodel.aumentar10();
            }
        }
        
        //BOTON QUE PERMITE ELIMINAR EMPLEADOS CON SUELDOS IGUAL A 120000
        if(e.getSource()==list.btn_eliminar120000){
           Cmodel.eliminarSueldo120();
        }
        
        //EVENTOS DE LOS BOTONES LIMPIAR CASILLAS, DEJANDO EL CURSOR EN JTEXTFIELD CODIGO
        if(e.getSource()==agre.btn_limpiar){
            limpiarcamposagregar();
        }
        if(e.getSource()==eli.btn_limpiar){
            limpiarcamposeliminar();
        }
        if(e.getSource()==modi.btn_limpiar){
            limpiarcamposmodificar();
        }
        //1
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
        if(e.getSource()==menu.menu_listar_redes){
            menu.setVisible(false);
            listR.setVisible(true);
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
        if(e.getSource()==eli.menu_listar_redes){
            eli.setVisible(false);
            listR.setVisible(true);
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
        if(e.getSource()==modi.menu_listar_redes){
            modi.setVisible(false);
            listR.setVisible(true);
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
        if(e.getSource()==list.menu_listar_redes){
            list.setVisible(false);
            listR.setVisible(true);
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
        if(e.getSource()==agre.menu_listar_redes){
            agre.setVisible(false);
            listR.setVisible(true);
        }
        
         //Action Event de los botones volver de todas las ventanas
        if(e.getSource()==eli.btn_volver_eliminar){
            menu.setVisible(true);
            eli.setVisible(false);
            limpiarcamposeliminar();
        }else if(e.getSource()==modi.btn_volver_modificar){
            menu.setVisible(true);
            modi.setVisible(false);
            limpiarcamposmodificar();
        }else if(e.getSource()==list.btn_volver_listar){
            menu.setVisible(true);
            list.setVisible(false);
        }else if(e.getSource()==listR.btn_volver_listar){
            menu.setVisible(true);
            listR.setVisible(false);
        }else if(e.getSource()==agre.btn_volver_agregar){
            menu.setVisible(true);
            agre.setVisible(false);
            limpiarcamposagregar();
        }
        
        //Action Event de LOS BOTONES BUSCAR POR CODIGO de las vistas Eliminar y Modificar
        if(e.getSource()==eli.btnbuscar_eliminar){
            try {
                System.out.println("Buscar codigo a eliminar");
                int codigo =Integer.parseInt(eli.txtcodigo.getText().trim());

                Modelo model = Cmodel.buscarPeliculaporCodigo(codigo);

                if(model==null){
                    JOptionPane.showMessageDialog(eli, "NO HAY REGISTROS PARA EL CODIGO "+codigo, "ERROR", JOptionPane.WARNING_MESSAGE);
                //limpiarPestañabuscar();
                }else{
                
                    eli.txtnombre.setText(model.getNombre());
                    eli.txtnombre.setEditable(false);
                    eli.txtapellido.setText(model.getApellido());
                    eli.txtapellido.setEditable(false);
                    eli.txtrut.setText(model.getRut());
                    eli.txtrut.setEnabled(false);
                    eli.txtcelular.setText(String.valueOf(model.getCelular()));
                    eli.txtcelular.setEditable(false);
                    eli.txtsueldobruto.setText(String.valueOf(model.getSueldo_bruto()));
                    eli.txtsueldobruto.setEditable(false);
                    eli.txtemail.setText(model.getEmail());
                    eli.txtemail.setEditable(false);
                    eli.cbestadocivil.setSelectedItem(model.getEst_civil());
                    eli.cbestadocivil.setEditable(false);
                    eli.cbdepartamento.setSelectedItem(model.getNom_depto());
                    eli.cbdepartamento.setEditable(false);
                
                }  
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(eli, "DEBE INGRESAR EL CÓDIGO A ELIMINAR", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if(e.getSource()==modi.btnbuscar_modificar){
            try {
                System.out.println("Buscar codigo a modificar");
                int codigo =Integer.parseInt(modi.txtcodigo.getText().trim());

                Modelo model = Cmodel.buscarPeliculaporCodigo(codigo);

                if(model==null){
                    JOptionPane.showMessageDialog(modi, "NO HAY REGISTROS PARA EL CODIGO "+codigo, "ERROR", JOptionPane.WARNING_MESSAGE);
                //limpiarPestañabuscar();
                }else{
                
                    modi.txtnombre.setText(model.getNombre());
                    modi.txtapellido.setText(model.getApellido());
                    modi.txtrut.setText(model.getRut());
                    modi.txtcelular.setText(String.valueOf(model.getCelular()));
                    modi.txtsueldobruto.setText(String.valueOf(model.getSueldo_bruto()));
                    modi.txtemail.setText(model.getEmail());
                    modi.cbestadocivil.setSelectedItem(model.getEst_civil());
                    modi.cbdepartamento.setSelectedItem(model.getNom_depto());
                
                }  
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(modi, "DEBE INGRESAR EL CÓDIGO A MODIFICAR", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        //Action Event del botón eliminar
        if(e.getSource()==eli.btneliminar){
            try {
                System.out.println("Eliminar");
                int codigo = Integer.parseInt(eli.txtcodigo.getText());
                int msje=JOptionPane.showConfirmDialog(eli,"¿ESTÁ SEGURO QUE DESEA ELIMINAR EL CÓDIGO " + codigo +" ?", "SALIR", JOptionPane.YES_NO_OPTION);
                        if(msje==JOptionPane.YES_OPTION){
                            if(Cmodel.eliminarEmpleadoporCodigo(codigo)){
                            JOptionPane.showMessageDialog(eli, "REGISTRO ELIMINADO EXITOSAMENTE", "ELIMINAR", JOptionPane.INFORMATION_MESSAGE);
                            }else if (Cmodel.buscarPeliculaporCodigo(codigo) == null){
                                JOptionPane.showMessageDialog(eli, "CODIGO " + codigo + " NO EXISTE", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }else{
                                JOptionPane.showMessageDialog(eli, "NO SE HA PODIDO ELIMINAR", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        } 
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(eli, "NO HAY NADA SELECCIONADO PARA ELIMINAR", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            limpiarcamposeliminar();
        }
        
        //Action Event del Boton Agregar
        if(e.getSource()==agre.btnagregar){
            //VALIDACIONES
            if(agre.txtcodigo.getText().isEmpty()){
                JOptionPane.showMessageDialog(agre, "CÓDIGO no puede quedar en blanco", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else if((Integer.parseInt(agre.txtcodigo.getText().trim())<0) || (Integer.parseInt(agre.txtcodigo.getText().trim())==0)){
                JOptionPane.showMessageDialog(agre, "CÓDIGO debe ser MAYOR a 0", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else if((Integer.parseInt(agre.txtcodigo.getText().trim())>100)){
                JOptionPane.showMessageDialog(agre, "CÓDIGO debe ser MENOR a 100", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else if(agre.txtrut.getText().isEmpty()){
                JOptionPane.showMessageDialog(agre, "RUT no puede quedar en blanco", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else if(agre.txtrut.getText().length()<8){
                JOptionPane.showMessageDialog(agre, "RUT no puede poseer menos de 8 dígitos", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else if(agre.txtnombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(agre, "NOMBRE no puede quedar en blanco", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else if(agre.txtapellido.getText().isEmpty()){
                JOptionPane.showMessageDialog(agre, "APELLIDO no puede quedar en blanco", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else if(agre.txtcelular.getText().isEmpty()){
                JOptionPane.showMessageDialog(agre, "CELULAR no puede quedar en blanco", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else if(agre.txtcelular.getText().length()<9){
                JOptionPane.showMessageDialog(agre, "NUMERO DE CELULAR debe poseer 9 dígitos", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else if(agre.txtcelular.getText().length()>9){
                JOptionPane.showMessageDialog(agre, "NUMERO DE CELULAR debe poseer 9 dígitos", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else if(agre.txtemail.getText().isEmpty()){
                JOptionPane.showMessageDialog(agre, "EMAIL no debe quedar vacío", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else if(agre.txtsueldobruto.getText().isEmpty()){
                JOptionPane.showMessageDialog(agre, "SUELDO no debe quedar en blanco", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else if((Double.parseDouble(agre.txtsueldobruto.getText().trim())<120000)){
                JOptionPane.showMessageDialog(agre, "SUELDO BRUTO debe ser MAYOR O IGUAL A a $120.000", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else if(agre.cbestadocivil.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(agre, "Debe asignar un ESTADO CIVIL", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else if(agre.cbdepartamento.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(agre, "Debe asignar un DEPARTAMENTO", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else{
                //ACCIÓN DE AGREGAR UN NUEVO REGISTRO PREVIO HABER PASADO LAS VALIDACIONES
                try {
                    System.out.println("agregar");
                    model = new Modelo();
                    model.setCodigo(Integer.parseInt(agre.txtcodigo.getText().trim()));
                    model.setCelular(Integer.parseInt(agre.txtcelular.getText().trim()));
                    model.setNombre(agre.txtnombre.getText().trim());
                    model.setRut(agre.txtrut.getText().trim());
                    model.setApellido(agre.txtapellido.getText().trim());
                    model.setEmail(agre.txtemail.getText().trim());
                    model.setEst_civil(agre.cbestadocivil.getSelectedItem().toString().trim());
                    model.setNom_depto(agre.cbdepartamento.getSelectedItem().toString().trim());
                    model.setSueldo_bruto(Double.parseDouble(agre.txtsueldobruto.getText().trim()));
                   
                    if(Cmodel.agregarEmpleado(model)){
                        JOptionPane.showMessageDialog(agre, "REGISTRO AGREGADO EXITOSAMENTE", "AGREGAR EMPLEADO", JOptionPane.INFORMATION_MESSAGE);
                        limpiarcamposagregar();
                    }else if(Cmodel.agregarEmpleado(model) == Cmodel.agregarEmpleado(model)){
                        JOptionPane.showMessageDialog(agre, "CODIGO " + (Integer.parseInt(agre.txtcodigo.getText().trim())) + " YA HA SIDO INGRESADO, PRUEBE CON OTRO", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(agre, "NO SE PUDO AGREGAR EL PRODUCTO", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(agre, "AUN FALTAN DATOS POR INGRESAR", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
               
        }
        
        if(e.getSource()==modi.btnmodificar){
            //VALIDACIONES
            if (modi.txtcodigo.getText().length()==0){
                 try {
                    int codigo = Integer.parseInt(modi.txtcodigo.getText());
                    if (Cmodel.buscarPeliculaporCodigo(codigo) == null){
                        JOptionPane.showMessageDialog(modi, "CODIGO " + codigo + " NO EXISTE", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(modi, "AUN FALTAN DATOS POR INGRESAR", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            if(modi.txtcodigo.getText().length()==0){
                JOptionPane.showMessageDialog(modi, "CÓDIGO no puede quedar vacío", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else if((Integer.parseInt(modi.txtcodigo.getText().trim())<0) || (Integer.parseInt(modi.txtcodigo.getText().trim())==0)){
                JOptionPane.showMessageDialog(modi, "CÓDIGO debe ser MAYOR a 0", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else if((Integer.parseInt(modi.txtcodigo.getText().trim())>100)){
                JOptionPane.showMessageDialog(modi, "CÓDIGO debe ser MENOR a 100", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else if(modi.txtrut.getText().length()==0){
                JOptionPane.showMessageDialog(modi, "RUT no puede quedar en blanco", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else if(modi.txtnombre.getText().length()==0){
                JOptionPane.showMessageDialog(modi, "NOMBRE no puede quedar en blanco", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else if(modi.txtapellido.getText().length()==0){
                JOptionPane.showMessageDialog(modi, "APELLIDO no puede quedar en blanco", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else if(modi.txtcelular.getText().length()==0){
                JOptionPane.showMessageDialog(modi, "CELULAR no puede quedar en blanco", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else if(modi.txtcelular.getText().length()<9){
                JOptionPane.showMessageDialog(modi, "NUMERO DE CELULAR debe poseer 9 dígitos", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else if(modi.txtcelular.getText().length()>9){
                JOptionPane.showMessageDialog(modi, "NUMERO DE CELULAR debe poseer 9 dígitos", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else if(modi.txtemail.getText().length()==0){
                JOptionPane.showMessageDialog(modi, "EMAIL no debe quedar vacío", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else if(modi.txtsueldobruto.getText().length()==0){
                JOptionPane.showMessageDialog(modi, "SUELDO no debe quedar en blanco", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else if((Double.parseDouble(modi.txtsueldobruto.getText().trim())<120000)){
                JOptionPane.showMessageDialog(modi, "SUELDO BRUTO debe ser MAYOR O IGUAL A a $120.000", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else if(modi.cbestadocivil.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(modi, "Debe asignar un ESTADO CIVIL", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else if(modi.cbdepartamento.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(modi, "Debe asignar un DEPARTAMENTO", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else{
                //ACCIÓN DE MODIFICAR UN REGISTRO PREVIO HABER PASADO LAS VALIDACIONES
                try {
                    System.out.println("modificar");
                    model = new Modelo();
                    model.setCodigo(Integer.parseInt(modi.txtcodigo.getText().trim()));
                    model.setCelular(Integer.parseInt(modi.txtcelular.getText().trim()));
                    model.setNombre(modi.txtnombre.getText().trim());
                    model.setRut(modi.txtrut.getText().trim());
                    model.setApellido(modi.txtapellido.getText().trim());
                    model.setEmail(modi.txtemail.getText().trim());
                    model.setEst_civil(modi.cbestadocivil.getSelectedItem().toString().trim());
                    model.setNom_depto(modi.cbdepartamento.getSelectedItem().toString().trim());
                    model.setSueldo_bruto(Double.parseDouble(modi.txtsueldobruto.getText().trim()));
                   
                    if(Cmodel.modificarEmpleadoporCodigo(model)){
                        JOptionPane.showMessageDialog(modi, "REGISTRO MODIFICADO", "AGREGAR EMPLEADO", JOptionPane.INFORMATION_MESSAGE);
                        limpiarcamposmodificar();
                    }else{
                        JOptionPane.showMessageDialog(modi, "NO SE PUDO MODIFICAR", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(modi, "AUN FALTAN DATOS POR INGRESAR", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }       
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
    public void focusGained(FocusEvent fe) {
        if(fe.getSource()==list){
            actualizarMostrar();
        }
    }

    @Override
    public void focusLost(FocusEvent fe) {
        
        if(fe.getSource()==agre.txtrut){
            try {
                while(agre.txtrut.getText().length()==9){
                    String frase=agre.txtrut.getText();
                    agre.txtrut.setText(frase.substring(0, 2)+'.'+frase.substring(2, 5)+'.'+frase.substring(5, 8)+'-'+frase.substring(8, 9));
                }
                while(agre.txtrut.getText().length()==8){
                    String frase=agre.txtrut.getText();
                    agre.txtrut.setText(frase.substring(0, 1)+'.'+frase.substring(1, 4)+'.'+frase.substring(4, 7)+'-'+frase.substring(7, 8));
                }
                if(agre.txtrut.getText().length()<8){
                    JOptionPane.showMessageDialog(agre, "RUT no puede poseer menos de 8 dígitos", "ERROR", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception e) {
                System.out.println(e);
            }     
        }
        
        if(fe.getSource()==agre.txtemail){
            int arroba=0;
            boolean punto=false;
            String mail = agre.txtemail.getText().trim();
                for (int i=0;i<mail.length(); i++) {		
			if(mail.charAt(i)=='@') {
				arroba++;	
			}
			if(mail.charAt(i)=='.') {
				punto=true;	
			}			
		}		
		if (arroba==1 && punto==true) {
                    System.out.println("Email medianamente correcto, faltan validaciones");	
		}
		else {
                    JOptionPane.showMessageDialog(agre, "EMAIL no es correcto. Debe llevar una arroba ('@') y al menos un punto('.')", "VALIDACIÓN EMAIL", JOptionPane.WARNING_MESSAGE);
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
    public void mouseEntered(MouseEvent me) {
        if(me.getSource()==list){
            actualizarMostrar();
        }
        if(me.getSource()==listR){
            actualizarMostrarRedes();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {    
    }

    @Override
    public void keyPressed(KeyEvent ke) {    
    }

    @Override
    public void keyReleased(KeyEvent ke) {   
    }
    
    //Métodos Para limpiar Pestañas
    private void limpiarcamposagregar(){
        agre.txtcodigo.setText("");
        agre.txtnombre.setText("");
        agre.cbdepartamento.setSelectedIndex(0);
        agre.cbestadocivil.setSelectedIndex(0);
        agre.txtapellido.setText("");
        agre.txtrut.setText("");
        agre.txtcelular.setText("");
        agre.txtemail.setText("");
        agre.txtsueldobruto.setText("");
        agre.txtcodigo.grabFocus();
    }
    
    private void limpiarcamposeliminar(){
        eli.txtcodigo.setText("");
        eli.txtnombre.setText("");
        eli.cbdepartamento.setSelectedIndex(0);
        eli.cbestadocivil.setSelectedIndex(0);
        eli.txtapellido.setText("");
        eli.txtrut.setText("");
        eli.txtcelular.setText("");
        eli.txtemail.setText("");
        eli.txtsueldobruto.setText("");
        eli.txtcodigo.grabFocus();
    }
    
    private void limpiarcamposmodificar(){
        modi.txtcodigo.setText("");
        modi.txtnombre.setText("");
        modi.cbdepartamento.setSelectedIndex(0);
        modi.cbestadocivil.setSelectedIndex(0);
        modi.txtapellido.setText("");
        modi.txtrut.setText("");
        modi.txtcelular.setText("");
        modi.txtemail.setText("");
        modi.txtsueldobruto.setText("");
        modi.txtcodigo.grabFocus();
    }
    
    //Método para actualizar datos en jTable
    public void actualizarMostrar() {
        try {
            list.tbl_listar.setModel(Cmodel.MostrarEmpleados());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarMostrarRedes() {
        try {
            listR.tbl_listar_redes.setModel(Cmodel.MostrarEmpleadosRedes());
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
