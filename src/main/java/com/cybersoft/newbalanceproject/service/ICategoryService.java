package com.cybersoft.newbalanceproject.service;

import com.cybersoft.newbalanceproject.dto.request.CategoryRequest;
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.entity.CategoryEntity;

import java.util.List;

public interface ICategoryService {
    List<CategoryEntity> getAllCategories();
    boolean addCategory(CategoryRequest request);
    BaseResponse deleteCategory(CategoryRequest request);
    BaseResponse editCategory(CategoryRequest request);
}
