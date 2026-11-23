package com.kassmon.programmingGame.data.generic.email;

public abstract class Email {
	
	protected final String sender;
	protected final EmailGroup recipientGroup;
	protected final String subject;
	protected String body;
	
	public Email(String sender, EmailGroup recipientGroup, String subject) {
		this.sender = sender;
		this.recipientGroup = recipientGroup;
		this.subject = subject;
		this.body = "";
	}
	
	public String getSender() {
		return sender;
	}
	
	public EmailGroup getRecipientGroup() {
		return recipientGroup;
	}
	
	public String getSubject() {
		return subject;
	}
	
	protected void addLineToBody(String line) {
		this.body += line + "\n";
	}
	
	public String getBody() {
		return body;
	}
	
}
