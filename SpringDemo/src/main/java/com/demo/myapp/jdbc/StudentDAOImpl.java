package com.demo.myapp.jdbc;

import java.sql.*;

import javax.sql.DataSource;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class StudentDAOImpl implements StudentDAO {
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void insert(Student student) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO student(NAME,CLASSNAME,STATUS) VALUE(?,?,?)";
		Connection connection = null;

		try {
			connection = dataSource.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);

			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getClassName());
			preparedStatement.setString(3, student.getStatus());

			int results = preparedStatement.executeUpdate();

			if (results > 0) {
				System.out.println("Insert success");
			} else {
				System.out.println("Insert fail");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Student findByStudentId(int studentId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM student WHERE ID=?";
		Connection connection = null;
		Student student = null;

		try {
			connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setInt(1, studentId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				student = new Student(resultSet.getString("NAME"),
						resultSet.getString("CLASSNAME"),
						resultSet.getString("STATUS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return student;
	}
}
