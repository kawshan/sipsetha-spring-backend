package lk.sipsetha.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "enrolment")
@AllArgsConstructor
@NoArgsConstructor

public class Enrolment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "enrolmentnum")
    private String enrolmentnum;

    @Column(name = "note")
    private String note;

    @Column(name = "addeddatetime")
    private LocalDateTime addeddatetime;

    @Column(name = "modifydatetime")
    private LocalDateTime modifydatetime;

    @Column(name = "deletedatetime")
    private LocalDateTime deletedatetime;

    @Column(name = "addeduser_id")
    private Integer addeduser_id;

    @Column(name = "modifyuser_id")
    private Integer modifyuser_id;

    @Column(name = "deleteuser_id")
    private Integer deleteuser_id;

    @Column(name = "month")
    private String month;

    @Column(name = "totalclassincome")
    private BigDecimal totalclassincome;

    @Column(name = "totalservicecharge")
    private BigDecimal totalservicecharge;

    @Column(name = "totaladditionalcharge")
    private BigDecimal totaladditionalcharge;

    @Column(name = "totaltobepayed")
    private BigDecimal totaltobepayed;

    @Column(name = "payedamount")
    private BigDecimal payedamount;



    @ManyToOne
    @JoinColumn(name = "enrolmentstatus_id",referencedColumnName = "id")
    private EnrolmentStatus enrolmentstatus_id;


    @ManyToOne
    @JoinColumn(name = "teacher_id",referencedColumnName = "id")
    private Teacher  teacher_id;

    //cascade all damme association ekata data save karannna one nisa orphan removal eka damme remove karanna eka one nisa naththam association eken remove karananna ba
    @OneToMany(mappedBy = "enrolment_id",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<EnrolmentHasClassOfferings> classOfferings;




}

