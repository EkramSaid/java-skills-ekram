public class UserInfo {
    private String name;
    private int age;
    private String email;
    private boolean isActive;

    public UserInfo(String name, int age, String email, boolean isActive) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void displayInfo() {
        System.out.println("========== USER INFO ==========");
        System.out.println("Name    : " + name);
        System.out.println("Age     : " + age);
        System.out.println("Email   : " + email);
        System.out.println("Active? : " + (isActive ? "Yes" : "No"));
        System.out.println("===============================\n");
    }

    public static void main(String[] args) {
        // Create 3 users
        UserInfo user1 = new UserInfo("Ekram", 25, "ekram@example.com", true);
        UserInfo user2 = new UserInfo("Ali", 30, "ali@example.com", false);
        UserInfo user3 = new UserInfo("Salma", 28, "salma@example.com", true);

        user1.displayInfo();
        user2.displayInfo();
        user3.displayInfo();

        user1.setAge(26);
        user1.setEmail("new-ekram@example.com");
        System.out.println("After update:");
        user1.displayInfo();
    }
}
