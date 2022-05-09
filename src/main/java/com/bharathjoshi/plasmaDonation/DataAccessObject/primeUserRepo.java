package com.bharathjoshi.plasmaDonation.DataAccessObject;

import com.bharathjoshi.plasmaDonation.Beans.primeUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface primeUserRepo extends CrudRepository<primeUser, Integer> {

}
