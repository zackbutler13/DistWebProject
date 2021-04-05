package  com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.Trainer;

//communicates with MySQL

@Repository
public interface TrainerRepository extends CrudRepository<Trainer, Integer>{
    
}