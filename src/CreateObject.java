import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateObject {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static int createChoiceMenu() {
        int choice = -1;
        try {
            choice = SCANNER.nextInt();
        } catch (InputMismatchException exception) {
            System.err.println("Nhập số nguyên!");
        } finally {
            SCANNER.nextLine();
        }
        return choice;
    }

    public static String createName() {
        System.out.print("Nhập tên: ");
        String fullName = SCANNER.nextLine();
        int indexOfChar = fullName.indexOf(',');
        while (!Validation.validateString(fullName, Validation.FULL_NAME) || indexOfChar != -1) {
            System.err.println("Họ và tên chưa hợp lệ. Vui lòng nhập lại.");
            fullName = SCANNER.nextLine();
            indexOfChar = fullName.indexOf(',');
        }
        return fullName;
    }

    public static String createBirthday() {
        System.out.print("Nhập ngày sinh: ");
        String date = SCANNER.nextLine();
        while (!Validation.validateString(date, Validation.DATE_REGEX)) {
            System.out.println("Ngày không hợp lệ. Vui lòng nhập lại.");
            date = SCANNER.nextLine();
        }
        return date;
    }

    public static String createNewPhoneNumber() {
        System.out.print("Nhập số điện thoại: ");
        String phoneNumber = SCANNER.nextLine();
        boolean isValid = Validation.validateString(phoneNumber, Validation.PHONE_NUMBER_REGEX);
        boolean isExist = (DirectoryManage.getDirectoryInstance().findIndexByNumber(phoneNumber) != -1);
        while (isExist || !isValid) {
            System.err.println("Số điện thoại đã tồn tại hoặc chưa hợp lệ. Vui lòng nhập lại.");
            phoneNumber = SCANNER.nextLine();
            isValid = Validation.validateString(phoneNumber, Validation.PHONE_NUMBER_REGEX);
            isExist = (DirectoryManage.getDirectoryInstance().findIndexByNumber(phoneNumber) != -1);
        }
        return phoneNumber;
    }

    public static String createOldPhoneNumber() {
        System.out.print("Nhập số điện thoại: ");
        String phoneNumber = SCANNER.nextLine();
        boolean isValid = Validation.validateString(phoneNumber, Validation.PHONE_NUMBER_REGEX);
        boolean isExist = (DirectoryManage.getDirectoryInstance().findIndexByNumber(phoneNumber) != -1);
        while (!isExist || !isValid) {
            System.err.println("Số điện thoại không tồn tại hoặc chưa hợp lệ. Vui lòng nhập lại.");
            phoneNumber = SCANNER.nextLine();
            isValid = Validation.validateString(phoneNumber, Validation.PHONE_NUMBER_REGEX);
            isExist = (DirectoryManage.getDirectoryInstance().findIndexByNumber(phoneNumber) != -1);
        }
        return phoneNumber;
    }

    public static String createEmail() {
        System.out.print("Nhập địa chỉ email: ");
        String email = SCANNER.nextLine();
        while (!Validation.validateString(email, Validation.EMAIL_REGEX)) {
            System.err.println("Địa chỉ email chưa hợp lệ. Vui lòng nhập lại.");
            email = SCANNER.nextLine();
        }
        return email;
    }

    public static String createAddress() {
        System.out.print("Nhập địa chỉ: ");
        return SCANNER.nextLine();
    }

    public static String createGender() {
        System.out.println("Mời lựa chọn");
        System.out.println("1. Nữ");
        System.out.println("2. Nam");
        int choice = -1;
        while (choice != 0) {
            choice = createChoiceMenu();
            switch (choice) {
                case 1:
                    return Directory.FEMALE;
                case 2:
                    return Directory.MALE;
            }
        }
        return null;
    }

    public static String createDirectoryGroup() {
        System.out.println("Mời lựa chọn");
        System.out.println("1. Gia đình");
        System.out.println("2. Bạn bè");
        System.out.println("3. Công việc");
        int choice = -1;
        while (choice != 0) {
            choice = createChoiceMenu();
            switch (choice) {
                case 1:
                    return Directory.FAMILY;
                case 2:
                    return Directory.FRIEND;
                case 3:
                    return Directory.WORK;
            }
        }
        return null;
    }

    public static Directory createDirectory() {
        String name = createName();
        String phoneNumber = createNewPhoneNumber();
        String directoryGroup = createDirectoryGroup();
        String gender = createGender();
        String address = createAddress();
        String birthday = createBirthday();
        String email = createEmail();
        return new Directory(name, phoneNumber, directoryGroup, gender, address, birthday, email);
    }
}
