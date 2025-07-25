public class OOPS_01 {
    public static void main(String[] args) {
        // A Class in a template of Object
        // An Object is an instance of Class

        // Variables inside the object are called Instance variables.
        // The default value of objects, when not initialized is = NULL;
        // The "new" keyword allocates memory dynamically at runtime and returns a reference to that variable
        // Constructor : It defines what will happen when your object is created.
        //               Special type of function in Class, that runs when you create a new Object and it allocates some variables.
        // In JAVA : Primitive data type are not Objects..so the keyword "new" is not used and
        //           they are stored in the stack memory.
        // In JAVA : There is only pass by value...
        //           BUT...when you pass objects..there is pass by reference..
        //           There is a catch..In case of "final" they can't be modified.
        // final variables are needed to be initialized
        // Ex :
                final int size =5 ;
        // In case of non-primitives you can't reassign it...but you can change the value.
        // In JAVA : You can't destroy an object manually...but what you can do, you can ask JAVA to these things at the time of destroying the object
        //           The method is called finalizer.....
        //           You can have different Finalizer methods in different classes.


        Student name = new Student();
        name.rno = 14;
      //  name.name = "Pavan";
//        System.out.println(name.rno);
//        System.out.println(name.name);
//        name.changeName("Gym Paglu");
//        name.greeting();
        Student sumit = new Student(36,"Sumit",69.9f);
        System.out.println(sumit.rno);
        System.out.println(sumit.name);
        System.out.println(sumit.marks);
        Student ramu = new Student(sumit);
        




    }
    static class Student {
        int rno;
        String name;
        float marks;
        void changeName(String newName){
            name = newName;

        }
        void greeting(){
            System.out.println("My name is "+ name);
        }
        Student( Student other) {
            this.name =other.name;
            this.rno = other.rno;
            this.marks = other.marks;
        }
        Student(int roll, String naam, float mark){
            this.rno = roll;
            this.name = naam;
            this.marks = mark;
        }


        Student () {
            this.rno = 13;
            this.name = "Sumit Rajput";
            this.marks = 69.99f;
        }
    }
}
