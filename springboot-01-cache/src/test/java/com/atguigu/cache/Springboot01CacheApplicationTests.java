package com.atguigu.cache;

import com.atguigu.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 进行单元测试
 * */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01CacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;  //操作k-v都是字符串的

    @Autowired
    RedisTemplate redisTemplate;  //k-v都是对象的

    //自动注入自己编写的序列化器
    @Autowired
    RedisTemplate<Object, com.atguigu.cache.Employee> empRedisTemplate;

    /**
     * Redis常见的五大数据类型
     *  String（字符串）、List（列表）、Set（集合）、Hash（散列）、ZSet（有序集合）
     *  stringRedisTemplate.opsForValue()[String（字符串）]
     *  stringRedisTemplate.opsForList()[List（列表）]
     *  stringRedisTemplate.opsForSet()[Set（集合）]
     *  stringRedisTemplate.opsForHash()[Hash（散列）]
     *  stringRedisTemplate.opsForZSet()[ZSet（有序集合）]
     */
    @Test
    public void test01(){
        //前提是已经自动注入了StringRedisTemplate
        //给redis中保存数据，操作String字符串
//        stringRedisTemplate.opsForValue().append("msg","helloWorld");

        //读取redis中的数据
//		String msg = stringRedisTemplate.opsForValue().get("msg");
//		System.out.println(msg);

        //操作redis中的列表
//		stringRedisTemplate.opsForList().leftPush("mylist","1");
//		stringRedisTemplate.opsForList().leftPush("mylist","2");
    }

    //测试保存对象
    @Test
    public void test02(){
        com.atguigu.cache.Employee empById = employeeMapper.getEmpById(2);
        /**
         * 如果保存对象，默认使用jdk序列化机制，序列化后的数据保存到redis中
         * 使用默认的序列化器，需要绕过Employee.class继承序列化，
         * 即public class Employee implements Serializable {
         * 查看数据会按照序列化器的格式显示，不方便阅读
         * */
        //redisTemplate.opsForValue().set("emp-01",empById);

        /**
         * 可以自己编写序列化器，将数据以json的方式保存
         * (1)自己将对象转为json
         * (2)redisTemplate默认的序列化规则；改变默认的序列化规则；
         * 在com.atguigu.cache.config.MyRedisConfig.class中编写序列化器empRedisTemplate
         * 自动注入后即可使用
         * */
        empRedisTemplate.opsForValue().set("emp-01",empById);
    }


    /**
     * 测试是否连接成功
     * */
    @Test
    public void contextLoads() {
        System.out.println("测试连接成功");
        com.atguigu.cache.Employee empByID=employeeMapper.getEmpById(1);
        System.out.println(empByID);
    }

}
