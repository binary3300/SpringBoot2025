package com.thejoa.boot3.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BoardRepository extends JpaRepository<Board, Long>{
	
//1. @Query 는 객체파라미터를 지원한다.. 엔티티 테이블명 사용: Board -select 기본작업이라 @Query만 쓰면 된다.
	//@Query(value="select * from board order by id desc", nativeQuery=true) 가능하긴 하지만 버전에 따라 오류난다
	@Query("select b from Board b order by id desc")
	List<Board> findAllByOrderByDesc();
	
//2. insert, update, delete 를 사용할떄(수정)에는 @Modifying, @Transactional, @Query 세개가 들어가야한다
	@Modifying //2-1 삽입, 수정, 삭제 쿼리는 변경작업이라 @Modifying가 꼭 들어가야한다
	@Transactional //2-2 rollback 활성화기능이다. 데이터손상을 최소화하기위해 넣는다
	@Query("delete from Board b where  b.id=:id  and  b.bpass=:bpass")
	int deleteByIdAndBpass(@Param("id") Long id, @Param("bpass") String bpass );
//2-3. @Param("id") 쿼리의 변수명과 동일하면 생략가능
//2-4. deleteByIdAndBpass(Board board)XXXxX 불가능!!!		객체파라미터 지원안함~~~~~
	
	
	//수정!! id와 pass가 같으면 btitle bcontent수정
	@Modifying //2-1  수정, 쿼리는 변경작업이라 @Modifying가 꼭 들어가야한다
	@Transactional //2-2 rollback 활성화기능이다. 데이터손상을 최소화하기위해 넣는다
	@Query("update Board b set b.btitle = :btitle, b.bcontent = :bcontent where b.id = :id and b.bpass = :bpass")
	int updateByIdAndBpass(Long id, String bpass, String btitle, String bcontent ); //@Param("id") 쿼리의 변수명과 동일하면 생략가능
	
	/*
	 * #3. 글검색부분은 작성자 및 글제목으로도 가능하게 [도전!] 
	 * ※ 참고) 
	 * select distinct b from Board b left join Member m 
	 * on b.member = m 
	 * where b.title like %:key% 
	 *   or b.content like %:key% 
	 *   or m.name like %:key%
	 * 
	 */
	
	
}  // JpaRepository<Member, Long>   테이블, pk의 자료형

/*

 https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html#jpa.query-methods.query-creation

mysql> desc member;
+-------------+--------------+------+-----+---------+----------------+
| Field       | Type         | Null | Key | Default | Extra          |
+-------------+--------------+------+-----+---------+----------------+
| id          | bigint       | NO   | PRI | NULL    | auto_increment |
| age         | int          | NO   |     | NULL    |                |
| create_date | datetime(6)  | YES  |     | NULL    |                |
| name        | varchar(255) | NO   |     | NULL    |                |
+-------------+--------------+------+-----+---------+----------------+
4 rows in set (0.00 sec)
*/