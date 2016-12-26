package bean;

/**
 * Created by Sunyubo on 2016/11/14.
 */
public class Student {
    public String name;
    public String path;

    public Student(String name, String path) {
        this.name = name;
        this.path = path;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", path='" + path
                ;
    }
}
