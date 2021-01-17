package main.Java0.Lombok;

class DepartmentDelomboked {

    private String location;
    private String employeeNumber;

    private DepartmentDelomboked(String location, String employeeNumber) {
        this.location = location;
        this.employeeNumber = employeeNumber;
    }

    public static DepartmentDelomboked of(String location, String employeeNumber) {
        return new DepartmentDelomboked(location, employeeNumber);
    }
}

