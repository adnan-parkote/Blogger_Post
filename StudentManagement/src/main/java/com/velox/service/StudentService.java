package com.velox.service;

import org.json.JSONArray;
import org.json.JSONObject;

public interface StudentService {

	public String signUp(String administrator, String username, String email, String contact, String gender,
			String password);

	JSONArray getStudentList();

	JSONObject getStudentDetails(int id);

	public String updateStudent(String srno, String administrator, String username, String email, String contact,
			String gender, String password);

	public String deleteStudent(String srno);

	public String[] login(String username, String password);

	public String createPost(String postedby, String title, String description);

	JSONArray getPostList();

	JSONObject getPostDetails(int id);

	public String updatePost(String srno, String titleupdate, String descriptionupdate);

	public String deletePost(String srno);

}
