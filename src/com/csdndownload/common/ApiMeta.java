package com.csdndownload.common;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ApiMeta {

    /**
     * 名称
     * @return
     */
    public String value() default "";


}
