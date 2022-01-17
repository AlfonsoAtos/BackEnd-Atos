package com.backend.services;

import java.util.List;
import java.util.Optional;

import com.backend.interfaceService.ICouponsService;
import com.backend.interfaces.ICoupons;
import com.backend.models.CouponsModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponsService implements ICouponsService {

    @Autowired
    private ICoupons dataCoupons;

    @Override
    public List<CouponsModel> list() {
        return (List<CouponsModel>) dataCoupons.findAll();
    }

    @Override
    public Optional<CouponsModel> listId(int couponId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int save(CouponsModel cm) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void delete(int couponId) {
        // TODO Auto-generated method stub

    }

}
