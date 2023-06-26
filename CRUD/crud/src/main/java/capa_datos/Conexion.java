package capa_datos;

/**
 * Importación de paquetes y clases necesarias.
 */
import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 * La clase Conexion proporciona métodos para establecer y obtener una conexión a una base de datos MySQL.
 */
public class Conexion {
    
    // Declacion e inicializacion de las variables necesarias para la conexion
    static final String URL = "jdbc:mysql://localhost:3306/crud";
    static final String USER = "root";
    static final String PASSWORD = "root";
    
    
    /**
     * Obtiene un objeto DataSource configurado con la información de conexión a la base de datos.
     *
     * @return Un objeto DataSource configurado con la URL, usuario y contraseña.
     */
    public static DataSource getDataSource(){
        BasicDataSource bds = new BasicDataSource();
        
        bds.setUrl(URL);
        bds.setUsername(USER);
        bds.setPassword(PASSWORD);
        
        bds.setInitialSize(5);
        
        return bds;
    }
    
    /**
     * Obtiene una conexión a la base de datos utilizando el objeto DataSource configurado.
     *
     * @return Una conexión a la base de datos MySQL.
     * @throws SQLException Si ocurre un error al obtener la conexión.
     */
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
      
}

