package zy.entity;

import lombok.Data;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.Alias;

/**
 * Created by Administrator on 2020/3/14.
 */
@Data
public class Student {
    private int id;
    private String name;
    private String pwd;
    private int did;//外键

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }
}
