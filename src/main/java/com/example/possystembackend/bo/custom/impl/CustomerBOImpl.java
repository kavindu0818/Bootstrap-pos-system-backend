package com.example.possystembackend.bo.custom.impl;

import com.example.possystembackend.bo.custom.CustomerBO;
import com.example.possystembackend.dao.DAOFactory;
import com.example.possystembackend.dao.custom.CustomerData;
import com.example.possystembackend.dto.CustomerDTO;
import com.example.possystembackend.entity.Customer;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    CustomerData customerData= (CustomerData) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOType.CUSTOMER);


    @Override
    public boolean saveCustomer(CustomerDTO customerDTO, Connection connection) {
        return customerData.save(new Customer(customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress(),customerDTO.getSalary()),connection);
    }

    @Override
    public List<CustomerDTO> getAllCustomer(Connection connection) {
        List<Customer> all = customerData.getAll(connection);
        List<CustomerDTO> customerDTOList=new ArrayList<>();
        for (Customer customer : all) {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(customer.getId());
            customerDTO.setName(customer.getName());
            customerDTO.setAddress(customer.getAddress());
            customerDTO.setSalary(customer.getSalary());

            customerDTOList.add(customerDTO);
        }

        return customerDTOList;
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO, String Id, Connection connection) {
        return customerData.update(new Customer(customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress(),customerDTO.getSalary()),Id,connection);
    }

    @Override
    public boolean isExistsCustomer(String id, Connection connection) {
        return false;
    }

    @Override
    public boolean deleteCustomer(String id, Connection connection) {
        return customerData.delete(id, connection);
    }

    @Override
    public CustomerDTO get(String id, Connection connection) {
        Customer customer = customerData.get(id, connection);
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setSalary(customer.getSalary());

        return customerDTO;
    }
}
