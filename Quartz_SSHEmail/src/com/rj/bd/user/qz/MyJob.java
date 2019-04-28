package com.rj.bd.user.qz;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import com.rj.bd.framework.entity.Student;
import com.rj.bd.utils.MailUtils;
import com.rj.bd.user.service.IStudentService;
import com.rj.bd.utils.DateUtils;

/**
 * @desc JOb任务类
 */
public class MyJob {

	public IStudentService studentService;
	public List list;
	public DateUtils dateu;
	public Student stu;

	public String query() {
		list = studentService.queryStudentAll();

		return "birlist";

	}

	public String queryByBir() {
		list = studentService.queryByBir();

		return "birlist";

	}

	public void Checkbirthday() throws Exception {
		String email = "";
		String name = "";
		String mes = "";
		list = studentService.queryByBir();
		if (list != null) {
			System.out.println("生日人数共有:" + list.size() + "人！");
			for (int i = 0; i < list.size(); i++) {
				stu = (Student) list.get(i);
				email = stu.getEmail();
				if (email == null) {
					System.out.println("发送失败" + name + "邮箱为空!");
					continue;
				}
				name = stu.getName();
				mes = "发送成功！生日快乐：------" + name;
				System.out.println("进入发送邮件");
				MailUtils.sendMail(email, mes, 2);// 发送邮件
			}
		} else {
			System.out.println("没有人生日哦！");
		}

	}

	public void work() throws Exception {
		System.out.println("date:" + new Date().toString());
		System.out.println("检查是否有人生日，如果有就发送邮件");
		// Checkbirthday();
	}

	// set and get
	public IStudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public DateUtils getDateu() {
		return dateu;
	}

	public void setDateu(DateUtils dateu) {
		this.dateu = dateu;
	}

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

}
