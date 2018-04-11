package edu.pune.university.dao;

import edu.pune.university.data.WaterData;
import edu.pune.university.exception.ApplicationException;
import junit.framework.TestCase;

public class WaterDataDaoTest extends TestCase {
	WaterDataDao waterDataDao = null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		waterDataDao = new WaterDataDao();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testCreateWaterDataTest() {
		WaterData waterData = new WaterData();
		waterData.setId("2");
		waterData.setTemperature(38.5F);
		try {
			waterDataDao.createWaterData(waterData);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
