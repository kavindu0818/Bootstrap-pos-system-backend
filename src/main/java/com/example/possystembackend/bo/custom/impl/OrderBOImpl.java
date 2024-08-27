package com.example.possystembackend.bo.custom.impl;

import com.example.possystembackend.bo.custom.OrderBO;
import com.example.possystembackend.dao.DAOFactory;
import com.example.possystembackend.dao.custom.OrderData;
import com.example.possystembackend.dto.ItemDTO;
import com.example.possystembackend.dto.OrderDTO;
import com.example.possystembackend.entity.Item;
import com.example.possystembackend.entity.Order;
import com.example.possystembackend.entity.OrderDetail;

import java.sql.Connection;

public class OrderBOImpl implements OrderBO {

    OrderData orderData= (OrderData) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOType.ORDER);

    @Override
    public boolean saveOrder(OrderDTO orderDTO, Connection connection) {
        Order order = new Order();
        order.setOrderId(orderDTO.getOrderId());
        order.setOrderDate(orderDTO.getOrderDate());
        order.setCusIdOption(orderDTO.getCusIdOption());
        order.setItemIdOption(orderDTO.getItemIdOption());
        order.setOrderQty(orderDTO.getOrderQty());
        order.setTotal(orderDTO.getTotal());
        order.setTxtCash(orderDTO.getTxtCash());
        order.setTxtDiscount(orderDTO.getTxtDiscount());

        for (ItemDTO itemDTO : orderDTO.getItems()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setItem(new Item(itemDTO.getId(), itemDTO.getName(), itemDTO.getPrice(), itemDTO.getQty()));
            orderDetail.setOrderQty(orderDTO.getOrderQty());
            orderDetail.setItemPrice(itemDTO.getPrice());
            order.getOrderDetails().add(orderDetail);
        }

        boolean save = orderData.save(order, connection);
        if (save) {
            return true;
        }else {
            return false;
        }
    }
}
