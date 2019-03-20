package com.lhy.mybatis1.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScheduleTest {

//    Seconds : 可出现", - * /"四个字符，有效范围为0-59的整数
//    Minutes : 可出现", - * /"四个字符，有效范围为0-59的整数
//    Hours : 可出现", - * /"四个字符，有效范围为0-23的整数
//    DayofMonth : 可出现", - * / ? L W C"八个字符，有效范围为0-31的整数
//    Month : 可出现", - * /"四个字符，有效范围为1-12的整数或JAN-DEc
//    DayofWeek : 可出现", - * / ? L C #"四个字符，有效范围为1-7的整数或SUN-SAT两个范围。1表示星期天，2表示星期一， 依次类推
//    Year : 可出现", - * /"四个字符，有效范围为1970-2099年

//    @Scheduled(initialDelay = 1000*4,fixedDelay = 1000*2)
//   public void  scheduleTest(){
//        log.info(String.valueOf(System.currentTimeMillis()));
//    }
}
