import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import kr.kwangan2.jpatest.entity.Board;

public class JPAClient {
	public static void main(String[] args) {
		
		//EntityManager 생성
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("jpatest");
		
		EntityManager em = emf.createEntityManager();
		
		//transaction 생성
		EntityTransaction tx = em.getTransaction();
		
		try {
			
			//transaction 시작
			tx.begin();
			
			/* persiste: insert 쿼리
			Board board = new Board();
			board.setTitle("JPA 제목");
			board.setWriter("관리자");
			board.setContent("JPA 글 등록 잘 안 되네요");
			board.setCreateDate(new Date());
			board.setCnt(0L);
			
			em.persist(board); //보드에 저장
			*/
			
			//find : select one query
			Board board = em.find(Board.class,5L);
			
			//update query
			//board.setTitle("수정된 제목");
			
			//remove: delete query
			//em.remove(board);
			
			//createQuery : select list
			//엔티티에 대한 쿼리문 (jpql) 작성
			String jpql = "select b from Board b order by b.seq desc";
			List<Board> boardList = 
					em.createQuery(jpql, Board.class).getResultList();
			for(Board brd : boardList) {
				System.out.println("===>" + brd.toString());
			}
			
			
			tx.commit();
			
		}catch (Exception ex) {
			ex.printStackTrace();
			//문제가 발생하면 rollback() 실행
			tx.rollback();
		}finally {
			em.close();
			emf.close();
		}
	}

}
