package main.Java0.Lombok;

import lombok.Value;

/**
 * @Value is similar to the @Data annotation, but it creates immutable objects.
 *It is a shortcut annotation which combines @FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE),
 * @Getter, @AllArgsConstructor, @ToString and @EqualsAndHashCode. However, it doesn't have @Setter. Moreover,
 * the usage of @FieldDefaults makes every instance field private final.
 */

@Value
public class LombokEmployee {

    private String name;
    private int salary;
}