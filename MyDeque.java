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
      output += data[i];
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
    MyDeque m = new MyDeque();
    System.out.println(m);
  }




}
