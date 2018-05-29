package edu.pune.university.business;

import java.util.ArrayList;
import java.util.List;

import edu.pune.university.dao.WaterDataDao;
import edu.pune.university.dao.WaterDemoDataDao;
import edu.pune.university.data.WaterData;
import edu.pune.university.data.WaterDataTO;
import edu.pune.university.data.WaterDemoData;
import edu.pune.university.data.WaterDemoDataTO;
import edu.pune.university.exception.ApplicationException;

/**
 * WaterDataBusiness class is responsible for holding the business logic for
 * water data. This class will interact with {@link WaterDataDao} for database
 * operations and with {@link WaterDataService} for returning the result to
 * user.
 * 
 * @author <a href="mailto:mayap282@gmail.com">Maya Pilania</a>
 *
 */

public class WaterDemoDataBusiness {
	

	/**
	 * Instance variable declaration for {@link WaterDataDao}.
	 */
	private WaterDemoDataDao waterDemoDataDao = null;

	/**
	 * Create an instance of {@link WaterDataDao}.
	 */
	public WaterDemoDataBusiness() {
		waterDemoDataDao = new WaterDemoDataDao();
	}

	/**
	 * Get all the {@link WaterDataTO} from {@link WaterDataDao}.
	 * @return {@link List} of {@link WaterDataTO}
	 * @throws ApplicationException
	 */
	public List<WaterDemoDataTO> getAllWaterDemoDataTOs() throws ApplicationException {
		List<WaterDemoDataTO> waterDemoDataTOs = new ArrayList<WaterDemoDataTO>();
		List<WaterDemoData> allWaterDemoData = waterDemoDataDao.getAllWaterDemoData();
		for (WaterDemoData waterDemoData : allWaterDemoData) {
			waterDemoDataTOs.add(new WaterDemoDataTO(waterDemoData));
		}
		return waterDemoDataTOs;
	}

}
