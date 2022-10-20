package com.leekav.todo.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Builder
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "todo")
public class ToDo extends BaseEntity {
    //기본키로 사용할 ID
    //랜덤한 UUID를 가지고 ID값을 생성
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    //사용자 식별을 위한 ID
    @Column(length = 100, nullable = false)
    private String userId;

    //제목
    @Column(length = 500, nullable = false)
    private String title;

    //수행 여부
    @Column(nullable = false)
    private boolean done;

}
