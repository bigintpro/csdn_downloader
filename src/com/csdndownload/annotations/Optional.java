package com.csdndownload.annotations;

import java.lang.annotation.*;

/**
 * 标记字段可选
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Optional {

}
