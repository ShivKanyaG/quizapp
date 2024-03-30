package com.shiv.controller;

import com.shiv.model.Quiz;
import com.shiv.model.QuizQuestionMapping;
import com.shiv.model.Response;
import com.shiv.service.QuizService;
import com.shiv.wrapper.QuestionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;
    /*@PostMapping("/createQuiz")
    public String createQuiz(@RequestParam String title,@RequestParam int numQ,@RequestParam String category){
        return quizService.createQuiz(title,numQ,category);
    }*/

    @PostMapping("/createQuiz")
    public String createQuiz(@RequestBody QuizQuestionMapping quizQuestionMapping){
        return quizService.createQuiz(quizQuestionMapping);
    }

    @GetMapping("/get/{id}")
    public List<QuestionWrapper> getQuizQuestions(@PathVariable int id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public Integer submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }
}
