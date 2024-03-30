package com.shiv.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class QuizQuestionMapping {
    private Integer numQ;
    private String title;
    private String category;
}
