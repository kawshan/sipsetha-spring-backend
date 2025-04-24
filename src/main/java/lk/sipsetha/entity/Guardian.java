package lk.sipsetha.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "guardian")
@Data

@AllArgsConstructor
@NoArgsConstructor

public class Guardian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "nic")
    private String nic;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "landno")
    private String landno;

    @Column(name = "address")
    private String address;

    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "wpaddress")
    private String wpaddress;

    @Column(name = "wplandno")
    private String wplandno;

    @Column(name = "position")
    private String position;

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
    @JoinColumn(name = "guardiantype_id",referencedColumnName = "id")
    private GuardianType guardiantype_id;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user_id;
}
