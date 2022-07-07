package com.example.sample4.dao;

import android.content.Context;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author : ALE_IS_TER
 * Project Name: Hostel_Management_System
 * Date        : 6/17/2022
 * Time        : 12:10 AM
 * @Since : 0.1.0
 */

public interface CrudDAO <T,ID> extends SuperDAO{

    ArrayList<T> getAll() ;

    boolean save(T dto, Context context);

    boolean update(T dto);

    T search(ID id);

    boolean exist(ID id);

    boolean delete(ID id);

    int generateNewID();


}
