











<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="80px"
                :style="{backgroundColor:addEditForm.addEditBoxColor}">
            <el-row>
                <el-col :span="12"  v-if="sessionTable !='clazz'">
                    <el-form-item class="select" v-if="type!='info'"  label="班级" prop="clazzId">
                        <el-select v-model="ruleForm.clazzId" filterable placeholder="请选择班级" @change="clazzChange">
                            <el-option
                                    v-for="(item,index) in clazzOptions"
                                    v-bind:key="item.id"
                                    :label="item.clazzName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='clazz' ">
                    <el-form-item class="input" v-if="type!='info'"  label="班级名称" prop="clazzName">
                        <el-input v-model="clazzForm.clazzName"
                                  placeholder="班级名称" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="班级名称" prop="clazzName">
                            <el-input v-model="ruleForm.clazzName"
                                      placeholder="班级名称" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='clazz' ">
                    <el-form-item class="input" v-if="type!='info'"  label="班级位置" prop="clazzAddress">
                        <el-input v-model="clazzForm.clazzAddress"
                                  placeholder="班级位置" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="班级位置" prop="clazzAddress">
                            <el-input v-model="ruleForm.clazzAddress"
                                      placeholder="班级位置" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="节数" prop="sectionsTypes">
                        <el-select v-model="ruleForm.sectionsTypes" placeholder="请选择节数">
                            <el-option
                                v-for="(item,index) in sectionsTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="节数" prop="sectionsValue">
                        <el-input v-model="ruleForm.sectionsValue"
                            placeholder="节数" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
            <input id="clazzId" name="clazzId" type="hidden">
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="学期" prop="xueqiTypes">
                        <el-select v-model="ruleForm.xueqiTypes" placeholder="请选择学期">
                            <el-option
                                v-for="(item,index) in xueqiTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="学期" prop="xueqiValue">
                        <el-input v-model="ruleForm.xueqiValue"
                            placeholder="学期" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
    
    
                <el-col :span="12">
                    <el-form-item class="input" v-if="type!='info'"  label="排序字段" prop="paixuNumber">
                        <el-input v-model="ruleForm.paixuNumber"
                                  placeholder="排序字段" clearable  :readonly="ro.paixuNumber"></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="排序字段" prop="paixuNumber">
                            <el-input v-model="ruleForm.paixuNumber"
                                      placeholder="排序字段" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                
                
                <!-- 星期一 -->
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="星期一">
                        <el-select v-model="ruleForm.kecheng[0]" placeholder="星期一">
                            <el-option
                                    v-for="(item,index) in kechengOptions"
                                    v-bind:key="item.id"
                                    :label="'老师：' +item.tempLaoshiName +' -- 课程：' +item.kechengName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="星期一">
                            <el-input v-model="ruleForm.kechengName[0]"
                                      placeholder="星期一" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <!-- 星期二 -->
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="星期二">
                        <el-select v-model="ruleForm.kecheng[1]" placeholder="星期二">
                            <el-option
                                    v-for="(item,index) in kechengOptions"
                                    v-bind:key="item.id"
                                    :label="'老师：' +item.tempLaoshiName +' -- 课程：' +item.kechengName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="星期二">
                            <el-input v-model="ruleForm.kechengName[1]"
                                      placeholder="星期二" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
				<!-- 星期三 -->
				<el-col :span="12">
					<el-form-item class="select" v-if="type!='info'"  label="星期三">
						<el-select v-model="ruleForm.kecheng[2]" placeholder="星期三">
							<el-option
									v-for="(item,index) in kechengOptions"
									v-bind:key="item.id"
									:label="'老师：' +item.tempLaoshiName +' -- 课程：' +item.kechengName"
									:value="item.id">
							</el-option>
						</el-select>
					</el-form-item>
					<div v-else>
						<el-form-item class="input" label="星期三">
							<el-input v-model="ruleForm.kechengName[2]"
									  placeholder="星期三" readonly></el-input>
						</el-form-item>
					</div>
				</el-col>
				<!-- 星期四 -->
				<el-col :span="12">
					<el-form-item class="select" v-if="type!='info'"  label="星期四">
						<el-select v-model="ruleForm.kecheng[3]" placeholder="星期四">
							<el-option
									v-for="(item,index) in kechengOptions"
									v-bind:key="item.id"
									:label="'老师：' +item.tempLaoshiName +' -- 课程：' +item.kechengName"
									:value="item.id">
							</el-option>
						</el-select>
					</el-form-item>
					<div v-else>
						<el-form-item class="input" label="星期四">
							<el-input v-model="ruleForm.kechengName[3]"
									  placeholder="星期四" readonly></el-input>
						</el-form-item>
					</div>
				</el-col>
				<!-- 星期五 -->
				<el-col :span="12">
					<el-form-item class="select" v-if="type!='info'"  label="星期五">
						<el-select v-model="ruleForm.kecheng[4]" placeholder="星期五">
							<el-option
									v-for="(item,index) in kechengOptions"
									v-bind:key="item.id"
									:label="'老师：' +item.tempLaoshiName +' -- 课程：' +item.kechengName"
									:value="item.id">
							</el-option>
						</el-select>
					</el-form-item>
					<div v-else>
						<el-form-item class="input" label="星期五">
							<el-input v-model="ruleForm.kechengName[4]"
									  placeholder="星期五" readonly></el-input>
						</el-form-item>
					</div>
				</el-col>
                
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                clazzForm: {},

                // kechengForm:{
                //     kecheng1:"",
                //     kecheng2:"",
                //     kecheng3:"",
                //     kecheng4:"",
                //     kecheng5:"",
                // },
                ro:{
                    sectionsTypes: false,
                    clazzId: false,
                    xueqiTypes: false,
                    // kecheng: false,
                    paixuNumber: false,
                },
                ruleForm: {
                    sectionsTypes: '',
                    clazzId: '',
                    xueqiTypes: '',
                    kecheng: [],//id列表
                    kechengName: [],//数据列表
                    paixuNumber: '',
                },
                sectionsTypesOptions : [],
                xueqiTypesOptions : [],
                clazzOptions : [],
                kechengOptions : [],
                rules: {
                   sectionsTypes: [
                              { required: true, message: '节数不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   clazzId: [
                              { required: true, message: '班级不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   xueqiTypes: [
                              { required: true, message: '学期不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   kecheng: [
                              { required: true, message: '课程不能为空', trigger: 'blur' },
                          ],
                   paixuNumber: [
                              { required: true, message: '排序字段不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                },
                
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            let _this= this;
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");

            if (this.role != "管理员"){
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=sections_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.sectionsTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=xueqi_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.xueqiTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `clazz/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.clazzOptions = data.data.list;
            }
         });







        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){

                    this.$http({
                        url: `kecheng/page?page=1&limit=100`,
                        method: "get"
                    }).then(({ data }) => {
                        if (data && data.code === 0) {
                            this.kechengOptions = data.data.list;
                        }
                        debugger
                        this.info(id);
                    });
                }else{

                    this.$http({
                        url: `kecheng/page?page=1&limit=100`,
                        method: "get"
                    }).then(({ data }) => {
                        if (data && data.code === 0) {
                            this.kechengOptions = data.data.list;
                        }
                    });
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            clazzChange(id){
                this.$http({
                    url: `clazz/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.clazzForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this= this;
                _this.$http({
                    url: `kebiao/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        let tempKecheng = data.data.kecheng;
                        let kechenglist = tempKecheng.split(",");
                        let kechenglist1=[];
                        let kechengName111=[];
                        kechenglist.forEach(element =>{
                            kechenglist1.push(Number(element))
                            _this.kechengOptions.forEach(element1 =>{
                                if(element1.id == Number(element)){
                                    kechengName111.push(String('老师：' +element1.tempLaoshiName +' -- 课程：' +element1.kechengName))

                                }
                            })
                        })
                        _this.ruleForm.kecheng=kechenglist1;
                        _this.ruleForm.kechengName=kechengName111;
                        debugger
                        _this.clazzChange(data.data.clazzId)
                        //解决前台上传图片后台不显示的问题
                        let reg=new RegExp('../../../upload','g')//g代表全部
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        if(this.ruleForm.kecheng.length != 5){
                            this.$message.error("课程没有选完");
                            return;
						}
                        let kechengTemp = this.ruleForm.kecheng.toString();
                        this.ruleForm.kecheng = kechengTemp;
                        this.$http({
                            url:`kebiao/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data:this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.kebiaoCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                                // let kechengTempList = this.ruleForm.kecheng.split(",");
                                // this.ruleForm.kecheng = kechengTempList;

                                this.parent.showFlag = true;
                                this.parent.addOrUpdateFlag = false;
                                this.parent.kebiaoCrossAddOrUpdateFlag = false;
                                this.parent.search();
                                this.parent.contentStyleChange();
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.kebiaoCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}</style>

