package lk.sipsetha.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "enrolment_has_classoffering")
@AllArgsConstructor
@NoArgsConstructor
public class EnrolmentHasClassOfferings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "classfee")
    private BigDecimal classfee;

    @Column(name = "classincome")
    private BigDecimal classincome;

    @Column(name = "regstudentcount")
    private Integer regstudentcount;

    @Column(name = "payedcount")
    private BigDecimal payedcount;

    @Column(name = "freestudentscount")
    private Integer freestudentscount ;

    @Column(name = "servicecharge")
    private BigDecimal servicecharge;

    @Column(name = "additionalcharge")
    private BigDecimal additionalcharge;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "enrolment_id",referencedColumnName = "id")
    private Enrolment enrolment_id ;


    @ManyToOne
    @JoinColumn(name = "classoffering_id",referencedColumnName = "id")
    private ClassOffering classoffering_id;

}
