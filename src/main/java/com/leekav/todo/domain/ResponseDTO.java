package com.leekav.todo.domain;

import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class ResponseDTO<T> {
    private String error;
    private List<T> data;

}
