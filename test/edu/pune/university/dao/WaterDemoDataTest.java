package edu.pune.university.dao;

import java.util.ArrayList;
import java.util.List;

import edu.pune.university.data.Record;
import edu.pune.university.data.WaterData;
import edu.pune.university.data.WaterDataTO;
import edu.pune.university.data.WaterDemoData;
import edu.pune.university.data.WaterDemoDataTO;
import edu.pune.university.exception.ApplicationException;
import junit.framework.TestCase;

public class WaterDemoDataTest extends TestCase {
	
	WaterDemoDataDao waterDemoDataDao = null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		waterDemoDataDao = new WaterDemoDataDao();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testCreateWaterDemoDataTest() {
		WaterDemoData waterDemoData = new WaterDemoData();
		waterDemoData.setTime("2018-05-30 12:49:26");
		waterDemoData.setTemprature(32.40F);
		waterDemoData.setpH(7);
		
		try {
			waterDemoDataDao.createWaterDemoData(waterDemoData);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
	}

	public void testGetAllWaterDemoData () {
		try {
			List<WaterDemoData> allWaterDemoData = waterDemoDataDao.getAllWaterDemoData();
			for (WaterDemoData waterData : allWaterDemoData) {
				WaterDemoDataTO waterDemoDataTO = new WaterDemoDataTO(waterData);
				System.out.println(waterDemoDataTO);
			}
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
