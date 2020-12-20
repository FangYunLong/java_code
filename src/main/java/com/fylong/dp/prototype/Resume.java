package com.fylong.dp.prototype;

import java.io.*;

/**
 * 深复制实现原型模式
 * 原型模式避免多次重复构建同一对象
 * Created by Fang on 2019/8/12.
 */
public class Resume implements Serializable{
    private String name;
    private WorkExperience workExperience;

    public Resume(String name){
        this.name = name;
    }

    public void setWorkExperience(String workDate,String company){
        workExperience = new WorkExperience();
        workExperience.setWorkDate(workDate);
        workExperience.setCompany(company);
    }

    public String display(){
        return name + "在" + workExperience.getCompany() + "工作了" +workExperience.getWorkDate();
    }

    public Resume deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        //this-->oos-->bos
        //将对象通过对象输出流写到字节数组输出流中
        oos.writeObject(this);


        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);//
        //bos.toByteArray-->ois--> bis
        //将字节数组输出流中的字节通过对象输入流读到字节输入流
        return (Resume)ois.readObject();
    }



}
