package demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/users")
public class UserRestController {

    @PostMapping
    public boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/oldest")
    public User getOldestUser() {
        return userService.getOldestUser();
    }

    @GetMapping("/search/olderthan")
    public List<User> searchUsersWithAgeOlderThan(@RequestParam("age") int age) {
        return userService.getUsersWithAgeOlderThan(age);
    }

    @GetMapping("/adults")
    public List<User> searchAdults() {
        return userService.getAdults();
    }

    @GetMapping("/search/{name}")
    public User searchUserWithName(@PathVariable("name") String name) {
        return userService.getUserWithName(name);
    }

    @GetMapping("/search/email/{email}")
    public User searchUserWithEmail(@PathVariable("email") String email) {
        return userService.getUserWithEmail(email);
    }

    @GetMapping("/search")
    public List<User> searchUsersWithAgeAndAge(@RequestParam("email") String email, @RequestParam("age") int age) {
        return userService.getUserWithEmailAndAge(email, age);
    }

    @GetMapping("/search/age/{min}/{max}")
    public List<User> giveUsersBetweenTwoAges(@PathVariable("min") int min, @PathVariable("max") int max) {
        return userService.getUsersBetweenAges(min, max);
    }

}
