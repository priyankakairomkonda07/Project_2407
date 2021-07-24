package com.optum.memberdetails.exceptions;

public class BirthDateException  extends Exception{
    private static final long serialVersionUID = -470180507998564368L;
    public BirthDateException() {
        super();
    }
    public BirthDateException(final String message) {
        super(message);
    }
}
