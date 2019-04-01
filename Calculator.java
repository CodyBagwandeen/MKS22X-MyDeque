public class Calculator{
  /*Evaluate a postfix expression stored in s.
   *Assume valid postfix notation, separated by spaces.
   */
  public static double eval(String s){
    MyDeque<String> queue = new MyDeque<String>();
       s += " ";
       String val = "";
       for(int i=0; i<s.length(); i++) {
         if(s.charAt(i) == ' ') {
           queue.addLast(val);
           val = "";

           if(isOperation(queue.getLast())) {
             String operation = queue.removeLast();
             double v2 = Double.parseDouble(queue.removeLast());  // first in last out so v2 is the last one
             double v1 = Double.parseDouble(queue.removeLast());
             if(operation.equals("+")) queue.addLast(Double.toString(v1 + v2)); // see if adding
             else if(operation.equals("-")) queue.addLast(Double.toString(v1 - v2));  // see if subtracing
             else if(operation.equals("*")) queue.addLast(Double.toString(v1 * v2)); // see if multiply
             else if(operation.equals("/")) queue.addLast(Double.toString(v1 / v2)); // see if divide
             else queue.addLast(Double.toString(v1 % v2)); // this is the only other operation sooooo
              }
            }else{
              val += s.charAt(i);
           }
       }
       return Double.parseDouble(queue.getLast());

  }

  public static boolean isOperation(String s){
    return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("%");
  }

}
