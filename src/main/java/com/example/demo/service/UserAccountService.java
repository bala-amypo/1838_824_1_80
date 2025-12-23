public interface UserAccountService {

    UserAccount register(UserAccount user);

    String login(String fullName, String password);

    List<UserAccount> getAllUsers();

    UserAccount getUserById(Long id);
}
