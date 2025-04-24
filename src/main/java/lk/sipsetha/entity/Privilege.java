package lk.sipsetha.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "privilege")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Privilege {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sel")
    @NotNull
    private Boolean sel;

    @Column(name = "inst")
    @NotNull
    private Boolean inst;

    @Column(name = "upd")
    @NotNull
    private Boolean upd;

    @Column(name = "del")
    @NotNull
    private Boolean del;



    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role_id;

    @ManyToOne
    @JoinColumn(name = "module_id", referencedColumnName = "id")
    private Module module_id;
}
