package vn.myclass.core.daoimpl;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.myclass.core.common.common.util.HibernateUtil;
import vn.myclass.core.dao.UserDao;
import vn.myclass.core.data.daoimpl.AbstractDao;

import vn.myclass.core.persistence.entity.UserEntity;

public class UserDaoImpl extends AbstractDao<Integer, UserEntity> implements UserDao {


    @Override
    public UserEntity isUserExist(String name, String password) {
        UserEntity entity = new UserEntity();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();


        try
        {
            //HQL
            StringBuilder sql = new StringBuilder("from UserEntity WHERE name= :name AND password= :password");

            //Query phải dùng cái của hibernate
            Query query = session.createQuery(sql.toString());
            query.setParameter("name",name);
            query.setParameter("password",password);
            entity = (UserEntity) query.uniqueResult();
            transaction.commit();
        }
        catch (HibernateException e)
        {
            transaction.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        return entity;
    }

    @Override
    public UserEntity findRoleByName(String name) {
        UserEntity entity = new UserEntity();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();


        try
        {
            //HQL
            StringBuilder sql = new StringBuilder("from UserEntity WHERE name= :name ");

            //Query phải dùng cái của hibernate
            Query query = session.createQuery(sql.toString());
            query.setParameter("name",name);
            //query.setParameter("password",password);
            entity = (UserEntity) query.uniqueResult();
            transaction.commit();
        }
        catch (HibernateException e)
        {
            transaction.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        return entity;
    }
}
