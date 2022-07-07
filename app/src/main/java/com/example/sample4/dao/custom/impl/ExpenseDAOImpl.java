package com.example.sample4.dao.custom.impl;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;

import com.example.sample4.MainActivity;
import com.example.sample4.dao.custom.ExpenseDAO;
import com.example.sample4.db.DBHandler;
import com.example.sample4.entity.Expense;
import com.example.sample4.util.DbBitmapUtility;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExpenseDAOImpl implements ExpenseDAO {


    DBHandler dbHandler;



    @Override
    public ArrayList<Expense> getAll()  {
        return null;
    }

  @Override
    public boolean save(Expense expense, Context context) {
        dbHandler = new DBHandler(context);

        dbHandler.setExpense(expense);

        return true;
    }


    @Override
    public boolean update(Expense dto)  {
        return false;
    }

    @Override
    public Expense search(String s)  {
        return null;
    }

    @Override
    public boolean exist(String s) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public int generateNewID() {
        return 0;
    }
}
