public class Stringss {
    public static void main(String[] args) {
        String one = "Sumit";
        String two = "Sumit";
    //    System.out.println(one==two); // Output : True; (Both the objects are inside the String pool)

        String a =  new String("Sumit");
        String b =  new String("Sumit");
  //      System.out.println(a==b); // Output : False;  (Both the objects are outside the String Pool and are inside the heap Memory)


        System.out.println('a' + 'b'); // Prints the ascii value of the characters.
        System.out.println("a" + "b"); // It will concatenate the strings , Output : ab;
        System.out.println((char) ('a' + 3)); // Output : d
        System.out.println("a" + 3);  // Output : a3;
        // this is same as after a few steps : "a" + "1"
        // integer will be converted to Integer that will call toString();
        System.out.println("a" + 'b');// Output : ab
                                        // Reason : If any of the datatype is String , the output will be of type String;

        String s = "G()(al)";

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'G'){
                ans.append("G");
            }else if (s.startsWith("()",i)){
                ans.append("o");
                i++;
            } else if (s.startsWith("(al)",i)) {
                ans.append("al");
                i = i + 3;
            }

        }
        System.out.println(ans.toString());



    }
}
