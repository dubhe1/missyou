package com.missyou.service;

import com.missyou.model.GridCategory;
import com.missyou.repository.GridCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GridCategoryService {
    @Autowired
    private GridCategoryRepository gridCategoryRepository;
    public List<GridCategory> getGridCategoryList() {
        return gridCategoryRepository.findAll();
    }
}
