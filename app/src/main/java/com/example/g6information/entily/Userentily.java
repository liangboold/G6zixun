package com.example.g6information.entily;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @ClassName Userentily
 * @Description TODO
 * @Author 梁波
 * @Date 2021/9/1 13:43
 * @Version 1.0
 */
@Entity
public class Userentily {
    private Long id;
    private String url;
    @Generated(hash = 1852217031)
    public Userentily(Long id, String url) {
        this.id = id;
        this.url = url;
    }
    @Generated(hash = 2115628603)
    public Userentily() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

}
