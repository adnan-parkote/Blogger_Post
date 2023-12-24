package com.velox.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velox.dao.StudentDao;
import com.velox.model.Post;
import com.velox.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentdao;

	@Override
	public String signUp(String administrator, String username, String email, String contact, String gender,
			String password) {

		Student student = new Student();
		student.setUserrole(administrator);
		student.setStudentname(username);
		student.setEmail(email);
		student.setContact(contact);
		student.setGender(gender);
		student.setPassword(password);

		String result = studentdao.signUp(student);
		return result;
	}

	@Override
	public JSONArray getStudentList() {

		JSONArray result = new JSONArray();
		try {
			List<Student> studentList = studentdao.getStudentList();
			for (Student student : studentList) {
				JSONArray studentarr = new JSONArray();
				studentarr.put(student.getUserrole());
				studentarr.put(student.getStudentname());
				studentarr.put(student.getEmail());
				studentarr.put(student.getContact());
				studentarr.put(student.getGender());

				studentarr.put(
						"<button class='btn btn-primary' data-toggle='modal' data-target='#userEdit' onclick='editStudent("
								+ student.getStudentid() + ");' ><i class='fa fa-edit'></i></button>"); 
				studentarr.put("<button class='btn btn-danger' onclick='deleteStudent(" + student.getStudentid()
						+ ");' ><i class=\"fa fa-trash\"></i></button>");
				result.put(studentarr);
			}

		} catch (Exception e) {
			System.out.println("[ERROR] in getUsersListService::" + e.getMessage());
		}

		return result;
	}

	@Override
	public JSONObject getStudentDetails(int id) {

		JSONObject result = new JSONObject();

		try {
			Student student = studentdao.findStudent(id);
			result.put("administrator", student.getUserrole());
			result.put("username", student.getStudentname());
			result.put("email", student.getEmail());
			result.put("contact", student.getContact());
			result.put("gender", student.getGender());
			result.put("password", student.getPassword());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public String updateStudent(String srno, String administrator, String username, String email, String contact,
			String gender, String password) {

		Student student = studentdao.findStudent(Integer.parseInt(srno));
		student.setUserrole(administrator);
		student.setStudentname(username);
		student.setEmail(email);
		student.setContact(contact);
		student.setGender(gender);
		student.setPassword(password);

		return studentdao.updateStudent(student);
	}

	@Override
	public String deleteStudent(String srno) {

		Student student = studentdao.findStudent(Integer.parseInt(srno));

		return studentdao.deleteStudent(student);
	}

	@Override
	public String[] login(String username, String password) {

		String[] status = null;
		try {
			status = studentdao.login(username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public String createPost(String postedby, String title, String description) {

		Post post = new Post();
		post.setPosttitle(title);
		post.setPostdescription(description);
		post.setPostedby(postedby);

		String result = studentdao.createPost(post);

		return result;
	}

	@Override
	public JSONArray getPostList() {

		JSONArray result = new JSONArray();
		try {
			List<Post> postList = studentdao.getPostList();
			for (Post post : postList) {
				JSONArray posttarr = new JSONArray();
				posttarr.put(post.getPosttitle());
				posttarr.put(post.getPostdescription());
				posttarr.put(post.getPostedby());
				posttarr.put(
						"<button class='btn btn-primary' data-toggle='modal' data-target='#postEdit' onclick='editPost("
								+ post.getPostid() + ");' ><i class='fa fa-edit'></i></button>");
				posttarr.put("<button class='btn btn-danger' onclick='deletePost(" + post.getPostid()
						+ ");' ><i class=\"fa fa-trash\"></i></button>");
				result.put(posttarr);
			}

		} catch (Exception e) {
			System.out.println("[ERROR] in getUsersListService::" + e.getMessage());
		}

		return result;

	}

	@Override
	public JSONObject getPostDetails(int id) {
		JSONObject result = new JSONObject();

		try {
			Post post = studentdao.findPost(id);
			result.put("title", post.getPosttitle());
			result.put("description", post.getPostdescription());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public String updatePost(String srno, String titleupdate, String descriptionupdate) {

		Post post = studentdao.findPost(Integer.parseInt(srno));
		post.setPosttitle(titleupdate);
		post.setPostdescription(descriptionupdate);

		return studentdao.updatePost(post);
	}

	@Override
	public String deletePost(String srno) {

		Post post = studentdao.findPost(Integer.parseInt(srno));

		String result = studentdao.deletePost(post);
		return result;
	}

}
