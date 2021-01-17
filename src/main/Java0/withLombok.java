package main.Java0;
/**
 * @Data is a shortcut annotation that combines @Getter, @Setter, @RequiredArgsConstructor, @ToString, and @EqualsAndHashCode.
 */

import lombok.AccessLevel;
        import lombok.Setter;
        import lombok.Data;
        import lombok.ToString;

@Data
public class withLombok {
    private  String name;
    @Setter(AccessLevel.PACKAGE) private int age;
    private double position;
    private String[] notes;

    @ToString(includeFieldNames=true)
    @Data(staticConstructor="of")
    public static class Sample<T> {
        private  String name;
        private  T value;
    }
}

