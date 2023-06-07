package demo;

import java.util.ArrayList;
import java.util.List;

import org.h2.message.Trace;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.joran.conditional.ElseAction;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

    // private List<User> userRepository = new ArrayList<>();

    // public UserService() {
    // User miyo = new User("Miyo", 15, "miyo@ucll.be", "miyopassword");
    // User elke = new User("Elke", 44, "elke@ucll.be", "elke");
    // User eric = new User("Eric", 65, "eric@kuleuven.be", "eric");
    // User yuki = new User("Yuki", 13, "yuki@ucll.be", "yuki");

    // userRepository.add(elke);
    // userRepository.add(miyo);
    // userRepository.add(eric);
    // userRepository.add(yuki);
    // }

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getUsersWithAgeOlderThan(int age) {
        return userRepository.findUsersByAgeAfter(age);
    }

    public List<User> getAdults() {
        return userRepository.findUsersByAgeAfter(17);
    }

    public User getOldestUser() {
        List<User> list_Users = userRepository.findAllByOrderByAgeDesc();
        if (list_Users == null) {
            return null;
        }
        return list_Users.get(0);
    }

    public User getUserWithName(String name) {
        return userRepository.findUserByName(name);
    }

    public boolean addUser(User user) {

        if (getUserWithEmail(user.getEmail()) != null)
            return false;
        userRepository.save(user);
        return true;

    }

    public User getUserWithEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User getUserWithEmailAndAge(String email, int age) {
        return userRepository.findByEmailAndAge(email, age);
    }

    public User removeUser(String email) {
        User deleted_user = userRepository.findUserByEmail(email);
        userRepository.delete(deleted_user);
        return deleted_user;

    }

    public List<User> returnListUsersWithGivenMembershipYears(int year) {
        List<User> allUsers = userRepository.findAll();
        List<User> givenMembershipYearsUsers = new ArrayList<>();
        for (User user : allUsers) {
            if (user.hasMemberShipYear(year) == true) {
                givenMembershipYearsUsers.add(user);
            }
        }
        return givenMembershipYearsUsers;
    }

    public List<User> getUsersBetweenAges(int min, int max) {
        List<User> allUsers = userRepository.findAll();

        List<User> usersBetweenAges = new ArrayList<>();

        for (User user : allUsers) {
            if (min < user.getAge() && user.getAge() < max) {
                usersBetweenAges.add(user);
            }
        }
        return usersBetweenAges;
    }

}
