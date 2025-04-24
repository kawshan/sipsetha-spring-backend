package lk.sipsetha.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "classroomallocation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomAllocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "starttime")
    private LocalTime starttime;

    @Column(name = "endtime")
    private LocalTime endtime;

    @Column(name = "note")
    private String note;

    @Column(name = "addeddatetime")
    private LocalDateTime addeddatetime;

    @Column(name = "modifydatetime")
    private LocalDateTime modifydatetime;

    @Column(name = "deletedatetime")
    private LocalDateTime deletedatetime;


    @ManyToOne
    @JoinColumn(name = "allocationstatus_id",referencedColumnName = "id")
    private AllocationStatus allocationstatus_id;

    @ManyToOne
    @JoinColumn(name = "allocationtype_id",referencedColumnName = "id")
    private AllocationType allocationtype_id;

    @ManyToOne
    @JoinColumn(name = "weekday_id",referencedColumnName = "id")
    private WeekDay weekday_id;

    @ManyToOne
    @JoinColumn(name = "classhall_id",referencedColumnName = "id")
    private ClassHall classhall_id;

    @ManyToOne
    @JoinColumn(name = "classoffering_id",referencedColumnName = "id")
    private ClassOffering classoffering_id;



}
