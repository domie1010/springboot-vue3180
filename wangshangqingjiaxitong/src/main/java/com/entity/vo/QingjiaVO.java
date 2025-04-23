package com.entity.vo;

import com.entity.QingjiaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 请假
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("qingjia")
public class QingjiaVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 学生
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 请假编号
     */

    @TableField(value = "qingjia_uuid_number")
    private String qingjiaUuidNumber;


    /**
     * 请假标题
     */

    @TableField(value = "qingjia_name")
    private String qingjiaName;


    /**
     * 请假类型
     */

    @TableField(value = "qingjia_types")
    private Integer qingjiaTypes;


    /**
     * 请假开始日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "qingjiakaishi_time")
    private Date qingjiakaishiTime;


    /**
     * 请假天数
     */

    @TableField(value = "qingjia_number")
    private Integer qingjiaNumber;


    /**
     * 请假结束日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "qingjiajieshu_time")
    private Date qingjiajieshuTime;


    /**
     * 请假内容
     */

    @TableField(value = "qingjia_content")
    private String qingjiaContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 请假审核状态
     */

    @TableField(value = "qingjia_yesno_types")
    private Integer qingjiaYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "qingjia_yesno_text")
    private String qingjiaYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "qingjia_shenhe_time")
    private Date qingjiaShenheTime;


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
	 * 设置：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：学生
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：请假编号
	 */
    public String getQingjiaUuidNumber() {
        return qingjiaUuidNumber;
    }


    /**
	 * 获取：请假编号
	 */

    public void setQingjiaUuidNumber(String qingjiaUuidNumber) {
        this.qingjiaUuidNumber = qingjiaUuidNumber;
    }
    /**
	 * 设置：请假标题
	 */
    public String getQingjiaName() {
        return qingjiaName;
    }


    /**
	 * 获取：请假标题
	 */

    public void setQingjiaName(String qingjiaName) {
        this.qingjiaName = qingjiaName;
    }
    /**
	 * 设置：请假类型
	 */
    public Integer getQingjiaTypes() {
        return qingjiaTypes;
    }


    /**
	 * 获取：请假类型
	 */

    public void setQingjiaTypes(Integer qingjiaTypes) {
        this.qingjiaTypes = qingjiaTypes;
    }
    /**
	 * 设置：请假开始日期
	 */
    public Date getQingjiakaishiTime() {
        return qingjiakaishiTime;
    }


    /**
	 * 获取：请假开始日期
	 */

    public void setQingjiakaishiTime(Date qingjiakaishiTime) {
        this.qingjiakaishiTime = qingjiakaishiTime;
    }
    /**
	 * 设置：请假天数
	 */
    public Integer getQingjiaNumber() {
        return qingjiaNumber;
    }


    /**
	 * 获取：请假天数
	 */

    public void setQingjiaNumber(Integer qingjiaNumber) {
        this.qingjiaNumber = qingjiaNumber;
    }
    /**
	 * 设置：请假结束日期
	 */
    public Date getQingjiajieshuTime() {
        return qingjiajieshuTime;
    }


    /**
	 * 获取：请假结束日期
	 */

    public void setQingjiajieshuTime(Date qingjiajieshuTime) {
        this.qingjiajieshuTime = qingjiajieshuTime;
    }
    /**
	 * 设置：请假内容
	 */
    public String getQingjiaContent() {
        return qingjiaContent;
    }


    /**
	 * 获取：请假内容
	 */

    public void setQingjiaContent(String qingjiaContent) {
        this.qingjiaContent = qingjiaContent;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：请假审核状态
	 */
    public Integer getQingjiaYesnoTypes() {
        return qingjiaYesnoTypes;
    }


    /**
	 * 获取：请假审核状态
	 */

    public void setQingjiaYesnoTypes(Integer qingjiaYesnoTypes) {
        this.qingjiaYesnoTypes = qingjiaYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getQingjiaYesnoText() {
        return qingjiaYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setQingjiaYesnoText(String qingjiaYesnoText) {
        this.qingjiaYesnoText = qingjiaYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getQingjiaShenheTime() {
        return qingjiaShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setQingjiaShenheTime(Date qingjiaShenheTime) {
        this.qingjiaShenheTime = qingjiaShenheTime;
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
