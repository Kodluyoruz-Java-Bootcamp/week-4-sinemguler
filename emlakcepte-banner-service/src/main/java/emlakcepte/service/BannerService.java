package emlakcepte.service;

import emlakcepte.model.Banner;
import emlakcepte.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService {

	@Autowired
	private BannerRepository bannerRepository;

	public void create(Banner banner) {
		bannerRepository.save(banner);
		System.out.println("BannerService :: banner kaydedildi");
	}

	public List<Banner> getAll() {
		return bannerRepository.findAll();
	}

}
