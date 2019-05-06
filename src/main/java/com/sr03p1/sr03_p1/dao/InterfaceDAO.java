package com.sr03p1.sr03_p1.dao;

import java.util.List;

public interface InterfaceDAO<T> {
    List<T> index() throws DAOException;

    void create(T t) throws DAOException;

    T show(String mail) throws DAOException;

    void update(String mail, T t) throws DAOException;

    void delete(String mail) throws DAOException;
}
