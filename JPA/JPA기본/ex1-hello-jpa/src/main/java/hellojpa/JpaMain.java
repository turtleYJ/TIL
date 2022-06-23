package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

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
//            Member findMember = em.find(Member.class, 1L);
            // JPQL : 테이블이 아닌 객체를 대상으로 검색하는 객체 지향 쿼리
            // 엔티티에서 컬럼이 아닌 객체 그 자체를 가져온다.
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
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
