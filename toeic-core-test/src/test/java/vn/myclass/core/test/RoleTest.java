package vn.myclass.core.test;

import org.testng.annotations.Test;
import vn.myclass.core.dao.RoleDao;
import vn.myclass.core.daoimpl.RoleDaoImpl;
import vn.myclass.core.persistence.entity.RoleEntity;

import java.util.ArrayList;
import java.util.List;

public class RoleTest {
//    @Test
//    public void checkfindAll()
//    {
//        RoleDao roleDao = new RoleDaoImpl();
//        List<RoleEntity> list = roleDao.findAll();
//    }
//    @Test
//    public void checkUpdateRole()
//    {
//        RoleDao roleDao = new RoleDaoImpl();
//        RoleEntity entity = new RoleEntity();
//
//        entity.setRoleId(2);
//        entity.setName("USER_1");
//        roleDao.update(entity);
//    }
//    @Test
//    public void checkSaveRole()
//    {
//        RoleDao roleDao = new RoleDaoImpl();
//        RoleEntity entity = new RoleEntity();
//
//        entity.setRoleId(2);
//        entity.setName("USER");
//        roleDao.update(entity);
//    }
//    @Test
//    public void checkfindById()
//    {
//        RoleDao roleDao = new RoleDaoImpl();
//        RoleEntity entity = roleDao.findById(1);
//
//    }
//    @Test
//    public void checkfindByProperty()
//    {
//        RoleDao roleDao = new RoleDaoImpl();
//        String property = null;
//        Object value = null;
//        String sortExpression=null;
//        String sortDirection=null;
//        Object[] objects= roleDao.findByProperty(null,null,null,null);
//
//    }
//    @Test
    public void checkDelete()
    {
        List<Integer> listId= new ArrayList<Integer>();
        listId.add(1);
        listId.add(2);

        RoleDao roleDao = new RoleDaoImpl();
        Integer count= roleDao.delete(listId);
    }
}
