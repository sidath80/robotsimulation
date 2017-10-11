package com.robotsimulation.command;

public class InvalidPlaceCommandException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidPlaceCommandException(String string) {
		super(string);
	}
}
