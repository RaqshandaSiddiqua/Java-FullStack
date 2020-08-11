package com.learnersacademy.dao;

import java.util.List;

import com.exception.MyException;
import com.learnersacademy.model.ClassObj;
import com.learnersacademy.model.StudentObj;
import com.learnersacademy.model.SubjectObj;
import com.learnersacademy.model.TeacherObj;

public interface LearnersAcadDAO {
	public boolean userLogin(String username, String password) throws MyException;
	public List<SubjectObj> listSubject() throws MyException;
	public List<ClassObj> listClasses() throws MyException;
	public List<TeacherObj> listTeacher() throws MyException;
	public List<StudentObj> listStudents() throws MyException;
	public boolean deleteSubject(Integer subjectID) throws MyException;
	public boolean deleteClass(Integer classID) throws MyException;
	public boolean deleteTeacher(Integer teacherID) throws MyException;
	public boolean deleteStudent(Integer studentID) throws MyException;
	public boolean addSubject(SubjectObj subject) throws MyException;
	public boolean addClass(ClassObj cls) throws MyException;
	public boolean addTeacher(TeacherObj teacher) throws MyException;
	public boolean addStudent(StudentObj student) throws MyException;
	public boolean updSubject(SubjectObj subject) throws MyException;
	public boolean updTeacher(TeacherObj teacher) throws MyException;
	public boolean updStudent(StudentObj student) throws MyException;
	public List<Object> generateReport(ClassObj cls) throws MyException;
}
