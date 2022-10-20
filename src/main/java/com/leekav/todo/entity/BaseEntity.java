package com.leekav.todo.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

//Entity를 별도로 생성하지 않는 클래스
@MappedSuperclass
//Jpa를 감시하고 있다가 동작하도록 설정
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
public abstract class BaseEntity {
    @CreatedDate
    @Column(name="regdate", updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(name="moddate")
    private LocalDateTime modDate;
}
