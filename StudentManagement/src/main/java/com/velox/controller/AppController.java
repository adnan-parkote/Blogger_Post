package com.velox.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.velox.service.StudentService;

@Controller
public class AppController {

	@Autowired
	StudentService studentservice;

	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String loginStudent() {
		return "signup";
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String signUp(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			String administrator = request.getParameter("administrator");
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String contact = request.getParameter("contact");
			String gender = request.getParameter("gender");
			String password = request.getParameter("password");
			String result = studentservice.signUp(administrator, username, email, contact, gender, password);
			out.print(result);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/studentDetails", method = RequestMethod.GET)
	public String studentDetails() {
		return "getdetails";
	}

	@RequestMapping(value = { "/getStudentList" }, method = RequestMethod.POST)
	public void getStudentList(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;
		try {
			String role = session.getAttribute("userrole").toString();
			out = response.getWriter();
			JSONArray result = studentservice.getStudentList();
			out.print(result);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/getStudentDetails", method = RequestMethod.POST)
	public void getStudentDetails(HttpServletRequest request, HttpServletResponse response) {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			PrintWriter out = response.getWriter();
			JSONObject result = studentservice.getStudentDetails(id);
			out.print(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	public void updateStudent(HttpServletRequest request, HttpServletResponse response) {
		try {

			PrintWriter out = response.getWriter();
			String srno = request.getParameter("srno");
			String administrator = request.getParameter("administrator");
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String contact = request.getParameter("contact");
			String gender = request.getParameter("gender");
			String password = request.getParameter("password");

			String status = studentservice.updateStudent(srno, administrator, username, email, contact, gender,
					password);
			out.print(status);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/deleteStudent", method = RequestMethod.POST)
	public void deleteUser(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			String srno = request.getParameter("srno");

			String status = studentservice.deleteStudent(srno);
			out.print(status);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		try {
			PrintWriter out = response.getWriter();
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			String[] result = studentservice.login(username, password);

			if (result[0].equals("Success")) {
				session.setAttribute("username", username);
				session.setAttribute("userrole", result[1].toString());
			}

			out.print(result[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		return "home";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public String posts() {
		return "posts";
	}

	@RequestMapping(value = "/createPost", method = RequestMethod.POST)
	public String createPost(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		try {
			PrintWriter out = response.getWriter();
			String postedby = String.valueOf(session.getAttribute("username"));
			String title = request.getParameter("title");
			String description = request.getParameter("description");

			String result = studentservice.createPost(postedby, title, description);
			out.print(result);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = { "/getPostList" }, method = RequestMethod.POST)
	public void getPostList(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		PrintWriter out = null;
		try {
			String role = session.getAttribute("userrole").toString();
			out = response.getWriter();
			JSONArray result = studentservice.getPostList();
			out.print(result);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/newPost", method = RequestMethod.POST)
	public String newPost(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		try {
			PrintWriter out = response.getWriter();
			String postedby = String.valueOf(session.getAttribute("username"));
			String title = request.getParameter("title");
			String description = request.getParameter("description");

			String result = studentservice.createPost(postedby, title, description);
			out.print(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/getPostDetails", method = RequestMethod.POST)
	public void getPostDetails(HttpServletRequest request, HttpServletResponse response) {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			PrintWriter out = response.getWriter();
			JSONObject result = studentservice.getPostDetails(id);
			out.print(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/updatePost", method = RequestMethod.POST)
	public void updatePost(HttpServletRequest request, HttpServletResponse response) {
		try {

			PrintWriter out = response.getWriter();
			String srno = request.getParameter("srno");
			String titleupdate = request.getParameter("titleupdate");
			String descriptionupdate = request.getParameter("descriptionupdate");

			String status = studentservice.updatePost(srno, titleupdate, descriptionupdate);
			out.print(status);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/deletePost", method = RequestMethod.POST)
	public void deletePost(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();
			String srno = request.getParameter("srno");

			String status = studentservice.deletePost(srno);
			out.print(status);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
