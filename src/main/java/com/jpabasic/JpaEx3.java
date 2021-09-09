package com.jpabasic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaEx3 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			
			//영속
			Member member1 = new Member(150L, "A");
			Member member2 = new Member(160L, "B");

			//영속성 컨텍스트의 1차 캐시에 엔티티 등록
			//쓰기 지연 SQL 저장소에 INSERT 쿼리문 쌓아둔다.
			em.persist(member1);
			em.persist(member2);

			System.out.println("=================");
			
			//1차 캐시에 있는 엔티티를 비워두고 DB에 INSERT 쿼리문 날려준다.
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		
		emf.close();
	}

}
