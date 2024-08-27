package com.example.possystembackend.bo.custom;

import com.example.possystembackend.bo.SuperBO;
import com.example.possystembackend.dto.UserDTO;

import java.sql.Connection;

public interface UserBO extends SuperBO {
    boolean saveUser(UserDTO userDTO, Connection connection);

//    boolean saveUser(UserDTO userDTO, Connection connection);

    boolean isExistsUser(String id, String password, Connection connection);
}
