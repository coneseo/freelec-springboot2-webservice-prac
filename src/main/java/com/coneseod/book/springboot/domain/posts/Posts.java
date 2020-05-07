package com.coneseod.book.springboot.domain.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Posts {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 500, nullable = false)
  private String title;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String content;

  private String author;

  @Builder
  public Posts(String title, String content, String author){
    this.title = title;
    this.content = content;
    this.author = author;
  }

  public void update(String title, String content){
    this.title = title;
    this.content = content;
  }
}

/*
  @Entity
  - 테이블과 링크될 클래스임을 나타낸다.
  - 기본값으로 클래스이 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭한다.
  ex) SalesManager.java => sales_manager table

  @Id
  - 해당 테이블의 PK 필드를 나타낸다.

  @GeneratedValue
  - PK의 생성 규칙을 나타낸다.
  - 스프링 부트 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment 된다.

  @Column
  - 테이블의 칼럼을 나타내며 굳이 선언하지 않아도 해당 클래스이 필드는 모두 칼럼이 된다.
  - 사용하는 이유는 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용한다.
  - 문자열의 경우 VARCHAR(255)가 기본인데 사이즈를 500으로 늘리고 싶거나 타입을 TEXT로 변경하고 싶거나 등의 경우에 사용된다.k
 */