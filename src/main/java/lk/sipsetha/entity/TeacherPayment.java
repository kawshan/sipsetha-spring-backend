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
@Table(name = "teacherpayment")
@AllArgsConstructor
@NoArgsConstructor
public class TeacherPayment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "billnumber")
    private String billnumber;

    @Column(name = "addeddatetime")
    private LocalDateTime addeddatetime;

    @Column(name = "addeduser")
    private Integer addeduser;

    @Column(name = "totalenrolmentamount")
    private BigDecimal totalenrolmentamount;

    @Column(name = "totalpaymentamount")
    private BigDecimal totalpaymentamount;

    @Column(name = "totalbalanceamount")
    private BigDecimal totalbalanceamount;

    @Column(name = "bankname")
    private String bankname;

    @Column(name = "branchname")
    private String branchname;

    @Column(name = "accountholdername")
    private String accountholdername;

    @Column(name = "accountnumber")
    private String accountnumber;

    @Column(name = "depositortransferdatetime")
    private LocalDateTime depositortransferdatetime;

    @Column(name = "referencenumber")
    private String referencenumber;


    @OneToMany(mappedBy = "teacherpayment_id",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<TeacherPaymentHasEnrolment> teacherPaymentHasEnrolments;






}
