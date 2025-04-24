package lk.sipsetha.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "attendance")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Attendance {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "addeduser")
    private Integer addeduser;

    @Column(name = "updateuser")
    private Integer updateuser;

    @Column(name = "deleteuser")
    private Integer deleteuser;

    @Column(name = "addeddate")
    private LocalDate addeddate;

    @Column(name = "updatedate")
    private LocalDate updatedate;

    @Column(name = "deletedate")
    private LocalDate deletedate;

    @Column(name = "note")
    private String note;




    @ManyToOne
    @JoinColumn(name = "attendancestatus_id",referencedColumnName = "id")
    private AttendanceStatus attendancestatus_id;

    @ManyToOne
    @JoinColumn(name = "student_id",referencedColumnName = "id")
    private Student student_id;

    @ManyToOne
    @JoinColumn(name = "classoffering_id",referencedColumnName = "id")
    private ClassOffering classoffering_id;











}
