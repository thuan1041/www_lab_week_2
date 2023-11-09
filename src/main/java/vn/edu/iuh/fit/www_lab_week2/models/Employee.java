package vn.edu.iuh.fit.www_lab_week2.models;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import vn.edu.iuh.fit.www_lab_week2.enums.EmployeeStatus;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "employee")
@NamedQueries(
    @NamedQuery(name = "Employee.findAll", query = "select e from Employee e")
)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long empId;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "dob", columnDefinition = "date(6)")
    private Date dob;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private EmployeeStatus status;
    @JsonbTransient
    @OneToMany(mappedBy = "employee")
    private List<Order> orderList;

    public Employee() {
    }

    public Employee(String fullName, Date dob, String email, String phone, String address, EmployeeStatus status, List<Order> orderList) {
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.orderList = orderList;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
