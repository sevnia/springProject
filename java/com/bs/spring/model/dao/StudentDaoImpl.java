package com.bs.spring.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bs.spring.model.vo.Board;
import com.bs.spring.model.vo.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> selectStudentAll(SqlSession session) {
		return session.selectList("student.selectStudentAll");
	}

	@Override
	public int insertStudent(SqlSession session, String s) {
		return session.insert("student.insertStudent", s);
	}

	@Override
	public int updateStudent(SqlSession session, String s) {
		return 0;
	}

	@Override
	public int deleteStudent(SqlSession session, String id) {
		return 0;
	}

	@Override
	public int insertStudent(SqlSession session, Student s) {
		return 0;
	}

	@Override
	public Student selectStudnetById(SqlSession session, String id) {
		return session.selectOne(id);
	}

	@Override
	public List<Student> selectStudentPage(SqlSession session, int cPage, int numPerPage) {
		Map<String, Integer> pageNum = new HashMap<>();
		pageNum.put("start1", (cPage - 1) * numPerPage + 1);
		pageNum.put("end1", cPage * numPerPage);
		return session.selectList("student.selectStudentPage", pageNum);
	}




	

}
