package main.Java0;


import java.util.Arrays;

public class withoutLombok{
    private  String name;
    private int age;
    private double position;
    private String[] notes;

    public withLombok withLombok(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setPosition(double position) {
        this.position = position;
    }

    public double getPosition() {
        return this.position;
    }

    public String[] getNotes() {
        return this.notes;
    }

    public void setNotes(String[] notes) {
        this.notes = notes;
    }

    @Override public String toString() {
        return "DataExample(" + this.getName() + ", " + this.getAge() + ", " + this.getPosition() + ", " + Arrays.deepToString(this.getNotes()) + ")";
    }

    protected boolean canEqual(Object other) {
        return other instanceof withLombok;
    }

    @Override public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof withLombok)) return false;
        withLombok other = (withLombok) o;
        if (!other.canEqual((Object)this)) return false;
        if (this.getName() == null ? other.getName() != null : !this.getName().equals(other.getName())) return false;
        if (this.getAge() != other.getAge()) return false;
        if (Double.compare(this.getPosition(), other.getPosition()) != 0) return false;
        if (!Arrays.deepEquals(this.getNotes(), other.getNotes())) return false;
        return true;
    }

    @Override public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long temp1 = Double.doubleToLongBits(this.getPosition());
        result = (result*PRIME) + (this.getName() == null ? 43 : this.getName().hashCode());
        result = (result*PRIME) + this.getAge();
        result = (result*PRIME) + (int)(temp1 ^ (temp1 >>> 32));
        result = (result*PRIME) + Arrays.deepHashCode(this.getNotes());
        return result;
    }

    public static class Sample<T> {
        private final String name;
        private final T value;

        private Sample(String name, T value) {
            this.name = name;
            this.value = value;
        }

        public static <T> Sample<T> of(String name, T value) {
            return new Sample<T>(name, value);
        }

        public String getName() {
            return this.name;
        }

        public T getValue() {
            return this.value;
        }

        @Override public String toString() {
            return "Sample(name=" + this.getName() + ", value=" + this.getValue() + ")";
        }

        protected boolean canEqual(Object other) {
            return other instanceof Sample;
        }

        @Override public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof Sample)) return false;
            Sample<?> other = (Sample<?>) o;
            if (!other.canEqual((Object)this)) return false;
            if (this.getName() == null ? other.getValue() != null : !this.getName().equals(other.getName())) return false;
            if (this.getValue() == null ? other.getValue() != null : !this.getValue().equals(other.getValue())) return false;
            return true;
        }

        @Override public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            result = (result*PRIME) + (this.getName() == null ? 43 : this.getName().hashCode());
            result = (result*PRIME) + (this.getValue() == null ? 43 : this.getValue().hashCode());
            return result;
        }
    }
}