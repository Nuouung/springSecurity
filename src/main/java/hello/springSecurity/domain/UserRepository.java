package hello.springSecurity.domain;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class UserRepository {

    private final Map<String, User> userMap = new HashMap<>();

    public User saveUser(User user) {
        userMap.put(user.getEmail(), user);

        return userMap.get(user.getEmail());
    }

    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(userMap.get(email));
    }

}
