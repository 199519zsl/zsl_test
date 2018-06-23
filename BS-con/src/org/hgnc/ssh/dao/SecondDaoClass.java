package org.hgnc.ssh.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class SecondDaoClass<T> extends HibernateDaoSupport implements FirstDaoInte<T>{
	private Class<T> clas;
	
	public Class<T> getClas(){
		if(clas != null){
			clas = (Class<T>)(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]);
		}
		return clas;
	}
	@Resource(name="sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	public void add(T t) {
		this.getHibernateTemplate().save(t);
	}

	public void delete(String id) {
		this.getHibernateTemplate().delete(this.getById(id));
	}

	public List<T> getAll() {
		return null;
	}

	public T getById(String id) {
		return this.getHibernateTemplate().load(getClas(), id);
	}

	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

}
