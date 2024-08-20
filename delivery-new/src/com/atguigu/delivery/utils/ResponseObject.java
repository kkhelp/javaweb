package com.atguigu.delivery.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 响应对象中的数据
 * @author 17932
 * @date 2024/8/19 17:32
 * @description TODO
 */
@Data
@AllArgsConstructor
public class ResponseObject {
    private Integer code; // 状态码
    private String message; // 提示信息
    private Object data; // 返回数据
}
