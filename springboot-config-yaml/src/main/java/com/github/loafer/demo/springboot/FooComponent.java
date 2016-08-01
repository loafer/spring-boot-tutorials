package com.github.loafer.demo.springboot;

import java.util.List;

/**
 * @author zhaojh.
 */
public class FooComponent {
  private Integer primitive;
  private List<String> servers;

  public Integer getPrimitive() {
    return primitive;
  }

  public List<String> getServers() {
    return servers;
  }

  public void setPrimitive(Integer primitive) {
    this.primitive = primitive;
  }

  public void setServers(List<String> servers) {
    this.servers = servers;
  }

  @Override
  public String toString() {
    return "{" +
           "primitive=" + primitive +
           ", servers=" + servers +
           '}';
  }
}
