package com.mp5a5.www.salary;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author ：mp5a5 on 2019-05-10 17：20
 * @describe
 * @email：wwb199055@126.com
 */
public class User implements Parcelable {

    public int id;
    public String name;
    public User friend;

    public User() {
    }

    public User(int id, String name, User friend) {
        this.id = id;
        this.name = name;
        this.friend = friend;
    }

    protected User(Parcel source) {
        name = source.readString();
        id = source.readInt();
        friend = source.readParcelable(Thread.currentThread().getContextClassLoader());
    }

    /**
     * 当前对象的内容描述,一般返回0即可
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * 将当前对象写入序列化结构中
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeParcelable(this.friend, flags);
    }

    /**
     * public static final一个都不能少，内部对象CREATOR的名称也不能改变，必须全部大写。
     * 重写接口中的两个方法：
     * createFromParcel(Parcel in) 实现从Parcel容器中读取传递数据值,封装成Parcelable对象返回逻辑层，
     * newArray(int size) 创建一个类型为T，长度为size的数组，供外部类反序列化本类数组使用。
     */

    public static final Parcelable.Creator<User> CREATOR = new Creator<User>() {

        /**
         * 从序列化后的对象中创建原始对象
         */
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        /**
         * 创建指定长度的原始对象数组
         */
        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };


}
