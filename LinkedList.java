import java.util.NoSuchElementException;


public class LinkedList
{
   //only instance variable that points to the first node
   private Node first;

   //nested class to represent a node
   private class Node
   {
      public Object data;
      public Node next;
   }

   // Constructs an empty linked list.
   public LinkedList()
   {
      first = null;
   }

   //Returns the first element in the linked list.
   public Object getFirst()
   {
      if (first == null)
         throw new NoSuchElementException();
      return first.data;
   }

   //Removes the first element in the linked list.
   public Object removeFirst()
   {
      if (first == null)
         throw new NoSuchElementException();
      Object element = first.data;
      first = first.next;
      return element;
   }

   //Adds an element to the front of the linked list.
   public void addFirst(Object element)
   {
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
      first = newNode;
   }


   //toString() method prints the elements out from front to tail
   public String toString()
   {

      ListIterator iterator = listIterator();
      String result  = "{ ";
      while (iterator.hasNext())
      {
         result += iterator.next() + " ";
      }
      result += "}\n";

      return result;
   }

  //*************** Below is where you should add the new methods ***********

  //*****************************************************************
  //size() method returns the number of nodes inside this LinkedList
  //*****************************************************************
   public int size()
   {
	   ListIterator iterator = listIterator();
	   int counter = 0;
	   for(int i = 0; i < 50; i++) {
		   if(iterator.hasNext()) {
			   counter++;
			   iterator.next();
		   }
	   }
	   return counter;
   }

    //***********************************************************************************
    //searchElement() method returns the index of the first occurrence of the
    //parameter object in the linked list if it exists. It returns -1 if it does not exit.
    //***********************************************************************************
   public int searchElement(Object element)
   {
	   ListIterator iterator = listIterator();

	   for(int i = 0; i < size(); i++) {
		   if(element.equals(iterator.next()))
			   return i;
	   }
	   return -1;
   }

  //*****************************************************************
  // getElement() method returns the element at the parameter index
  // If the index is out of bounds, throw an IndexOutOfBoundException.
  //*****************************************************************
   public Object getElement(int index)
   {
	   if(index > size() || index < 0)
		   throw new IndexOutOfBoundsException();
	   ListIterator iterator = listIterator();
	   
	   for(int i = 0; i < index; i++)
		   iterator.next();
	   return iterator.next();
   }

   //****************************************************************************
   //setElement() method sets the parameter object at the parameter index in the
   //linked list. If the index is out of bounds, throws an IndexOutOfBoundException
   //****************************************************************************
   public void setElement(int index, Object element)
   {
	   if(index > size() || index < 0)
		   throw new IndexOutOfBoundsException();
	   ListIterator iterator = listIterator();
	   
	   for(int i = 0; i <= index; i++)
		   iterator.next();
	   
	   iterator.set(element);
   }
   //***********************************************************************************
   //insertElement() method inserts the parameter object at the parameter index.
   //If the index is out of bounds, throws an IndexOutOfBoundException
   //Note: the element can be inserted at the end, i.e. inserted at size() index/position
   //************************************************************************************
   public void insertElement(int index, Object element)
   {
	   ListIterator iterator = listIterator();
	   
	   if(index > size() || index < 0)
		   throw new IndexOutOfBoundsException();
	   if(index == size() && index != 0)
		   for(int i = 0; i < index; i++)
			   iterator.next();
	   if(size() != 0 && index != size()) {
		   for(int i = 0; i < index; i++)
			   iterator.next();
	   }
	   
	   iterator.add(element);
   }
  //*******************************************************************
  //removeElement()method removes and returns element at parameter index
  //and throw an IndexOutOfBoundException if the index is out of bounds
  //*******************************************************************
   public Object removeElement(int index)
   {
	   if(index > size() || index < 0)
		   throw new IndexOutOfBoundsException();
	   Object element = null;
	   ListIterator iterator = listIterator();
	   for(int i = 0; i < index; i++)
		   iterator.next();
	   element = iterator.next();
	   iterator.remove();
	   return element;

   }

   //*****************************************************************
   //countHowMany(Object) method returns the number of occurences of
   //the parameter object in the LinkedList
   //*****************************************************************
   public int countHowMany(Object searchedObject)
   {
	   int counter = 0;
	   ListIterator iterator = listIterator();
	   for(int i = 0; i < size(); i++) {
		   if(searchedObject.equals(iterator.next()))
			   counter++;
	   }
	   return counter;
   }

   //*****************************************************************
   //removeDuplicate() method removes all occurences of the parameter
   //objects from the LinkedList
   //*****************************************************************
   public void removeDuplicate(Object removedObject)
   {
	   ListIterator iterator = listIterator();
	   while (iterator.hasNext()) {
		   if(removedObject.equals(iterator.next())) {
			   iterator.remove();  
		   }
	   }
	   
   }

   //*******************************************************************************
   //appendAtEnd(Object, int) method appends the parameter object number of
   //times at the end of the linked list. For example, a call of appendAtEnd("A", 3)
   //will append string "A" three times at the end of the linked list.
   //*******************************************************************************
   public void appendAtEnd(Object element, int howManyTimes)
   {
	  ListIterator iterator = listIterator();
	  while(iterator.hasNext()) {
		  iterator.next();
	  }
	  for(int i = 1; i <= howManyTimes; i++)
			  iterator.add(element);
	   

   }

   //********************************************************************************
   //appendAfter(Object element1, Object element2) method appends the second parameter
   //object, i.e. element2 right after the first occurence of first parameter object,
   //i.e. element1. If element1 is not inside the linked list, then append element2
   //at the front/head of the linked list.
   //********************************************************************************
   public void appendAfter(Object element1, Object element2)
   {
	   ListIterator iterator = listIterator();
	   if (searchElement(element1) != -1) {
		   for(int i = 0; i <= searchElement(element1); i++)
			   iterator.next();
	   }
	   iterator.add(element2);
   }

  //**************************************************************************************
  //reverseFistFew(int howMany) reverse the first parameter number of elements inside the
  //linked list. For example, if the original linked list is { A B C D E }, a call of
  //reverseFirstFew(3) will change the linked list to { C B A D E }. Note: (1)you need to
  //consider the boundary value, i.e.cases where howMany <= 0 or howMany > size()
  //(2)list.reverseFirstFew(list.size()) should reverse the whole linked list
  //**************************************************************************************
   public void reverseFirstFew(int howMany)
   {
	   ListIterator iterator = listIterator();
	   if(howMany > size() || howMany <= 0)
		   throw new IndexOutOfBoundsException();
		   
	   for(int i = 0; i < howMany/2; i++) {
		   Object temp = iterator.next();
		   Object temp2 = getElement(howMany-1-i);
		   setElement(i,temp2);
		   setElement(howMany-1-i,temp);
	   }
   }

   //***************************************************************
   //Method creates an iterator on the current LinkedList
   //***************************************************************
   public ListIterator listIterator()
   {
      return new LinkedListIterator();
   }

   //***************************************************************
   //nested class to define its iterator
   //***************************************************************
   private class LinkedListIterator implements ListIterator
   {

      private Node position;
      private Node previous;

      // Constructs an iterator that points to the front
      // of the linked list.   of the linked list.
      public LinkedListIterator()
      {
         position = null;
         previous = null;
      }

     // Moves the iterator past the next element, and returns
     // the traversed element's data.
      public Object next()
      {
         if (!hasNext())
            throw new NoSuchElementException();
         previous = position; // Remember for remove

         if (position == null)
            position = first;
         else
            position = position.next;

         return position.data;
      }

      // Tests if there is an element after the iterator position  position
      public boolean hasNext()
      {
         if (position == null)
            return first != null;
         else
            return position.next != null;
      }

      // Adds an element after the iterator position
      // and moves the iterator to the inserted element.
      public void add(Object element)
      {
         if (position == null)
         {
            addFirst(element);
            position = first;
         }
         else
         {
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            position.next = newNode;
            position = newNode;
         }
         previous = position;
      }

    // Removes the last traversed element. This method may
    // only be called after a call to the next() method.
      public void remove()
      {
         if (previous == position)
            throw new IllegalStateException();

         if (position == first)
         {
            removeFirst();
         }
         else
         {
            previous.next = position.next;
         }
         position = previous;
      }

      // Sets the last traversed element to a different value
      public void set(Object element)
      {
         if (position == null)
            throw new NoSuchElementException();
         position.data = element;
      }
   } //end of
}