package com.lxxjn0.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 해당 Annotation이 있는 위치부터 설정을 읽어가기 때문에 항상 최상단에 위치해야 함
public class Application { // 앞으로 만들 프로젝트의 메인 클래스

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args); // 여기서 내장 WAS가 실행됨, 스프링 부트에서는 내장 WAS를 사용하는 것을 권장
	}

}
