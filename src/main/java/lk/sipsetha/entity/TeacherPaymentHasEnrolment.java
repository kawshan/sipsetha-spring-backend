package lk.sipsetha.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "teacherpayment_has_enrolment")
@AllArgsConstructor
@NoArgsConstructor
public class TeacherPaymentHasEnrolment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "payedamount")
    private BigDecimal payedamount;

    @Column(name = "balanceamount")
    private BigDecimal balanceamount;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "teacherpayment_id",referencedColumnName = "id")
    private TeacherPayment teacherpayment_id;

    @ManyToOne
    @JoinColumn(name = "enrolment_id",referencedColumnName = "id")
    private Enrolment enrolment_id;
}
