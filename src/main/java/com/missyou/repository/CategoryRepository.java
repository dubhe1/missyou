/**
 * @作者 7七月
 * @微信公号 林间有风
 * @开源项目 $ http://7yue.pro
 * @免费专栏 $ http://course.7yue.pro
 * @我的课程 $ http://imooc.com/t/4294850
 * @创建时间 2020-03-09 19:15
 */
package com.missyou.repository;

import com.missyou.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    //    {List, List, List}
//     List, List
    List<Category> findAllByIsRootOrderByIndexAsc(Boolean isRoot);
}
