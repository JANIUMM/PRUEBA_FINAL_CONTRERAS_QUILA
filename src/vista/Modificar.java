
package vista;

public class Modificar extends javax.swing.JFrame {

    public Modificar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtsueldobruto = new javax.swing.JTextField();
        txtcelular = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtcodigo = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtrut = new javax.swing.JTextField();
        cbestadocivil = new javax.swing.JComboBox<>();
        cbdepartamento = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnmodificar = new javax.swing.JButton();
        btn_volver_modificar = new javax.swing.JButton();
        btnbuscar_modificar = new javax.swing.JButton();
        MenuPrincipal = new javax.swing.JMenuBar();
        menu_opciones = new javax.swing.JMenu();
        menu_agregar = new javax.swing.JMenuItem();
        menu_eliminar = new javax.swing.JMenuItem();
        menu_modificar = new javax.swing.JMenuItem();
        menu_salir = new javax.swing.JMenuItem();
        menu_catalogo = new javax.swing.JMenu();
        menu_listar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("MODIFICAR");

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabel1.setText("MODIFICAR DATOS EMPLEADOS");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jLabel2.setText("Código");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jLabel3.setText("Rut");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jLabel4.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jLabel5.setText("Apellido");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jLabel6.setText("Celular");

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jLabel7.setText("Email");

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jLabel8.setText("Sueldo Bruto");

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jLabel9.setText("Estado Civil");

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jLabel10.setText("Nombre Depto.");

        txtsueldobruto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtcelular.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtnombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtcodigo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtemail.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtapellido.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtrut.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbestadocivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "S", "C", "V" }));
        cbestadocivil.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        cbdepartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Informatica", "Redes", "Administracion", "Finanzas", "Bienestar" }));
        cbdepartamento.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 1, 10)); // NOI18N
        jLabel11.setText("S= Soltero");

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 1, 10)); // NOI18N
        jLabel12.setText("C = Casado");

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 1, 10)); // NOI18N
        jLabel13.setText("V = Viudo");

        btnmodificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnmodificar.setText("MODIFICAR");
        btnmodificar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_volver_modificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_volver_modificar.setText("VOLVER");
        btn_volver_modificar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnbuscar_modificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnbuscar_modificar.setText("CARGAR CODIGO");
        btnbuscar_modificar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        menu_opciones.setText("OPCIONES");

        menu_agregar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        menu_agregar.setText("Agregar Empleado");
        menu_opciones.add(menu_agregar);

        menu_eliminar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        menu_eliminar.setText("Eliminar Empleado");
        menu_opciones.add(menu_eliminar);

        menu_modificar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        menu_modificar.setText("Modificar Empleado");
        menu_opciones.add(menu_modificar);

        menu_salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menu_salir.setText("Salir");
        menu_opciones.add(menu_salir);

        MenuPrincipal.add(menu_opciones);

        menu_catalogo.setText("LISTA EMPLEADOS");

        menu_listar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        menu_listar.setText("Listar Empleados");
        menu_catalogo.add(menu_listar);

        MenuPrincipal.add(menu_catalogo);

        setJMenuBar(MenuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8)
                        .addGap(10, 10, 10)
                        .addComponent(txtsueldobruto, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(jLabel7)
                        .addGap(51, 51, 51)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(cbdepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(cbestadocivil, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(444, 444, 444)
                        .addComponent(jLabel11)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel12)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel13))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(btnmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127)
                        .addComponent(btn_volver_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(38, 38, 38)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(33, 33, 33)
                                .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(43, 43, 43)
                                .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnbuscar_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(42, 42, 42)
                                .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addComponent(jLabel3)
                                .addGap(60, 60, 60)
                                .addComponent(txtrut, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnbuscar_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel5))
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtrut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel3))
                            .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtsueldobruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel7))
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbdepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbestadocivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btn_volver_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modificar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuBar MenuPrincipal;
    public javax.swing.JButton btn_volver_modificar;
    public javax.swing.JButton btnbuscar_modificar;
    public javax.swing.JButton btnmodificar;
    public javax.swing.JComboBox<String> cbdepartamento;
    public javax.swing.JComboBox<String> cbestadocivil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JMenuItem menu_agregar;
    public javax.swing.JMenu menu_catalogo;
    public javax.swing.JMenuItem menu_eliminar;
    public javax.swing.JMenuItem menu_listar;
    public javax.swing.JMenuItem menu_modificar;
    public javax.swing.JMenu menu_opciones;
    public javax.swing.JMenuItem menu_salir;
    public javax.swing.JTextField txtapellido;
    public javax.swing.JTextField txtcelular;
    public javax.swing.JTextField txtcodigo;
    public javax.swing.JTextField txtemail;
    public javax.swing.JTextField txtnombre;
    public javax.swing.JTextField txtrut;
    public javax.swing.JTextField txtsueldobruto;
    // End of variables declaration//GEN-END:variables
}
