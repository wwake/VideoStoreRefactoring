public class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public String getTitle() {
		return movie.getTitle();
	}

	public double cost() {
		return movie.cost(daysRented);
	}

	public int frequentRenterPoints() {
		return movie.frequentRentalPoints(this.daysRented);
	}
}
