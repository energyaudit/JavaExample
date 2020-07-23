package main.Java1;


class MyThread2 extends Thread
{
    @Override
    public void run()
    {
        while (!Thread.interrupted())
        {
            System.out.println("I am running....");
        }

        System.out.println("Stopped Running.....");
    }
}

public class stopThread2
{
    public static void main(String[] args)
    {
        MyThread2 thread = new MyThread2();

        thread.start();

        try
        {
            Thread.sleep(100);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        //interrupting the thread
        thread.interrupt();
      ////////////////////////only way to   stop a endless thread
        Thread loop = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            if (Thread.interrupted()) {
                                break;
                            }
                            // Continue to do nothing
                        }
                    }
                }
        );
        loop.start();
        loop.interrupt();
    }
}