package zy.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * Created by Administrator on 2020/3/14.
 */
@Data
public class Dorm {
    private int id;
    private String dormName;
    private int dormNum;
    private int limit;
}
