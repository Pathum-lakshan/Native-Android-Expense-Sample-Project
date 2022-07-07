package com.example.sample4.dao;


import com.example.sample4.dao.custom.impl.ExpenseDAOImpl;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/17/2022
 * Time        : 12:38 AM
 */
public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory=new DAOFactory() : daoFactory;
    }

    public enum DAOTypes{
        EXPENSE
    }

    public SuperDAO getDAO(DAOTypes daoTypes) {
        switch (daoTypes) {
            case EXPENSE:
                return new ExpenseDAOImpl();
            default:
                return null;
        }
    }
}
