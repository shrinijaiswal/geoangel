package com.geoangel.baseapp.model;

import java.util.ArrayList;


public class Response {
    private Integer count;
    private String next,previous;
    private ArrayList<Demo> results;

    public Response(Integer count, String next, String previous, ArrayList<Demo> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public ArrayList<Demo> getResults() {
        return results;
    }

    public void setResults(ArrayList<Demo> results) {
        this.results = results;
    }
}
