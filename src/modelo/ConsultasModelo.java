package modelo;

import java.sql.PreparedStatement;

public class ConsultasModelo {
    
    Conexion c;
    
    public ConsultasModelo(){
        c= new Conexion();
    }
    
    public boolean agregarPelicula(Modelo m) {
        try {
            String query = "INSERT INTO empleados(codigo, rut, nombre, apellido, celular, email, sueldo_bruto, est_civil, nom_depto) VALUES(?,?,?,?,?,?,?,?,?)";
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
    
}
