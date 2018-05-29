package edu.pune.university.dao;

import java.util.List;

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
