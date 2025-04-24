package lk.sipsetha.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true)
    private Integer id;

    @Column(name = "empnum",unique = true,length = 5)
    @NotNull
    private String empnum;

    @Column(name = "fullname")
    @NotNull
    private String fullname;

    @Column(name = "callingname",unique = true)
    @NotNull
    private String callingname;

    @Column(name = "dob")
    @NotNull
    private LocalDate dob;

    @Column(name = "nic")
    @NotNull
    @Length(min = 10,max = 12,message = "nic value must have 10 or 12 digits")
    private String nic;

    @Column(name = "mobile",length = 10)
    @NotNull
    private String mobile;

    @Column(name = "landno",length = 10)
    private String landno;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    @NotNull
    private String address;

    @Column(name = "addeddate")
    @NotNull
    private LocalDate addeddate;

    @Column(name = "civilstatus")
    @NotNull
    private String civilstatus;



    @ManyToOne
    @JoinColumn(name = "gender_id",referencedColumnName = "id")
    private Gender gender_id;
    @ManyToOne
    @JoinColumn(name = "employeestatus_id",referencedColumnName = "id")
    private EmployeeStatus employeestatus_id;
    @ManyToOne
    @JoinColumn(name = "designation_id",referencedColumnName = "id")
    private Designation designation_id;

    @Column(name = "emp_photo")
    private byte[] emp_photo;

    @Column(name = "emp_photo_name")
    private String emp_photo_name;


}
