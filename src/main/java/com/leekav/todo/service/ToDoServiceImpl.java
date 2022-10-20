package com.leekav.todo.service;

import com.leekav.todo.entity.ToDo;
import com.leekav.todo.persistence.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService{
    private final ToDoRepository toDoRepository;
    //유효성 검사를 위한 메서드
    private void validate(final ToDo toDo) {
        if(toDo == null) {
            throw new RuntimeException("ToDo cannot be null");
        }
        if (toDo.getUserId() == null) {
            throw new RuntimeException("UserId cannot be null");
        }
    }

    @Override
    public List<ToDo> create(ToDo toDo) {
        validate(toDo);
        //데이터 추가
        toDoRepository.save(toDo);
        //데이터 자신의 데이터 목록을 리턴
        return toDoRepository.findByUserId(toDo.getUserId());
    }

    @Override
    public List<ToDo> retrieve(String userId) {
        return toDoRepository.findByUserId(userId);
    }

    @Override
    public List<ToDo> update(ToDo toDo) {
        validate(toDo);
        //데이터 추가
        toDoRepository.save(toDo);
        //데이터 자신의 데이터 목록을 리턴
        return toDoRepository.findByUserId(toDo.getUserId());
    }

    @Override
    public List<ToDo> delete(ToDo toDo) {
        validate(toDo);
        //데이터 추가
        toDoRepository.delete(toDo);
        //데이터 자신의 데이터 목록을 리턴
        return toDoRepository.findByUserId(toDo.getUserId());
    }
}
