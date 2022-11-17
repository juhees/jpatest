package kr.kwangan2.jpatest.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity//자바 클래스를 jpa가 관리하는 엔티티로 인식하게 하는 어노테이션. 기본적으로 클래스 이름과 동일한 테이블과 매핑된다
@Table(name="BOARD")//엔티티 이름과 매핑될 테이블 이름이 다른 경우, name 속성을 사용해 매핑한다. 같으면 생략가능
@Data
public class Board{

	@Id//엔티티로부터 생성된 객체는 반드시 다른 객체와 식별할 수 있어야 하는데 이를 위해서 반드시 사용해야하는 어노테이션
	//테이블의 기본 키를 매핑한다. 예제에서는 seq 변수가 테이블의 seq 칼럼과 매핑되도록 설정함
	@GeneratedValue//@id가 선언된 필드에 기본 키 값을 자동으로 할당.자동 증가. 다양한 옵션이있지만 이걸 사용하면 db에 따라 jpa가  자동으로 결정해줌
	private Long seq;
	
	private String title; 
	private String writer; 
	private String content; 
	private Date createDate; 
	private Long cnt;
   
}
