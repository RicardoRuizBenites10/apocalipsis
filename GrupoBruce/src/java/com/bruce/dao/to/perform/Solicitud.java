/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.to.perform;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author SISTEMAS
 */
public class Solicitud {
    
    private String _dc;
    private int page;
    private int start;
    private int limit;
//    private Set<Sort> sort = new HashSet<>();
//    private Set<Filter> filter = new HashSet<>();

    public Solicitud() {
    }

    public Solicitud(String _dc, int page, int start, int limit) {
        this._dc = _dc;
        this.page = page;
        this.start = start;
        this.limit = limit;
    }

    

    public String getDc() {
        return _dc;
    }

    public void setDc(String _dc) {
        this._dc = _dc;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

//    public Set<Sort> getSort() {
//        return sort;
//    }
//
//    public void setSort(Set<Sort> sort) {
//        this.sort = sort;
//    }
//
//    public Set<Filter> getFilter() {
//        return filter;
//    }
//
//    public void setFilter(Set<Filter> filter) {
//        this.filter = filter;
//    }
}
