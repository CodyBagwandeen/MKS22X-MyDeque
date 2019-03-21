public class MyDeque<E>{
  private E[] data;
  private int size;
  private int start;
  private int end;


  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    size = 10;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int intialCapacity){
    data = (E[])new Object[intialCapacity];
    size = intialCapacity;
  }

  public int size(){
    return size;

  }

  public String toString() {
    String output = "[";

    for(int i = start; i <= end; i++){
      output += "" + data[i];
      if( i != end){
        output += " ";
      }

    }
    return output + "]";

  }

  public void addFirst(E element){
    int temp = start;
    start++;
    data[temp] = element;
    size++;
    end++;

  }

  public void addLast( E element){
    int temp = end;
    end++;
    size++;
    data[temp] = element;

  }

  public E removeFirst(){
    int temp = start;
    start++;
    size--;
    return data[temp];

  }

  public E removeLast() {
    int temp = end;
    end--;
    size--;
    return data[temp];

  }

  public E getFirst(){
    return data[start];

  }

  public E getLast() {
    return data[end];

  }

  public static void main(String[] args){
    MyDeque<String> m = new MyDeque<String>();
    System.out.println(m);
    System.out.println(m.start);
    System.out.println(m.end);
    System.out.println();
    m.addFirst("5");
    System.out.println(m.start);
    System.out.println(m.end);
    System.out.println();
    m.addFirst("4");
    System.out.println(m.start);
    System.out.println(m.end);
    System.out.println();
    m.addLast("6");
    System.out.println(m.start);
    System.out.println(m.end);
    System.out.println();
    System.out.println(m);
  }




}
