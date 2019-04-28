package com.rj.bd.user.service;
/**
 * @desc   Student模块的M层接口的实现类
 */

import java.util.List;

import com.rj.bd.framework.dao.IDao;
import com.rj.bd.framework.entity.Student;
import com.rj.bd.utils.DateUtils;

public class StudentServiceImpl implements IStudentService {

	public IDao dao;

	public List<?> queryStudentAll() {

		return dao.query("  from  com.rj.bd.framework.entity.Student  ");
	}

	public Object querybyid(String id) {
		
		return dao.queryById(Student.class, id);
	}
	
	public List<Student> queryByBir() {
		DateUtils dateu = new DateUtils();
		String nextDay = dateu.getOneDayAfter();
		String hql = "from  com.rj.bd.framework.entity.Student where DATE_FORMAT(bir,'%m%d') >= DATE_FORMAT(now(),'%m%d') "
				+ " and DATE_FORMAT(bir,'%m%d') <= DATE_FORMAT('"+nextDay+"','%m%d') ";
		System.out.println(hql);
		return (List<Student>) dao.query(hql);
	}
	
	//set and get 
	public IDao getDao() {
		return dao;
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}

}
