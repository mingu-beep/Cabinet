package com.cabinet.Cabinet.service;

import com.cabinet.Cabinet.dao.CategoryDAO;
import com.cabinet.Cabinet.dao.ReplyDAO;
import com.cabinet.Cabinet.dto.CategoryDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private SqlSessionTemplate categorySqlSession;
    private CategoryDAO categoryDAO;

    public List<CategoryDTO> getAllCategory() {
        categoryDAO = categorySqlSession.getMapper(CategoryDAO.class);
        return categoryDAO.findAll();
    }

    public boolean updateCtType(int ctNo, String ctType) {

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCtNo(ctNo);
        categoryDTO.setCtType(ctType);

        categoryDAO = categorySqlSession.getMapper(CategoryDAO.class);
        return categoryDAO.updateByCtNo(categoryDTO);
    }

    public boolean deleteCategory(int ctNo) {
        categoryDAO = categorySqlSession.getMapper(CategoryDAO.class);
        return categoryDAO.deleteByCtNo(ctNo);
    }

    public void insertCategory(String ctType) {
        categoryDAO = categorySqlSession.getMapper(CategoryDAO.class);
        categoryDAO.insertNewCategory(ctType);
    }
}
