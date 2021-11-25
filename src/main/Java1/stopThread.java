package main.Java1;

class MyThread extends Thread
{
    //Initially setting the flag as true,The Java volatile keyword is used to mark a Java variable as
    // "being stored in main memory". More precisely that means, that every read of a volatile variable
    // will be read from the computer's main memory, and not from the CPU cache

    private volatile boolean flag = true;

    //This method will set flag as false

    public void stopRunning()
    {
        flag = false;
    }

    @Override
    public void run()
    {
        //Keep the task in while loop

        //This will make thread continue to run until flag becomes false

        while (flag)
        {
            System.out.println("I am running....");
        }

        System.out.println("Stopped Running....");
    }
}

public class stopThread
{
    public static void main(String[] args)
    {
        MyThread thread = new MyThread();

        thread.start();

        try
        {
            Thread.sleep(100);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        //call stopRunning() method whenever you want to stop a thread

        thread.stopRunning();
    }
}