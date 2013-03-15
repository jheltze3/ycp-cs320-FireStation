package edu.ycp.CS320.test;

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
