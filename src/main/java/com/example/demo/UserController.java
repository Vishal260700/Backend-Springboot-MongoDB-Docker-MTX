package com.example.demo;

import lombok.AllArgsConstructor;
import org.bson.json.JsonObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    private UserRepository userRepository;


    /* GET REQUESTS */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<user> fetchAllUsers(){
        return userRepository.findAll();
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public Optional<user> getUserById(@PathVariable("id") String ID){
        Optional<user> users = userRepository.findById(ID);
        return users;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/userSearch/{email}")
    public List<user> getUserByEmail(@PathVariable("email") String Email){
        List<user> users = userRepository.findByEmail(Email);
        return users;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getUser/{name}")
    public List<user> getUserByName(@PathVariable("name") String Name){
        List<user> users = userRepository.findByName(Name);
        return users;
    }

    /* DELETE REQUESTS */
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/delUser/{id}")
    public void delUser(@PathVariable("id") String id){
        userRepository.deleteById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/delUserEmail/{email}")
    public void delUserEmail(@PathVariable("email") String email){
        userRepository.deleteByEmail(email);
    }

    /* PUT REQUESTS */
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping
    public void insert(@RequestBody user newUser){
        userRepository.insert(newUser);
    }

    /* POST REQUESTS */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/editUserDetail")
    public void editUser(@RequestBody user editedUser){
        userRepository.save(editedUser);
    }

}
