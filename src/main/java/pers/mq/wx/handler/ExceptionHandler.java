package pers.mq.wx.handler;

import com.alibaba.fastjson.JSON;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.mq.wx.model.RestResult;

/**
 * Created with IntelliJ IDEA.
 * User: mq
 * Date: 2016/12/13
 * Time: 17:19
 * To change this template use File | Settings | File Templates.
 */
public class ExceptionHandler extends SimpleMappingExceptionResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        RestResult restResult = new RestResult();
        restResult.setErrorCode(500);
        restResult.setErrorMessage(ex.toString());
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
        response.setCharacterEncoding("UTF-8"); //避免乱码
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        try {
            response.getWriter().write(JSON.toJSONString(restResult));
        } catch (IOException e) {
            LOGGER.error("与客户端通讯异常", e);
        }
        return modelAndView;
    }
}
