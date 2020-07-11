package com.lhb.jsp.common.exception;


import com.lhb.jsp.common.enums.ExceptioneEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CommonAdviceException extends  RuntimeException{
    private ExceptioneEnum exceptioneEnum;
}
