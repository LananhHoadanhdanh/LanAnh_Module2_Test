import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

public class DirectoryManage {
    private static ArrayList<Directory> directoryList;

    private DirectoryManage() {
        directoryList = new ArrayList<>();
    }

    private static DirectoryManage directoryInstance;
    public static DirectoryManage getDirectoryInstance() {
        if (directoryInstance == null) directoryInstance = new DirectoryManage();
        return directoryInstance;
    }

    public ArrayList<Directory> getDirectoryList() {
        return directoryList;
    }

    public void setDirectoryList(ArrayList<Directory> directoryList) {
        DirectoryManage.directoryList = directoryList;
    }

    public int findIndexByNumber(String number) {
        for (int i = 0; i < directoryList.size(); i++) {
            if (directoryList.get(i).getName().equals(number)) {
                return i;
            }
        } return -1;
    }

    public void add(Directory directory) {
        directoryList.add(directory);
    }

    public void delete(String number) {
        directoryList.remove(findIndexByNumber(number));
    }

    public void displayDirectoryList() {
        System.out.println();
        System.out.println("_________________________________*** DANH DÁCH TOÀN BỘ DANH BẠ ***_________________________________");
        System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-15s %n", "Tên", "Số điện thoại", "Nhóm danh bạ", "Giới tính", "Địa chỉ", "Ngày sinh", "Email");
        for (Directory directory : directoryList) {
            System.out.println(directory);
        }
        System.out.println("___________________________________________________________________________________________________");
        System.out.println();
    }

    public void getInformationByName(String name) {
        System.out.println();
        System.out.println("___________________________________*** DANH DÁCH TÊN PHÙ HỢP ***___________________________________");
        System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-15s %n", "Tên", "Số điện thoại", "Nhóm danh bạ", "Giới tính", "Địa chỉ", "Ngày sinh", "Email");
        for (Directory directory : directoryList) {
            if (directory.getName().matches(name+".*")) {
                System.out.println(directory);
            }
        }
        System.out.println("___________________________________________________________________________________________________");
        System.out.println();
    }

    public void getInformationByNumber(String number) {
        System.out.println();
        System.out.println("___________________________________*** DANH DÁCH TÊN PHÙ HỢP ***___________________________________");
        System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-15s %n", "Tên", "Số điện thoại", "Nhóm danh bạ", "Giới tính", "Địa chỉ", "Ngày sinh", "Email");
        for (Directory directory : directoryList) {
            if (directory.getPhoneNumber().matches(number+".*")) {
                System.out.println(directory);
            }
        }
        System.out.println("___________________________________________________________________________________________________");
        System.out.println();
    }

    public static void writeDirectorToFile() throws IOException, ParseException {
        FileWriter fileWriter = new FileWriter("src/DirectorManageFile.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        StringBuilder str = new StringBuilder("Tên,Số điện thoại,Nhóm danh bạ,Giới tính,Địa chỉ,Ngày sinh,Email");
        for (Directory receipt : directoryList) {
            str.append("\n");
            str.append(receipt.getName()).append(",");
            str.append(receipt.getPhoneNumber()).append(",");
            str.append(receipt.getDirectoryGroup()).append(",");
            str.append(receipt.getGender()).append(",");
            str.append(receipt.getAddress()).append(",");
            str.append(receipt.getBirthday()).append(",");
            str.append(receipt.getEmail());
        }
        bufferedWriter.write(str.toString());
        bufferedWriter.close();
    }

    public static void readDirectorFromFile() throws IOException {
        directoryList = new ArrayList<>();
        FileReader fileReader = new FileReader("src/DirectorManageFile.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String content = bufferedReader.readLine();
        while ((content = bufferedReader.readLine()) != null) {
            String[] array = content.split(",");
            String name = array[0];
            String phoneNumber = array[1];
            String directoryGroup = array[2];
            String gender = array[3];
            String address = array[4];
            String birthday = array[5];
            String email = array[5];
            directoryList.add(new Directory(name, phoneNumber, directoryGroup, gender, address, birthday, email));
        }
        bufferedReader.close();
        fileReader.close();
    }
}
