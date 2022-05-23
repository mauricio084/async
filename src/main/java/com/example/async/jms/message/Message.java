package com.example.async.jms.message;

public class Message {
	private String msg;

	public Message() {
	}
	
	public Message(String msg){
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Message [msg=" + msg + "]";
	}

}
