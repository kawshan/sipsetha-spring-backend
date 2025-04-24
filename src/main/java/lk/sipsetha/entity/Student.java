package lk.sipsetha.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "stunum")
    private String stunum;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "status")
    private Boolean status;


    @Column(name = "note")
    private String note;

    @Column(name = "addeddatetime")
    private LocalDateTime addeddatetime;

    @Column(name = "modifydatetime")
    private LocalDateTime modifydatetime;

    @Column(name = "deletedatetime")
    private LocalDateTime deletedatetime;



    @ManyToOne
    @JoinColumn(name = "guardian_id",referencedColumnName = "id")
    private Guardian guardian_id;

    @ManyToOne
    @JoinColumn(name = "grade_id",referencedColumnName = "id")
    private Grade grade_id;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user_id;


}
