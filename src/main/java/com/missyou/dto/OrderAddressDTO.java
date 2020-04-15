/**
 * @作者 7七月
 * @微信公号 林间有风
 * @开源项目 $ http://7yue.pro
 * @免费专栏 $ http://course.7yue.pro
 * @我的课程 $ http://imooc.com/t/4294850
 * @创建时间 2019-08-26 15:08
 */
package com.missyou.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderAddressDTO {
    private String userName;
    private String province;
    private String city;
    private String county;
    private String mobile;
    private String nationalCode;
    private String postalCode;
    private String detail;
}
