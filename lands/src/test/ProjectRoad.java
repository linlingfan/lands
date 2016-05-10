package test;

/**
 * Created by lenovo on 2016/4/24.
 */
public class ProjectRoad {
    public static void main(String[] args) {
        String path=ClassLoader.getSystemResource("").toString();
        System.out.println(path);
//        String realpath=path.substring(0,path.lastIndexOf("/build/classes"));
//        System.out.println(realpath);

    }
}
