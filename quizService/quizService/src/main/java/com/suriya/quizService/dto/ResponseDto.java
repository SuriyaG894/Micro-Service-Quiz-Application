package com.suriya.quizService.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ResponseDto {

    private Long id;
    private String response;
}
