package App.User.Controller;

import App.User.Repository.UserRepository;
import App.User.Model.User;
import App.User.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/user")
    public User createUser(@Validated @RequestBody User user){
        User user1 = userRepository.save(user);
        return user1;
    }

    @GetMapping("/user")
    public Page<User> listOfUsers(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    @GetMapping("/user/{id}")
    public User getById(@PathVariable Long id){
        User user = userRepository.getOne(id);
        return user;
    }

    @DeleteMapping("/user")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        return userRepository.findById(id)
                .map(user -> {
                    userRepository.delete(user);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("User not found "));

    }

}
