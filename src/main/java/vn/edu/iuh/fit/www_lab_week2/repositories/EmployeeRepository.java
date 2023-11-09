package vn.edu.iuh.fit.www_lab_week2.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.www_lab_week2.enums.EmployeeStatus;
import vn.edu.iuh.fit.www_lab_week2.models.Employee;

import javax.lang.model.element.TypeElement;
import java.util.List;

public class EmployeeRepository {
    private EntityManager em;
    private EntityTransaction trans;

    public EmployeeRepository(){
        em = Persistence.createEntityManagerFactory("WWW-week02").createEntityManager();
        trans = em.getTransaction();
    }

    public void insertEmployee(Employee e){
        try {
            trans.begin();
            em.persist(e);
            trans.commit();
        } catch (Exception e1){
            e1.printStackTrace();
        }
    }
    public void updateEmployee(Employee e){
        try{
            trans.begin();
            em.merge(e);
            trans.commit();
        } catch (Exception e1){
            e1.printStackTrace();
        }
    }
    public boolean deteleEmployee(Employee e) {
        if (e.getEmpId()!=null) {
            e.setStatus(EmployeeStatus.TERMINATED);
            try {
                trans.begin();
                em.merge(e);
                trans.commit();
                return true;
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } return false;
    }

    public Employee findById(long id) {
        TypedQuery<Employee> query = em.createQuery("select e from Employee e where e.employeeId =: id", Employee.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
    public List<Employee> findAllEmployee(){
        return em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
    }
}
