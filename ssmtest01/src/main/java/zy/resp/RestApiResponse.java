package zy.resp;


import java.io.Serializable;


/**
 * Function:
 * @author crossoverJie
 * Date: 2018/8/25 15:23
 * @since JDK 1.8
 */
public class RestApiResponse<T> implements Serializable {

    private String code;

    private String message;

    private T result;


    private RestApiResponse(String code, String message, T result) {

        this.code = code;
        this.message = message;
        this.result = result;
    }


//    public static <T> HttpBaseResponse<T> success(String message, T t) {
//        return new HttpBaseResponse(StatusEnum.SUCCESS.getCode(),
//                                    StringUtils.isBlank(message) ? StatusEnum.SUCCESS.getMessage() : message,
//                                    t);
//    }
//
//
//    public static <T> HttpBaseResponse<T> createFail(T t, String message) {
//        return new HttpBaseResponse(StatusEnum.FAIL.getCode(),
//                                    StringUtils.isBlank(message) ? StatusEnum.FAIL.getMessage() : message,
//                                    t);
//    }
//
//
//    public static <T> HttpBaseResponse<T> create(T t, StatusEnum statusEnum, String message) {
//        return new HttpBaseResponse(statusEnum.getCode(), message, t);
//    }


    private static RestApiResponse SUCCESS_RESPONSE =
            new RestApiResponse(ResponseCodes.SUCCESS.getCode(), ResponseCodes.SUCCESS.getMessage(), null);


    public static RestApiResponse<String> success() {
        return SUCCESS_RESPONSE;
    }


    public static <K> RestApiResponse<K> failure(String errorCode, String msg) {
        return new RestApiResponse<K>(errorCode, msg, null);
    }
    public static <K> RestApiResponse<K> failure(String errorCode, String msg, K object) {
        return new RestApiResponse<K>(errorCode, msg, object);
    }
    public static <K> RestApiResponse<K> success(String msg, K resultObject) {

        RestApiResponse response = new RestApiResponse<K>(ResponseCodes.SUCCESS.getCode(), msg, resultObject);
        return response;
    }

    public static <K> RestApiResponse<K> success(K resultObject) {
        return new RestApiResponse<K>(ResponseCodes.SUCCESS.getCode(),
                                      ResponseCodes.SUCCESS.getMessage(),
                                      resultObject);
    }

    public static <K> RestApiResponse<K> build(ResponseCode responseCode) {
        return new RestApiResponse<K>(responseCode.getCode(), responseCode.getMessage(), null);
    }
    public static <K> RestApiResponse<K> build(ResponseCode responseCode, Object result) {
        return new RestApiResponse<K>(responseCode.getCode(), responseCode.getMessage(), (K) result);
    }


//    public static <T> BaseResponse<T> create(T t, Exception e) {
//        return e instanceof RouteException ? new BaseResponse(((RouteException) e).getErrorCode(),
//                                                              ((RouteException) e).getErrorMessage(),
//                                                              t) : new BaseResponse(StatusEnum.FAIL.getCode(),
//                                                                                    e.getMessage(),
//                                                                                    t);
//    }


    public RestApiResponse() {
    }

    @Override
    public String toString() {
        return "BaseResponse{code=" + this.code + ", message=\'" + this.message + '\'' + ", messageBody=" + this.result + '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public static RestApiResponse getSuccessResponse() {
        return SUCCESS_RESPONSE;
    }

    public static void setSuccessResponse(RestApiResponse successResponse) {
        SUCCESS_RESPONSE = successResponse;
    }

}