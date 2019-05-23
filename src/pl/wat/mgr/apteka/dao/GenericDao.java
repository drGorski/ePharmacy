package pl.wat.mgr.apteka.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

public abstract class GenericDao<T> implements Serializable{
	private static final long serialVersionUID = 1L;

	private final static String UNIT_NAME = "mgr_apteka";

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIT_NAME);
	private EntityManager em;
	
	private Class<T> entityClass;
	
	public GenericDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	public void beginTransaction() {
		em = emf.createEntityManager();
		em.getTransaction().begin();
	}
	
	public void commit() {
		em.getTransaction().commit();	
	}
	
	public void rollback() {
		em.getTransaction().rollback();
	}
	
	public void closeTransaction() {
		em.close();
	}
			
	public void commitAndCloseTransaction() {
		commit();
		closeTransaction();
	}
	 
	public void flush() {
		em.flush();
	}

	public void joinTransaction() {
		em = emf.createEntityManager();
		em.joinTransaction();
	}
	
	public void save(T entity) {
		em.persist(entity);
	}
	
	public void delete(T entity) {
		T entityToRemove = em.merge(entity);
		em.remove(entityToRemove);
	}
	
	public T update(T entity) {
		return em.merge(entity);
	}
	
	public T find(long entityId) {
		return em.find(entityClass, entityId);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findAll() {
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		
		return em.createQuery(cq).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findResult(String namedQuery, Map<String, Object> parameters) {
		List<T> result = null;
		
		try
		{
			Query query = em.createNamedQuery(namedQuery);
			
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}
			
			result = (List<T>) query.getResultList();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	protected T findOneResult(String namedQuery, Map<String, Object> parameters) {
		T result = null;
		
		try 
		{
			Query query = em.createNamedQuery(namedQuery);
			
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}
			
			result = (T) query.getSingleResult();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	private void populateQueryParameters(Query query, Map<String, Object> parameters) {
		for (Entry<String, Object> entry : parameters.entrySet())
			query.setParameter(entry.getKey(), entry.getValue());
	}
}
