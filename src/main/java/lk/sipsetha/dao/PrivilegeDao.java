package lk.sipsetha.dao;

import lk.sipsetha.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PrivilegeDao extends JpaRepository <Privilege,Integer> {

    @Query("select p from Privilege p where p.role_id.id=?1 and p.module_id.id=?2")
    Privilege getByRoleModule(Integer roleid, Integer moduleid);

    @Query(value = "select bit_or(p.sel) as pri_select, bit_or(p.inst) as pri_insert, bit_or(p.upd) as pri_update, bit_or(p.del) as pri_delete from sipsetha.privilege as p where p.module_id in(select m.id from sipsetha.module as m where m.name=?2) and p.role_id in(SELECT uhr.role_id FROM sipsetha.user_has_role as uhr where uhr.user_id in (SELECT u.id FROM sipsetha.user as u where u.username=?1));",nativeQuery = true)
    public String getPrivilegeByUserModule(String username, String modulename);

}
