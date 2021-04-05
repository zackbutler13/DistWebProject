package  com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.Gym;

//communicates with MySQL

@Repository
public interface GymRepository extends CrudRepository<Gym, Integer>{
    
}