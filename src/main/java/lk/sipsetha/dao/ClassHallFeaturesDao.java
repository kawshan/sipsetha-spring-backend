package lk.sipsetha.dao;

import lk.sipsetha.entity.ClassHallFeatures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassHallFeaturesDao extends JpaRepository<ClassHallFeatures,Integer> {

    @Query(value = "select ch from ClassHallFeatures ch where ch.id not in(select chHsChf.classhallfeatures_id.id from ClassHallHasClassHallFeatures chHsChf where chHsChf.classhall_id.id=?1)")
//    select ch.id, ch.name from classhall as ch where ch.id not in(select chHsChf.classhallfeatures_id from classhall_has_classhallfeatures as chHsChf where classhall_id)
    public List<ClassHallFeatures> getClassHallWithOutFeatures(Integer classHallId);
}
