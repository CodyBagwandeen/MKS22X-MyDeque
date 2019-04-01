public class Calculator{
  /*Evaluate a postfix expression stored in s.
   *Assume valid postfix notation, separated by spaces.
   */
  public static double eval(String s){
    MyDeque<String> queue = new MyDeque<String>();
    double ans = 0;
    return ans;

  }

  public static boolean isOperation(String s){
    return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("%");
  }
}
