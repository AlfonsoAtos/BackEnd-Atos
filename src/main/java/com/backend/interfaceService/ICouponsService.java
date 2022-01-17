package com.backend.interfaceService;

import java.util.*;

import com.backend.models.CouponsModel;

public interface ICouponsService {
    public List<CouponsModel> list();

    public Optional<CouponsModel> listId(int couponId);

    public int save(CouponsModel cm);

    public void delete(int couponId);
}
