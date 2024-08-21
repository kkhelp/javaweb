package com.jw2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 17932
 * @date 2024/8/20 18:50
 * @description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysStory {
    private Integer id;
    private String title;
    private String content;
}
