package App.User.Service;

import App.User.Model.User;
import App.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(long id){
        return userRepository.findById(id);
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public String deleteUserById(long id){
        userRepository.deleteById(id);
        return "User Deleted id=" + id + " ";
    }

    public User updateUser( User user){
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        return userRepository.save(existingUser);
    }




}
