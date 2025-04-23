package com.entity.model;

import com.entity.XizhurenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 系主任
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XizhurenModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 系主任工号
     */
    private String xizhurenUuidNumber;


    /**
     * 系主任姓名
     */
    private String xizhurenName;


    /**
     * 系主任手机号
     */
    private String xizhurenPhone;


    /**
     * 系主任身份证号
     */
    private String xizhurenIdNumber;


    /**
     * 系主任头像
     */
    private String xizhurenPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    private String xizhurenEmail;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：系主任工号
	 */
    public String getXizhurenUuidNumber() {
        return xizhurenUuidNumber;
    }


    /**
	 * 设置：系主任工号
	 */
    public void setXizhurenUuidNumber(String xizhurenUuidNumber) {
        this.xizhurenUuidNumber = xizhurenUuidNumber;
    }
    /**
	 * 获取：系主任姓名
	 */
    public String getXizhurenName() {
        return xizhurenName;
    }


    /**
	 * 设置：系主任姓名
	 */
    public void setXizhurenName(String xizhurenName) {
        this.xizhurenName = xizhurenName;
    }
    /**
	 * 获取：系主任手机号
	 */
    public String getXizhurenPhone() {
        return xizhurenPhone;
    }


    /**
	 * 设置：系主任手机号
	 */
    public void setXizhurenPhone(String xizhurenPhone) {
        this.xizhurenPhone = xizhurenPhone;
    }
    /**
	 * 获取：系主任身份证号
	 */
    public String getXizhurenIdNumber() {
        return xizhurenIdNumber;
    }


    /**
	 * 设置：系主任身份证号
	 */
    public void setXizhurenIdNumber(String xizhurenIdNumber) {
        this.xizhurenIdNumber = xizhurenIdNumber;
    }
    /**
	 * 获取：系主任头像
	 */
    public String getXizhurenPhoto() {
        return xizhurenPhoto;
    }


    /**
	 * 设置：系主任头像
	 */
    public void setXizhurenPhoto(String xizhurenPhoto) {
        this.xizhurenPhoto = xizhurenPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getXizhurenEmail() {
        return xizhurenEmail;
    }


    /**
	 * 设置：电子邮箱
	 */
    public void setXizhurenEmail(String xizhurenEmail) {
        this.xizhurenEmail = xizhurenEmail;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
