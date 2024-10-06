package com.bs.spring.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bs.spring.model.vo.Board;
import com.bs.spring.model.vo.Student;

public interface StudentService {
	List<Student> selectStudentAll();
	
	Student selectStudnetById(String id);
	List<Student> selectStudentPage(int cPage, int numPerPage);
	
	int insertStudent(Student s);
	int updateStudent(String s);
	int deleteStudent(String id);
	int insertStudent(String s);
//	Student selectStudentById(SqlSession session, String id);
}
