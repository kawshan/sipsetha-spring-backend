package lk.sipsetha.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    @NotNull
    private String username;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "photopath")
    private String photopath;

    @Column(name = "status")
    @NotNull
    private Boolean status;

    @Column(name = "addeddatetime")
    @NotNull
    private LocalDateTime addeddatetime;

    @Column(name = "note")
    private String note;

    @Column(name = "userphoto")
    private byte[] userphoto;

    @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    private Employee employee_id;

    @ManyToMany
    @JoinTable(name = "user_has_role", joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User(Integer id,String username){
        this.id=id;
        this.username=username;
    }



}
