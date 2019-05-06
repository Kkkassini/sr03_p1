package com.sr03p1.sr03_p1.dao;

import static com.sr03p1.sr03_p1.Config.ConfigConnection.initialisationRequetePreparee;
import static com.sr03p1.sr03_p1.dao.UtilityDAO.fermeturesSilencieuses;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sr03p1.sr03_p1.Config.ConfigConnection;
import com.sr03p1.sr03_p1.model.User;



public class UserDAO implements InterfaceDAO<User> {

    private static final String SQL_SELECT_ALL = "SELECT * FROM user";
    private static final String SQL_SELECT_BY_MAIL = "SELECT * FROM user WHERE user.mail = ?";
    private static final String SQL_INSERT = "INSERT INTO user (mail, password, name, company, phone, creationDate, is_Admin, is_Active) VALUES (?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE user SET password=?, name=?, company=?, phone=?, creationDate=?, is_Admin=? ,is_Active=? WHERE mail=?";
    private static final String SQL_SOFT_DELETE = "UPDATE user SET isActive = 0 WHERE mail = ?";

    public UserDAO() {}


    @Override
    public List<User> index() throws DAOException {
        ArrayList users = new ArrayList();

        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connexion = ConfigConnection.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);

            while (resultSet.next()) {
                users.add(map(resultSet));
            }
            if ( resultSet.next() ) {
                System.out.println(resultSet);
                //user = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return users;
    }

    @Override
    public void create(User user) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connexion = ConfigConnection.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, user.getMail(), user.getPassword(), user.getName(),
                    user.getCompany(), user.getPhone(), user.getCreationDate(), user.getIsAdmin(), user.getIsActive() );
            int status = preparedStatement.executeUpdate();
            System.out.println(status);

        } catch ( SQLException e ) {
            throw new DAOException(e);
        } catch ( ClassNotFoundException e){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
    }

    @Override
    public User show(String mail) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;

        try {
            connexion = ConfigConnection.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_BY_MAIL, false, mail );
            resultSet = preparedStatement.executeQuery();
            if ( resultSet.next() ) {
                user = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }

        return user;
    }

    @Override
    public void update(String mail, User user) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connexion = ConfigConnection.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_UPDATE, true, user.getMail(), user.getName(), user.getCompany(),
                    user.getPhone(), user.getCreationDate(), user.getIsAdmin(), user.getIsActive(), mail );
            int status = preparedStatement.executeUpdate();
            System.out.println(status);

        } catch ( SQLException e ) {
            throw new DAOException( e );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
    }

    @Override
    public void delete(String mail) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connexion = ConfigConnection.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_SOFT_DELETE, true, mail );
            int status = preparedStatement.executeUpdate();
            System.out.println(status);

        } catch ( SQLException e ) {
            throw new DAOException( e );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
    }

    private static User map(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setMail(resultSet.getString("mail"));
        user.setPassword(resultSet.getString("password"));
        user.setName(resultSet.getString("name"));
        user.setCompany(resultSet.getString("company"));
        user.setCreationDate(resultSet.getString("creationDate"));
        user.setIsAdmin(resultSet.getInt("isAdmin"));
        user.setIsActive(resultSet.getInt("isActive"));


        return user;
    }
}
