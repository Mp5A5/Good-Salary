package recover;

import org.junit.jupiter.api.Test;

import java.io.*;

/** 作者：王文彬 on 2019-05-10 15：10 邮箱：wwb199055@126.com */
public class Java_08_03_Serializable {

  @Test
  public void main() {

    //writeToFile();
    readFormFile();

  }

  private void readFormFile() {
    // Read Obj from File
    File file = new File("tempFile");
    try {
      FileInputStream fileInputStream = new FileInputStream(file);
      ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
      Person newUser = (Person) objectInputStream.readObject();
      System.out.println(newUser);
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  private void writeToFile() {
    Person user = new Person();
    user.setName("mp5a5");
    user.setId(28);
    System.out.println(user);

    // Write Obj to File
    try {
      FileOutputStream fileOutputStream = new FileOutputStream("tempFile");
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
      objectOutputStream.writeObject(user);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
