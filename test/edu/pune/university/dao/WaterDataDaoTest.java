package edu.pune.university.dao;

import java.util.ArrayList;
import java.util.List;

import edu.pune.university.data.Record;
import edu.pune.university.data.WaterData;
import edu.pune.university.data.WaterDataTO;
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
		waterData.setLocation("CTW Dighi Pimpri-Chinchwad, Maharashtra 411039");
		waterData.setLatitude(18.6123331F);
		waterData.setLongitude(73.85091160000002F);
		
		List<Record> records = new ArrayList<Record>();
		
		Record record1 = new Record("01-March-2017", 8, 25.0F);
		records.add(record1);
		
		record1 = new Record("01-April-2017", 9, 25.0F);
		records.add(record1);
		
		record1 = new Record("01-May-2017", 8, 25.0F);
		records.add(record1);
		
		record1 = new Record("01-June-2017", 8, 25.0F);
		records.add(record1);
		
		record1 = new Record("01-July-2017", 8, 25.0F);
		records.add(record1);
		
		record1 = new Record("01-August-2017", 8, 25.0F);
		records.add(record1);
		
		waterData.setRecords(records);
		
		try {
			waterDataDao.createWaterData(waterData);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
	}

	public void testGetAllWaterData () {
		try {
			List<WaterData> allWaterData = waterDataDao.getAllWaterData();
			for (WaterData waterData : allWaterData) {
				WaterDataTO waterDataTO = new WaterDataTO(waterData);
				System.out.println(waterDataTO);
			}
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
