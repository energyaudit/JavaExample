package Spring;

import java.util.Date;

/**
 *  If we had 10 different parameters, it would become very difficult to identify what's what in the constructor at a
 *  single glance. To make it worse, some of those values might be optional, which means that we'll need to create a bunch
 *  of overloaded constructors to deal with all possible combinations, or we'll have to pass nulls to our constructor (ugly!).
 * You might be thinking that we can mitigate the issue by calling a no-arg constructor and then setting up the account
 * via setter methods instead. However, that leaves us open to another issue – what happens if a developer forgets to
 * call a particular setter method? We could end up with an object that is only partially initialized, and again, the
 * compiler wouldn't see any problems with it.Thus, there are two specific problems that we need to solve:
 *Too many constructor arguments.
 * Incorrect object state.
 * This is where the Builder pattern comes into play.
 */
public class BuilderPattern {
    public static class Builder {

        private long accountNumber; //This is important, so we'll pass it to the constructor.
        private String owner;
        private String branch;
        private double balance;
        private double interestRate;

        public Builder(long accountNumber) {
            this.accountNumber = accountNumber;
        }

        public Builder() {

        }

        public Builder withOwner(String owner){
            this.owner = owner;

            return this;  //By returning the builder each time, we can create a fluent interface.
        }

        public Builder atBranch(String branch){
            this.branch = branch;

            return this;
        }

        public Builder openingBalance(double balance){
            this.balance = balance;

            return this;
        }

        public Builder atRate(double interestRate){
            this.interestRate = interestRate;

            return this;
        }

        public Builder build(){
            //Here we create the actual bank account object, which is always in a fully initialised state when it's returned.
            Builder account = new Builder();  //Since the builder is in the BankAccount class, we can invoke its private constructor.
            account.accountNumber = this.accountNumber;
            account.owner = this.owner;
            account.branch = this.branch;
            account.balance = this.balance;
            account.interestRate = this.interestRate;

            return account;
        }
    }

    //Fields omitted for brevity.
    private BuilderPattern() {
        //Constructor is now private.
    }

    //Getters and setters omitted for brevity.
    public static void main(String[] args) {
        Builder account = new Builder(1234L)
                .withOwner("Marge")
                .atBranch("Springfield")
                .openingBalance(100)
                .atRate(2.5)
                .build();

        System.out.println(account.branch);

        Builder anotherAccount = new Builder(4567L)
                .withOwner("Homer")
                .atBranch("Springfield")
                .openingBalance(100)
                .atRate(2.5)
                .build();
        System.out.println(anotherAccount.interestRate);
    }
}
