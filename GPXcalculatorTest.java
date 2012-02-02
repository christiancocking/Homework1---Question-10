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
		GPXtrkseg nullseginclued = new GPXtrkseg (points);
		GPXtrkseg nullseg = new GPXtrkseg (null);
		segs.add(nullseginclued);
		segs.add(nullseg);
		GPXtrk nullsegtrk = new GPXtrk ("Nothing",segs);
		assertEquals("Null Seg",0,-5.0, calc.calculateDistanceTraveled(nullsegtrk));
	}
	
	@SuppressWarnings("static-access")
	public void testNoGPXtrkobjects () {
		GPXcalculator calc = new GPXcalculator ();
		GPXtrkseg notrks = new GPXtrkseg (null);
		ArrayList <GPXtrkseg> segs = new ArrayList<GPXtrkseg> ();
		segs.add(notrks);
		GPXtrk nullsegtrk = new GPXtrk ("Nothing",segs);
		assertEquals("No Trks",0,-5.0, calc.calculateDistanceTraveled(nullsegtrk));	
	}
		
	
	@SuppressWarnings("static-access")
	public void testOneGPXtrk () {
		Date date = new Date (1300);
		GPXcalculator calc = new GPXcalculator ();
		ArrayList <GPXtrkpt> points = new ArrayList<GPXtrkpt> ();
		ArrayList <GPXtrkseg> segs = new ArrayList<GPXtrkseg> ();
		GPXtrkpt point1 = new GPXtrkpt (50,50,date);
		points.add(point1);
		GPXtrkseg oneseg= new GPXtrkseg (points);
		segs.add(oneseg);
		GPXtrk onetrk = new GPXtrk ("One TrkPoint",segs);
		assertEquals("Not Handleing Seg with no trks",0,-5.0, calc.calculateDistanceTraveled(onetrk));		
	}
	
	
	@SuppressWarnings("static-access")
	public void testNulltrkpt () {
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
		assertEquals("Seg with Null trk",0,-5.0, calc.calculateDistanceTraveled(nullsegtrk));				
	
	}

	@SuppressWarnings("static-access")
	public void testLatitudeGreater90 () {
		Date date = new Date (1300);
		GPXcalculator calc = new GPXcalculator ();
		ArrayList <GPXtrkpt> points = new ArrayList<GPXtrkpt> ();
		ArrayList <GPXtrkseg> segs = new ArrayList<GPXtrkseg> ();
		GPXtrkpt point1 = new GPXtrkpt (100,50,date);
		GPXtrkpt point2 = new GPXtrkpt (50,50,date);
		points.add(point1);
		points.add(point2);
		GPXtrkseg latgreater90 = new GPXtrkseg (points);
		segs.add(latgreater90);
		GPXtrk segtrk = new GPXtrk ("Nothing",segs);
		assertEquals("Seg with Lat Greater Than 90",0,-5.0, calc.calculateDistanceTraveled(segtrk));	
	}
	
	@SuppressWarnings("static-access")
	public void testLongitudeGreater180 () {
		Date date = new Date (1300);
		GPXcalculator calc = new GPXcalculator ();
		ArrayList <GPXtrkpt> points = new ArrayList<GPXtrkpt> ();
		ArrayList <GPXtrkseg> segs = new ArrayList<GPXtrkseg> ();
		GPXtrkpt point1 = new GPXtrkpt (90,181,date);
		GPXtrkpt point2 = new GPXtrkpt (50,50,date);
		points.add(point1);
		points.add(point2);
		GPXtrkseg longgreater180 = new GPXtrkseg (points);
		segs.add(longgreater180);
		GPXtrk segtrk = new GPXtrk ("Nothing",segs);
		assertEquals("Seg with Long Greater Than 180",0,-5.0, calc.calculateDistanceTraveled(segtrk));
	}
	
		@SuppressWarnings("static-access")
		public void testLongitudeLess0 () {
			Date date = new Date (1300);
			GPXcalculator calc = new GPXcalculator ();
			ArrayList <GPXtrkpt> points = new ArrayList<GPXtrkpt> ();
			ArrayList <GPXtrkseg> segs = new ArrayList<GPXtrkseg> ();
			GPXtrkpt point1 = new GPXtrkpt (90,-1,date);
			GPXtrkpt point2 = new GPXtrkpt (50,50,date);
			points.add(point1);
			points.add(point2);
			GPXtrkseg longless0 = new GPXtrkseg (points);
			segs.add(longless0);
			GPXtrk segtrk = new GPXtrk ("Nothing",segs);
			assertEquals("Seg with Long less Than 0",0,-5.0, calc.calculateDistanceTraveled(segtrk));
}
		
		@SuppressWarnings("static-access")
		public void testLatitudeLess0 () {
			Date date = new Date (1300);
			GPXcalculator calc = new GPXcalculator ();
			ArrayList <GPXtrkpt> points = new ArrayList<GPXtrkpt> ();
			ArrayList <GPXtrkseg> segs = new ArrayList<GPXtrkseg> ();
			GPXtrkpt point1 = new GPXtrkpt (90,90,date);
			GPXtrkpt point2 = new GPXtrkpt (-1,50,date);
			points.add(point1);
			points.add(point2);
			GPXtrkseg latless0 = new GPXtrkseg (points);
			segs.add(latless0);
			GPXtrk segtrk = new GPXtrk ("Nothing",segs);
			assertEquals("Seg with Lat less Than 0",0,-5.0, calc.calculateDistanceTraveled(segtrk));		
}
		
		@SuppressWarnings("static-access")
		public void testSamePointTwice () {
			Date date = new Date (1300);
			GPXcalculator calc = new GPXcalculator ();
			ArrayList <GPXtrkpt> points = new ArrayList<GPXtrkpt> ();
			ArrayList <GPXtrkseg> segs = new ArrayList<GPXtrkseg> ();
			GPXtrkpt point1 = new GPXtrkpt (90,90,date);
			GPXtrkpt point2 = new GPXtrkpt (90,90,date);
			points.add(point1);
			points.add(point2);
			GPXtrkseg latless0 = new GPXtrkseg (points);
			segs.add(latless0);
			GPXtrk segtrk = new GPXtrk ("Nothing",segs);
			assertEquals("Same point in the seg twice",0,-5.0, calc.calculateDistanceTraveled(segtrk));		
}
		public void testZeroes () {
			Date date = new Date (1300);
			GPXcalculator calc = new GPXcalculator ();
			ArrayList <GPXtrkpt> points = new ArrayList<GPXtrkpt> ();
			ArrayList <GPXtrkseg> segs = new ArrayList<GPXtrkseg> ();
			GPXtrkpt point1 = new GPXtrkpt (0,0,date);
			GPXtrkpt point2 = new GPXtrkpt (90,180,date);
			points.add(point1);
			points.add(point2);
			GPXtrkseg latless0 = new GPXtrkseg (points);
			segs.add(latless0);
			GPXtrk segtrk = new GPXtrk ("Nothing",segs);
			assertEquals("Same point in the seg twice with different long and lat",0,-5.0, calc.calculateDistanceTraveled(segtrk));		
}
		
		
		
		
}
