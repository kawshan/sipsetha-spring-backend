package lk.sipsetha.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "studentregistration")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "indexnumber")
    private String indexnumber;

    @Column(name = "fee")
    private BigDecimal fee;

    @Column(name = "addeddatetime")
    private LocalDateTime addeddatetime;

    @Column(name = "deletedatetime")
    private LocalDateTime deletedatetime ;

    @Column(name = "modifydatetime")
    private LocalDateTime modifydatetime;

    @Column(name = "note")
    private String note;



    @ManyToOne
    @JoinColumn(name = "student_id",referencedColumnName = "id")
    private Student student_id;

    @ManyToOne
    @JoinColumn(name = "classoffering_id",referencedColumnName = "id")
    private ClassOffering classoffering_id ;

    @ManyToOne
    @JoinColumn(name = "registrationstatus_id",referencedColumnName = "id")
    private RegistrationStatus registrationstatus_id;

    @ManyToOne
    @JoinColumn(name = "registerdtype_id",referencedColumnName = "id")
    private RegisteredType registerdtype_id;


}
