package vn.edu.iuh.fit.www_lab_week2.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.www_lab_week2.enums.EmployeeStatus;
import vn.edu.iuh.fit.www_lab_week2.models.Customer;
import vn.edu.iuh.fit.www_lab_week2.models.Employee;

import java.util.List;

public class CustomerRepository {
    private EntityManager em;
    private EntityTransaction trans;

    public CustomerRepository(){
        em = Persistence.createEntityManagerFactory("WWW-week02").createEntityManager();
        trans = em.getTransaction();
    }

    public void insertCustomer(Customer c){
        try {
            trans.begin();
            em.persist(c);
            trans.commit();
        } catch (Exception e1){
            e1.printStackTrace();
        }
    }
    public void updateCustomer(Customer customer){
        try{
            trans.begin();
            em.merge(customer);
            trans.commit();
        } catch (Exception e1){
            e1.printStackTrace();
        }
    }
    public boolean deteleCustomer(Customer customer) {
        if (customer.getCustomerId()!=null) {
            try {
                trans.begin();
                em.merge(customer);
                trans.commit();
                return true;
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } return false;
    }

    public Customer findById(long id) {
        TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.customerId = :id", Customer.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
    public List<Customer> findAllCustomer(){
        return em.createNamedQuery("Customer.findAll", Customer.class).getResultList();
    }
}
