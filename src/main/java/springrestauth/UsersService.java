package springrestauth;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UsersService {
    private final List<User> users = Collections.synchronizedList(new ArrayList<>(Arrays.asList(
            new User(0, "User0"),
            new User(1, "User1"),
            new User(2, "User2")
    )));

    public List<User> getAll() {
        return users;
    }

    public User getById(int id) {
        User user;

        try {
            user = users.get(id);
        } catch (IndexOutOfBoundsException e) {
            return new User(-1, "");
        }
        return user;
    }

    public void add(String name) {
        users.add(new User(users.size(), name));
    }

    public void addAll(String[] nameArray) {
        for (String e : nameArray) {
            users.add(new User(users.size(), e));
        }
    }
}
