package vn.edu.iuh.fit.www_lab_week2.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.www_lab_week2.models.Customer;
import vn.edu.iuh.fit.www_lab_week2.models.Order;

import java.security.Permission;
import java.util.List;

public class OrderRepository {
    private EntityManager em;
    private EntityTransaction trans;

    public OrderRepository() {
        em = Persistence.createEntityManagerFactory("WWW-week02").createEntityManager();
        trans= em.getTransaction();
    }
    public void insertOrder(Order order){
        try{
            trans.begin();
            em.persist(order);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateOrder(Order order){
        try{
            trans.begin();
            em.merge(order);
            trans.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public Order findById(Long id){
        TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o WHERE o.orderId = :id", Order.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
    public List<Order> findAllOrder(){
        return em.createNamedQuery("Order.findAll", Order.class).getResultList();
    }
}
