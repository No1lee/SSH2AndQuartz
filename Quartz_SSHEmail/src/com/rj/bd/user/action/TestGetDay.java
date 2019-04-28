package com.rj.bd.user.action;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rj.bd.user.service.IStudentService;
import com.rj.bd.user.service.StudentServiceImpl;
import com.rj.bd.utils.DateUtils;

public class TestGetDay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateUtils dateu = new DateUtils();
		
		System.out.println(dateu.getOneDayAfter());
		
		
	}

}
