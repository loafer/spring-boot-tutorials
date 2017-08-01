package com.github.loafer.demo.service;

import com.github.loafer.demo.datasource.annotation.TargetDataSource;
import com.github.loafer.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Service
public class UserService {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  public void save(User user){
    jdbcTemplate.update("insert into users(id, name, age)values(?,?,?)", new Object[]{user.getId(), user.getName(), user.getAge()});
  }

  public List<User> findAll(){
    return jdbcTemplate.query("select * from users", new RowMapper<User>() {
      @Override
      public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setName(rs.getString("name"));
        user.setAge(rs.getInt("age"));
        return user;
      }
    });
  }

  public void clean(){
    jdbcTemplate.update("truncate table users ");
  }

  @TargetDataSource("ds1")
  public void save2(User user){
    save(user);
  }

  @TargetDataSource("ds1")
  public List<User> findAll2(){
    return findAll();
  }

  @TargetDataSource("ds1")
  public void clean2(){
    clean();
  }
}
