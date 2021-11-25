package main.Java1;
/**
 *Java provides two approaches for creating threads one by implementing the Runnable interface and the other by
 * inheriting the Thread class. However, one important feature missing with the implementation of the Runnable
 * interface is that it is not possible for a thread to return something when it completes its execution, i.e.,
 * when the run() method execution is over. In order to support this feature, the Java Callable interface is used.
 */

import java.util.concurrent.Callable;
import java.util.Random;

class CallableSimple implements Callable {

    public Object call() throws Exception {
// Creating an object of the  Random class
        Random randObj = new Random();

// generating a random number between 0 to 9
        Integer randNo = randObj.nextInt(10);

// the thread is delayed for some random time
        Thread.sleep(randNo * 1000);

        return randNo;
    }
}