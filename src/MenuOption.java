public class MenuOption {

    public static DirectoryManage directoryInstance = DirectoryManage.getDirectoryInstance();

    public static void updateOption() {
        String phoneNumber = CreateObject.createOldPhoneNumber();
        directoryInstance.delete(phoneNumber);
        directoryInstance.add(CreateObject.createDirectory());
        System.out.println("Đã cập nhật thành công");
    }


}
