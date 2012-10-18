/*
 * Jamie Ly
 * jal39@drexel.edu
 * CS ##:TITLE
 * Assignment ## Program ##
 * 
 * Created on May 13, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author DaAznAngel
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

import java.util.*;
public class MyObject {
	boolean debug = false;
	protected static boolean initIntegers = false;
	public static Vector INTEGERS = new Vector();
	
	public MyObject(){
		if(!initIntegers){
			initIntegers = true;
			for(int i=0;i<1000;i++){
					INTEGERS.add(new Integer(i));
			}
		}
	}
	
	public Integer getInteger(int i){
		return (Integer)INTEGERS.get(i);
	}
	public Integer getInteger(Integer i){
		return (Integer) INTEGERS.get(i.intValue());
	}
	
	public void debugOut(String text){
		if(debug) System.out.println(text); // out to console
	}
	/**
	 * @return whether or not debuggin is on
	 */
	public boolean isDebug() {
		return debug;
	}

	/**
	 * @param b
	 */
	public void setDebug(boolean b) {
		debug = b;
	}
	/** Sort the entire vector, if it is not empty
	 */
	  public static void quickSort(Vector elements)
	  { if (! elements.isEmpty())
		{ 
			MyObject.quickSort(elements, 0, elements.size()-1);
		}
	  }


	/**
	 * QuickSort.java by Henk Jan Nootenboom, 9 Sep 2002
	 * Copyright 2002-2004 SUMit. All Rights Reserved.
	 *
	 * Algorithm designed by prof C. A. R. Hoare, 1962
	 * See http://www.sum-it.nl/en200236.html
	 * for algorithm improvement by Henk Jan Nootenboom, 2002.
	 *
	 * Recursive Quicksort, sorts (part of) a Vector by
	 *  1.  Choose a pivot, an element used for comparison
	 *  2.  dividing into two parts:
	 *      - less than-equal pivot
	 *      - and greater than-equal to pivot.
	 *      A element that is equal to the pivot may end up in any part.
	 *      See www.sum-it.nl/en200236.html for the theory behind this.
	 *  3. Sort the parts recursively until there is only one element left.
	 *
	 * www.sum-it.nl/QuickSort.java this source code
	 * www.sum-it.nl/quicksort.php3 demo of this quicksort in a java applet
	 *
	 * Permission to use, copy, modify, and distribute this java source code
	 * and its documentation for NON-COMMERCIAL or COMMERCIAL purposes and
	 * without fee is hereby granted.
	 * See http://www.sum-it.nl/security/index.html for copyright laws.
	 */
	  private static void quickSort(Vector elements, int lowIndex, int highIndex)
	  { int lowToHighIndex;
		int highToLowIndex;
		int pivotIndex;
		Comparable pivotValue;  // values are Hands in this demo, change to suit your application
		Comparable lowToHighValue;
		Comparable highToLowValue;
		Comparable parking;
		int newLowIndex;
		int newHighIndex;
		int compareResult;

		lowToHighIndex = lowIndex;
		highToLowIndex = highIndex;
		/** Choose a pivot, remember it's value
		 *  No special action for the pivot element itself.
		 *  It will be treated just like any other element.
		 */
		pivotIndex = (lowToHighIndex + highToLowIndex) / 2;
		pivotValue = (Comparable)elements.elementAt(pivotIndex);

		/** Split the Vector in two parts.
		 *
		 *  The lower part will be lowIndex - newHighIndex,
		 *  containing elements <= pivot Value
		 *
		 *  The higher part will be newLowIndex - highIndex,
		 *  containting elements >= pivot Value
		 */
		newLowIndex = highIndex + 1;
		newHighIndex = lowIndex - 1;
		// loop until low meets high
		while ((newHighIndex + 1) < newLowIndex) // loop until partition complete
		{ // loop from low to high to find a candidate for swapping
		  lowToHighValue = (Comparable)elements.elementAt(lowToHighIndex);
		  while (lowToHighIndex < newLowIndex
			& lowToHighValue.compareTo(pivotValue)<0 )
		  { newHighIndex = lowToHighIndex; // add element to lower part
			lowToHighIndex ++;
			lowToHighValue = (Comparable)elements.elementAt(lowToHighIndex);
		  }

		  // loop from high to low find other candidate for swapping
		  highToLowValue = (Comparable)elements.elementAt(highToLowIndex);
		  while (newHighIndex <= highToLowIndex
			& (highToLowValue.compareTo(pivotValue)>0)
			)
		  { newLowIndex = highToLowIndex; // add element to higher part
			highToLowIndex --;
			highToLowValue = (Comparable)elements.elementAt(highToLowIndex);
		  }

		  // swap if needed
		  if (lowToHighIndex == highToLowIndex) // one last element, may go in either part
		  { newHighIndex = lowToHighIndex; // move element arbitrary to lower part
		  }
		  else if (lowToHighIndex < highToLowIndex) // not last element yet
		  { compareResult = lowToHighValue.compareTo(highToLowValue);
			if (compareResult >= 0) // low >= high, swap, even if equal	
			{ parking = lowToHighValue;
			  elements.setElementAt(highToLowValue, lowToHighIndex);
			  elements.setElementAt(parking, highToLowIndex);

			  newLowIndex = highToLowIndex;
			  newHighIndex = lowToHighIndex;

			  lowToHighIndex ++;
			  highToLowIndex --;
			}
		  }
		}

		// Continue recursion for parts that have more than one element
		if (lowIndex < newHighIndex)
		{ 
			MyObject.quickSort(elements, lowIndex, newHighIndex); // sort lower subpart
		}
		if (newLowIndex < highIndex)
		{ MyObject.quickSort(elements, newLowIndex, highIndex); // sort higher subpart
		}
	  }
	public static void echo(Object o){
		System.out.println(o);
	}
	public static void main(String args[]){
	
	}
}
