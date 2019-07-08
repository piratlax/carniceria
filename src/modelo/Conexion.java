package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    Connection link = null;
     
    public Conexion() {
    }

    public Connection conectar() {
        
        try {
            
            link = DriverManager.getConnection("jdbc:sqlite:karsad.db");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Sin poderse conectar a la base de datos "+e);

        }
        return link;
    }
    public void close(){
        try {
            link.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
