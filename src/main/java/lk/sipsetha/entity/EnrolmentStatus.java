package lk.sipsetha.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "enrolmentstatus")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class EnrolmentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true)
    private Integer id;

    @Column(name = "name")
    private String name;
}
