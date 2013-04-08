package edu.ycp.cs320.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ycp.CS320.shared.Station;

public class StationTest {
	
	@Test
	public void test() {
		
		Station YorkStation = new Station("York");
		assertEquals("York", YorkStation.getName());
	}

}
