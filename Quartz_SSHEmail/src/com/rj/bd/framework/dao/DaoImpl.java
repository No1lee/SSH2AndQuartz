package com.rj.bd.framework.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

import com.rj.bd.framework.page.Param;

public class DaoImpl extends HibernateDaoSupport implements IDao {
	
	
	/**
	 * 查询列表（不分页）
	 */
	public List query(String hql) {

		return super.getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("unchecked")
	public List query(final String hql, final List paramList) {
		return (List) super.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {

				Query query = session.createQuery(hql);
				for (int i = 0; i < paramList.size(); i++) {
					Param p = (Param) paramList.get(i);
					switch (p.getType()) {
					case Types.VARCHAR:
						query.setString(i, (String) p.getValue());
						break;
					case Types.INTEGER:
						query.setInteger(i, (Integer) p.getValue());
						break;
					case Types.FLOAT:
						query.setFloat(i, (Float) p.getValue());
						break;
					case Types.DOUBLE:
						query.setDouble(i, (Double) p.getValue());
						break;
					case Types.DATE:
						query.setDate(i, (Date) p.getValue());
						break;
					default:
						query.setString(i, (String) p.getValue());
						break;
					}
				}
				return query.list();
			}
		});
	}

	// /**
	// * 分页查询
	// * @param BasicPage 分页对象（里面包含HQL,pageNo,pageSize等）
	// * @return
	// */
	// public List queryForPage(final BasicPage page ) {
	//
	// return (List) super.getHibernateTemplate().execute(new
	// HibernateCallback(){
	//
	// public Object doInHibernate(Session session)throws HibernateException,
	// SQLException {
	//
	// //from com.turing.lx.student.entity.Student where name like ? and age = ?
	// Query query = session.createQuery( page.getHQLString() );
	//
	//// query.setString(0, "张飞");
	//// query.setInteger(1, 23);
	// for (int i = 0; i <page.getParamList().size(); i++) {
	// Param p = (Param) page.getParamList().get(i);
	//
	// switch( p.getType() ){
	// case Types.VARCHAR:
	// query.setString( i , (String)p.getValue() );
	// break;
	// case Types.INTEGER:
	// query.setInteger( i , (Integer)p.getValue() );
	// break;
	// case Types.FLOAT:
	// query.setFloat( i , (Float)p.getValue() );
	// break;
	// case Types.DOUBLE:
	// query.setDouble( i , (Double)p.getValue() );
	// break;
	// case Types.DATE:
	// query.setDate( i , (Date)p.getValue() );
	// break;
	// default:
	// query.setString( i , (String)p.getValue() );
	// break;
	// }
	// }
	//
	// query.setFirstResult( (page.getPageNo()-1)*page.getPageSize()
	// );//设置从第几条开始
	// query.setMaxResults( page.getPageSize() );//查询一页多少条
	//
	// return query.list();
	// }
	// });
	// }
	// /**
	// * 查询记录总数
	// * @param BasicPage 分页对象（里面包含HQL,pageNo,pageSize等）
	// * @return
	// */
	// public int queryForCount(final BasicPage page ) {
	//
	// return (Integer) super.getHibernateTemplate().execute(new
	// HibernateCallback(){
	//
	// public Object doInHibernate(Session session)throws HibernateException,
	// SQLException {
	// //select count(*) from com.turing.lx.student.entity.Student
	// Query query = session.createQuery( page.getHQLCountString() );
	//
	// for (int i = 0; i <page.getParamList().size(); i++) {
	// Param p = (Param) page.getParamList().get(i);
	//
	// switch( p.getType() ){
	// case Types.VARCHAR:
	// query.setString( i , (String)p.getValue() );
	// break;
	// case Types.INTEGER:
	// query.setInteger( i , (Integer)p.getValue() );
	// break;
	// case Types.FLOAT:
	// query.setFloat( i , (Float)p.getValue() );
	// break;
	// case Types.DOUBLE:
	// query.setDouble( i , (Double)p.getValue() );
	// break;
	// case Types.DATE:
	// query.setDate( i , (Date)p.getValue() );
	// break;
	// default:
	// query.setString( i , (String)p.getValue() );
	// break;
	// }
	// }
	//
	// List list = query.list();
	// Integer integer = (Integer) list.get(0);
	//
	// return integer;
	// }
	// });
	// }

	public Object queryById(Class cla, Serializable id) {

		return this.getHibernateTemplate().load(cla, id);
	}

	public void save(Object obj) {
		super.getHibernateTemplate().save(obj);
	}

	public void update(Object obj) {
		super.getHibernateTemplate().update(obj);
	}

	public void delete(Object obj) {
		super.getHibernateTemplate().delete(obj);
	}

	public void delete(Collection c) {
		// TODO Auto-generated method stub
		super.getHibernateTemplate().deleteAll(c);
	}

	public void save(Collection c) {
		// TODO Auto-generated method stub

		super.getHibernateTemplate().saveOrUpdateAll(c);
	}

	public void clear(Object obj) {
		super.getHibernateTemplate().evict(obj);

	}

	public void merge(Object obj) {
		super.getHibernateTemplate().merge(obj);

	}
}
