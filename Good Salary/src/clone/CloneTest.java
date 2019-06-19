package clone;

/** 作者：王文彬 on 2019-05-17 14：24 邮箱：wwb199055@126.com */
public class CloneTest {

  public static void main(String[] args) throws CloneNotSupportedException {
    /*Info clone = new Info(1, "I am Mp5A5");
    Info clone1 = (Info) clone.clone();


    System.out.println(clone.getClass() == clone1.getClass()); // true

    System.out.println(clone == clone1); // false

    System.out.println(clone.equals(clone1)); // true*/

   /* Info info = new Info(2, "Hello world.");

    MyFile file1 = new MyFile("c:", info);

    MyFile file2 = (MyFile) file1.clone();

    System.out.println(file1.getClass() == file2.getClass()); // true

    System.out.println(file1 == file2); // false

    System.out.println(file1.equals(file2)); // true

    System.out.println(file1.info.getClass() == file2.info.getClass()); // true

    System.out.println(file1.info == file2.info); // true

    System.out.println(file1.info.equals(file2.info)); // true*/


    Info info = new Info(2, "Hello world.");

    MyFile2 file1 = new MyFile2("c:", info);

    MyFile2 file2 = (MyFile2) file1.clone();



    System.out.println(file1.getClass() == file2.getClass());//true

    System.out.println(file1 == file2);//false

    System.out.println(file1.equals(file2));//true

    System.out.println(file1.info.getClass() == file2.info.getClass());//true

    System.out.println(file1.info == file2.info);//false

    System.out.println(file1.info.equals(file2.info));//true
  }
}
