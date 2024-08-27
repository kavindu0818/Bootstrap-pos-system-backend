package com.example.possystembackend.dao.custom;

import com.example.possystembackend.dao.CrudDAO;
import com.example.possystembackend.entity.User;

import java.sql.Connection;

public interface UserData extends CrudDAO<User> {
    boolean isExistsUser(String email, String password, Connection connection);
}
