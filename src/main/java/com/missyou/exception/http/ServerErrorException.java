/**
 * @作者 7七月
 * @微信公号 林间有风
 * @开源项目 $ http://7yue.pro
 * @免费专栏 $ http://course.7yue.pro
 * @我的课程 $ http://imooc.com/t/4294850
 * @创建时间 2020-03-02 05:59
 */
package com.missyou.exception.http;

public class ServerErrorException extends HttpException {
    public ServerErrorException(int code){
        this.code = code;
        this.httpStatusCode = 500;
    }
}
