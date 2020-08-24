package com.shoes.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table

public class User {
	public int getUserId() {
		return userId;
	}

	public User(int userId, String userName, int userAge, Date date, List<Shoes> shoes) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAge = userAge;
		this.date = date;
		this.shoes = shoes;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userAge=" + userAge + ", date=" + date
				+ ", shoes=" + shoes + "]";
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Shoes> getShoes() {
		return shoes;
	}

	public void setShoes(List<Shoes> shoes) {
		this.shoes = shoes;
	}

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private int userId;
	private String userName;
	private int userAge;
	private Date date;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(name = "user_shoes",
			joinColumns = @JoinColumn(name="user_shoes"),
			inverseJoinColumns = @JoinColumn(name="shoesId"))
	private List<Shoes> shoes;

}
