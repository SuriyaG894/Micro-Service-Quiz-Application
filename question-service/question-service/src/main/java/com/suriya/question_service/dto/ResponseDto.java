package com.suriya.question_service.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ResponseDto {

    private Long id;
    private String response;
}
