package com.projects.Entity;

public class Books {
    private int id;
    private String title;
    private  int yearOfPublication;

    private  int authors_id;

    public Books(){}
    public Books (int id){
        this.id = id;
        
    }

    public Books(String title,int yearOfPublication, int authors_id){
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.authors_id = authors_id;
    }

    // getter and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public int getAuthors_id() {
        return authors_id;
    }

    public void setAuthors_id(int authors_id) {
        this.authors_id = authors_id;
    }
}
