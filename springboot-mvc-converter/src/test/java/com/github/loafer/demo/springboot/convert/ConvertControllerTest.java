package com.github.loafer.demo.springboot.convert;

import com.github.loafer.demo.springboot.WebApplication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author zhaojh.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebApplication.class)
@WebAppConfiguration
public class ConvertControllerTest {
  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext context;

  @Before
  public void setup(){
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  public void primitive() throws Exception {
    mockMvc.perform(get("/convert/primitive").param("value", "3"))
        .andExpect(MockMvcResultMatchers.content().string("Converted primitive 3"))
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void date() throws Exception {
    mockMvc.perform(get("/convert/date/2016-07-25"))
//        .andExpect(MockMvcResultMatchers.content().string("Converted date Mon Jul 25 08:00:00 CST 2016"))
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void date2() throws Exception {
    mockMvc.perform(get("/convert/date").param("value","2016-07-26 17:22:12"))
//        .andExpect(MockMvcResultMatchers.content().string("Converted date Mon Jul 25 08:00:00 CST 2016"))
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void collection() throws Exception {
    mockMvc.perform(get("/convert/collection?values=1&values=2&values=3&values=4"))
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void collection2() throws Exception {
    mockMvc.perform(get("/convert/collection?values=1,2,3,4"))
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void dateCollection() throws Exception {
    mockMvc.perform(get("/convert/dateCollection?values=2016-07-24,2016-07-25"))
        .andExpect(MockMvcResultMatchers.content().string("Converted date collection [Sun Jul 24 08:00:00 CST 2016, Mon Jul 25 08:00:00 CST 2016]"))
        .andDo(MockMvcResultHandlers.print());
  }
}
