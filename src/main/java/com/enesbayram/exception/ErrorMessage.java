package com.enesbayram.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {

	private MessageType messageType;

	private String ofStatic;

	public ErrorMessage(MessageType messageType, String ofStatic) {
		this.messageType = messageType;
		this.ofStatic = ofStatic;
	}

	public String prepareErrorMessage() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getMessageType().getMessage());
		if (this.ofStatic != null) {
			builder.append(" : " + this.ofStatic);
		}

		return builder.toString();
	}
}
