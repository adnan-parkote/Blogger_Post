package com.velox.dao;

import java.util.List;

import com.velox.model.Post;
import com.velox.model.Student;

public interface StudentDao {

	String signUp(Student student);

	List<Student> getStudentList();

	Student findStudent(int id);

	String updateStudent(Student student);

	String deleteStudent(Student student);

	String[] login(String username, String password);

	String createPost(Post post);

	List<Post> getPostList();

	Post findPost(int id);

	String updatePost(Post post);

	String deletePost(Post post);
}
