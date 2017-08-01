package com.github.loafer.demo;

import com.github.loafer.demo.datasource.DataSourceContext;
import com.github.loafer.demo.entity.User;
import com.github.loafer.demo.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zhaojh.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
  private static final Logger logger = LoggerFactory.getLogger(ApplicationTests.class);

  @Autowired
  private UserService userService;

  @Before
  public void setup(){
    userService.clean();
    userService.clean2();
  }

  @Test
  public void contextLoads() {

  }

  @Test
  public void userServiceTest(){
    userService.save(new User(1L, "aaa", 20));
    logger.info("{}", userService.findAll());
  }

  @Test
  public void changeDatasourceTest(){
    userService.save(new User(1L, "aaa", 20));

    DataSourceContext.setDatasourceName("ds1");
    userService.save(new User(2L, "bbb", 26));
    DataSourceContext.clean();

    Assert.assertEquals(1, userService.findAll().size());

    DataSourceContext.setDatasourceName("ds1");
    Assert.assertEquals(1, userService.findAll().size());
    DataSourceContext.clean();
  }

  @Test
  public void datasourceAspectTest(){
    userService.save(new User(1L, "aaa", 20));
    userService.save2(new User(2L, "bbb", 26));

    Assert.assertEquals(1, userService.findAll().size());
    Assert.assertEquals(1, userService.findAll2().size());
  }
}
