package com.velox.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.velox.model.Post;
import com.velox.model.Student;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public String signUp(Student student) {

		String status;
		try {

			int value = (int) sessionFactory.getCurrentSession().save(student);
			if (value > 0) {
				status = "success";
			} else {
				status = "error";
			}

		} catch (Exception e) {
			status = "error";
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public List<Student> getStudentList() {

		List<Student> studentList = null;
		try {
			studentList = sessionFactory.getCurrentSession().createQuery("from Student").list();

		} catch (Exception e) {
			System.err.println("[ERROR] in getStudentList::" + e.getMessage());

		}
		return studentList;

	}

	@Override
	public Student findStudent(int id) {

		Student student = null;

		try {
			student = sessionFactory.getCurrentSession().get(Student.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public String updateStudent(Student student) {
		String status = null;
		try {
			sessionFactory.getCurrentSession().update(student);
			status = "success";
		} catch (Exception e) {
			status = "error";
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public String deleteStudent(Student student) {

		String status = null;
		try {
			sessionFactory.getCurrentSession().delete(student);
			status = "success";
		} catch (Exception e) {
			status = "error";
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String[] login(String username, String password) {

		String[] status = new String[2];
		List<Student> studentlist = null;
		Student result = null;
		String usernames = null;

		try {
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Student where studentname=:name");
			query.setParameter("name", username);
			studentlist = query.list();
			result = studentlist.get(0);

			for (Student student : studentlist) {
				usernames = student.getStudentname();
			}

			if (result.getPassword().equals(password)  && usernames.equals(username)) {
				status[0] = "Success";
				status[1] = result.getUserrole();
			} else {
				status[0] = "Invalid User OR Password !!";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println(studentlist +" dao controlle");
//		System.out.println(result +" dao controlle");
//		System.out.println(status[0]+" dao controller ");
//		System.out.println(status[1]+" dao controller ");
		return status;
	}

	@Override
	public String createPost(Post post) {

		String status;
		try {

			int value = (int) sessionFactory.getCurrentSession().save(post);
			if (value > 0) {
				status = "success";
			} else {
				status = "error";
			}

		} catch (Exception e) {
			status = "error";
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public List<Post> getPostList() {

		List<Post> postList = null;
		try {
			postList = sessionFactory.getCurrentSession().createQuery("from Post").list();

		} catch (Exception e) {
			System.err.println("[ERROR] in getStudentList::" + e.getMessage());

		}

		System.out.println(postList + " dao method");
		return postList;

	}

	@Override
	public Post findPost(int id) {

		Post post = null;

		try {
			post = sessionFactory.getCurrentSession().get(Post.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return post;

	}

	@Override
	public String updatePost(Post post) {
		String status = null;
		try {
			sessionFactory.getCurrentSession().update(post);
			status = "success";
		} catch (Exception e) {
			status = "error";
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public String deletePost(Post post) {
		String status = null;
		try {
			sessionFactory.getCurrentSession().delete(post);
			status = "success";
		} catch (Exception e) {
			status = "error";
			e.printStackTrace();
		}
		return null;
	}

}
