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
import io.mybatis.provider.EntityColumn;
import io.mybatis.provider.EntityTable;
import io.mybatis.provider.keysql.GenId;

@Entity.Table(value = "user")
public class User3 {
  @Entity.Column(id = true, genId = GenIdLong.class)
  private Long   id;
  @Entity.Column("name")
  private String username;

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

  public static class GenIdLong implements GenId<Long> {
    @Override
    public Long genId(EntityTable table, EntityColumn column) {
      return System.currentTimeMillis() & 0xffff;
    }
  }
}
