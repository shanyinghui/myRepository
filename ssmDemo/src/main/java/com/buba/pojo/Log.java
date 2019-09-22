package com.buba.pojo;

public class Log {
	private int id;
	private String userName;
	private String className;
	private String methodName;
	private String operteContent;
	private String exceptionMessage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getOperteContent() {
		return operteContent;
	}
	public void setOperteContent(String operteContent) {
		this.operteContent = operteContent;
	}
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	@Override
	public String toString() {
		return "Log [id=" + id + ", userName=" + userName + ", className=" + className + ", methodName=" + methodName
				+ ", operteContent=" + operteContent + ", exceptionMessage=" + exceptionMessage + "]";
	}
	
	
}
