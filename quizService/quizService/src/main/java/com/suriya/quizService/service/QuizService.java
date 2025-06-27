package com.suriya.quizService.service;


import com.suriya.quizService.dao.QuizRepository;
import com.suriya.quizService.dto.QuestionWrapperDto;
import com.suriya.quizService.dto.ResponseDto;
import com.suriya.quizService.feign.QuizInterface;
import com.suriya.quizService.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuizInterface quizInterface;

//    @Autowired
//    private QuestionRepository questionRepository;

    public List<Quiz> getAllQuiz() {
        return quizRepository.findAll();
    }

    public void addQuiz(String quiz_name, String category, int numQ) {
//        List<Question> dbQuestion = questionRepository.findByCategoryAndFilterByLimit(category,numQ);
        List<Integer> questionIds = quizInterface.getQuestionsForQuiz(category,numQ);
        Quiz quiz1 = new Quiz(quiz_name,questionIds);
        quizRepository.save(quiz1);
    }

    public List<QuestionWrapperDto> getQuestionByQuizID(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId).get();
        List<QuestionWrapperDto> questionWrapperDtos = quizInterface.getQuestionsFromId(quiz.getQuestionsIds());
//        for(Question question:quiz.getQuestions()){
//            questionWrapperDtos.add(new QuestionWrapperDto(question.getId(),question.getQuestionTitle(),question.getOption1(),question.getOption2(),question.getOption3(),question.getOption4()));
//        }
        return questionWrapperDtos;
    }

    public Long calculateResult(Long id, List<ResponseDto> responses) {
        Quiz quiz = quizRepository.findById(id).get();
//        List<Question> questions = quiz.getQuestions();
        int score = quizInterface.getScore(responses);
//        for(ResponseDto responseDto:responses){
//            for(Question question:questions){
//                if(responseDto.getId() == question.getId()){
//                    if(responseDto.getResponse().equals(question.getRightAnswer())){
//                        right++;
//                    }
//                }
//            }
//        }
        return Long.valueOf(score);
    }
}
