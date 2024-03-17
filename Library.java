import java.util.HashMap;
import java.util.Scanner;

public class Library {
    private HashMap<String, String> users;

    public Library() {
        users = new HashMap<>();
        users.put("admin", "admin123");
        users.put("mahasiswa1", "password1");
        users.put("mahasiswa2", "password2");
    }

    public String login(String username, String password) {
        if (users.containsKey(username)) {
            if (users.get(username).equals(password)) {
                return username.startsWith("mahasiswa") ? "mahasiswa" : "admin";
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        String userType = null;


        while (userType == null) {
            System.out.print("Masukkan username: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();
            userType = library.login(username, password);
            if (userType == null) {
                System.out.println("Login gagal. Username atau password salah.");
            }
        }


        if (userType.equals("admin")) {
            System.out.println("Selamat datang, Admin!");
        } else if (userType.equals("mahasiswa")) {
            System.out.println("Selamat datang, Mahasiswa!");
        }

        scanner.close();
    }
}
