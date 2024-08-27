package com.example.possystembackend.bo.custom;

import com.example.possystembackend.bo.SuperBO;
import com.example.possystembackend.dto.OrderDTO;

import java.sql.Connection;

public interface OrderBO extends SuperBO {
    boolean saveOrder(OrderDTO orderDTO, Connection connection);

//    boolean saveOrder(OrderDTO orderDTO, Connection connection);
}
