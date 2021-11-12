public class Directory {
    public static final String MALE = "Nam";
    public static final String FEMALE = "Nữ";

    public static final String FAMILY = "Gia đình";
    public static final String FRIEND = "Bạn bè";
    public static final String WORK = "Công việc";

    private String name;
    private String phoneNumber;
    private String directoryGroup;
    private String gender;
    private String address;
    private String birthday;
    private String email;

    public Directory() {
    }

    public Directory(String fullName, String phoneNumber, String directoryGroup, String gender, String address, String birthday, String email) {
        this.name = fullName;
        this.phoneNumber = phoneNumber;
        this.directoryGroup = directoryGroup;
        this.gender = gender;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDirectoryGroup() {
        return directoryGroup;
    }

    public void setDirectoryGroup(String directoryGroup) {
        this.directoryGroup = directoryGroup;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-15s %-15s %-10s %-10s %-10s %-15s", name, phoneNumber, directoryGroup, gender, address, birthday, email);
    }
}