package com.emlakcepteservice.service;


import com.emlakcepteservice.client.Banner;
import com.emlakcepteservice.client.BannerServiceClient;
import com.emlakcepteservice.controller.RealtyController;
import com.emlakcepteservice.controller.UserController;
import com.emlakcepteservice.model.Realty;
import com.emlakcepteservice.model.User;
import com.emlakcepteservice.model.enums.RealtyType;
import com.emlakcepteservice.model.enums.UserType;
import com.emlakcepteservice.repository.RealtyRepository;
import com.emlakcepteservice.repository.UserRepository;
import com.emlakcepteservice.request.RealtyRequest;
import com.emlakcepteservice.request.RealtyUpdateRequest;
import com.emlakcepteservice.response.RealtyResponse;
import com.emlakcepteservice.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class RealtyService {
    private static final int MAX_INDIVICUAL_REALTY_SIZE = 5;
    @Autowired
    private UserService userService;

    @Autowired
    private RealtyRepository realtyRepository;

    @Autowired
    private BannerServiceClient bannerServiceClient;

    public Realty create(RealtyRequest realtyRequest) {
        Logger logger = Logger.getLogger(UserController.class.getName());

        Optional<User> foundUser = userService.getById(realtyRequest.getUserId());

        if (!foundUser.isPresent()) {
            throw new IllegalArgumentException("Kullanıcı kayıtlı değildir");
        }

        if (UserType.INDIVIDUAL.equals(foundUser.get().getType())) { // en fazla 5 ilan girebilir.

            List<Realty> realtyList = realtyRepository.findAllByUserId(foundUser.get().getId());

            if (MAX_INDIVICUAL_REALTY_SIZE == realtyList.size()) {
                // TODO exception fırlatılabilir.
                logger.log(Level.WARNING, "Bireysel kullanıcı en fazla 5 ilan girebilir. userID : {0}",
                        foundUser.get().getId());
            }

        }

        /*
         * NPE fırlatır
         *
         * if (foundUser.get().getType().equals(UserType.INDIVIDUAL)) { // en fazla 5
         * ilan girebilir.
         * System.out.println("Bireysel kullanıclar en fazla 5 ilan girebilir."); }
         */

        // User user = userService.getByEmail("test@gmail.com");
        // realty.setUser(user);


            Realty realty = convert(realtyRequest);
            realty.setUser(foundUser.get());
            Realty savedRealty = realtyRepository.save(realty);

        System.out.println("createRealty :: " + realty);

        // TODO :: banner-service çağır ve banner siparişi ver

        Banner bannerRequest = new Banner(String.valueOf(realty.getNo()), 1, "123123", "");

        Banner bannerResponse = bannerServiceClient.create(bannerRequest);

        if (bannerResponse.getAdet() > 1) {
            System.out.println("hata verilsin");
        }
        System.out.println("bannerResponse :" + bannerResponse.getAdet());

        return savedRealty;

    }

    private Realty convert(RealtyRequest realtyRequest) {
        Realty realty = new Realty();
        realty.setNo(realtyRequest.getNo());
        realty.setCreateDate(LocalDateTime.now());
        realty.setStatus(RealtyType.IN_REVIEW);
        realty.setTitle(realtyRequest.getTitle());
        realty.setProvince(realtyRequest.getProvince());
        return realty;
    }

    public List<Realty> getAll() {
        return realtyRepository.findAll();
    }

    public void getAllByProvince(String province) {

        getAll().stream().filter(realty -> realty.getProvince().equals(province)) //
                // .count();
                .forEach(realty -> System.out.println(realty));

    }
//
//	public List<Realty> getAllByUserName(User user) {
//		return getAll().stream().filter(realty -> realty.getUser().getMail().equals(user.getMail())).toList();
//	}

    public List<Realty> getActiveRealtyByUserName(User user) {
        return getAll().stream().filter(realty -> realty.getUser().getName().equals(user.getName()))
                .filter(realty -> RealtyType.ACTIVE.equals(realty.getStatus())).toList();
    }

    public List<Realty> getAllById(int id) {
        return realtyRepository.findAllByUserId(id);
    }

    public List<Realty> getAllActiveRealtyes() {
        return realtyRepository.findAllByStatus(RealtyType.ACTIVE);
    }

    public RealtyResponse update(RealtyUpdateRequest realtyUpdateRequest) {
        Realty realty = realtyRepository.findById(realtyUpdateRequest.getId()).get();

        if (realtyUpdateRequest.getStatus() != RealtyType.ACTIVE && realtyUpdateRequest.getStatus() != RealtyType.PASSIVE) {
            throw new IllegalArgumentException("İlanın statüsü sadece Aktif veya Pasif olarak güncellenebilir");
        }

        realty.setStatus(realtyUpdateRequest.getStatus());
        realty.setNo(realtyUpdateRequest.getNo());
        realty.setTitle(realtyUpdateRequest.getTitle());
        realty.setProvince(realtyUpdateRequest.getProvince());
        realtyRepository.save(realty);
        return new RealtyResponse();
    }

    public List<Realty> getAllPassiveRealtyes() {
        return realtyRepository.findAllByStatus(RealtyType.PASSIVE);
    }

    public void delete(int id){
        realtyRepository.deleteById(id);
    }


}


