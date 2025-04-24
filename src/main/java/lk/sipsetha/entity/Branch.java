package lk.sipsetha.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "branch")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Branch {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "bankbranchcode")
    private String bankbranchcode;

    @ManyToOne
    @JoinColumn(name = "bank_id",referencedColumnName = "id")
    private Bank bank_id;

}
