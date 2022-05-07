package com.cybertek.repository;

import com.cybertek.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

    // Native Query
    @Query(value = "select * from regions where country = ?1", nativeQuery = true)
    List<Region> getRegionByCountry(String country);

}
