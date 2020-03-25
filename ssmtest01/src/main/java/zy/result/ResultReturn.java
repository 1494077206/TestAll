package zy.result;

import lombok.Data;

/**
 * Created by Administrator on 2020/3/20.
 */
@Data
public class ResultReturn {
    private boolean flag;
    private String msg;
    private Object data;

    public ResultReturn() {
    }

    public ResultReturn(boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public ResultReturn(boolean flag, String msg, Object data) {

        this.flag = flag;
        this.msg = msg;
        this.data = data;
    }
}
