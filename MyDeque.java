import java.util.*;
import java.io.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    size = 0;
    start = 0;
    end = 0;

  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    size = 0;
    start = 0;
    end = 0;

  }
  public int size(){
    return size;

  }

  public String toString(){
    if (size == 0)
    return "{}";

    String output = "{ ";
    if (start <= end){
      for (int i = start; i <= end; i++){
        output += data[i] + " ";
      }
    }
    else{
      for (int i = start; i < data.length; i++){
        output += data[i] + " ";
      }
      for (int i = 0; i <= end; i++){
        output += data[i] + " ";
      }
    }

    return output + "}";

  }

  public void addFirst(E element){
    if (element == null){
      throw new NullPointerException();

    }

    if (size == data.length) resize();

    if (size == 0){
      data[start] = element;
      end = start;
      size++;
      return;

    }

    start = (start - 1 + data.length) % data.length;
    data[start] = element;
    size++;

  }

  public void addLast(E element){
    if (element == null){
      throw new NullPointerException();

    }
    if (size == data.length) resize();
    if (size == 0){
      data[start] = element;
      end = start;
      size++;
      return;
    }

    end = (end + 1) % data.length;
    data[end] = element;
    size++;

  }

  @SuppressWarnings("unchecked")
  private void resize(){
    E[] newdata = (E[])new Object[data.length * 2 + 1];

    for (int i = start; i < start + size; i++){
      newdata[i - start] = data[i % data.length];
    }

    end = size - 1;
    start = 0;
    data = newdata;

  }

  public E removeFirst(){
    if (data.length == 0 || size() == 0){
      throw new NoSuchElementException();
    }

    E temp = data[start];
    data[start] = null;
    int dif = start + 1;
    start = dif % data.length;
    size--;
    return temp;

  }

  public E removeLast(){
    if (data.length == 0 || size() == 0){
      throw new NoSuchElementException();
    }

    E temp = data[end];
    data[end] = null;
    int dif = end - 1 + data.length;
    end = dif % data.length;
    size--;
    return temp;

  }

  public E getFirst(){
    if (data.length == 0 || size() == 0){
      throw new NoSuchElementException();
    }

    return data[start];

  }
  public E getLast(){
    if (data.length == 0 || size() == 0){
      throw new NoSuchElementException();
    }

    return data[end];

  }
}
