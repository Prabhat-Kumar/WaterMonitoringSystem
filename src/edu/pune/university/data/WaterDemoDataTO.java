package edu.pune.university.data;
/**
 * {@link WaterDataTO} is transfer object for {@link WaterData}. The
 * {@link WaterData} information will be converted to {@link WaterDataTO} before
 * sending to user.
 * 
 * @author <a href="mailto:mayap282@gmail.com">Maya Pilania</a>
 */

public class WaterDemoDataTO {
	
	private String time;
	private double temp;
	private double pH;
	
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}




	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}




	/**
	 * @return the temp
	 */
	public double getTemp() {
		return temp;
	}




	/**
	 * @param temp the temp to set
	 */
	public void setTemp(double temp) {
		this.temp = temp;
	}




	/**
	 * @return the pH
	 */
	public double getpH() {
		return pH;
	}




	/**
	 * @param pH the pH to set
	 */
	public void setpH(double pH) {
		this.pH = pH;
	}




	/**
	 * Get {@link WaterDataTO} using {@link WaterData}.
	 * @param waterData {@link WaterData}
	 */
	public WaterDemoDataTO(WaterDemoData waterData) {
		this.time = waterData.getTime();
		this.temp = waterData.getTemp();
		this.pH = waterData.getpH();
		
	}


	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long tmp;
		tmp = Double.doubleToLongBits(temp);
		result = prime * result + (int) (tmp ^ (tmp >>> 32));
		tmp = Double.doubleToLongBits(pH);
		result = prime * result + (int) (tmp ^ (tmp >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WaterDemoDataTO other = (WaterDemoDataTO) obj;
		if (Double.doubleToLongBits(temp) != Double.doubleToLongBits(other.temp))
			return false;
		if (Double.doubleToLongBits(pH) != Double.doubleToLongBits(other.pH))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WaterDataTO [time=" + time + ", temp=" + temp + ", pH=" + pH
				 + "]";
	}


}
