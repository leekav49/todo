package com.leekav.todo;

import com.leekav.todo.entity.ToDo;
import com.leekav.todo.persistence.ToDoRepository;;
import com.leekav.todo.service.ToDoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ToDoTest {
    @Autowired
    private ToDoRepository toDoRepository;

    //데이터 삽입 테스트
    //@Test
    public void testInsert() {
        ToDo todo1 = ToDo.builder()
                .userId("mini")
                .title("공부하기")
                .done(false)
                .build();
        toDoRepository.save(todo1);
        ToDo todo2 = ToDo.builder()
                .userId("mini")
                .title("외식하기")
                .done(false)
                .build();
        toDoRepository.save(todo2);
    }

    //유저 아이디를 이용한 조회
    //@Test
    public void testFindUserId() {
        List<ToDo> list = toDoRepository.findByUserId("mini");
        /*for(ToDo toDo : list) {
            System.out.println(toDo);
        }*/
        list.stream().forEach(toDo -> {
            System.out.println(toDo);
        });
    }

    //id에 해당하는 하나의 데이터 조회
    //@Test
    public void testDetail() {
        Optional<ToDo> result = toDoRepository.findById("402881c283f3d8d20183f3d8db960000");
        if (result.isPresent()) {
            System.out.println(result.get());
        } else {
            System.out.println("데이터가 존재하지 않습니다.");
        }
    }

    //데이터 수정
    //@Test
    public void testUpdate() {
        ToDo todo = ToDo.builder()
                .id("402881c283f3d8d20183f3d8db960000")
                .userId("미니")
                .title("집가기")
                .done(true)
                .build();
        toDoRepository.save(todo);
    }

    //데이터 삭제
    //@Test
    public void testDelete() {
        toDoRepository.deleteById("402881c283f3d8d20183f3d8db960000");
    }

    @Autowired
    private ToDoService toDoService;

    //삽입 테스트
    //@Test
    public void testServiceInsert() {
        ToDo toDo = ToDo.builder()
                .userId("mini")
                .title("서비스 테스트")
                .done(false)
                .build();
        List<ToDo> list = toDoService.create(toDo);
        System.out.print(list);
    }

    //@Test
    public void testServiceRetrive() {
        List<ToDo> list = toDoService.retrieve("mini");
        System.out.print(list);
    }

    //@Test
    public void testServiceUpdate() {
        ToDo toDo = ToDo.builder()
                .id("402881c283f3d9f70183f3da02b80000")
                .userId("mini")
                .title("수정")
                .done(true)
                .build();
        List<ToDo> list = toDoService.update(toDo);
        System.out.print(list);
    }

    //삭제
    //@Test
    public void testServiceDelete(){
        ToDo toDo = ToDo.builder()
                .id("402881c283f3d9f70183f3da02b80000")
                .userId("mini")
                .build();
        List<ToDo>list = toDoService.delete(toDo);
        System.out.println(list);
    }


}
