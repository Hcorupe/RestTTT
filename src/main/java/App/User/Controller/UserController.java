package App.User.Controller;

import App.User.Model.User;

import App.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path ="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping("/{id}")
    public Optional<User> getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @PostMapping(path = "/adduser")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUserById(@PathVariable long id){
        return userService.deleteUserById(id);
    }



}
