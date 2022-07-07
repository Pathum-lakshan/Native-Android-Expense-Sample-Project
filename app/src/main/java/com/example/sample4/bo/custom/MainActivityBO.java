package com.example.sample4.bo.custom;

import android.content.Context;

import com.example.sample4.bo.SuperBO;
import com.example.sample4.dto.ExpenseDTO;

public interface MainActivityBO extends SuperBO {
    boolean saveExpense(ExpenseDTO expenseDTO, Context context);
}
