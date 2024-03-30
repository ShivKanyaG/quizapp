package com.shiv.controller;

import com.shiv.model.Question;
import com.shiv.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/question")
public class QuestionController {

    Logger logger =LoggerFactory.getLogger(QuestionController.class);
    @Autowired
    QuestionService questionService;
    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){

        return questionService.addQuestion(question);
    }

    @GetMapping("/allQuestion")
    public ResponseEntity<List<Question>>fetchQuestions(Question question){
        logger.info("Fetching All questions");
        return questionService.fetchQuestions();
    }

    @PutMapping("/update")
    public ResponseEntity<String> saveOrUpdateQuestion(@RequestBody Question question){

        return questionService.saveOrUpdateQuestion(question);
    }

   @GetMapping("/findById/{id}")
    public Optional<Question> findQuestionById(@PathVariable int id){
        return questionService.findQuestionById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id){
        return questionService.deleteById(id);
    }

    @GetMapping("findByCategory/{category}")
    public List<Question> findByCategory(@PathVariable String category){
        return questionService.findByCategory(category);
    }
}
