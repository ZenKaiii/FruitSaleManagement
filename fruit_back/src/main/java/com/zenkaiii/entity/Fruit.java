package com.zenkaiii.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2021-06-18
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Fruit implements Serializable {

    private static final long serialVersionUID=1L;

      private Integer id;

    private String name;

    private Integer sale;

    private String icon;


}
