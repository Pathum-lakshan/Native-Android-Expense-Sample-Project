package com.example.sample4.bo.custom.impl;

import android.content.Context;
import android.os.Build;

import com.example.sample4.bo.custom.MainActivityBO;
import com.example.sample4.dao.DAOFactory;
import com.example.sample4.dao.custom.ExpenseDAO;
import com.example.sample4.dto.ExpenseDTO;
import com.example.sample4.entity.Expense;

import java.time.LocalDate;

public class MainActivityBOImpl implements MainActivityBO {
    private final ExpenseDAO expenseDAO = (ExpenseDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EXPENSE);
    public boolean saveExpense(ExpenseDTO expenseDTO, Context context){
        LocalDate localDate=null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            localDate= LocalDate.now();
        }

       return expenseDAO.save(new Expense(expenseDTO.getTravelExpense(),expenseDTO.getTravelImage(),expenseDTO.getFuelExpense(),expenseDTO.getFuelImage(),
               expenseDTO.getHighwayChargeExpense(),expenseDTO.getHighwayChargeImage(),expenseDTO.getParkingExpense(),expenseDTO.getParkingImage(),
               expenseDTO.getVehicleServiceExpense(),expenseDTO.getVehicleServiceImage(),expenseDTO.getNightOutExpense(),expenseDTO.getNightOutImage(),expenseDTO.getLunchExpense(),
               expenseDTO.getLunchImage(),localDate
               ),context);

    }
}
