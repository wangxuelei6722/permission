package com.wangxl.exception;

import com.wangxl.common.JsonData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
public class SpringExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        String url = request.getRequestURL().toString();
        ModelAndView mv;
        String defualtMsg = "System error";
        /**json请求使用.json结尾，页面请求使用.page结尾。
         * 根据后缀来判断时json请求还是页面请求
         * */
        if (url.endsWith(".json")) {
            /*json请求*/
            if (e instanceof PermissionException){
                JsonData result = JsonData.fail(e.getMessage());
                mv = new ModelAndView("jsonView",result.toMap());
            }else {
                log.info("unknow json exception ,url= "+url,e);
                JsonData result = JsonData.fail(defualtMsg);
                mv = new ModelAndView("jsonView",result.toMap());
            }
        } else if (url.endsWith(".page")){
            /*页面请求*/
            log.info("unknow page exception ,url= "+url,e);
            JsonData result = JsonData.fail(defualtMsg);
            mv = new ModelAndView("exception",result.toMap());
        }else {
            /*其他请求，例如.css、.js等等*/
            log.info("unknow exception ,url= "+url,e);
            JsonData result = JsonData.fail(defualtMsg);
            mv = new ModelAndView("jsonView",result.toMap());
        }
        return mv;
    }
}
