package be.pxl.ja.streamingservice;

import be.pxl.ja.streamingservice.model.Account;
import be.pxl.ja.streamingservice.model.Content;
import be.pxl.ja.streamingservice.model.Documentary;
import be.pxl.ja.streamingservice.model.Movie;
import be.pxl.ja.streamingservice.model.Rating;
import be.pxl.ja.streamingservice.model.TVShow;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StreamingService {

	private List<Account> accounts = new ArrayList<>();
	private List<Content> contentList = new ArrayList<>();

	public StreamingService() {
		Movie the_incredibles = new Movie("The Incredibles", Rating.LITTLE_KIDS);
		the_incredibles.setReleaseDate(LocalDate.of(2004, 10, 27));
		the_incredibles.setImageUrl("the_incredibles.jpeg");
		contentList.add(the_incredibles);

		Documentary planet_earth = new Documentary("Planet Earth", Rating.LITTLE_KIDS);
		planet_earth.setReleaseDate(LocalDate.of(2006, 3, 5));
		planet_earth.setImageUrl("planet_earth.jpeg");
		contentList.add(planet_earth);

		Movie jack_ryan = new Movie("Jack Ryan: Shadow Recruit", Rating.TEENS);
		jack_ryan.setReleaseDate(LocalDate.of(2004, 10, 27));
		jack_ryan.setImageUrl("jack_ryan.jpeg");
		contentList.add(jack_ryan);

		Movie mi = new Movie("Mission Impossible: Fall Out", Rating.TEENS);
		mi.setImageUrl("mi.jpeg");
		contentList.add(mi);

		Movie iron_fist = new Movie("Iron Fist", Rating.MATURE);
		iron_fist.setReleaseDate(LocalDate.of(2004, 10, 27));
		iron_fist.setImageUrl("iron_fist.jpeg");
		contentList.add(iron_fist);

		TVShow eigen_kweek = new TVShow("Eigen kweek", Rating.TEENS, 3);
		eigen_kweek.setImageUrl("eigen_kweek.jpeg");
		contentList.add(eigen_kweek);

	}

	public void addAccount(Account account) {
		accounts.add(account);
	}

	public List<Content> getContentList() {
		return contentList;
	}

	public Account verifyAndGetAccount(String email, String password) {
		for (Account account : accounts) {
			if (account.getEmail().equals(email) && account.verifyPassword(password)) {
				return account;
			}
		}
		return null;
	}
}
