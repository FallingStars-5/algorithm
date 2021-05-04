package cn.itcast.algorithm.sort;

//定义一个学生类Student，具有年龄age和姓名username两个属性，并通过Comparable接口提供比较规则

/**
 * @author 落星
 */
public class Student implements Comparable<Student> {
    private String username;
    private int age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    /**
     * 实现Comparable接口的CompareTo方法，返回当前Student对象和要比较对象的Age属性差值，通过返回值大于0，小于0或等于0来确定两个待比较对象的大小关系
     * @param o
     * @return
     */
    @Override
    public int compareTo(Student o) {
        return this.getAge()-o.getAge();
    }

    /**
     * 重写toString方法，用于测试时打印输出
     * @return
     */
    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
