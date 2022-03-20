package hello.springSecurity.domain;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryUserRepository {

    private final Map<String, User> userNap = new HashMap<>();

    public User save(User user) {
        userNap.put(user.getEmail(), user);
        return user;
    }

    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(userNap.get(email));
    }
}
