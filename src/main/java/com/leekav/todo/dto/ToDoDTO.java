package com.leekav.todo.dto;

import com.leekav.todo.entity.ToDo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ToDoDTO {
    private String id;
    private String title;
    private boolean done;

    //Entity를 받아서 DTO 인스턴스를 생성해주는 생성자
    public ToDoDTO(final ToDo toDo) {
        this.id = toDo.getId();
        this.title = toDo.getTitle();
        this.done = toDo.isDone();
    }

    //DTO 인스턴스를 Entity 인스턴스로 변화해주는 메서드
    public static ToDo toEntity(final ToDoDTO dto) {
        return ToDo.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .done(dto.isDone())
                .build();
    }

}
