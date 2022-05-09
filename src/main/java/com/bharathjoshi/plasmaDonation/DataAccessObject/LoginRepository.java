package com.bharathjoshi.plasmaDonation.DataAccessObject;

import com.bharathjoshi.plasmaDonation.Beans.primeUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends CrudRepository<primeUser, Integer> {
    @Query(value = "select * from prime_user where email=?1", nativeQuery = true)
    List<primeUser> findByEmail(String email);

}
