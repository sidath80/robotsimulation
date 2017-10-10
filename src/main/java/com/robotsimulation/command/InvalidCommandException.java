package com.robotsimulation.command;

class InvalidCommandException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidCommandException(String string) {
		super(string);
	}
}
