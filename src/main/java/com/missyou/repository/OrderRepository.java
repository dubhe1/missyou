/**
 * @作者 7七月
 * @微信公号 林间有风
 * @开源项目 $ http://talelin.com
 * @免费专栏 $ http://course.talelin.com
 * @我的课程 $ http://imooc.com/t/4294850
 * @创建时间 2020-03-27 21:54
 */
package com.missyou.repository;

import com.missyou.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // status = unpaid 延迟消息队列
    // expiredTime > now
    // uid

    Page<Order> findByExpiredTimeGreaterThanAndStatusAndUserId(Date now, Integer status, Long uid, Pageable pageable);

    Page<Order> findByUserId(Long uid, Pageable pageable);

    Page<Order> findByUserIdAndStatus(Long uid, Integer status, Pageable pageable);

    Optional<Order> findFirstByUserIdAndId(Long uid, Long oid);

    Optional<Order> findFirstByOrderNo(String orderNo);

    @Modifying
    @Query("update Order o set o.status=:status where o.orderNo=:orderNo")
    int updateStatusByOrderNo(String orderNo, Integer status);

    @Modifying
    @Query("update Order o set o.status=5 where o.status = 1 and o.id=:oid")
    int cancelOrder(Long oid);

}
