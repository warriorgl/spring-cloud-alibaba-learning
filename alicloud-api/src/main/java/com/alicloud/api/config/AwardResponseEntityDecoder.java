package com.alicloud.api.config;

import com.alibaba.fastjson.JSON;
import com.chinafocus.common.ResultBody;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import feign.FeignException;
import feign.Response;
import feign.Util;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import java.io.IOException;
import java.lang.reflect.Type;


@Slf4j
public class AwardResponseEntityDecoder extends ResponseEntityDecoder {

    public AwardResponseEntityDecoder(Decoder decoder) {
        super(decoder);
    }

    @Override
    public Object decode(Response response, Type type) throws IOException,FeignException {
        if (response.body() == null) {
            throw new DecodeException(response.status(), "没有返回有效的数据", response.request());
        }
        String bodyStr = Util.toString(response.body().asReader(Util.UTF_8));
        //对结果进行转换
        ResultBody resultBody=JSON.parseObject(bodyStr,ResultBody.class);
        //此处如果不是正常的200状态，则抛出异常，异常就会进入熔断，走熔断策略
        if (resultBody.getCode() != 200) {
            throw new DecodeException(resultBody.code, resultBody.message, response.request());
        }
        return jsonToobj(bodyStr,type);
    }


    /**
     * 反序列化
     * @param jsonStr
     * @param targetType
     * @param <T>
     * @return
     */
    public static <T> T jsonToobj(String jsonStr, Type targetType) {
        try {
            JavaType javaType = TypeFactory.defaultInstance().constructType(targetType);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(jsonStr, javaType);
        } catch (IOException e) {
            throw new IllegalArgumentException("Feign JSON转换为对象异常:" + jsonStr, e);
        }
    }
}
