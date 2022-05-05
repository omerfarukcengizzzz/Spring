package com.cybertek.repository;

import com.cybertek.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

    // Display all the regions in Canada
    List<Region> findByCountry(String country);

    // Display all the regions in Canada without duplicates
    List<Region> findDistinctByCountry(String country);

    //Display all the regions with country name includes 'United'
    List<Region> findByCountryContaining(String infix);

    // Display all the regions with country name includes 'United' in order
    List<Region> findByCountryContainingOrderByCountryDesc(String infix);

    //Display top 2 regions in Canada
    List<Region> findTop2ByCountry(String country);

}
