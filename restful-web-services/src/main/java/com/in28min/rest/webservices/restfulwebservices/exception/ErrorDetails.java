package com.in28min.rest.webservices.restfulwebservices.exception;

import java.time.LocalDate;

public class ErrorDetails {
//timestamp
//message
//details
	
private LocalDate timestamp;
private String message;
private String details;
public ErrorDetails(LocalDate timestamp, String message, String details) {
	super();
	this.timestamp = timestamp;
	this.message = message;
	this.details = details;
}
public LocalDate getTimestamp() {
	return timestamp;
}
public void setTimestamp(LocalDate timestamp) {
	this.timestamp = timestamp;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getDetails() {
	return details;
}
public void setDetails(String details) {
	this.details = details;
}
@Override
public String toString() {
	return "ErrorDetails [message=" + message + ", details=" + details + "]";
} 


}
