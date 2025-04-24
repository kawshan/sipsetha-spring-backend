package lk.sipsetha.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "classhall_has_classhallfeatures")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassHallHasClassHallFeatures {

    @Id
    @ManyToOne
    @JoinColumn(name = "classhall_id",referencedColumnName = "id")
    private ClassHall classhall_id;

    @Id
    @ManyToOne
    @JoinColumn(name = "classhallfeatures_id",referencedColumnName = "id")
    private ClassHallFeatures classhallfeatures_id;





}
