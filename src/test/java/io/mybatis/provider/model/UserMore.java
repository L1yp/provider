/*
 * Copyright 2020-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.mybatis.provider.model;

import io.mybatis.provider.Entity;
import io.mybatis.provider.Style;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.StringTypeHandler;

import java.util.Date;

/**
 * @Extend.Table 优先级更高，@Entity.Table("user") 不起作用
 */
@Entity.Table(value = "sys_user", remark = "系统用户", style = Style.LOWER_UNDERSCORE, autoResultMap = true)
public class UserMore {
  @Entity.Column(id = true, remark = "主键", updatable = false, insertable = false)
  private Long    id;
  @Entity.Column(value = "name", remark = "帐号", orderBy = "ASC", orderByPriority = 2)
  private String  name;
  @Entity.Column(value = "is_admin", remark = "是否为管理员", updatable = false)
  private boolean admin;
  @Entity.Column(remark = "顺序号", orderBy = "DESC", orderByPriority = 1)
  private Integer seq;
  @Entity.Column(numericScale = "4", remark = "积分（保留4位小数）")
  private Double  points;
  @Entity.Column(selectable = false, remark = "密码")
  private String  password;
  @Entity.Column(jdbcType = JdbcType.TIMESTAMP)
  private Date    whenCreated;
  @Entity.Column(remark = "介绍", typeHandler = StringTypeHandler.class)
  private String  info;
  //不是表字段
  @Entity.Transient
  private String  noExtendColumn;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isAdmin() {
    return admin;
  }

  public void setAdmin(boolean admin) {
    this.admin = admin;
  }

  public Integer getSeq() {
    return seq;
  }

  public void setSeq(Integer seq) {
    this.seq = seq;
  }

  public Double getPoints() {
    return points;
  }

  public void setPoints(Double points) {
    this.points = points;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getWhenCreated() {
    return whenCreated;
  }

  public void setWhenCreated(Date whenCreated) {
    this.whenCreated = whenCreated;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public String getNoExtendColumn() {
    return noExtendColumn;
  }

  public void setNoExtendColumn(String noExtendColumn) {
    this.noExtendColumn = noExtendColumn;
  }
}
