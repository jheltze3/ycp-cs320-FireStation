package edu.ycp.CS320.jjda;

import static org.junit.Assert.*;

import org.junit.Test;

public class StationTest {

	@Test
	public void test() {
		Station YorkStation = new Station("York");
		
		assertEquals("York", YorkStation.getName());
	}

}
