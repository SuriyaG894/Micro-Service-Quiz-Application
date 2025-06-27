package com.suriya.question_service.service;


import com.suriya.question_service.dao.QuestionRepository;
import com.suriya.question_service.dto.QuestionWrapperDto;
import com.suriya.question_service.dto.ResponseDto;
import com.suriya.question_service.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }


    public String addQuestion(Question question) {
        questionRepository.save(question);
        return "Success";
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionRepository.findByCategory(category);
    }

    public String addQuestions(List<Question> questions) {
        questionRepository.saveAll(questions);
        return "success";
    }

    public List<Integer> getQuestionsForQuiz(String category,int numQ) {
        return questionRepository.findByCategoryAndFilterByLimit(category,numQ);
    }


    public List<QuestionWrapperDto> getQuestionsFromId(List<Integer> questionId) {
        List<Question> questions = new ArrayList<>();
        List<QuestionWrapperDto> questionWrapperDtos = new ArrayList<>();
        for(Integer id:questionId){
            questions.add(questionRepository.findById(Long.valueOf(id)).get());
        }
//        private Long id;
//        private String questionTitle;
//        private String option1;
//        private String option2;
//        private String option3;
//        private String option4;
        for(Question question: questions){
            questionWrapperDtos.add(new QuestionWrapperDto(question.getId(), question.getQuestionTitle(),question.getOption1(),question.getOption2(),question.getOption3(),question.getOption4()));
        }
        return questionWrapperDtos;
    }

    public Integer getScore(List<ResponseDto> responses) {
        int right = 0;
        for(ResponseDto responseDto:responses){
            Question question = questionRepository.findById(responseDto.getId()).get();
            System.out.println(question.getRightAnswer() + " "+ responseDto.getResponse());
            if(question.getRightAnswer().equals(responseDto.getResponse())){
                right++;
            }
        }
        return right;
    }
}
