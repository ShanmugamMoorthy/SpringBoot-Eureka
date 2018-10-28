package com.equifax.eureka.microsvcs.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class User {

	private String userId;
	private String userName;
	private String userMobile;
	private Date userAddedDate;

	public User() {
	}

	public User(String userId, String userName, String userMobile, Date userAddedDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userMobile = userMobile;
		this.userAddedDate = userAddedDate;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}


	/**
	 * @return the userMobile
	 */
	public String getUserMobile() {
		return userMobile;
	}

	/**
	 * @param userMobile
	 *            the userMobile to set
	 */
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	/**
	 * @return the userAddedDate
	 */
	public Date getUserAddedDate() {
		return userAddedDate;
	}

	/**
	 * @param userAddedDate
	 *            the userAddedDate to set
	 */
	public void setUserAddedDate(Date userAddedDate) {
		this.userAddedDate = new Date(System.currentTimeMillis());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userId=");
		builder.append(userId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", userMobile=");
		builder.append(userMobile);
		builder.append(", userAddedDate=");
		builder.append(userAddedDate);
		builder.append("]");
		return builder.toString();
	}

}
