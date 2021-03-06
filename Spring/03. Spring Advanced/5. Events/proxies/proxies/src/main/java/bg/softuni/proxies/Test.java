package bg.softuni.proxies;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        StudentServiceIfc studentServiceIfc = getStudentService();
        System.out.println(studentServiceIfc.getAllStudents());
    }

    private static StudentServiceIfc getStudentService() {
       return (StudentServiceIfc) Proxy.newProxyInstance(
                Test.class.getClassLoader(),
                new Class[]{StudentServiceIfc.class},
                new CacheableInvocationHandler(new StudentService())
       );
    }
}
