package com.missyou.service;

import com.missyou.model.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {

    public Map<Integer, List<Category>> getAll();
}
