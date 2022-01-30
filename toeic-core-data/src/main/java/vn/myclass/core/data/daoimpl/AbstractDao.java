package vn.myclass.core.data.daoimpl;

import org.hibernate.*;
import vn.myclass.core.common.common.constant.CoreConstant;
import vn.myclass.core.common.common.util.HibernateUtil;
import vn.myclass.core.data.dao.GenericDao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class AbstractDao <ID extends Serializable,T> implements GenericDao<ID,T>{
    private Class<T> persistentClass;

    public AbstractDao() {
                                //lấy cái class T
        this.persistentClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
    public String getpersistentClassName()
    {
        //Chuyển từ class sang string
        return persistentClass.getSimpleName();
    }


    public List<T> findAll() {
        List <T> list = new ArrayList<>();
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            transaction = session.beginTransaction();
            //HQL
            StringBuilder sql = new StringBuilder("from ");
            sql.append(this.getpersistentClassName());
            //Query phải dùng cái của hibernate
            Query query = session.createQuery(sql.toString());
            list =query.list();
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
        return list;
    }


    public T  update(T entity) {
        T result =null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try
        {
            //cập nhật
           Object object = session.merge(entity);
           // session.update(entity);

            result = (T) object;
            transaction.commit();

        }
        catch (HibernateException e)
        {
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
        return result;
    }

    public void  save(T entity) {
        T result =null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try
        {
            //lưu lại
            session.persist(entity);
            transaction.commit();

        }
        catch (HibernateException e)
        {
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }

    }
    public T  findById(ID id)
    {
        T result =null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try
        {
            //lưu lại
            result = (T) session.get(persistentClass,id);
            if(result==null)
            {
                throw  new ObjectNotFoundException("Not found t"+id,null);
            }

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
        return result;
    }

    @Override
    public Object[] findByProperty(String property, Object value, String sortExpression, String sortDirection) {
        List <T> list = new ArrayList<>();


        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        Object totalitem=0;
        try
        {
            //lấy list

            //HQL
            StringBuilder sql = new StringBuilder("from ");
            sql.append(this.getpersistentClassName());
            if(property !=null && value !=null)
            {
                sql.append(" where ").append(property).append("=: value");
            }
            if(sortExpression !=null && sortDirection !=null)
            {
                sql.append(" order by ").append(sortExpression);
                sql.append(" " + (sortDirection.equals(CoreConstant.SORT_ASC)?"asc":"desc"));
            }
            //Query phải dùng cái của hibernate
            Query query = session.createQuery(sql.toString());
            if(value !=null)
            {

                query.setParameter("value",value);
            }
            list =query.list();
            //lấy size
            StringBuilder sql1 = new StringBuilder("select count(*) from ");
            sql1.append(getpersistentClassName());
            if(property !=null && value !=null)
            {
                sql1.append(" where ").append(property).append("=: value");


            }

            Query query1 = session.createQuery(sql1.toString());
            if(value !=null)
            {

                query1.setParameter("value",value);
            }
            totalitem=query1.list().get(0);

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
        //phần từ 0 đầu là size , 1 là list
        return new Object[]{totalitem,list};
    }
    public Integer delete(List<ID> id)
    {
        Integer count =0;
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        try
        {
            //lưu lại
            for(ID item: id)
            {
                T t= (T) session.get(persistentClass,item);
                session.delete(t);
                count++;
            }

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
        return count;
    }
}
