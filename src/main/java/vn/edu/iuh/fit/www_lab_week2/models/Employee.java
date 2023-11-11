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
    @Column(name = "full_name", length = 150, nullable = false)
    private String fullName;
    @Column(nullable = false)
    private Date dob;
    @Column(unique = true, length = 150)
    private String email;
    @Column(length = 15, nullable = false)
    private String phone;
    @Column(length = 250, nullable = false)
    private String address;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", nullable = false)
    private EmployeeStatus status;
    @JsonbTransient
    @OneToMany(mappedBy = "employee")
    private List<Order> orderList;

    public Employee(String name, java.util.Date dob, String email, String phone, String address, EmployeeStatus status) {
    }

    public Employee(String fullName, Date dob, String email, String phone, String address, EmployeeStatus status) {
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    public Employee() {

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
