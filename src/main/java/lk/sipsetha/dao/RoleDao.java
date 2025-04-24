package lk.sipsetha.dao;

import lk.sipsetha.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleDao extends JpaRepository<Role,Integer>{


    //define query for get role list without admin account
//    select * from role as r where r.name <> 'admin';
    @Query(value = "select r from Role r where r.name <> 'admin' ")
    public List<Role> getRoleListWithoutAdmin();

    @Query(value = "select r from Role r where r.name=?1")
    public Role getByRoleName(String role);

}
