import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        User user = getUserByLoginAndPasswords(login, password);

        validateUser(user);
        System.out.println("Вам налить что-нибудь?");
    }

    private static void validateUser(User user) throws AccessDeniedException {
        if (user.getAge() < 18) {
            throw new AccessDeniedException("Доступ Запрещен, мал еще!");
        } else {
            System.out.println("Доступ разрешен. Добро пожаловать!");
        }
    }

    public static User[] getUsers(){
        User user1 = new User("admin", "12345", "admin@info.ru", 40);
        User user2 = new User("webmaster", "qwerty", "webmaster@info.ru", 32);
        User user3 = new User("tester", "qazxsw", "tester@info.ru", 28);

        return new User[] {user1, user2, user3};
    }

    public static  User getUserByLoginAndPasswords(String login, String password) throws UserNotFoundException{
        User[] users = getUsers();
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)){
                return user;
            }
        }
        throw new UserNotFoundException("User Not Found");
    }
}