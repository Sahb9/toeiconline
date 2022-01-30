package vn.myclass.core.test;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import vn.myclass.core.dao.UserDao;
import vn.myclass.core.daoimpl.UserDaoImpl;
import vn.myclass.core.persistence.entity.UserEntity;

public class LoginTest {
    private final Logger log = Logger.getLogger(this.getClass());

    @Test
    public void checkisUserExist()
    {
        UserDao userDao = new UserDaoImpl();
        String name ="anhtuan";
        String password = "123456";
        UserEntity entity = userDao.isUserExist(name,password);
        if(entity!=null)
        {
            log.error("login success");
        }
        else
        {
            log.error("login fail");

        }
    }
    @Test
    public void checkfindRoleByName()
    {
        UserDao userDao = new UserDaoImpl();
        String name ="anhtuan";

        UserEntity entity = userDao.findRoleByName(name);
        if(entity!=null)
        {
            log.error(entity.getRoleEntity().getName() +"-"+entity.getName());
        }
        else
        {
            log.error("login fail");

        }
    }
}
