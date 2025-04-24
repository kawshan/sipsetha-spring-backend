package lk.sipsetha.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "classoffering")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassOffering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "classname")
    private String classname;

    @Column(name = "fees")
    private BigDecimal fees;

    @Column(name = "duration")
    private BigDecimal duration;

    @Column(name = "note")
    private String note;

    @Column(name = "addeduserid")
    private Integer addeduserid;

    @Column(name = "addeddatetime")
    private LocalDateTime addeddatetime ;

    @Column(name = "modifydatetime")
    private LocalDateTime modifydatetime;

    @Column(name = "deletedatetime")
    private LocalDateTime deletedatetime;

    @Column(name = "servicecharge")
    private BigDecimal servicecharge;


    @ManyToOne
    @JoinColumn(name = "grade_id",referencedColumnName = "id")
    private Grade grade_id;

    @ManyToOne
    @JoinColumn(name = "classtype_id",referencedColumnName = "id")
    private ClassType classtype_id;

    @ManyToOne
    @JoinColumn(name = "academicyear_id",referencedColumnName = "id")
    private AcademicYear academicyear_id;

    @ManyToOne
    @JoinColumn(name = "subject_id",referencedColumnName = "id")
    private Subject subject_id;

    @ManyToOne
    @JoinColumn(name = "teacher_id",referencedColumnName = "id")
    private Teacher teacher_id;

    @ManyToOne
    @JoinColumn(name = "classofferingstatus_id",referencedColumnName = "id")
    private ClassOfferingStatus classofferingstatus_id;



}
