package projectWeb0301;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	final String JDBC_URL ="jdbc:mysql://localhost:3306/condb";
	
	public void open() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL,"user","0000");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void close() {
		try {
			pstmt.close();
			conn.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	/*
	 * 학생추가
	 */
	public void insert(Student s) {
		open();
		String sql = "INSERT INTO student(username, univ, birth, email) VALUE (?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getUsername());
			pstmt.setString(2, s.getUniv());
			pstmt.setDate(3, s.getBirth());
			pstmt.setString(4, s.getEmail());
			
			int count = pstmt.executeUpdate();
			
			if(count == 0) {
				System.out.println("추가 실패");
			} else {
				System.out.println("추가 성공");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	public List<Student> getAll() {
		open();
		List<Student> students = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("select * from student");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setUsername(rs.getString("username"));
				s.setUniv(rs.getString("univ"));
				s.setBirth(rs.getDate("birth"));
				s.setEmail(rs.getString("email"));
				
				students.add(s);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return students;
	}
	
	public List<Student> nameSearch(String name) {
		List<Student> students = new ArrayList<>();
		open();
		try {
			String sql = "select * from student where username like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setUsername(rs.getString("username"));
				s.setUniv(rs.getString("univ"));
				s.setBirth(rs.getDate("birth"));
				s.setEmail(rs.getString("email"));
				
				students.add(s);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return students;
	}
	
	public List<Student> univSearch(String univname) {
		List<Student> students = new ArrayList<>();
		open();
		try {
			String sql = "select * from student where univ like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+univname+"%");
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setUsername(rs.getString("username"));
				s.setUniv(rs.getString("univ"));
				s.setBirth(rs.getDate("birth"));
				s.setEmail(rs.getString("email"));
				
				students.add(s);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return students;
	}
}
