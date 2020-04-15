/**
 * @作者 7七月
 * @微信公号 林间有风
 * @开源项目 $ http://talelin.com
 * @免费专栏 $ http://course.talelin.com
 * @我的课程 $ http://imooc.com/t/4294850
 * @创建时间 2020-03-23 20:20
 */
package com.missyou.repository;

import com.missyou.model.Sku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SkuRepository  extends JpaRepository<Sku, Long> {

    List<Sku> findAllByIdIn(List<Long> ids);

    @Modifying
    @Query("update Sku s \n" +
            "set s.stock = s.stock - :quantity\n" +
            "where s.id = :sid\n" +
            "and s.stock >= :quantity")
    int reduceStock(Long sid, Long quantity);

    @Modifying
    @Query("update Sku s set s.stock=s.stock+(:quantity) where s.id = :sid")
    int recoverStock(@Param("sid") Long sid,
                     @Param("quantity") Long quantity);
}
