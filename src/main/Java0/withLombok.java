package main.Java0;

import lombok.AccessLevel;
        import lombok.Setter;
        import lombok.Data;
        import lombok.ToString;

@Data public class withLombok {
    private final String name;
    @Setter(AccessLevel.PACKAGE) private int age;
    private double position;
    private String[] notes;

    @ToString(includeFieldNames=true)
    @Data(staticConstructor="of")
    public static class Sample<T> {
        private final String name;
        private final T value;
    }
}

