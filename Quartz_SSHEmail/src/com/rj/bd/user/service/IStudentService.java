package com.rj.bd.user.service;

import java.util.List;

/**
 * @desc   Student模块的M层接口
 */
public interface IStudentService {
	public List<?>  queryStudentAll();
	public Object querybyid(String id);
	public List queryByBir();
}
