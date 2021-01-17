package Spring;

/**
 * In normal practice, if you want to make a immutable User class, then you must pass all five information as parameters
 * to constructor. It will look like this:
 * public User (String firstName, String lastName, int age, String phone, String address){
 *     this.firstName = firstName;
 *     this.lastName = lastName;
 *     this.age = age;
 *     this.phone = phone;
 *     this.address = address;
 * }
 * Very good. Now what if only firstName and lastName are mandatory and rest 3 fields are optional. Problem !!
 * We need more constructors.
 *
 * public User (String firstName, String lastName, int age, String phone){ ... }
 * public User (String firstName, String lastName, String phone, String address){ ...  }
 * public User (String firstName, String lastName, int age){ ...   }
 * public User (String firstName, String lastName){ ...    }
 */
public class UserBuilderTest {
    public static void main(String[] args) {
        User user1 = new User.UserBuilder("Lokesh", "Gupta")
                .age(30)
                .phone("1234567")
                .address("Fake address 1234")
                .build();

        System.out.println(user1);

        User user2 = new User.UserBuilder("Jack", "Reacher")
                .age(40)
                .phone("5655")
                //no address
                .build();

        System.out.println(user2);

        User user3 = new User.UserBuilder("Super", "Man")
                //No age
                //No phone
                //no address
                .build();

        System.out.println(user3);
    }
}
