package com.suriya.quizService.controller;


import com.suriya.quizService.dto.QuestionWrapperDto;
import com.suriya.quizService.dto.ResponseDto;
import com.suriya.quizService.model.Quiz;
import com.suriya.quizService.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/all")
    public List<Quiz> getAllQuiz(){
        return quizService.getAllQuiz();
    }

    @PostMapping("/add/{quizName}")
    public String addQuiz(@PathVariable("quizName") String quiz_name, @RequestParam String category, @RequestParam int numQ){
        quizService.addQuiz(quiz_name,category,numQ);
        return "Success";
    }

    @GetMapping("/get/{id}")
    public List<QuestionWrapperDto> getQuestionByQuizID(@PathVariable("id") Long quizId){
        return quizService.getQuestionByQuizID(quizId);
    }

    @PostMapping("/submit/{id}")
    public Long calculateResult(@PathVariable("id") Long id ,@RequestBody List<ResponseDto> responses){
        return quizService.calculateResult(id,responses);
    }
}
