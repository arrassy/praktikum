import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<Book> bookList = new ArrayList<>();

    ArrayList<Book> borrowed = new ArrayList<>();
    ArrayList<Student> userStudent = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the Library System");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Student");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi (1-3): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    menuAdmin();
                    break;
                case 2:
                    menuStudent();
                    break;
                case 3:
                    System.out.println("Keluar...");
                    return;
                default:
                    System.out.println("pilihan tidak sesuai");
            }
        }
    }

    public void menuAdmin() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nAdmin Dashboard");
            System.out.println("1. Tambah Student");
            System.out.println("2. List tampilan Student");
            System.out.println("3. Tambah buku");
            System.out.println("4. List tampilan buku");
            System.out.println("5. Kembali ke menu");
            System.out.print("Pilih opsi (1-5): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudent();
                    break;
                case 3:
                    addBook();
                    break;
                case 4:
                    displayBookList();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Oilihan tidak sesuai");
            }
        }
    }

    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan nama siswa: ");
        String name = scanner.nextLine();
        System.out.println("Masukkan NIM: ");
        String nim = scanner.nextLine();
        System.out.println("Masukkan fakultas: ");
        String faculty = scanner.nextLine();
        System.out.println("Masukkan program studi: ");
        String programStudy = scanner.nextLine();

        if (nim.length() != 15) {
            System.out.println("Nim tidak sesuai. Nim harus 15 karakter");
            return;
        }

        Student student = new Student();
        student.nama = name;
        student.nim = nim;
        student.fakultas = faculty;
        student.programStudi = programStudy;

        userStudent.add(student);

        System.out.println("Siswa sukses ditambahkan.");
    }

    public void displayStudent() {
        for (Student student : userStudent) {
            System.out.println("NIM: " + student.nim + ", Name: " + student.nama + ", Faculty: " + student.fakultas + ", Program Study: " + student.programStudi);
        }
    }

    public void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan judul buku: ");
        String title = scanner.nextLine();
        System.out.println("Masukkan nama pengarang: ");
        String author = scanner.nextLine();
        System.out.println("Masukkan ID buku: ");
        int id = scanner.nextInt();
        System.out.println("masukkan stok buku: ");
        int stock = scanner.nextInt();


        Book book = new Book();
        book.judul = title;
        book.author = author;
        book.id_buku = id;
        book.stok = stock;


        bookList.add(book);

        System.out.println("Buku sukses ditambahkan");
    }

    public void displayBookList() {
        for (Book book : bookList) {
            System.out.println("ID: " + book.id_buku + ", Title: " + book.judul + ", Author: " + book.author +
                    ", Stock: " + book.stok);
        }
    }

    public void menuStudent() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nStudent Dashboard");
            System.out.println("1. Tampilkan buku");
            System.out.println("2. Pinjam buku");
            System.out.println("3. List buku yang dipinjam");
            System.out.println("4. Kembali ke menu");
            System.out.print("Pilih opsi (1-4): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayBooks();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    listBorrowedBooks();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("pilihan tidak sesuai");
            }
        }
    }

    public void displayBooks() {
        for (Book book : bookList) {
            System.out.println("ID: " + book.id_buku + ", Title: " + book.judul + ", Author: " + book.author +
                    ", Stock: " + book.stok);
        }
    }

    public void borrowBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan ID buku yang ingin dipinjam: ");
        int bookId = scanner.nextInt();

        Book bookToBorrow = null;
        for (Book book : bookList) {
            if (book.id_buku == bookId) {
                bookToBorrow = book;
                break;
            }
        }

        if (bookToBorrow != null && bookToBorrow.stok > 0) {
            System.out.println("Buku yang telah anda pinjam:" + bookToBorrow.judul);
        } else {
            System.out.println("Buku tidak dapat dipinjam atau ID buku tidak valid");
        }
        borrowed.add(bookToBorrow);
    }

    public void listBorrowedBooks() {
        System.out.println("List buku yang di pinjam:");
        if (bookList.isEmpty()) {
            System.out.println("Tidak ada buku yang dipinjam");
        } else {
            for (Book book : borrowed) {
                System.out.println("Book ID: " + book.id_buku + ", Title: " + book.judul);
            }
        }
    }
}

