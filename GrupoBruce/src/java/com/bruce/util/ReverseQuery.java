/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author SISTEMAS
 */
public class ReverseQuery {

    private String query;
    private String select;
    private String from;
    private String entidad;
    private String iniEntidad;
    private String pagination;
    private List<String> resultados = new ArrayList<>();
    private Map<String, String> joins = new HashMap<>();
    private List<FilterPage> filters = new ArrayList<>();
    private List<SortPage> sorts = new ArrayList<>();

    public ReverseQuery(String entidad, String iniEntidad) {
        this.entidad = entidad + " " + iniEntidad + "\n";
        this.select = "SELECT\n";
        this.from = "FROM\n";
        this.iniEntidad = iniEntidad;
        this.pagination = "";
    }

    public String getQuery() {
        return this.select + getResults() + from + this.entidad + getJoins() + getFilters() + getSorts() + getPagination();
    }

    public void addResult(String result) {
        this.resultados.add(result);
    }

    private String getResults() {
        String resultString;
        int cont = 0;
        if (!this.resultados.isEmpty()) {
            resultString = "\n";
            for (String item : this.resultados) {
                cont++;
                resultString = resultString + item + (cont != this.resultados.size() ? "," : "") + "\n";
            }
        } else {
            resultString = "*";
        }
        return resultString;
    }

    public void addJoin(String entity, String params) {
        this.joins.put(entity, params);
    }

    private String getJoins() {
        String joinString = "";
        if (!this.joins.isEmpty()) {
            for (Map.Entry<String, String> entry : this.joins.entrySet()) {
                joinString = joinString + entry.getKey() + " ON " + entry.getValue() + "\n";
            }
        }
        return joinString;
    }

    private String getFilters() {
        String filterString = "\n", filterBand;
        int cont = 0;
        if (!this.filters.isEmpty()) {
            filterString = filterString + "WHERE\n";
            for (FilterPage item : filters) {
                cont++;
                filterBand = !item.getProperty().equalsIgnoreCase("CLAVE") ? iniEntidad + "." + item.getProperty() : "DECRYPTBYPASSPHRASE('Bruces@22'," + iniEntidad + "." + item.getProperty() + ")";
                filterString = filterString + filterBand + " = :" + item.getProperty() + (this.filters.size() != cont ? " AND " : "");
            }
        }
        return filterString;
    }

    public void setFilters(List<FilterPage> filters) {
        this.filters = filters;
    }

    private String getSorts() {
        String sortString = "\n";
        int cont = 0;
        if (!this.sorts.isEmpty()) {
            sortString = sortString + "ORDER BY\n";
            for (SortPage item : this.sorts) {
                cont++;
                sortString = sortString + this.iniEntidad + "." + item.getProperty() + " " + item.getDirection() + (this.sorts.size() != cont ? ", " : "");
            }
        }
        return sortString;
    }

    public void setSorts(List<SortPage> sorts) {
        this.sorts = sorts;
    }

    public void setPagination(int start, int limit) {
        this.pagination = (start == 0 && limit == 0) ? "" : "\nOFFSET " + start + " ROWS FETCH NEXT " + limit + " ROWS ONLY";
    }

    private String getPagination() {
        return this.pagination;
    }

}