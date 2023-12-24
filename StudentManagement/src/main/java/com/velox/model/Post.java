package com.velox.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postid;

	private String posttitle;
	private String postdescription;
	private String postedby;

	public int getPostid() {
		return postid;
	}

	public void setPostid(int postid) {
		this.postid = postid;
	}

	public String getPosttitle() {
		return posttitle;
	}

	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}

	public String getPostdescription() {
		return postdescription;
	}

	public void setPostdescription(String postdescription) {
		this.postdescription = postdescription;
	}

	public String getPostedby() {
		return postedby;
	}

	public void setPostedby(String postedby) {
		this.postedby = postedby;
	}

	@Override
	public String toString() {
		return "Post [postid=" + postid + ", posttitle=" + posttitle + ", postdescription=" + postdescription
				+ ", postedby=" + postedby + "]";
	}

}
