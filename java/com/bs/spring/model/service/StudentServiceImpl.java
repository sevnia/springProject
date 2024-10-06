package com.bs.spring.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.spring.model.dao.StudentDao;
import com.bs.spring.model.vo.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao dao;
	
	@Autowired
	private SqlSession session;

	@Override
	public List<Student> selectStudentAll() {
		return dao.selectStudentAll(session);
	}

	@Override
	public Student selectStudnetById(String id) {
		return dao.selectStudnetById(session, id);
	}

	@Override
	public List<Student> selectStudentPage(int cPage, int numPerPage) {
		return dao.selectStudentPage(session, cPage, numPerPage);
	}

	@Override
	public int insertStudent(Student s) {
		return 0;
	}

	@Override
	public int updateStudent(String s) {
		return 0;
	}

	@Override
	public int deleteStudent(String id) {
		return 0;
	}

	@Override
	public int insertStudent(String s) {
		return 0;
	}



	

}
