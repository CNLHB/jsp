package com.lhb.jsp.common.result;


import com.lhb.jsp.common.enums.SucessEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SucessHandler {
    public Integer code;
    public Integer status;
    public String message;
    public SucessHandler(SucessEnum en){
        this.code = en.getCode();
        this.status = en.getStatus();
        this.message = en.getMsg();
    }

}
