package  com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.Schedule;

//communicates with MySQL

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Integer>{
    
}