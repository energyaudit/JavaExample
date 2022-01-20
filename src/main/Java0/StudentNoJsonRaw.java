package main.Java0;


class StudentNoJsonRaw {
    private String name;
    private int rollNo;
    private String json;
    public StudentNoJsonRaw(String name, int rollNo, String json) {
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