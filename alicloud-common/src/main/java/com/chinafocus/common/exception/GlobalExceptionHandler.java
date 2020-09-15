package com.chinafocus.common.exception;

import com.chinafocus.common.ResultBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.websocket.DecodeException;
import java.util.List;
import java.util.Set;

import static com.chinafocus.common.enums.ErrorCode.PARAMETER_ERROR;
import static com.chinafocus.common.enums.ErrorCode.REQUEST_NOT_FOUND;


@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);



    @ExceptionHandler(value = ServiceException.class)
    public ResultBody handleServiceException(ServiceException se) {
        logger.error("ServiceException:{}", se.getMessage());
        return new ResultBody(se.getErrorCode().code, se.getMessage());
    }


    @ExceptionHandler(value = DecodeException.class)
    public ResultBody handleAuthException(HttpServletResponse response,DecodeException se) {
        logger.error("DecodeException:{}", se.getMessage());
        return new ResultBody(response.getStatus(),se.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResultBody handleException(HttpServletResponse response, Exception e) {
        logger.error("Exception:{}", e);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResultBody(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器错误");
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResultBody handleParamException(MissingServletRequestParameterException se) {
        logger.error("ParameterException:{}", se.getMessage());
        return new ResultBody(PARAMETER_ERROR.code, se.getMessage());
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResultBody handleParamException(HttpRequestMethodNotSupportedException se) {
        logger.error("Method Exception:{}", se.getMessage());
        return new ResultBody(REQUEST_NOT_FOUND.code, "不支持该请求类型");
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResultBody ConstraintViolationException(ConstraintViolationException se) {
        Set<ConstraintViolation<?>> errors = se.getConstraintViolations();
        StringBuffer errorMsg = new StringBuffer();
        errors.stream().forEach(x -> errorMsg.append(x.getMessage()).append(";"));
        logger.error("ValidException:{}", se.getMessage());
        return new ResultBody(PARAMETER_ERROR.code, errorMsg.toString());
    }

    @ExceptionHandler(value = {BindException.class})
    public ResultBody MethodArgumentNotValidException(BindException se) {
        List<ObjectError> errors = se.getAllErrors();
        StringBuffer errorMsg = new StringBuffer();
        errors.stream().forEach(x -> errorMsg.append(x.getDefaultMessage()).append(";"));
        logger.error("ValidException:{}", se.getMessage());
        return new ResultBody(PARAMETER_ERROR.code, errorMsg.toString());
    }

}
