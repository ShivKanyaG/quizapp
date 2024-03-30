package com.shiv.service;

import com.shiv.dao.QuestionDao;
import com.shiv.dao.QuizDao;
import com.shiv.exceptionHandler.DataNotFoundException;
import com.shiv.model.Question;
import com.shiv.model.Quiz;
import com.shiv.model.QuizQuestionMapping;
import com.shiv.model.Response;
import com.shiv.wrapper.QuestionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;


/*    public String createQuiz(String title, int numQ, String category) {

        List<Question> questions=questionDao.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return "quiz is ready";

    }*/

    public String createQuiz(QuizQuestionMapping quizQuestionMapping) {

        List<Question> questions=questionDao.findRandomQuestionsByCategory(quizQuestionMapping.getCategory(),quizQuestionMapping.getNumQ());
        Quiz quiz=new Quiz();
        quiz.setTitle(quizQuestionMapping.getTitle());
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return "quiz is ready";

    }

    public List<QuestionWrapper> getQuizQuestions(int id) {
        Optional<Quiz> quiz = quizDao.findById(id);

        if(quiz.isEmpty()){
            throw new DataNotFoundException("Quiz id not found in database");
        }
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for(Question q : questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionsForUser.add(qw);
        }
        return questionsForUser;
    }

  /*  public Integer calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;
        for(Response response : responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;
                i++;
        }
        return right;
    }*/

    public Integer calculateResult(Integer id, List<Response> responses) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questions = quiz.get().getQuestions();
        int right = 0;
        int i = 0;
        for(Response response : responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;
            i++;
        }
        return right;
    }
}
