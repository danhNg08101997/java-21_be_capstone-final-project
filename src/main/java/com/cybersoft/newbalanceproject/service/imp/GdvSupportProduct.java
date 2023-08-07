package com.cybersoft.newbalanceproject.service.imp;

import com.cybersoft.newbalanceproject.dto.response.GDVRespone;
import com.cybersoft.newbalanceproject.entity.GDVEntity;
import com.cybersoft.newbalanceproject.repository.GDVRepository;
import com.cybersoft.newbalanceproject.service.IGdvSupportProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GdvSupportProduct implements IGdvSupportProduct {
    @Autowired
    private GDVRepository gdvRepository;
    @Override
    public GDVRespone findSupportProduct(int idProduct) {
        GDVEntity gdv = gdvRepository.findByIdProduct(idProduct);
        GDVRespone gdvRespone = new GDVRespone();
        gdvRespone.setId(gdv.getGdvId());
        gdvRespone.setGdvName(gdv.getUsername());
        gdvRespone.setFullname(gdv.getFullname());
        return gdvRespone;
    }
}
