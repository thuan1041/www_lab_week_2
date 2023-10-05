package vn.edu.iuh.fit.www_lab_week2.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.www_lab_week2.enums.EmployeeStatus;

import java.sql.Date;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id", columnDefinition = "BEGINT(20)")
    private long employeeId;
    @Column(name = "full_name", columnDefinition = "VARCHAR(150)")
    private String fullName;
    @Column(name = "dob", columnDefinition = "DATETIME(6)")
    private Date dob;
    @Column(name = "email", columnDefinition = "VARCHAR(150)")

    private String email;
    @Column(name = "phone", columnDefinition = "VARCHAR(150)")

    private String phone;
    @Column(name = "adress", columnDefinition = "VARCHAR(150)")

    private String address;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private EmployeeStatus status;

    public Employee() {
    }

    public Employee(long employeeId, String fullName, Date dob, String email, String phone, String address, EmployeeStatus status) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
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
}
