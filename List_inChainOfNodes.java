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

     public Object set(int index, Object val) {
       Node iterator = headReference;
       while (index != 0) {
         iterator = headReference.getReferenceToNextNode();
         index--;
       }
       Object returnValue = iterator.getCargo();
       iterator.setCargo(val);
       return returnValue;
     }

     public Object get(int index) {
       Node iterator = headReference;
       while (index != 0) {
         iterator = headReference.getReferenceToNextNode();
         index--;
       }
       return iterator.getCargo();
     }

     public boolean add(int index, Object val) {
       if (index == 0) {
         return addAsHead(val);
       }
       Node iterator = headReference;
       while (index > 1) {
         iterator = headReference.getReferenceToNextNode();
         index--;
       }
       Node newNode = new Node(val, iterator.getReferenceToNextNode());
       iterator.setReferenceToNextNode(newNode);
       return true;
     }

     public Object remove(int index) {
       Object returnValue;
       if (index == 0) {
         returnValue = headReference.getCargo();
         headReference = headReference.getReferenceToNextNode();
         return returnValue;
       }
       Node iterator = headReference;
       while (index > 1) {
         iterator = headReference.getReferenceToNextNode();
         index--;
       }
       returnValue = iterator.getReferenceToNextNode().getCargo();
       iterator.setReferenceToNextNode(iterator.getReferenceToNextNode().getReferenceToNextNode());
       return returnValue;
     }
}