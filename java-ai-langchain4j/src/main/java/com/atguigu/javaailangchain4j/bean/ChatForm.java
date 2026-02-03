package com.atguigu.javaailangchain4j.bean;

import lombok.Data;

@Data
public class ChatForm {
    private Long memoryId;//conversation id
    private String message;//user question
}
