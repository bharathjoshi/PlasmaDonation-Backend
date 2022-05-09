package com.bharathjoshi.plasmaDonation.DataAccessObject;

import com.bharathjoshi.plasmaDonation.Beans.donorAvail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonorRepo extends CrudRepository<donorAvail, Integer> {
    @Query(value = "select * from (select t.email, t.first_name, t.last_name, t.phone_number, t.age, t.blood_group, s.place from prime_user t, donor_avail s where s.user_email = t.email) as p where p.place = ?1", nativeQuery = true)
    List<Object[]> getDonorDetailsBasedonLocation(String Location);

    @Query(value = "select * from (select t.email, t.first_name, t.last_name, t.phone_number, t.age, t.blood_group, s.place from prime_user t, donor_avail s where s.user_email = t.email) as p where p.blood_group = ?1", nativeQuery = true)
    List<Object[]> getDonorDetailsBasedonBloodGroup(String bloodGroup);

    @Query(value = "select * from (select t.id, t.email, t.first_name, t.last_name, t.phone_number, t.age, t.blood_group, s.place from prime_user t, donor_avail s where s.user_email = t.email) as p where p.blood_group = ?1 and p.place =?2", nativeQuery = true)
    List<Object[]> getDonorDetailsBasedonBloodGroupandLocation(String Location, String blood_group);

    @Query(value = "select * from donor_avail where place = ?1 and user_email= ?2",nativeQuery = true)
    List<donorAvail> getDonors(String Location, String user_email);
    void deleteById(Integer id);
}
