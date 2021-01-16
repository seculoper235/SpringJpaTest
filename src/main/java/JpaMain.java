import Domain.Member;
import Domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            logic(em);
            logic2(em);
            tx.commit();

        } catch (Exception e) {
            tx.rollback();

        } finally {
            em.close();
        }
        emf.close();
    }

    public static void logic(EntityManager em) {
        System.out.println("하이버나이트 연동 성공!!");
        System.out.println("데이터 삽입중...");
        Team teamA = new Team();
        teamA.setName("팀1");
        em.persist(teamA);
        System.out.println("데이터 삽입 성공!");
    }

    public static void logic2(EntityManager em) {
        System.out.println("하이버나이트 연동 성공!!");
        System.out.println("데이터 조회중...");
        Team findTeam = em.find(Team.class, 1);
        System.out.println("Team : " +findTeam+ "! 데이터 조회 성공!");
    }
}
