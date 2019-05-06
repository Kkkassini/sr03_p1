package com.sr03p1.sr03_p1.Config;

import com.sr03p1.sr03_p1.dao.InterfaceDAO;
import com.sr03p1.sr03_p1.dao.UserDAO;
import com.sr03p1.sr03_p1.model.User;

import java.sql.*;

public class ConfigConnection {
    private static String url = "";
    private static final String username = "root";
    private static final String password = "";

    public ConfigConnection(){ ConfigConnection.url = "jdbc:mysql://127.0.0.1:8889/sr03"; }


    public static PreparedStatement initialisationRequetePreparee(Connection connexion, String sql, boolean returnGeneratedKeys, Object... objets ) throws SQLException {
        PreparedStatement preparedStatement = connexion.prepareStatement( sql, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS );
        for ( int i = 0; i < objets.length; i++ ) {
            preparedStatement.setObject( i + 1, objets[i] );
        }
        return preparedStatement;
    }


    /**
     * Open connection to the database
     * @return
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(ConfigConnection.url, ConfigConnection.username, ConfigConnection.password);
    }

}
