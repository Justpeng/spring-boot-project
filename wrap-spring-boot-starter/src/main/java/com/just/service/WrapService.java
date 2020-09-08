package com.just.service;

import lombok.AllArgsConstructor;

/**
 * 1 服务类
 */
@AllArgsConstructor
public class WrapService {
    private String before;

    private String after;

    public String wrap(String word) {
        return before + word + after;
    }
}
