package com.jpabasic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaEx1 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			//비영속
			Member member = new Member();
			member.setId(101L);
			member.setName("HelloJPA");
			
			//영속
			System.out.println("=== BEFORE ===");
			em.persist(member);
			//영속성 컨텍스트에서 분리, 준영속 상태
			//em.detach(member);
			
			//객체를 삭제한 상태(삭제)
			//em.remove(member);
			System.out.println("=== AFTER ===");
			
			Member findMember = em.find(Member.class, 101L);
			
			System.out.println("findMember.id = " + findMember.getId());
			System.out.println("findMember.name = " + findMember.getName());
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		
		emf.close();
	}

}
