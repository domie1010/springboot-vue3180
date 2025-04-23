package com.entity.vo;

import com.entity.XizhurenEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 系主任
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xizhuren")
public class XizhurenVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 系主任工号
     */

    @TableField(value = "xizhuren_uuid_number")
    private String xizhurenUuidNumber;


    /**
     * 系主任姓名
     */

    @TableField(value = "xizhuren_name")
    private String xizhurenName;


    /**
     * 系主任手机号
     */

    @TableField(value = "xizhuren_phone")
    private String xizhurenPhone;


    /**
     * 系主任身份证号
     */

    @TableField(value = "xizhuren_id_number")
    private String xizhurenIdNumber;


    /**
     * 系主任头像
     */

    @TableField(value = "xizhuren_photo")
    private String xizhurenPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 电子邮箱
     */

    @TableField(value = "xizhuren_email")
    private String xizhurenEmail;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：系主任工号
	 */
    public String getXizhurenUuidNumber() {
        return xizhurenUuidNumber;
    }


    /**
	 * 获取：系主任工号
	 */

    public void setXizhurenUuidNumber(String xizhurenUuidNumber) {
        this.xizhurenUuidNumber = xizhurenUuidNumber;
    }
    /**
	 * 设置：系主任姓名
	 */
    public String getXizhurenName() {
        return xizhurenName;
    }


    /**
	 * 获取：系主任姓名
	 */

    public void setXizhurenName(String xizhurenName) {
        this.xizhurenName = xizhurenName;
    }
    /**
	 * 设置：系主任手机号
	 */
    public String getXizhurenPhone() {
        return xizhurenPhone;
    }


    /**
	 * 获取：系主任手机号
	 */

    public void setXizhurenPhone(String xizhurenPhone) {
        this.xizhurenPhone = xizhurenPhone;
    }
    /**
	 * 设置：系主任身份证号
	 */
    public String getXizhurenIdNumber() {
        return xizhurenIdNumber;
    }


    /**
	 * 获取：系主任身份证号
	 */

    public void setXizhurenIdNumber(String xizhurenIdNumber) {
        this.xizhurenIdNumber = xizhurenIdNumber;
    }
    /**
	 * 设置：系主任头像
	 */
    public String getXizhurenPhoto() {
        return xizhurenPhoto;
    }


    /**
	 * 获取：系主任头像
	 */

    public void setXizhurenPhoto(String xizhurenPhoto) {
        this.xizhurenPhoto = xizhurenPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getXizhurenEmail() {
        return xizhurenEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setXizhurenEmail(String xizhurenEmail) {
        this.xizhurenEmail = xizhurenEmail;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
