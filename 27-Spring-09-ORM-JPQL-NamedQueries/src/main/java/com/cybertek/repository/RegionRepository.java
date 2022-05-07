package com.cybertek.repository;

import com.cybertek.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

    // Native Query
    @Query(value = "select * from regions where country = ?1", nativeQuery = true)
    List<Region> getRegionByCountry(String country);

    // Modifying queries
    @Modifying
    @Transactional
    @Query("update Region r set r.region = 'Central' where r.id = :id")
    void updateRegionJPQL(@Param("id") Long id);

}
