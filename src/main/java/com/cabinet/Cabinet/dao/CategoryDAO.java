package com.cabinet.Cabinet.dao;

import com.cabinet.Cabinet.dto.CategoryDTO;

import java.util.List;

public interface CategoryDAO {
    public List<CategoryDTO> findAll();

    public boolean updateByCtNo(CategoryDTO categoryDTO);
    public boolean deleteByCtNo(int ctNo);
    public void insertNewCategory(String ctType);
}
