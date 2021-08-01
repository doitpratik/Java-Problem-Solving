package com.company.lecture20;

class Printer{
    //synchronized void printDocuments(int num, String docName){
    void printDocuments(int num, String docName){
        for (int i = 1; i <=num ; i++) {
            try {
                Thread.sleep(500);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(">> Printing Document "+docName+" "+i);
        }
    }
}
class Mythread extends Thread{
    Printer pRef;
    Mythread(Printer p){
        pRef = p;
    }
    @Override
    public void run(){
        synchronized (pRef) {
            pRef.printDocuments(10, "Profile.pdf");
        }
    }
}

class Yourthread extends Thread{
    Printer pRef;
    Yourthread(Printer p){
        pRef = p;
    }
    @Override
    public void run(){
        synchronized (pRef) {
            pRef.printDocuments(10, "JennyProfile.pdf");
        }
    }
}
public class MultiThreadingConcept {
    // Main is representing the main thread
    public static void main(String[] args) {
        System.out.println("==Application Started==");
        // We are have one single object of printer
        Printer print = new Printer();

        //print.printDocuments(10, "Profile Pratik.pdf");

        // Scenario is that we have multiple thrread working on the same print object
        Mythread pRef = new Mythread(print); // Mythread is having reference to the printer object
        Yourthread yRef = new Yourthread(print); // Your ref is havin reference to the prinjt object

        pRef.start();
        /*try{
            pRef.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }*/

        yRef.start();
        System.out.println("==Application Finished==");
    }
}
