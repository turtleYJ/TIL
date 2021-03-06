package jpql;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class JpaMain {

    public static void main(String[] args) {
        // 엔티티매니저 팩토리를 만든 순간 DB랑 연결이 된 것이다.
        // 엔티티맨니저 팩토리는 애플리케이션 로딩 시점에 딱 하나만 만들어 놔야 한다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // 실제 트랜잭션 단위 마다 DB커넥션을 날리고 쿼리를 만들고 종료되는 프로세스는 엔티티메니저를 만들어서 관리한다.
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();


        // code
        try {

            Member member = new Member();
            member.setUsername("Member1");
            member.setAge(10);
            em.persist(member);

            Member result = em.createQuery("selet m from Member m where m.username = :username", Member.class)
                    .setParameter("username", "member1")
                    .getSingleResult();
            System.out.println("result = " + result.getUsername());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
          em.close();
        }

        emf.close();


//        // 애플리케이션이 완전이 끝나면 엔티티메니저 펙토리를 닫아줘야 한다.(순차적으로)
//        em.close();
//
//        emf.close();

    }
}
