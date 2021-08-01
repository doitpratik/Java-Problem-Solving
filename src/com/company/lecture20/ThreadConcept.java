package com.company.lecture20;

/*
class MyTask {
    void executeTask(){
        for (int i = 1; i <=10 ; i++) {
            System.out.println("@@ Printing document $"+i+"- printer2");
        }
    }
}
*/
//My task is a thread
/*class MyTask extends Thread{
    @Override
    public void  run(){
        for (int i = 1; i <=10 ; i++) {
            System.out.println("@@ Printing document $"+i+"- printer2");
        }
    }
}*/

class CA{

}
class MyTask extends CA implements Runnable{
    @Override
    public void  run(){
        for (int i = 1; i <=10 ; i++) {
            System.out.println("@@ Printing document $"+i+"- printer2");
        }
    }
}

class YourTask implements Runnable{
    @Override
    public void  run(){
        for (int i = 1; i <=10 ; i++) {
            System.out.println("** Printing document $"+i+"- printer3");
        }
    }
}
public class ThreadConcept {
    // main methods represent main thread
    public static void main(String[] args) {
       //whatever we write in here will be executed by main thread
        // threads always execute the jobs in a sequence
        // Execution context ( execute in sequence)
        //Job1
        System.out.println("== Application Started++");

        // snippet to print the documents
        //job 2
       /* MyTask task = new MyTask();
        // task.executionTask();
        task.start();*///-> Now main and MyTask are executing -parallely or concurrently

            //TRYING RUNNABLE
        Runnable r = new MyTask();
        Thread task = new Thread(r);
        task.start();


        Thread yourTask = new Thread(new YourTask());
        yourTask.start();
        //Till job 2 is not finished below mentioned instructions
        //are waiting
        // In such use case os/jvm shall give a message that app is
        // not responding Some sluggish behaviour in app can be observed
        // Job3
        for (int i = 0; i < 10; i++) {
            System.out.println("Printing documents #"+i+ "- Printer1");
        }
        //job4



        System.out.println("== Application Fianished==");
    }
}
