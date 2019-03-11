package com.sresta.restjersey.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sresta.restjersey.entity.Student;

public class StudentDAO extends DAO{
	
	
	public StudentDAO(){}
	
	public List<Student> getAllStudents() throws SQLException{
		List<Student> students = new ArrayList<Student>();
		
		PreparedStatement stmt;
		stmt = con.prepareStatement("Select * from student");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			Student std = new Student();
			std.setuId(rs.getString("uId"));
			std.setFirstName(rs.getString("firstName"));
			std.setMiddleName(rs.getString("middleName"));
			std.setLastName(rs.getString("lastName"));
			std.setGender(rs.getString("gender"));
			std.setDeptId(rs.getString("deptId"));
			std.setLevel(rs.getString("level"));
			std.setDegId(rs.getString("degId"));
			
			students.add(std);
		}
	
		return students;
	}

	
	public Student getStudent(String uId) throws SQLException{
		Student std = null;
		PreparedStatement stmt = con.prepareStatement("Select * from student where uId = ?");
		stmt.setString(1, uId);
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()){
			std = new Student();
			std.setuId(rs.getString("uId"));
			std.setFirstName(rs.getString("firstName"));
			std.setMiddleName(rs.getString("middleName"));
			std.setLastName(rs.getString("lastName"));
			std.setGender(rs.getString("gender"));
			std.setDeptId(rs.getString("deptId"));
			std.setLevel(rs.getString("level"));
			std.setDegId(rs.getString("degId"));
				
		}
		return std;
	}

	
	public void createStudent(Student std) throws SQLException {
		System.out.println(std.toString());
		PreparedStatement stmt = con.prepareStatement("insert into student values(?,?,?,?,?,?,?,?)");
		
		stmt.setString(1, std.getuId());
		stmt.setString(2, std.getFirstName());
		stmt.setString(3, std.getMiddleName());
		stmt.setString(4, std.getLastName());
		stmt.setString(5, std.getGender());
		stmt.setString(6, std.getDeptId());
		stmt.setString(7, std.getLevel());
		stmt.setString(8, std.getDegId());
			
		stmt.executeUpdate();
	}
	
	
	public void updateStudent(Student std) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("update student set firstName=?, middleName=?,"
													+ "lastName=?, gender=?, deptId=?, level=?, degId=? "
													+ "where uId= ?");

		stmt.setString(1, std.getFirstName());
		stmt.setString(2, std.getMiddleName());
		stmt.setString(3, std.getLastName());
		stmt.setString(4, std.getGender());
		stmt.setString(5, std.getDeptId());
		stmt.setString(6, std.getLevel());
		stmt.setString(7, std.getDegId());
		stmt.setString(8, std.getuId());
			
		stmt.executeUpdate();
	}
	
	
	public void deleteStudent(String uId) throws SQLException {
		
		PreparedStatement stmt = con.prepareStatement("delete from student where uId= ?");
		stmt.setString(1, uId);
		stmt.executeUpdate();
	}
	
	public boolean checkStudentExists(String uId) throws SQLException{
		boolean studentExists = false;
		
		PreparedStatement stmt = con.prepareStatement("Select * from student where uId = ?");
		stmt.setString(1, uId);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()){
			studentExists = true;
		}
		return studentExists;
	}
	
}
