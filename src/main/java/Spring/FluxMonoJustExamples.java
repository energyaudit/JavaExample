package Spring;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxMonoJustExamples {
    public static void main(String[] args) {
        System.out.println("-- Flux#empty example --");
        Flux.empty()
                .subscribe(System.out::println);

        System.out.println("-- Mono#empty example --");
        Mono.empty()
                .subscribe(System.out::println);
//Since Flux/Mono don't allow null items, Flux#empty() and Mono#empty()
// can be useful where we need to handle null situation, examples:

        if (args.length != 0) {
            process(Flux.just(args[0]));
        } else {
            process(Flux.empty());
        }
    }

    private static void process(Flux<String> flux) {
        flux.map(n -> n.length())
                .subscribe(System.out::println);
    }

}