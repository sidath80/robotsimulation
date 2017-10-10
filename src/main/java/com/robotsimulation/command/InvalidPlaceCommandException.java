package com.robotsimulation.command;

class InvalidPlaceCommandException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidPlaceCommandException(String string) {
		super(string);
	}
}
