package lk.sipsetha.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "classhall")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClassHall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "mincount")
    private Integer mincount;

    @Column(name = "maxcount")
    private Integer maxcount ;

    @Column(name = "tablecount")
    private Integer tablecount;

    @Column(name = "benchcount")
    private Integer benchcount ;

    @Column(name = "maxtablecount")
    private Integer maxtablecount ;

    @Column(name = "maxbenchcount")
    private Integer maxbenchcount ;

    @Column(name = "note")
    private String note ;

    @Column(name = "addeddatetime")
    private LocalDateTime addeddatetime ;

    @Column(name = "modifydatetime")
    private LocalDateTime modifydatetime ;

    @Column(name = "deletedatetime")
    private LocalDateTime deletedatetime;

    @Column(name = "addeduserid")
    private Integer addeduserid ;

    @ManyToOne
    @JoinColumn(name = "classhallstatus_id",referencedColumnName = "id")
   private ClassHallStatus classhallstatus_id;

    @ManyToMany
    @JoinTable(name = "classhall_has_classhallfeatures",joinColumns = @JoinColumn(name = "classhall_id"),inverseJoinColumns = @JoinColumn(name = "classhallfeatures_id"))
    private Set<ClassHallFeatures> features;

    public ClassHall(Integer id, String name){
        this.id=id;
        this.name=name;
    }

}
