package org.newinit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/key")
public class KeyController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/ser/{key}/{value}")
  public String sert(@PathVariable String key,@PathVariable String value){
       redisTemplate.opsForSet().add(key,value);
                return "success";
    }


    @RequestMapping(value = "/get/{key}")
    public Object gert(@PathVariable String key){
        return redisTemplate.opsForValue().get(key);
    }
}
