/**
 * @作者 7七月
 * @微信公号 林间有风
 * @开源项目 $ http://talelin.com
 * @免费专栏 $ http://course.talelin.com
 * @我的课程 $ http://imooc.com/t/4294850
 * @创建时间 2020-03-22 13:56
 */
package com.missyou.exception;

import com.missyou.exception.http.HttpException;

public class DeleteSuccess extends HttpException {
    public DeleteSuccess(int code){
        this.httpStatusCode = 200;
        this.code = code;
    }
    // 200 201 204 200
    // 200 201 200 200

    // Create：201 资源本身
    // Get: 200
    // Put: 200
    // Delete: 200
}
