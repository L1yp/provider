/*
 * Copyright 2020 the original author or authors.
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

package io.mybatis.provider;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.UnknownTypeHandler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表对应的实体
 *
 * @author liuzh
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Entity {
  /**
   * 对应实体类
   */
  Class<?> value();

  /**
   * 表名
   */
  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.TYPE)
  @interface Table {
    /**
     * 表名，默认空时使用对象名（不进行任何转换）
     */
    String value() default "";

    /**
     * 备注，仅用于在注解上展示，不用于任何其他处理
     */
    String remark() default "";

    /**
     * 使用指定的 <resultMap>
     */
    String resultMap() default "";

    /**
     * 自动根据字段生成 <resultMap>
     */
    boolean autoResultMap() default false;

    /**
     * 属性配置
     */
    Prop[] props() default {};
  }

  /**
   * 属性配置
   */
  @interface Prop {
    /**
     * 属性名
     */
    String name();

    /**
     * 属性值
     */
    String value();

    /**
     * 属性值类型，支持 String, Integer, Long, Boolean, Double, Float 六种类型
     */
    Class type() default String.class;
  }

  /**
   * 列名
   */
  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.FIELD)
  @interface Column {
    /**
     * 列名，默认空时使用字段名（不进行任何转换）
     */
    String value() default "";

    /**
     * 备注，仅用于在注解上展示，不用于任何其他处理
     */
    String remark() default "";

    /**
     * 标记字段是否为主键字段
     */
    boolean id() default false;

    /**
     * 排序方式，默认空时不作为排序字段，只有手动设置 ASC 和 DESC 才有效
     */
    String orderBy() default "";

    /**
     * 可查询
     */
    boolean selectable() default true;

    /**
     * 可插入
     */
    boolean insertable() default true;

    /**
     * 可更新
     */
    boolean updatable() default true;

    /**
     * 数据库类型 {, jdbcType=VARCHAR}
     */
    JdbcType jdbcType() default JdbcType.UNDEFINED;

    /**
     * 类型处理器 {, typeHandler=XXTypeHandler}
     */
    Class<? extends TypeHandler> typeHandler() default UnknownTypeHandler.class;

    /**
     * 小数位数 {, numericScale=2}
     */
    String numericScale() default "";

    /**
     * 属性配置
     */
    Prop[] props() default {};
  }
}
