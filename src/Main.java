import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {


    public static void showMenu() {
        System.out.println("🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸");
        System.out.println("🌸　　　　　 　　⁂⁂⁂ MENU QUẢN LÍ DANH BẠ ⁂⁂⁂　  　　 　　　🌸");
        System.out.println("🌸             1. Xem danh sách                           🌸");
        System.out.println("🌸             2. Thêm mới                                🌸");
        System.out.println("🌸             3. Cập nhật                                🌸");
        System.out.println("🌸             4. Xóa                                     🌸");
        System.out.println("🌸             5. Tìm kiếm theo tên                       🌸");
        System.out.println("🌸             6. Tìm kiếm theo số điện thoại             🌸");
        System.out.println("🌸             7. Lưu lại thay đổi                        🌸");
        System.out.println("🌸             0. Thoát chương trình                      🌸");
        System.out.println("🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸♡🌸");
    }

    public static void main(String[] args) throws IOException, ParseException {
        final Scanner SCANNER = new Scanner(System.in);
        DirectoryManage directoryInstance = DirectoryManage.getDirectoryInstance();
        try {
            DirectoryManage.readDirectorFromFile();
        } catch (FileNotFoundException | NumberFormatException ignored) {
            System.err.println("Hệ thống chưa có dữ liệu danh bạ");
        }
        int choice;
        while (true) {
            showMenu();
            choice = CreateObject.createChoiceMenu();
            switch (choice) {
                case 1:
                    directoryInstance.showDirectoryList();
                    break;
                case 2:
                    directoryInstance.add(CreateObject.createDirectory());
                    System.out.println("Đã thêm thành công");
                    break;
                case 3:
                    String phoneNumber = CreateObject.createOldPhoneNumber();
                    directoryInstance.delete(phoneNumber);
                    String name = CreateObject.createName();
                    String directoryGroup = CreateObject.createDirectoryGroup();
                    String gender = CreateObject.createGender();
                    String address = CreateObject.createAddress();
                    String birthday = CreateObject.createBirthday();
                    String email = CreateObject.createEmail();
                    directoryInstance.add(new Directory(name, phoneNumber, directoryGroup, gender, address, birthday, email));
                    System.out.println("Đã cập nhật thành công");
                    break;
                case 4:
                    String phoneNumberDel = CreateObject.createOldPhoneNumber();
                    System.out.println("Bạn có chắc chắc muốn xóa?");
                    System.out.println("1. Xóa");
                    System.out.println("0. Không xóa");
                    int choose1 = -1;
                    while (choose1 != 0) {
                        choose1 = CreateObject.createChoiceMenu();
                        if (choose1 == 1) {
                            directoryInstance.delete(phoneNumberDel);
                            System.out.println("Đã xóa thành công");
                            break;
                        }
                        System.out.println("Chọn 1 hoặc 0");
                    }
                    break;
                case 5:
                    System.out.print("Nhập tên cần tìm: ");
                    String nameFind = SCANNER.nextLine();
                    directoryInstance.getInformationByName(nameFind);
                    break;
                case 6:
                    System.out.print("Nhập số cần tìm: ");
                    String numberFind = SCANNER.nextLine();
                    directoryInstance.getInformationByNumber(numberFind);
                    break;
                case 7:
                    System.out.println("Bạn có chắc chắc muốn lưu lại?");
                    System.out.println("1. Lưu lại");
                    System.out.println("0. Không lưu");
                    int choose = -1;
                    while (choose != 0) {
                        choose = CreateObject.createChoiceMenu();
                        if (choose == 1) {
                            DirectoryManage.writeDirectorToFile();
                            break;
                        }
                        System.out.println("Chọn 1 hoặc 0");
                    }
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
