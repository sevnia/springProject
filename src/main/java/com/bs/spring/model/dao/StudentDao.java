package com.bs.spring.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bs.spring.model.vo.Board;
import com.bs.spring.model.vo.Student;

public interface StudentDao {
	// select문을 실행할 때는 두개의 메소드를 이용할 수 있음
	// selectOne: select문의 실행결과가 0~1개 row일 때 사용하는 메소드
	// selectList: select문의 실행결과가 0~다수의 row일 때
	
	// 매개변수 두개
	// 첫번째는 mapper와 실행할 sql문을 설정 -> "mapper namespace.sql문 id"
	// 두번째는 sql문 실행시 필요한 데이터(parameter) 설정
	
	List<Student> selectStudentAll(SqlSession session);
	
	Student selectStudnetById(SqlSession session, String id);
	List<Student> selectStudentPage(SqlSession session, int cPage, int numPerPage);
	
	int insertStudent(SqlSession session, Student s);
	int updateStudent(SqlSession session, String s);
	int deleteStudent(SqlSession session, String id);
	int insertStudent(SqlSession session, String s);
}
