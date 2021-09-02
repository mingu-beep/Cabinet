package com.cabinet.Cabinet.dao;

import com.cabinet.Cabinet.dto.CategoryDTO;

import java.util.List;

public interface CategoryDAO {
    List<CategoryDTO> findAll();

    boolean updateByCtNo(CategoryDTO categoryDTO);
    boolean deleteByCtNo(int ctNo);
    void insertNewCategory(String ctType);

    void updateCtCNT(int ctNo);
    String findByCtNo(int ctNo);
}
