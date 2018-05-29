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
		waterData.setLocation("Panshet Dam , Maharastra");
		waterData.setLatitude(18.377934);
		waterData.setLongitude(73.613514);
		
		List<Record> records = new ArrayList<Record>();
		
		Record record1 = new Record("01-September-2017", 8, 32.40F);
		records.add(record1);
		
		record1 = new Record("01-October-2017", 8, 29.80F);
		records.add(record1);
		
		
		record1 = new Record("01-November-2017", 7, 27.80F);
		records.add(record1);
		
		record1 = new Record("01-December-2017", 7, 19.90F);
		records.add(record1);
		
		record1 = new Record("01-January-2018",6, 20.30F);
		records.add(record1);
		
		record1 = new Record("01-Febuary-2018", 7, 22.20F);
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
