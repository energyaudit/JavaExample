package main.Java0.Lombok.value.accessmodifier;

import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.experimental.PackagePrivate;

/**
 * Since we use @Value mainly to create immutable objects, Lombok marks the class as final and the instance
 * variables as private final. However, this isn't a strict rule.Firstly, we can change the access modifiers of the
 * fields using @NonFinal and @PackagePrivate:
 */
@Value
@NonFinal
public class EmployeeAccesModfierLombok {

    @NonFinal
    @PackagePrivate
    private String name;

    @NonFinal
    @PackagePrivate
    private int salary;
}
