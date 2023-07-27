package com.cybersoft.newbalanceproject.service.imp;

import com.cybersoft.newbalanceproject.dto.request.GDVRequest;
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.entity.GDVEntity;
import com.cybersoft.newbalanceproject.repository.GDVRepository;
import com.cybersoft.newbalanceproject.service.IGDVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GDVServiceImp implements IGDVService {
    @Autowired
    private GDVRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<GDVEntity> getAll() {
        return repository.findByIsDeleteFalse();
    }

    @Override
    public boolean addGDV(GDVRequest request) {
        boolean isSuccess = false;
        try {
            GDVEntity gdv = new GDVEntity();
            gdv.setUsername(request.getUsername());
            gdv.setFullname(request.getFullname());
            gdv.setPassword(passwordEncoder.encode(request.getPassword()));
            gdv.setAvailable(false);
            gdv.setDelete(false);

            // Kiểm tra trùng
            int countUsername = repository.countByUsername(request.getUsername());
            if(countUsername>0){
                return isSuccess;
            }
            // Thêm admin
            repository.save(gdv);
            isSuccess = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public BaseResponse deleteGDV(int id) {
        BaseResponse baseResponse = new BaseResponse();

        int countDeleteGDV = repository.deleteByGdvId(id);
        if(countDeleteGDV > 0){
            baseResponse.setStatusCode(HttpStatus.OK.value());
            baseResponse.setMessage("Xoá thành công");
            baseResponse.setData(countDeleteGDV);

        }else {
            baseResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            baseResponse.setMessage("Xoá thất bại");
            return baseResponse;
        }

        return baseResponse;
    }

    @Override
    public BaseResponse editGDV(GDVRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        GDVEntity entity = new GDVEntity();
        repository.getReferenceById(request.getId());
        entity.setGdvId(request.getId());
        entity.setUsername(request.getUsername());
        entity.setPassword(request.getPassword());
        entity.setFullname(request.getFullname());
        entity.setAvailable(request.isAvailable());
        entity.setDelete(request.isDelete());
        repository.save(entity);

        if(entity != null){
            baseResponse.setStatusCode(HttpStatus.OK.value());
            baseResponse.setMessage("Cập nhật thành công");
            baseResponse.setData(entity);
        }else {
            baseResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            baseResponse.setMessage("Cập nhật thất bại");
            return baseResponse;
        }
        return baseResponse;
    }
}
