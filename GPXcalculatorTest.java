package edu.upenn.cis350.gpx;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class GPXcalculatorTest {



	@SuppressWarnings("static-access")
	@Test
	public void testNullInput () {
		GPXcalculator calc = new GPXcalculator ();
		assertEquals("Not Handleing Null Correctly",-1,-5.0, calc.calculateDistanceTraveled(null));
	}

	@SuppressWarnings("static-access")
	public void testNoGPXtrksegobjects () {
		GPXcalculator calc = new GPXcalculator ();
		ArrayList <GPXtrkseg> empty = new ArrayList<GPXtrkseg> ();
		GPXtrk emptytrk = new GPXtrk ("Nothing",empty);
		assertEquals("Not Handleing Null Correctly",-1,-5.0, calc.calculateDistanceTraveled(emptytrk));
	}
	
	@SuppressWarnings("static-access")
	public void testNullGPXtrkseg () {
		Date date = new Date (1300);
		GPXcalculator calc = new GPXcalculator ();
		ArrayList <GPXtrkpt> points = new ArrayList<GPXtrkpt> ();
		ArrayList <GPXtrkseg> segs = new ArrayList<GPXtrkseg> ();
		GPXtrkpt point1 = new GPXtrkpt (50,50,date);
		GPXtrkpt point2 = new GPXtrkpt (50,50,date);
		points.add(point1);
		points.add(point2);
		points.add(null);
		GPXtrkseg nullseginclued = new GPXtrkseg (points);
		segs.add(nullseginclued);
		GPXtrk nullsegtrk = new GPXtrk ("Nothing",segs);
		assertEquals("Not Handleing Seg with Null trk",0,-5.0, calc.calculateDistanceTraveled(nullsegtrk));
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
