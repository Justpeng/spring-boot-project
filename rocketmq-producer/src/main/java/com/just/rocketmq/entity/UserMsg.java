package com.just.rocketmq.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserMsg {
    private Byte age;
    private String name;

    @Override
    public String toString() {
        return "user[name=" + name + " ,age=" + age + "]";
    }
}
