package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ConsultasModelo {
    
    Conexion c;
    
    public ConsultasModelo(){
        c= new Conexion();
    }
    
    public boolean agregarEmpleado(Modelo m) {
        try {
            String query = "INSERT INTO contrata.empleados(codigo, rut, nombre, apellido, celular, email, sueldo_bruto, est_civil, nom_depto) VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ins = c.getConexion().prepareStatement(query);
            
            ins.setInt(1, m.getCodigo());
            ins.setString(2, m.getRut());
            ins.setString(3, m.getNombre());
            ins.setString(4, m.getApellido());
            ins.setInt(5, m.getCelular());
            ins.setString(6, m.getEmail());
            ins.setDouble(7, m.getSueldo_bruto());
            ins.setString(8, m.getEst_civil());
            ins.setString(9, m.getNom_depto());
            
            if(ins.executeUpdate()>0){
                return true;
            }
            
            c.close(ins);
        } catch (Exception e) {
            System.out.println("Error al agregar " + e.getMessage());
        }
        return false;
    }
    
    public boolean eliminarEmpleadoporCodigo(int codigo) {
        try {
            String query = "DELETE FROM contrata.empleados WHERE codigo=?";
            PreparedStatement eli = c.getConexion().prepareStatement(query);
            
            eli.setInt(1, codigo);

            if (eli.executeUpdate() > 0) {
                return true;
            }
            
            c.close(eli);
        } catch (Exception e) {
            System.out.println("Error al eliminar " + e.getMessage());
        }
        return false;
    }
    
    public boolean modificarEmpleadoporCodigo(Modelo m) {
        try {
            String query = "UPDATE contrata.empleados SET rut=?, nombre=?, apellido=?, celular=?, email=?, sueldo_bruto=?, est_civil=?, nom_depto=? WHERE codigo=?";
            PreparedStatement mod = c.getConexion().prepareStatement(query);
           
            mod.setString(1, m.getRut());
            mod.setString(2, m.getNombre());
            mod.setString(3, m.getApellido());
            mod.setInt(4, m.getCelular());
            mod.setString(5, m.getEmail());
            mod.setDouble(6, m.getSueldo_bruto());
            mod.setString(7, m.getEst_civil());
            mod.setString(8, m.getNom_depto());
            mod.setInt(9, m.getCodigo());

            if (mod.executeUpdate() > 0) {
                return true;
            }
            
            c.close(mod);
        } catch (Exception e) {
            System.out.println("Error al modificar " + e.getMessage());
        }
        return false;
    }
    
    public DefaultTableModel MostrarEmpleados() throws ClassNotFoundException, SQLException {
        
        DefaultTableModel tablemodel = new DefaultTableModel();
        int registros = 0;
        String[] columNames = {"CODIGO", "RUT", "NOMBRE", "APELLIDO", "CELULAR", "EMAIL", "SUELDO BRUTO", "EST CIVIL", "NOMBRE DEPTO"};
        
        try {
            PreparedStatement pstm = c.getConexion().prepareStatement("SELECT count(*) as total FROM contrata.empleados");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        
        Object[][] data = new String[registros][9];
        try {
            PreparedStatement pstm = c.getConexion().prepareStatement("SELECT codigo, rut, nombre, apellido, celular, email, sueldo_bruto, est_civil, nom_depto FROM contrata.empleados order by codigo ASC");
            ResultSet res = pstm.executeQuery();
            
            int i = 0;
            while (res.next()) {
                data[i][0] = res.getString("codigo");
                data[i][1] = res.getString("rut");
                data[i][2] = res.getString("nombre");
                data[i][3] = res.getString("apellido");
                data[i][4] = res.getString("celular");
                data[i][5] = res.getString("email");
                data[i][6] = res.getString("sueldo_bruto");
                data[i][7] = res.getString("est_civil");
                data[i][8] = res.getString("nom_depto");
                i++;
            }
            
            res.close();
            tablemodel.setDataVector(data, columNames);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return tablemodel;
    }
    
}
