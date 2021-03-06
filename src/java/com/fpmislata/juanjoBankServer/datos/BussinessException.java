package com.fpmislata.juanjoBankServer.datos;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.validation.ConstraintViolation;

public class BussinessException extends Exception {

    private Set<BussinessMessage> bussinessMessages = new TreeSet<>();

    public BussinessException(List<BussinessMessage> bussinessMessages) {
        this.bussinessMessages.addAll(bussinessMessages);
    }

    public BussinessException(BussinessMessage bussinessMessage) {
        this.bussinessMessages.add(bussinessMessage);
    }

    public BussinessException(Exception ex) {
        bussinessMessages.add(new BussinessMessage(null, ex.toString()));
    }

    public BussinessException(javax.validation.ConstraintViolationException cve) {
        for (ConstraintViolation constraintViolation : cve.getConstraintViolations()) {
            String fieldName;
            String message;

            fieldName = constraintViolation.getPropertyPath() + "";
            message = constraintViolation.getMessage();

            bussinessMessages.add(new BussinessMessage(fieldName, message));
        }
    }

    public BussinessException(org.hibernate.exception.ConstraintViolationException cve) {
        bussinessMessages.add(new BussinessMessage(null, cve.getLocalizedMessage()));
    }

    public Set<BussinessMessage> getBussinessMessages() {
        return bussinessMessages;
    }
}