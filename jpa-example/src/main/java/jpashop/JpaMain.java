package jpashop;

import jpashop.domain.Member;
import jpashop.domain.Order;
import jpashop.domain.OrderStatus;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setName("memberA");
            em.persist(member);

            Order order = new Order();
            order.setMember(member);
            order.setStatus(OrderStatus.ORDER);
            em.persist(order);

            em.flush();
            em.clear();

            Order findOrder = em.find(Order.class, order.getId());
            List<Order> orders = findOrder.getMember().getOrders();

            for (Order o : orders) {
                System.out.println("o.getId() = " + o.getId());
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
