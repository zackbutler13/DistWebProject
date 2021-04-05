package  com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.User;

//communicates with MySQL

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
    
}