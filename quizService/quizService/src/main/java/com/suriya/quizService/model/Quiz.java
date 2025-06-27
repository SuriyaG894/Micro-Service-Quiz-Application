package com.suriya.quizService.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String QuizName;
    @ElementCollection
    private List<Integer> questionsIds;

    public Quiz(String quiz_name, List<Integer> questionIds) {
    }

    public Quiz() {
    }
}
