package lk.sipsetha.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "teacher")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "teachernum")
    private String teachernum;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "callingname")
    private String callingname;

    @Column(name = "nic")
    private String nic;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "landno")
    private String landno;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "teacherschool")
    private String teacherschool;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "accountname")
    private String accountname;

    @Column(name = "accountnumber")
    private String accountnumber;

    @ManyToOne
    @JoinColumn(name = "qualifications_id",referencedColumnName = "id")
    private Qualifications qualifications_id;

    @ManyToOne
    @JoinColumn(name = "branch_id",referencedColumnName = "id")
    private Branch branch_id;

    @ManyToOne
    @JoinColumn(name = "teacherstatus_id",referencedColumnName = "id")
    private TeacherStatus teacherstatus_id;



}
