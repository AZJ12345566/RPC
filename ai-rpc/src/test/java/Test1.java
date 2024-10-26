/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/7/26 17:34
 */
public class Test1 {
    public static void main(String[] args) {
        User user = new User("小艾");
        User user1 = new User("小杰");
        swap(user, user1);
        System.out.println(user.getName());
        System.out.println(user1.getName());
    }
    private static void swap(User user1, User user2) {
        User user = new User();
        user = user1;
        user1 = user2;
        user2 = user;
    }
}
