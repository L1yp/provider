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

@Entity.Table(value = "user",
    excludeSuperClasses = Role.class,
    excludeFieldTypes = User1.class,
    excludeFields = "age")
public class UserExclude extends Role {
  @Entity.Column(id = true, useGeneratedKeys = true)
  private Long   id;
  @Entity.Column("name")
  private String username;

  private User1 user1;

  private int age;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setUser1(User1 user1) {
    this.user1 = user1;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
