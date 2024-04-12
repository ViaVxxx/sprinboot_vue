package com.via.common;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Result {

    private static final String SUCCESS = "0";
    private static final String ERROR = "1";

    private String code; // code是状态码，表示调用是否成功。0表示成功，1表示失败
    private static String message; // message是返回的信息，表示调用的结果
    private Object data; // data是返回的数据，表示调用的结果数据

    public static Result success(){
        Result result = new Result();
        result.setCode(SUCCESS);
        return result;
    }

    // 重载success方法，返回数据
    public static Result success(Object data){
        Result result = new Result();
        result.setCode(SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result error(){
        Result result = new Result();
        result.setCode(ERROR);
        result.setMessage(message);
        return result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        Result.message = message;
    }

}
