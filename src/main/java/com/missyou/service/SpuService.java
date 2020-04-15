package com.missyou.service;

import com.missyou.model.Spu;
import org.springframework.data.domain.Page;


public interface SpuService {

    public Spu getSpu(Long id);

    public Page<Spu> getLatestPagingSpu(Integer pageNum, Integer size);

    public Page<Spu> getByCategory(Long cid, Boolean isRoot, Integer pageNum, Integer size);
}
