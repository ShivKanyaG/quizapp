package com.shiv.service;

import com.shiv.dao.QuestionDao;
import com.shiv.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("Added successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Question>> fetchQuestions() {
       List<Question> question = questionDao.findAll();
       return new ResponseEntity<>(question,HttpStatus.OK);
    }

    public ResponseEntity<String> saveOrUpdateQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("Added successfully", HttpStatus.CREATED);
    }

    public Optional<Question> findQuestionById(int id) {
       Optional<Question> question=questionDao.findById(id);
        return question;
    }

    public String deleteById(int id) {
        questionDao.deleteById(id);
        return "deleted successfully";
    }

    public List<Question> findByCategory(String category) {
        throw new NumberFormatException();
      // return questionDao.findByCategory(category);
    }
}
