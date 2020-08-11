package com.learnersacademy.bo;

import java.util.List;

import com.exception.MyException;
import com.learnersacademy.dao.LearnersAcadDAOImpl;
import com.learnersacademy.model.ClassObj;
import com.learnersacademy.model.StudentObj;
import com.learnersacademy.model.SubjectObj;
import com.learnersacademy.model.TeacherObj;

public class LearnersAcadBOImpl implements LearnersAcadBO{

	@Override
	public boolean userLogin(String username, String password) throws MyException {
		boolean bool=false; 
		if(!username.isEmpty() && !password.isEmpty()){
			if(username.matches("^[a-zA-Z0-9]+$") && password.matches("^[A-Za-z0-9]+$")) {
				LearnersAcadDAOImpl daoObject=new LearnersAcadDAOImpl();
				daoObject.userLogin(username, password);
				bool=true;
				return bool;
			}
			else {throw new MyException("Invalid Credentials");}
			
		}
		else {throw new MyException("Username or Password Cannot be Null");}
		
	}

	@Override
	public List<SubjectObj> listSubject() throws MyException {
		LearnersAcadDAOImpl daoObject=new LearnersAcadDAOImpl();
		List<SubjectObj> subjectList=daoObject.listSubject();
		return subjectList;
	}

	@Override
	public List<ClassObj> listClasses() throws MyException {
		LearnersAcadDAOImpl daoObject=new LearnersAcadDAOImpl();
		List<ClassObj> classList=daoObject.listClasses();
		return classList;	
		}

	@Override
	public List<TeacherObj> listTeacher() throws MyException {
		LearnersAcadDAOImpl daoObject=new LearnersAcadDAOImpl();
		List<TeacherObj> teacherList=daoObject.listTeacher();
		return teacherList;	
	}

	@Override
	public List<StudentObj> listStudents()  throws MyException {
		LearnersAcadDAOImpl daoObject=new LearnersAcadDAOImpl();
		List<StudentObj> studentList=daoObject.listStudents();
		return studentList;	
	}

	@Override
	public boolean deleteSubject(Integer subjectID) throws MyException {
		LearnersAcadDAOImpl daoObject=new LearnersAcadDAOImpl();
		return daoObject.deleteSubject(subjectID);
	
	}

	@Override
	public boolean deleteClass(Integer classID) throws MyException {
		LearnersAcadDAOImpl daoObject=new LearnersAcadDAOImpl();
		return daoObject.deleteClass(classID);	
		}

	@Override
	public boolean deleteTeacher(Integer teacherID) throws MyException {
		LearnersAcadDAOImpl daoObject=new LearnersAcadDAOImpl();
		return daoObject.deleteTeacher(teacherID);	
			}

	@Override
	public boolean deleteStudent(Integer studentID) throws MyException {
		LearnersAcadDAOImpl daoObject=new LearnersAcadDAOImpl();
		return daoObject.deleteStudent(studentID);	
			}

	@Override
	public boolean addSubject(SubjectObj subject) throws MyException {
		if(subject.getSubName().isEmpty()||subject.getSubLang().isEmpty()) {
			throw new MyException("Subject Name or Language Cannot be Empty");
		}
		else {
			if(subject.getSubName().matches("^[A-Za-z\\S]+$")) {
				
				if(subject.getSubLang().matches("^[A-Za-z]+$")) {
					LearnersAcadDAOImpl daoObject=new LearnersAcadDAOImpl();
					return daoObject.addSubject(subject);
				
				}
				else {
					throw new MyException("Subject Language should only have alphabets, No White Spaces Allowed");
				}

			}
			else {
				throw new MyException("Subject Name should only have alphabets and spaces");
			}
			
		}
	}

	@Override
	public boolean addClass(ClassObj cls) throws MyException {
		if(cls.getStandard()==null || cls.getDivision().isEmpty()) {
			throw new MyException("Subject Name or Language Cannot be Empty");
		}
		else {
			if(cls.getStandard()>0||cls.getStandard()<12) {
				
				if(cls.getDivision().matches("[A-D]{1}")) {
					LearnersAcadDAOImpl daoObject=new LearnersAcadDAOImpl();
					return daoObject.addClass(cls);
				
				}
				else {
					throw new MyException("Pls choose a division from A,B,C,D");
				}

			}
			else {
				throw new MyException("Standard Should be betweeen 1 and 12");
			}
			
		}
	}

	@Override
	public boolean addTeacher(TeacherObj teacher) throws MyException {
		if(teacher.getTeacherName().isEmpty()||teacher.getTeacherCategory().isEmpty()||teacher.getExperience()==null) {
			throw new MyException("Teacher Name, Category or Experience Cannot be Empty");
		}
		else {
			if(teacher.getTeacherName().matches("^[A-Za-z\\s]+$")) {
				
				if(teacher.getTeacherCategory().matches("^[A-Za-z]+$")) {
					LearnersAcadDAOImpl daoObject=new LearnersAcadDAOImpl();
					return daoObject.addTeacher(teacher);
				
				}
				else {
					throw new MyException("Teacher Category should only have alphabets, No White Spaces Allowed");
				}

			}
			else {
				throw new MyException("Teacher Name should only have alphabets and spaces");
			}
			
		}
	}

	@Override
	public boolean addStudent(StudentObj student) throws MyException {
		if(student.getStudentName().isEmpty()|| student.getStudentDOB()==null) {
			throw new MyException("Student Name or DoB Cannot be Empty");
		}
		else {
			if(student.getStudentName().matches("^[A-Za-z\\S]+$")) {
				
					LearnersAcadDAOImpl daoObject=new LearnersAcadDAOImpl();
					return daoObject.addStudent(student);
							
			}
			else {
				throw new MyException("Teacher Name should only have alphabets and spaces");
			}
			
		}

	}

	@Override
	public boolean updSubject(SubjectObj subject) throws MyException {
		if(subject.getSubName().matches("^[A-Za-z\\s]+$")||subject.getSubName().isEmpty()) {
			
			if(subject.getSubLang().matches("^[A-Za-z]+$")||subject.getSubLang().isEmpty()) {
				LearnersAcadDAOImpl daoObject=new LearnersAcadDAOImpl();
				return daoObject.updSubject(subject);
			
			}
			else {
				throw new MyException("Subject Language should only have alphabets, No White Spaces Allowed");
			}

		}
		else {
			throw new MyException("Subject Name should only have alphabets and spaces");
		}

	}

	
	@Override
	public boolean updTeacher(TeacherObj teacher) throws MyException {
		if(teacher.getTeacherName().isEmpty()&&teacher.getTeacherCategory().isEmpty()&&teacher.getExperience()==null) {
			throw new MyException("Teacher Name, Category and Experience Cannot be Empty. No parameter to be updated");
		}
		else {
			if(teacher.getTeacherName().matches("^[A-Za-z\\s]+$")||teacher.getTeacherName().isEmpty()) {
				
				if(teacher.getTeacherCategory().matches("^[A-Za-z]+$")||teacher.getTeacherCategory().isEmpty()) {
					LearnersAcadDAOImpl daoObject=new LearnersAcadDAOImpl();
					return daoObject.updTeacher(teacher);
				
				}
				else {
					throw new MyException("Teacher Category should only have alphabets, No White Spaces Allowed");
				}

			}
			else {
				throw new MyException("Teacher Name should only have alphabets and spaces");
			}
			
		}
	}

	@Override
	public boolean updStudent(StudentObj student) throws MyException {
		if(student.getStudentName().isEmpty() && student.getStudentDOB()==null && student.getClassID()==null) {
			throw new MyException("Student Name, DoB and ClassID all Cannot be Empty. no updation required.");
		}
		else {
			if(student.getStudentName().matches("^[A-Za-z\\s]+$") ||student.getStudentName().isEmpty()) {
				
					LearnersAcadDAOImpl daoObject=new LearnersAcadDAOImpl();
					return daoObject.updStudent(student);
							
			}
			else {
				throw new MyException("Student Name should only have alphabets and spaces");
			}
			
		}
	}

	@Override
	public List<Object> generateReport(ClassObj cls) throws MyException {
		LearnersAcadDAOImpl daoObject=new LearnersAcadDAOImpl();
		return daoObject.generateReport(cls);
	}

}
