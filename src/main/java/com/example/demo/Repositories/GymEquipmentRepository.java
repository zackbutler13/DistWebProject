package  com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.GymEquipment;

//communicates with MySQL

@Repository
public interface GymEquipmentRepository extends CrudRepository<GymEquipment, Integer>{
    
}