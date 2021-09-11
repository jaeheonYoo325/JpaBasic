package com.jpabasic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaEx6 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			
			//영속
			Member member = em.find(Member.class, 150L);
			member.setName("AAAAA");

			//준영속 상태
			//em.detach(member);
			
			//영속성 컨텍스트 완전히 초기화
			em.clear();
			
			Member member2 = em.find(Member.class, 150L);
			
			System.out.println("=================");
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		
		emf.close();

	}

}
