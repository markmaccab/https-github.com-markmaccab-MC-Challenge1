package com.luv2code.springboot.demo.mycoolapp.rest;

import java.util.ArrayList;
//	import java.util.HashSet;
import java.util.List;
//	import java.util.PriorityQueue;
//	import java.util.Set;
import java.util.Stack;

public class Path {
	ArrayList<String> cities = new ArrayList<String>();
//	private Set<Integer> settled; 
//	private PriorityQueue<Integer> pq; 
//	private int V; // Number of vertices 
	List<List<Integer> > adj; 
	boolean junit;

	public Path()
	{
	}
		
	public Path(ArrayList<String> cities, boolean junit) 
	{ 
		this.cities = cities;
		this.junit = junit;
	}
	

//	Documents path with node names
	Stack<Integer> pathStack = new Stack<Integer>(); 

//keeps the names of nodes that were children nodes that were not used in the path		
	Stack<Integer> recursionStack = new Stack<Integer>();
	
	int m;
	int current;
	int father = 0;
	int tempnode = 0;
	int src;
	int target;
	boolean done = true;
	String response=null;
	ArrayList<Integer> setOfCities = new ArrayList<Integer>(); 
	ArrayList<Integer> reverseSetOfCities = new ArrayList<Integer>(); 
	ArrayList<Integer> CitiesOfSegments = new ArrayList<Integer>(); 
	
	
	
// Function for Path Algorithm 
//
	public String findPath(List<List<Integer> > adj, int src, int target) 
	{ 
		this.adj = adj;
		this.src = src;
		this.target = target;
//	   System.out.println("Find path from " + cities.get(src) + "  to  " + cities.get(target));
	   
   
//			mSTART
		current = target;	//	'current' Node
		m=2;		//	mPUSH

	
		while (done)
		{	
	
			m = nextStep(m); 
		}
		return response;

	}
	
	public ArrayList<Integer> findPathJunit(List<List<Integer> > adj, int src, int target) 
	{ 
		
		if (findPath(adj, src, target)=="YES")
			{
			CitiesOfSegments.add(1);
			return CitiesOfSegments;
			}
		else
			{
			setOfCities.add(0);
			return setOfCities;
			}
		
	}
	
	
	public int nextStep(int m)
	{
	      switch(m)
	      {
		 case 1:
		 {
			 mSUCCESS();
			 
			 break;
		 }
		 case 2:
		 {
			 m=mPUSH();
			 return m;
		 }

		 case 3:
		 {
			 m=mPEER();
			 return m;
		 }

		 case 4:
		 {
			 m=mPOP();
			 return m;
		 }

		 case 5:
		 {
			 mNOPATH();
			 break;
		 }

		 default:
		 {
//			   System.out.println("Default ");
			   done = false;
			   break;
		 }
		      }
	      return 0;
		}
	
	public int mPUSH()
	{
		if (current==src) return 1; //mSUCCESS
		
		if (pathStack.search(current)>=0)
			return 3;	//	mPOP
		
		if (adj.get(current).size() > 0)
		{
		pathStack.push(current);
		if (junit==true)
		{
			setOfCities.add(current);
		}
		current = adj.get(current).get(0);	
		return 2;	//mPUSH
		}
		else
		{
			return 4;	// mPOP  
	    }

		}
	
	public int mPEER()
	{
		try
		{
			father=pathStack.peek();
	    } catch (Exception e) {
	    	return 5; //mNOPATH
	    }
		
		int nodeindex=adj.get(father).indexOf(current);
		try
		{
			current=adj.get(father).get(nodeindex+1);
			return 2;	//mPUSH
	    } catch (Exception e) {
	    	return 4; //mPOP
	    }
				}

	public int mPOP()
	{
		try
		{
			current=pathStack.pop();
	    } catch (Exception e) {
	    	return 5; //mNOPATH
	    }
	return 3;	
	}


	
	public int mNOPATH()
	{
		response="NO";
//		System.out.println(response); 
		if (junit==true)
		{
/*		System.out.println("No path found from " + cities.get(src) + "  to  " + cities.get(target));
		int j=pathTest.setOfCities.size();
		System.out.print("Cities visited:  "); 
		for (int i=0; i<j; i++)	
		{
				System.out.print(cities.get(pathTest.setOfCities.get(i)) + ",   "); 
		}		
*/		}
		
		return 5;	
	}
	
	public int mSUCCESS()
	{
/*		response="YES";
		System.out.println(response); 
		while (true) 
		{
			CitiesOfSegments.add(current);
			try
			{
			m=1;
			tempnode=pathStack.pop();
			CitiesOfSegments.add(tempnode);
			}
			catch (Exception e) {
				return 1;
				}
	     	}
*/	
	
		response="YES";
//		System.out.println(response); 
		//		System.out.print("path is " + cities.get(current) + "   "); 
		if (junit==true)
		{	
		CitiesOfSegments.add(current);
		while (true) 
		{
			try
			{
			m=1;
			tempnode=pathStack.pop();
//			System.out.print(", " + cities.get(tempnode) + "   "); 
			CitiesOfSegments.add(tempnode);
			}
			catch (Exception e) {
	    	return 1; //done
	     	}

	
	}
	}
    	return 1; //done
	}
	

	public void prtStack()
	{
		
		System.out.println("pathStack elements");
		for ( int i = 0; i < pathStack.size(); i++) { 
			int v = pathStack.get(i); 
			System.out.println("pathStack element " + i + " is node " + v);
		}
			System.out.println("recursionStack elements");
			for ( int i = 0; i < recursionStack.size(); i++) { 
				int v = recursionStack.get(i); 
				System.out.println("recursionStack element " + i + " is node " + v);
			}
			
	}
	
	}
