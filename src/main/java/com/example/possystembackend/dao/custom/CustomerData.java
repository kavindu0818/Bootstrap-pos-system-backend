package com.example.possystembackend.dao.custom;

import com.example.possystembackend.dao.CrudDAO;
import com.example.possystembackend.entity.Customer;

import java.sql.Connection;
import java.util.List;

public interface CustomerData extends CrudDAO<Customer> {
    boolean save(Customer entity, Connection connection);

    List<Customer> getAll(Connection connection);

    boolean update(Customer entity, String Id, Connection connection);

    boolean isExists(String id, Connection connection);

    boolean delete(String id, Connection connection);

    Customer get(String id, Connection connection);
}
