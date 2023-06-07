package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
@Table(name = "users")
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public long id;
    private String name;
    private int age;
    @Transient
    private List<Integer> membershipYears = new ArrayList<Integer>();
    private String email;
    private String password;

    public User(String name, int age, String email, String password) {
        this.name = name;
        if (age >= 0)
            this.age = age;
        if (email.contains("@"))
            this.email = email;
        if (password.isBlank())
            password = "t";
        this.password = password;
    }

    public User() {

    }

    public int countMembershipYearsAfter1999() {
        int result = 0;
        for (Integer year : membershipYears) {
            if (year > 1999)
                result++;
        }
        return result;
    }

    public int countYearsOfMembership() {
        return membershipYears.size();
    }

    public void addMembershipYear(int year) {
        membershipYears.add(year);
    }

    public int getFirstMembershipYear() {
        if (membershipYears.size() <= 0) {
            return 0;
        } else
            return Collections.min(membershipYears);
    }

    public String toString() {
        return "Elke is " + this.age + " years old and has as email " + this.email;
    }

    public int getNumberOfMembershipYearsIn2000() {
        int result = 0;
        for (int year : membershipYears) {
            if (2000 <= year && year < 3000) {
                result++;
            }
        }
        return result;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return "@$-" + password + "&%#";
    }

    public Boolean isPasswordCorrect(String password) {
        if (this.password == password) {
            return true;
        } else
            return false;
    }

    public boolean hasMemberShipYear(int year) {
        for (int membershipYear : membershipYears) {
            if (membershipYear == year) {
                return true;
            }
        }
        return false;

    }

}