import java.util.List;

class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public String getUsername(int id) {
        if (id == 1) throw new RuntimeException("Error");
//        id++;
        return repo.getUsername(id);
    }

    public void saveUser(User user) {
        repo.save(user);
    }

    public void deleteUser(int id) {
        repo.deleteById(id);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User getUserById(int id) {
        return repo.findById(id).orElse(null);
    }
}