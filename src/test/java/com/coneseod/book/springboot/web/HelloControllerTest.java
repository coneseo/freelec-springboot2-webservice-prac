package com.coneseod.book.springboot.web;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
// 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킨다. 여기서는 SpringRunner라는 스프링 실행자를 사용한다. 스프링 부트 테스트와 JUnit사이에 연결자 역할을 한다.
@WebMvcTest(controllers = HelloController.class)
//여러 스프링 어노테이션 중 Web에 집중할 수 있는 어노테이션, 선언할 경우 @Controller, @ControllerAdvice등을 사용할 수 있다.
//@Service, @Component, @Repository 등은 사용할 수 없다.
public class HelloControllerTest {
  @Autowired
  private MockMvc mvc;
  //웹 API를 테스트할 때 사용, 스프링 MVC 테스트의 시작점, 이 클래스를 통해 HTTP GET, POST 등에 대한 API를 테스트 할 수 있다.

  @Test
  public void hello가_리턴된다() throws Exception{
    String hello = "hello";
    mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));
  }


}
