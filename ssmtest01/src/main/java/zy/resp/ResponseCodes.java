package zy.resp;

/**
 * Function:
 *
 * @author crossoverJie
 * Date: 2018/8/25 15:25
 * @since JDK 1.8
 */
//RICH: TODO code 和core的一致。

public interface ResponseCodes {
    ResponseCode SUCCESS = new ResponseCode("001_0000_0000", "成功");
    ResponseCode NODATA = new ResponseCode("001_0000_0001", "没有数据");
}
