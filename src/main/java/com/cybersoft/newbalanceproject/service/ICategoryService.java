package com.cybersoft.newbalanceproject.service;

import com.cybersoft.newbalanceproject.dto.request.CategoryRequest;
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.dto.response.CategoryResponse;

import java.util.List;

public interface ICategoryService {
    List<CategoryResponse> getAllCategories();
    boolean addCategory(CategoryRequest request);
    BaseResponse deleteCategory(int id);
    BaseResponse editCategory(CategoryRequest request);
}
