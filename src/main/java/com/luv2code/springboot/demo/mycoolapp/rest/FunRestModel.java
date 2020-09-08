package com.luv2code.springboot.demo.mycoolapp.rest;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files
//	import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Set;

public class FunRestModel {
	
	String origin, destination;
	List<List<Integer> > adj3 = new ArrayList<List<Integer> >(); 
	ArrayList<String> cities = new ArrayList<String>();
//	List<List<Integer> > allSegments = new ArrayList<List<Integer> >(); 
//	ArrayList<String> cities = new ArrayList<String>();
	List<Set<Integer> > allSegments = new ArrayList<Set<Integer> >(); 

	/*
 				      Set<Integer> citiesSet 
			            = new HashSet<Integer>(); 
					for (int j=0; j<funRestModel.cities.size(); j++)
					{
						citiesSet.add(j);	
 */
	int source = 0; 
	int target = 0;
	ArrayList <Integer> test = new ArrayList <Integer>(); 
	String[] values = new String[2];
	boolean junit=false;
	
	public ArrayList <Integer> testFunRestModel(String origin,String destination, boolean junit)	{
		this.origin=origin;
		this.destination=destination;
		this.junit=junit;
//	when junit==true data is collected in Junit designated data structures
//	This data is then printed by Path class method testFindPath()
//		System.out.println("origin:  " + origin + "   destination:  " + destination);
		
		inputallSegmentsData();

		return lookupPath();
	}
	
	public void inputallSegmentsData()
	{

		try {
	    	File myObj = new File("city.txt");	//directory of project
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
//		        System.out.println(data);

		        values = data.split("\\s*,\\s*");
//		        System.out.println(Arrays.toString(values));
		        
		        if (!cities.contains(values[0]))
	        		{
//	If city1 is not in cities list, add it there
//	cities[] is a list of cities. We add city "values[0]" to cities[]		        	
		        	cities.add(values[0]);
	        		adj3.add(new ArrayList<Integer>());
	        		}
		       int i = cities.indexOf(values[0]);
		       
		        if (!cities.contains(values[1]))
	    		{
//		        	If city2 is not in cities list, add it there
//	        	cities[] is a list of cities. We add city "values[1]" to cities[]		        	
	        	cities.add(values[1]);
        		adj3.add(new ArrayList<Integer>());
	    		}
		        int j = cities.indexOf(values[1]);
		        
//				Add city1,city2 pair numbers in adj list
		        if (!adj3.get(i).contains(j))
		        {
		        	adj3.get(i).add(j);
		        	adj3.get(j).add(i);    	
//		        	segment.add(i);
//		        	segment.add(j);
//		        	allSegments.add(segment);
//		        	allSegments.add{i,j};
		        	allSegments.add(new HashSet<Integer>());
		        	allSegments.get(allSegments.size()-1).add(i);		        	
		        	allSegments.get(allSegments.size()-1).add(j);		       
		        	if (junit==true)
		        		System.out.println((allSegments.size()-1) + ".  " +  values[0] + ",  " + values[1]);		        	
		        
		        	//		        	allSegments.add(allSegments.get(allSegments.size()-1).add(i));
		        }
		      }
//	        System.out.println(allSegments);
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }

	}
	
	public ArrayList <Integer> lookupPath()
	{

	 try	{     
			source = cities.indexOf(origin); 
			target = cities.indexOf(destination);
	      
	    } catch (Exception e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }

		
		if ((source==-1)||(target==-1))
		{
//		System.out.println("No path from " + origin + "  to  " + destination);
		test.add(0);
//		System.out.println("NO");
		return test;
		}
		else
		{
		Path path = new Path(cities, junit); 
		 test=path.findPathJunit(adj3, source, target); 
		 return test;
		}
		

	}	
	}
	
	

