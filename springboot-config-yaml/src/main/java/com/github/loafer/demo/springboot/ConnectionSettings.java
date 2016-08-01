package com.github.loafer.demo.springboot;



import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
@ConfigurationProperties(prefix = "connection")
public class ConnectionSettings {
  private String username;

  @NotNull
  //通过注释掉application.yml中的remoteAddress属性来验证@NotNull注解是否生效
  private String remoteAddress;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getRemoteAddress() {
    return remoteAddress;
  }

  public void setRemoteAddress(String remoteAddress) {
    this.remoteAddress = remoteAddress;
  }

  @Override
  public String toString() {
    return "{" +
           "username='" + username + '\'' +
           ", remoteAddress='" + remoteAddress + '\'' +
           '}';
  }
}
