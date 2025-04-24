package lk.sipsetha.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fees")
    private BigDecimal fees;

    @Column(name = "month")
    private String month;

    @Column(name = "billnumber")
    private String billnumber;

    @Column(name = "payedamount")
    private BigDecimal payedamount;

    @Column(name = "balanceamount")
    private BigDecimal balanceamount;

    @Column(name = "referencenumber")
    private String referencenumber;

    @Column(name = "cardno")
    private String cardno;

    @Column(name = "addeddatetime")
    private LocalDateTime addeddatetime;

    @Column(name = "modifydatetime")
    private LocalDateTime modifydatetime;

    @Column(name = "addeduser")
    private Integer addeduser ;

    @Column(name = "modifyuser")
    private Integer modifyuser ;


    @ManyToOne
    @JoinColumn(name = "paytype_id" ,referencedColumnName = "id")
    private PayType paytype_id;

    @ManyToOne
    @JoinColumn(name = "student_id" ,referencedColumnName = "id")
    private Student student_id;

    @ManyToOne
    @JoinColumn(name = "studentregistration_id",referencedColumnName = "id")
    private StudentRegistration studentregistration_id;

    @ManyToOne
    @JoinColumn(name = "paymentcategory_id",referencedColumnName = "id")
    private PaymentCategory paymentcategory_id;




}
