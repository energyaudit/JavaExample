package main.Java0.Lombok.value.staticconstructor;

public final class EmployeeValueStaticConstructDelomboked {

    private final String name;
    private final int salary;

    private EmployeeValueStaticConstructDelomboked(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public static EmployeeValueStaticConstructDelomboked of(String name, int salary) {
        return new EmployeeValueStaticConstructDelomboked(name, salary);
    }

    public String getName() {
        return this.name;
    }

    public int getSalary() {
        return this.salary;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof EmployeeValueStaticConstructDelomboked)) {
            return false;
        }
        final EmployeeValueStaticConstructDelomboked other = (EmployeeValueStaticConstructDelomboked) o;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        if (this.getSalary() != other.getSalary()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        result = result * PRIME + this.getSalary();
        return result;
    }

    public String toString() {
        return "Employee(name=" + this.getName() + ", salary=" + this.getSalary() + ")";
    }
}
