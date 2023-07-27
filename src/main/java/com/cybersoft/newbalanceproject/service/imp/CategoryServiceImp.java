package com.cybersoft.newbalanceproject.service.imp;

import com.cybersoft.newbalanceproject.dto.request.CategoryRequest;
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.entity.CategoryEntity;
import com.cybersoft.newbalanceproject.repository.CategoryRepository;
import com.cybersoft.newbalanceproject.service.ICategoryService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImp implements ICategoryService {
    @Autowired
    private CategoryRepository repository;
    @Autowired
    private RedisTemplate redis;

    @Override
    public List<CategoryEntity> getAllCategories() {
        List<CategoryEntity> responseList = new ArrayList<>();
        if(redis.hasKey("listCategory")){
//            Nếu như có thì lấy giá trị lưu trữ lên redis
            System.out.println("Có giá trị trên redis");
            String data = redis.opsForValue().get("listCategory").toString();

            Type listType = new TypeToken<ArrayList<CategoryEntity>>(){}.getType();
            responseList = new Gson().fromJson(data, listType);

        }else {
            System.out.println("Không có giá trị trên redis");
            List<CategoryEntity> list = repository.findByIsDeleteFalse();

            for (CategoryEntity data: list) {
                CategoryEntity entity = new CategoryEntity();
                entity.setId(data.getId());
                entity.setCategoryName(data.getCategoryName());
                responseList.add(entity);
            }
            Gson gson = new Gson();
            String data = gson.toJson(responseList);

            redis.opsForValue().set("listCategory", data);
        }
        return responseList;
    }

    @Override
    public boolean addCategory(CategoryRequest request) {
        boolean isSuccess = false;
        try{
            if (request.getName().isEmpty()){
                return isSuccess;
            }
            CategoryEntity response = new CategoryEntity();
            response.setCategoryName(request.getName());
            response.setDelete(false);
            int countGetName = repository.countAllByCategoryName(request.getName());
            if (countGetName>0){
                System.out.println("Category_name đã tồn tại");
                return isSuccess;
            }
            repository.save(response);
            isSuccess = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public BaseResponse deleteCategory(int id) {
        BaseResponse baseResponse = new BaseResponse();
            int countDelete = repository.deleteCategory(id);
            if (countDelete > 0){
                baseResponse.setStatusCode(HttpStatus.OK.value());
                baseResponse.setMessage("Xoá thành công");
                baseResponse.setData(countDelete);
            }else {
                baseResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                baseResponse.setMessage("Xoá thất bại");
            }
            return baseResponse;
    }

    @Override
    public BaseResponse editCategory(CategoryRequest request) {
        BaseResponse response = new BaseResponse();
        CategoryEntity entity = new CategoryEntity();
        repository.getReferenceById(request.getId());
            entity.setCategoryName(request.getName());
            repository.save(entity);
            if(entity != null){
                response.setStatusCode(HttpStatus.OK.value());
                response.setMessage("Cập nhật thành công");
                response.setData(entity);
            }else {
                response.setStatusCode(HttpStatus.BAD_GATEWAY.value());
                response.setMessage("Cập nhật thất bại");
            }
        return response;

    }
}
