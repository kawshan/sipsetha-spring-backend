package lk.sipsetha.dao;

import lk.sipsetha.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModuleDao extends JpaRepository <Module,Integer> {


    //create query for get module by given role id
    @Query("select m from Module m where m.id not in(select p.module_id from Privilege p where p.role_id.id=?1)")
    public List<Module> getModuleByRole(Integer roleId);

}
