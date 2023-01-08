package com.emlakcepteservice.repository;

import com.emlakcepteservice.model.Message;
import com.emlakcepteservice.model.Realty;
import com.emlakcepteservice.model.enums.RealtyType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface RealtyRepository extends JpaRepository<Realty, Integer> {
    List<Realty> findAllByUserId(int id);
    List<Realty> findAllByStatus(RealtyType active);


}
