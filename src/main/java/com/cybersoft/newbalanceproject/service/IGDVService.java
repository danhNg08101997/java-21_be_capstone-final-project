package com.cybersoft.newbalanceproject.service;

import com.cybersoft.newbalanceproject.dto.request.GDVRequest;
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.entity.GDVEntity;

import java.util.List;

public interface IGDVService {
    boolean updateAvailable(int gdv);
    List<GDVEntity> getAll();
    List<GDVEntity> getUsername(GDVRequest request);
    boolean addGDV(GDVRequest request);
    BaseResponse deleteGDV(int id);
    BaseResponse editGDV(GDVRequest request);
}
