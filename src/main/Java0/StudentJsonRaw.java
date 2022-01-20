package main.Java0;


import com.fasterxml.jackson.annotation.JsonRawValue;

class StudentJsonRaw {
    private String name;
    private int rollNo;
    @JsonRawValue
    private String json;
    public StudentJsonRaw(String name, int rollNo, String json) {
        this.name = name;
        this.rollNo = rollNo;
        this.json = json;
    }
    public String getName(){
        return name;
    }
    public int getRollNo(){
        return rollNo;
    }
    public String getJson(){
        return json;
    }
}