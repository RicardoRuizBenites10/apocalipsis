/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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
    private String group;
    private List<String> resultados = new ArrayList<>();
    private Map<String, String> joins = new LinkedHashMap<>();
    private List<FilterPage> filters = new ArrayList<>();
    private List<String> exceptions = new ArrayList<>();
    private List<SortPage> sorts = new ArrayList<>();

    public ReverseQuery(String entidad, String iniEntidad) {
        this.entidad = entidad + " " + iniEntidad + "\n";
        this.select = "SELECT\n";
        this.from = "FROM\n";
        this.iniEntidad = iniEntidad;
        this.pagination = "";
        this.group = "";
    }

    public String getQuery() {
        String query = this.select + getResults() + from + this.entidad + getJoins() + getFilters() + getExceptions() + getGroup() + getSorts() + getPagination();
        return query;
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
            resultString = "COUNT(*)";
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
        String filterString = "\n", filterBand, filterSensitive, operator;
        boolean paramVP;
        int cont = 0;
        if (this.filters != null && !this.filters.isEmpty()) {
            for (FilterPage item : filters) {
                cont++;
                ArrayList<String> propiedad = (ArrayList<String>) Metodo.getSplit(item.getProperty(), ".");
                paramVP = propiedad.size() > 1;
                if (!item.getProperty().equalsIgnoreCase("CLAVE")) {
                    filterBand = paramVP ? propiedad.get(0) + "." + propiedad.get(1) : iniEntidad + "." + item.getProperty();
                } else {
                    filterBand = "DECRYPTBYPASSPHRASE('Bruces@22'," + iniEntidad + "." + item.getProperty() + ")";
                }
                if (item.getOperator() != null) {
                    switch (item.getOperator()) {
                        case "like":
                            operator = " LIKE (:";
                            break;
                        case "in":
                            operator = " IN (:";
                            break;
                        case "nin":
                            operator = " NOT IN (:";
                            break;
                        default:
                            operator = " = (:";
                            break;
                    }
                } else {
                    operator = " = (:";
                }
                filterSensitive = operator + item.getProperty() + ")";
                if (item.isInWhere()) {
                    filterString = filterString + filterBand + filterSensitive + (this.filters.size() != cont ? (item.isAnd() ? " AND " : " OR ") : "");
                }
            }
        }
        if (!filterString.trim().equals("")) {
            filterString = "\nWHERE\n" + filterString;
        }
        return filterString;
    }

    public String getExceptions() {
        String exceptionString = "\n";
        if (this.exceptions != null && !this.exceptions.isEmpty()) {
            for (String item : exceptions) {
                exceptionString = exceptionString + item;
            }
        }
        return exceptionString;
    }

    public List<String> getLExeptions() {
        return this.exceptions;
    }

    public void setExceptions(List<String> exceptions) {
        this.exceptions = exceptions;
    }

    public List<FilterPage> getLFilters() {
        return filters;
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
                ArrayList<String> propiedad = (ArrayList<String>) Metodo.getSplit(item.getProperty(), "-");
                if (propiedad.size() > 1) {
                    sortString = sortString + propiedad.get(0) + propiedad.get(1) + " " + item.getDirection() + (this.sorts.size() != cont ? ", " : "");
                } else {
                    sortString = sortString + this.iniEntidad + "." + item.getProperty() + " " + item.getDirection() + (this.sorts.size() != cont ? ", " : "");
                }
            }
        }
        return sortString;
    }

    public List<SortPage> getLSorts() {
        return sorts;
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = "GROUP BY\n" + group + "\n";
    }

}
