package staticExample;



public class Main {
    public static void main(String[] args) {
//        Human Kenny = new Human(22,"Kenpachi Zaraki",500000,false);
//        Human Kon = new Human(100,"Kon",0,false);
//        System.out.println(Human.population);
//        System.out.println(Human.population);

    }
//  we know that something which is not static, belongs to an object.
// so  the below method will have an instance and the above method will not.
    static void funny(){
  //      greet(); // you cant use this because it requires an instance
        // but the function you are using it in does not depend on instance


// you cannot access a non static stuff without referencing their instances in a static context.

// hence we can reference it like below :
    Main obj = new Main();
    obj.greet();


    }
    void greet(){
        System.out.println("Hell Yeah");
    }


}
