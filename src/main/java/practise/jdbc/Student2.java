package practise.jdbc;

public class Student2 {
    private int stuNum;
    private String stuName;
    private int stuScore;
    private String address;
    private String data;

    public Student2() {
    }

    public Student2(String stuName, int stuScore, String address, String data) {
        this.stuName = stuName;
        this.stuScore = stuScore;
        this.address = address;
        this.data = data;
    }

    public int getStuNum() {
        return stuNum;
    }

    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuScore() {
        return stuScore;
    }

    public void setStuScore(int stuScore) {
        this.stuScore = stuScore;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "stuNum=" + stuNum +
                ", stuName='" + stuName + '\'' +
                ", stuScore=" + stuScore +
                ", address='" + address + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
