import java.lang.NullPointerException;
import java.util.NoSuchElementException;

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
    int index = start;
    String output = "[";

    while((index <= end) || (end < start && index > end)) {
      if(index >= data.length) index = 0;
      if(data[index] != null) output += data[index] + " ";
        index++;
      }

    return output + "]";
  }

  public void addFirst(E element){
    if(element == null){
      throw new NullPointerException();
    }
    if(size == data.length - 1){
      resize();
    }

    if(data[start] != null) {
      if(start - 1 < 0) start = data.length;
        start -= 1;
    }

    size += 1;
    data[start] = element;

  }

  public void addLast( E element){
    if( element == null){
      throw new NullPointerException();
    }
    int temp = end;
    end++;
    size++;
    data[temp] = element;

  }

  public E removeFirst(){
    if( size == 0){
      throw new NoSuchElementException();
    }
    int temp = start;
    start++;
    size--;
    return data[temp];

  }

  public E removeLast() {
    if( size == 0){
      throw new NoSuchElementException();
    }
    int temp = end;
    end--;
    size--;
    return data[temp];

  }

  public E getFirst(){
    if( size == 0){
      throw new NoSuchElementException();
    }
    return data[start];

  }

  public E getLast() {
    if( size == 0){
      throw new NoSuchElementException();
    }
    return data[end];

  }

  public void resize() {
    @SuppressWarnings("unchecked")
    E[] temp = (E[]) new Object[data.length * 2 + 1];

    int index = start;
    int j = 0;

    while((index <= end) || (end < start && index > end)) {
        if(index == end + 1) return;

        if(index >= data.length) {
          index = 0;
        }
        temp[j] = data[index];
        index++;
        j++;
      }

      start = 0; end = data.length - 2;
      data = temp;
   }



  public static void main(String[] args){
    MyDeque<String> m = new MyDeque<String>();
    System.out.println(m);
    System.out.println(m.start);
    System.out.println(m.end);
    System.out.println();
    m.addFirst("5");
    System.out.println(m);
    System.out.println(m.start);
    System.out.println(m.end);
    System.out.println();
    m.addFirst("4");
    System.out.println(m);
    System.out.println(m.start);
    System.out.println(m.end);
    System.out.println();
    m.addLast("6");
    System.out.println(m);
    System.out.println(m.start);
    System.out.println(m.end);
    System.out.println();

  }




}
