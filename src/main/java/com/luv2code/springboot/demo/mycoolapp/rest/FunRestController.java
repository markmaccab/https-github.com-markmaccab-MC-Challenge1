package com.luv2code.springboot.demo.mycoolapp.rest;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	String origin, destination;
	
	@RequestMapping("/employees")
	//if "http://localhost:8080/employees" IS NOT there is no error in Console
	//if "/employees" IS YES there is error in Console: 'origin'
    public String handleEmployeeRequestByDept (@RequestParam("origin") String origin,
                                            @RequestParam("destination") String destination
   	//if "/employees?origin" IS YES there is error in Console: 'destination'                                        
                                          	) {
		this.origin=origin;
		this.destination=destination;
		ArrayList <Integer> test;
		boolean junit=false;
		FunRestModel funRestModel = new FunRestModel();
		System.out.println("Trip:  origin:  " + origin + "   destination:  " + destination);
		if (junit==true)
			System.out.println("All segments available:");		      
		test=funRestModel.testFunRestModel(origin, destination, junit);
		if (test.get(test.size()-1)==1)
		{
		System.out.println("YES");
		return "YES";
		}
		else
		{
		System.out.println("NO");
		return "NO";	
		}
		}
		
	//if incorrect destination (e.g. "/employees?origin=Boston&destination=Newar") 
	//cities.get(destination) is out of bounds
	//if incorrect origin (e.g. "/employees?origin=Bosto&destination=Newark")	
	//cities.get(origin) is out of bounds
	}	

	
	
