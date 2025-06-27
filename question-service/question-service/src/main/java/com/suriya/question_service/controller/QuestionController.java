package com.suriya.question_service.controller;


import com.suriya.question_service.dto.QuestionWrapperDto;
import com.suriya.question_service.dto.ResponseDto;
import com.suriya.question_service.model.Question;
import com.suriya.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/all")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @PostMapping("/add")
    public String addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @GetMapping("/category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("/addList")
    public String addQuestions(@RequestBody List<Question> questions)
    {
        return questionService.addQuestions(questions);
    }

    @GetMapping("/generate")
    public List<Integer> getQuestionsForQuiz(@RequestParam String category,@RequestParam int numQ){
        return questionService.getQuestionsForQuiz(category,numQ);
    }

    @PostMapping("/getQuestions")
    public List<QuestionWrapperDto> getQuestionsFromId(@RequestBody List<Integer> questionId){
        return questionService.getQuestionsFromId(questionId);
    }


    @PostMapping("/getScore")
    public Integer getScore(@RequestBody List<ResponseDto> responseDto){
        return questionService.getScore(responseDto);
    }

}
