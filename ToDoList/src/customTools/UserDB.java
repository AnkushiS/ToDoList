package customTools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.*;

public class UserDB {

    public static void insert(UserCh user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
        	
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(UserCh user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(UserCh user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.remove(em.merge(user));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }       
    }

    public static UserCh selectUser(String email) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM UserCh u " +
                "WHERE u.email = :email";
        TypedQuery<UserCh> q = em.createQuery(qString, UserCh.class);
        q.setParameter("email", email);
        try {
            UserCh user = q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static boolean emailExists(String email) {
        UserCh u = selectUser(email);   
        return u != null;
    }
    
    public static void insertNewList(ToDoList new_list) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
        	
            em.persist(new_list);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

	public static List<ToDoList> selectList(int userid) {
		
		 EntityManager em = DBUtil.getEmFactory().createEntityManager();
	        String qString = "SELECT u FROM ToDoList u " +
	                "WHERE u.userid = :userid";
	        TypedQuery<ToDoList> q = em.createQuery(qString, ToDoList.class);
	        q.setParameter("userid", userid);
	        List<ToDoList> dolist;
			try{
				dolist = q.getResultList();
				if(dolist==null || dolist.isEmpty()){
					dolist=null;
				}
			}finally {
				em.close();
			}
			return dolist;
			}
	 
}