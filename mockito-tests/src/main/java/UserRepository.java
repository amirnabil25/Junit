import java.util.List;
import java.util.Optional;

interface UserRepository {
    String getUsername(int id);
    void save(User user);
    void deleteById(int id);
    List<User> findAll();
    Optional<User> findById(int id);
}