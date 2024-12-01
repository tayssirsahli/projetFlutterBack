package com.tayssir.cosmetique.restcontrollers;

import com.tayssir.cosmetique.entities.User;
import com.tayssir.cosmetique.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")  // Permet l'accès depuis n'importe quelle origine
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        User oldUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (oldUser == null) {
            System.out.println("Utilisateur non trouvé");
        }
        System.out.println("Utilisateur : " + oldUser);
        return oldUser;
    }
}
