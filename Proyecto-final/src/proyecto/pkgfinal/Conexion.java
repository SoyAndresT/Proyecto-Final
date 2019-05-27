package proyecto.pkgfinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    private static Connection conn;
    private static final String driver="com.mysql.jdbc.Driver"; 
    private  static String user="root";
    private static  String password="";
    private static String url="jdbc:mysql://localhost:3306/inventario";
    
    public Conexion() {
        this.conn= null;
        try { 
            Class.forName(driver);
            this.conn=DriverManager.getConnection(this.url, this.user, this.password);
        if(this.conn !=null){
                System.out.println("Coneccion establecida...");
        }
        }catch(ClassNotFoundException | SQLException e){
            System.err.println("error al conectar..."+ e);
        }
    }
    
    public Connection getConnection(){
        return this.conn;
    }
    public void cerraConexion(){
        try {
            this.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

