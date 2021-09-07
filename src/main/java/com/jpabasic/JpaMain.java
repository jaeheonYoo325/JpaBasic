package com.jpabasic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			
			//1.등록
//			Member member = new Member();
//			member.setId(2L);
//			member.setName("HelloB");
//			
//			em.persist(member);
			
			//2.단건조회
			//Member findMember = em.find(Member.class, 1L);
			
			//3.수정
			//findMember.setName("HelloJPA");
			
			//4.전체조회 - JPQL 
			List<Member> result = em.createQuery("select m from Member as m", Member.class)
					.getResultList();
			
			
			for( Member member : result ) {
				System.out.println("member.name = " + member.getName()); 
			}
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		
		emf.close();
	}

}
