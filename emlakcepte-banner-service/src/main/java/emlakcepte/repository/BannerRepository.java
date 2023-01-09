package emlakcepte.repository;


import emlakcepte.model.Banner;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class BannerRepository {

	private static List<Banner> banners = new ArrayList<>();

	public void save(Banner banner) {
		banners.add(banner);
		System.out.println("BannerRepository :: banner kaydedildi." + banner);
	}

	public List<Banner> findAll() {
		return banners;
	}

}
