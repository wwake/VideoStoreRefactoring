public class Movie {
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	public static final int CHILDRENS = 2;

	private String title;

	double basePrice;
	double costPerExtraDay;
	int chargeExtraAfterDays;

	int bonusAfterDays;
	int bonusPoints;
	
	public Movie(String title, int priceCode) {
		this.title = title;
		
		switch (priceCode) {
		case Movie.REGULAR:
			basePrice = 2;
			
			chargeExtraAfterDays = 2;
			costPerExtraDay = 1.5;
			
			bonusAfterDays = 0;
			bonusPoints = 0;

			break;
		case Movie.NEW_RELEASE:
			basePrice = 0;

			chargeExtraAfterDays = 0;
			costPerExtraDay = 3;

			bonusAfterDays = 1;
			bonusPoints = 1;

			break;
		case Movie.CHILDRENS:
			basePrice = 1.5;
		
			chargeExtraAfterDays = 3;
			costPerExtraDay = 1.5;
			
			bonusAfterDays = 0;
			bonusPoints = 0;

			break;
		default:
			throw new RuntimeException("Movie.cost unexpected code");
		}
	}

	public String getTitle() {
		return title;
	}

	public double cost(int daysRented) {
		double result = 0;

		result += basePrice;
		if (daysRented > chargeExtraAfterDays) 
			result += (daysRented - chargeExtraAfterDays) * costPerExtraDay;

		return result;
	}

	public int frequentRentalPoints(int daysRented) {
		int points = 1;

		if (daysRented > bonusAfterDays)
			points += bonusPoints;
		
		return points;
	}
}