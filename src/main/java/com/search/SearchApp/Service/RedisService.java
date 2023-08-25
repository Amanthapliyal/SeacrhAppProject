package com.search.SearchApp.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.search.SearchApp.Adapter.Response.ImageResponse;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RedisService {

    private final StringRedisTemplate redisTemplate;
    private final ObjectMapper objectMapper;

    public RedisService(StringRedisTemplate redisTemplate,ObjectMapper objectMapper) {
        this.redisTemplate = redisTemplate;
        this.objectMapper=objectMapper;
    }

    public void setValue(String key, ImageResponse imageResponse) throws JsonProcessingException {
        String imageResponseString = objectMapper.writeValueAsString(imageResponse);
        redisTemplate.opsForValue().set(key,imageResponseString);
    }

    public ImageResponse getValue(String key) throws IOException {
        var result = redisTemplate.opsForValue().get(key);
        if(result!=null){
            return objectMapper.readValue(result,ImageResponse.class);
        }
        return null;
    }
    public boolean isValuePresent(String key) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String value = valueOperations.get(key);
        return value != null;
    }
}