package com.cybersoft.newbalanceproject.service;

import com.cybersoft.newbalanceproject.dto.response.GDVRespone;
import com.cybersoft.newbalanceproject.dto.response.SupportListProduct;
import com.cybersoft.newbalanceproject.entity.GDVEntity;

public interface IGdvSupportProduct {
    GDVRespone findSupportProduct(int idProduct);
}
