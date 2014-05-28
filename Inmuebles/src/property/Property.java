package property;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
public class Property {

	private Double area;
	private String address;
	private String city;
	private int stratum;
	private long salePrice;
	private long leasePrice;
	private int visits;
	private String timeBuilt;
	private long costOfAdministration;
	private boolean privateSecurity;
	private String description;
	private String photo;

	public Property(Double area, String address, String city, int stratum, long salePrice, long leasePrice, int visits, String timeBuilt, long costOfAdministration, boolean privateSecurity,
			String description, String photo) {
		super();
		this.area = area;
		this.address = address;
		this.city = city;
		this.stratum = stratum;
		this.salePrice = salePrice;
		this.leasePrice = leasePrice;
		this.visits = visits;
		this.timeBuilt = timeBuilt;
		this.costOfAdministration = costOfAdministration;
		this.privateSecurity = privateSecurity;
		this.description = description;
		this.photo = photo;
	}

	public Double getArea() {
		return area;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public int getStratum() {
		return stratum;
	}

	public long getSalePrice() {
		return salePrice;
	}

	public long getLeasePrice() {
		return leasePrice;
	}

	public int getVisits() {
		return visits;
	}

	public String getTimeBuilt() {
		return timeBuilt;
	}

	public long getCostOfAdministration() {
		return costOfAdministration;
	}

	public boolean isPrivateSecurity() {
		return privateSecurity;
	}

	public String getDescription() {
		return description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setStratum(int stratum) {
		this.stratum = stratum;
	}

	public void setSalePrice(long salePrice) {
		this.salePrice = salePrice;
	}

	public void setLeasePrice(long leasePrice) {
		this.leasePrice = leasePrice;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public void setTimeBuilt(String timeBuilt) {
		this.timeBuilt = timeBuilt;
	}

	public void setCostOfAdministration(long costOfAdministration) {
		this.costOfAdministration = costOfAdministration;
	}

	public void setPrivateSecurity(boolean privateSecurity) {
		this.privateSecurity = privateSecurity;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
