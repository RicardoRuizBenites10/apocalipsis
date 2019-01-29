/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.util;

/**
 *
 * @author SISTEMAS
 */
public class FilterPage {

    private String operator;
    private String property;
    private Object value;
    private boolean and;
    private boolean inWhere;

    public FilterPage(String property, Object value) {
        this.property = property;
        this.value = value;
        this.and = true;
        this.inWhere = true;
    }

    public FilterPage(String operator, String property, Object value) {
        this.operator = operator;
        this.property = property;
        this.value = value;
        this.and = true;
        this.inWhere = true;
    }

    public FilterPage(String operator, String property, Object value, boolean and, boolean inWhere) {
        this.operator = operator;
        this.property = property;
        this.value = value;
        this.and = and;
        this.inWhere = inWhere;
    }

    public FilterPage() {
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean isAnd() {
        return and;
    }

    public void setAnd(boolean and) {
        this.and = and;
    }

    public boolean isInWhere() {
        return inWhere;
    }

    public void setInWhere(boolean inWhere) {
        this.inWhere = inWhere;
    }
}
