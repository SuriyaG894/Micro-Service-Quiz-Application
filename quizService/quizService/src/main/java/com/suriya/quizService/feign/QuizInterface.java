package com.suriya.quizService.feign;

import com.suriya.quizService.dto.QuestionWrapperDto;
import com.suriya.quizService.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

    @GetMapping("question/generate")
    public List<Integer> getQuestionsForQuiz(@RequestParam String category, @RequestParam int numQ);

    @PostMapping("question/getQuestions")
    public List<QuestionWrapperDto> getQuestionsFromId(@RequestBody List<Integer> questionId);


    @PostMapping("question/getScore")
    public Integer getScore(@RequestBody List<ResponseDto> responseDto);


}
