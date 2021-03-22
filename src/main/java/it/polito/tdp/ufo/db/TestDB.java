package it.polito.tdp.ufo.db;

import java.sql.*;
import java.util.*;

public class TestDB {
	
	public static void main (String[] args) {
		
	SightingDAO dao = new SightingDAO ();
	List <String> forme = dao.readShape();
	
	for (String forma :forme) {
		int count = dao.countByShape(forma);
		System.out.println("Ufo di forma "+forma + " sono: " +count);
	}
		
	}

}
