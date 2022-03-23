package com.oopsConcepts.intro;

    class Student{
        int rno;
        String name;
        double marks;

        Student(int rno, String name, double marks){
            this.rno = rno;
            this.name = name;
            this.marks = marks;
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("This is now deleting the instances");
        }
    }


class main{
    public static void main(String[] args) {
        Student pratik = new Student(15, "PRatik Gholap", 99.99);
        System.out.println(pratik.rno);
        for(int i = 0; i < 1000000000; i++){
            Student student1 = new Student(0, "xyz", 100.0);
            
        }
    }
}
