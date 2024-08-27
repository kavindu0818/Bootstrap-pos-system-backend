package com.example.possystembackend.bo.custom;

import com.example.possystembackend.bo.SuperBO;
import com.example.possystembackend.dto.ItemDTO;

import java.sql.Connection;
import java.util.List;

public interface ItemBO extends SuperBO {
    boolean saveItem(ItemDTO itemDTO, Connection connection);
    List<ItemDTO> getAllItem(Connection connection);
    boolean updateItem(ItemDTO itemDTO, String Id, Connection connection);

//    boolean updateItem(ItemDTO itemDTO, String Id, Connection connection);

    boolean isExistsItem(String id, Connection connection);
    boolean deleteItem(String id,Connection connection);
    ItemDTO get(String id,Connection connection);
}
