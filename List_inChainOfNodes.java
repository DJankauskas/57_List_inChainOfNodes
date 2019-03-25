/**
  Represent a list, implemented in a chain of nodes
 */

public class List_inChainOfNodes{
    private Node headReference;

    public List_inChainOfNodes() {
      headReference = null;
    }
     

    /**
      @return the number of elements in this list
     */
    public int size() {
      int size = 0;
      Node currRef = headReference;
      while (currRef != null) {
        ++size;
        currRef = currRef.getReferenceToNextNode();
      }
      return size;
    }

    public int size_recursive() {
      if(headReference != null) {
        return headReference.size_recursive();
      }
      else return 0;
    }

    
     /**
       @return a string representation of this list,
       format:
           # elements [element0,element1,element2,] 
      */
    public String toString() {
      String temp = "[";
      Node currRef = headReference;
      while (currRef != null) {
        temp += currRef.getCargo() + ",";
        currRef = currRef.getReferenceToNextNode();
      }
      temp += "]";
      return temp;
    }
    
    
    /**
      Append @value to the head of this list.

      @return true, in keeping with conventions yet to be discussed
     */
     public boolean addAsHead( Object val) {
        Node head = new Node(val, headReference);
        headReference = head;
        return true;
     }
}