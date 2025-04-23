
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 系主任
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xizhuren")
public class XizhurenController {
    private static final Logger logger = LoggerFactory.getLogger(XizhurenController.class);

    @Autowired
    private XizhurenService xizhurenService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private LaoshiService laoshiService;
    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("老师".equals(role))
            params.put("laoshiId",request.getSession().getAttribute("userId"));
        else if("系主任".equals(role))
            params.put("xizhurenId",request.getSession().getAttribute("userId"));
        else if("学生".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = xizhurenService.queryPage(params);

        //字典表数据转换
        List<XizhurenView> list =(List<XizhurenView>)page.getList();
        for(XizhurenView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XizhurenEntity xizhuren = xizhurenService.selectById(id);
        if(xizhuren !=null){
            //entity转view
            XizhurenView view = new XizhurenView();
            BeanUtils.copyProperties( xizhuren , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XizhurenEntity xizhuren, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xizhuren:{}",this.getClass().getName(),xizhuren.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<XizhurenEntity> queryWrapper = new EntityWrapper<XizhurenEntity>()
            .eq("username", xizhuren.getUsername())
            .or()
            .eq("xizhuren_phone", xizhuren.getXizhurenPhone())
            .or()
            .eq("xizhuren_id_number", xizhuren.getXizhurenIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XizhurenEntity xizhurenEntity = xizhurenService.selectOne(queryWrapper);
        if(xizhurenEntity==null){
            xizhuren.setCreateTime(new Date());
            xizhuren.setPassword("123456");
            xizhurenService.insert(xizhuren);
            return R.ok();
        }else {
            return R.error(511,"账户或者系主任手机号或者系主任身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XizhurenEntity xizhuren, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xizhuren:{}",this.getClass().getName(),xizhuren.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<XizhurenEntity> queryWrapper = new EntityWrapper<XizhurenEntity>()
            .notIn("id",xizhuren.getId())
            .andNew()
            .eq("username", xizhuren.getUsername())
            .or()
            .eq("xizhuren_phone", xizhuren.getXizhurenPhone())
            .or()
            .eq("xizhuren_id_number", xizhuren.getXizhurenIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XizhurenEntity xizhurenEntity = xizhurenService.selectOne(queryWrapper);
        if("".equals(xizhuren.getXizhurenPhoto()) || "null".equals(xizhuren.getXizhurenPhoto())){
                xizhuren.setXizhurenPhoto(null);
        }
        if(xizhurenEntity==null){
            xizhurenService.updateById(xizhuren);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者系主任手机号或者系主任身份证号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        xizhurenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<XizhurenEntity> xizhurenList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            XizhurenEntity xizhurenEntity = new XizhurenEntity();
//                            xizhurenEntity.setUsername(data.get(0));                    //账户 要改的
//                            //xizhurenEntity.setPassword("123456");//密码
//                            xizhurenEntity.setXizhurenUuidNumber(data.get(0));                    //系主任工号 要改的
//                            xizhurenEntity.setXizhurenName(data.get(0));                    //系主任姓名 要改的
//                            xizhurenEntity.setXizhurenPhone(data.get(0));                    //系主任手机号 要改的
//                            xizhurenEntity.setXizhurenIdNumber(data.get(0));                    //系主任身份证号 要改的
//                            xizhurenEntity.setXizhurenPhoto("");//详情和图片
//                            xizhurenEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            xizhurenEntity.setXizhurenEmail(data.get(0));                    //电子邮箱 要改的
//                            xizhurenEntity.setCreateTime(date);//时间
                            xizhurenList.add(xizhurenEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //系主任工号
                                if(seachFields.containsKey("xizhurenUuidNumber")){
                                    List<String> xizhurenUuidNumber = seachFields.get("xizhurenUuidNumber");
                                    xizhurenUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xizhurenUuidNumber = new ArrayList<>();
                                    xizhurenUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xizhurenUuidNumber",xizhurenUuidNumber);
                                }
                                //系主任手机号
                                if(seachFields.containsKey("xizhurenPhone")){
                                    List<String> xizhurenPhone = seachFields.get("xizhurenPhone");
                                    xizhurenPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> xizhurenPhone = new ArrayList<>();
                                    xizhurenPhone.add(data.get(0));//要改的
                                    seachFields.put("xizhurenPhone",xizhurenPhone);
                                }
                                //系主任身份证号
                                if(seachFields.containsKey("xizhurenIdNumber")){
                                    List<String> xizhurenIdNumber = seachFields.get("xizhurenIdNumber");
                                    xizhurenIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xizhurenIdNumber = new ArrayList<>();
                                    xizhurenIdNumber.add(data.get(0));//要改的
                                    seachFields.put("xizhurenIdNumber",xizhurenIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<XizhurenEntity> xizhurenEntities_username = xizhurenService.selectList(new EntityWrapper<XizhurenEntity>().in("username", seachFields.get("username")));
                        if(xizhurenEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XizhurenEntity s:xizhurenEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //系主任工号
                        List<XizhurenEntity> xizhurenEntities_xizhurenUuidNumber = xizhurenService.selectList(new EntityWrapper<XizhurenEntity>().in("xizhuren_uuid_number", seachFields.get("xizhurenUuidNumber")));
                        if(xizhurenEntities_xizhurenUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XizhurenEntity s:xizhurenEntities_xizhurenUuidNumber){
                                repeatFields.add(s.getXizhurenUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [系主任工号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //系主任手机号
                        List<XizhurenEntity> xizhurenEntities_xizhurenPhone = xizhurenService.selectList(new EntityWrapper<XizhurenEntity>().in("xizhuren_phone", seachFields.get("xizhurenPhone")));
                        if(xizhurenEntities_xizhurenPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XizhurenEntity s:xizhurenEntities_xizhurenPhone){
                                repeatFields.add(s.getXizhurenPhone());
                            }
                            return R.error(511,"数据库的该表中的 [系主任手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //系主任身份证号
                        List<XizhurenEntity> xizhurenEntities_xizhurenIdNumber = xizhurenService.selectList(new EntityWrapper<XizhurenEntity>().in("xizhuren_id_number", seachFields.get("xizhurenIdNumber")));
                        if(xizhurenEntities_xizhurenIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XizhurenEntity s:xizhurenEntities_xizhurenIdNumber){
                                repeatFields.add(s.getXizhurenIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [系主任身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xizhurenService.insertBatch(xizhurenList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        XizhurenEntity xizhuren = xizhurenService.selectOne(new EntityWrapper<XizhurenEntity>().eq("username", username));
        if(xizhuren==null || !xizhuren.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(xizhuren.getId(),username, "xizhuren", "系主任");
        R r = R.ok();
        r.put("token", token);
        r.put("role","系主任");
        r.put("username",xizhuren.getXizhurenName());
        r.put("tableName","xizhuren");
        r.put("userId",xizhuren.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody XizhurenEntity xizhuren){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<XizhurenEntity> queryWrapper = new EntityWrapper<XizhurenEntity>()
            .eq("username", xizhuren.getUsername())
            .or()
            .eq("xizhuren_phone", xizhuren.getXizhurenPhone())
            .or()
            .eq("xizhuren_id_number", xizhuren.getXizhurenIdNumber())
            ;
        XizhurenEntity xizhurenEntity = xizhurenService.selectOne(queryWrapper);
        if(xizhurenEntity != null)
            return R.error("账户或者系主任手机号或者系主任身份证号已经被使用");
        xizhuren.setCreateTime(new Date());
        xizhurenService.insert(xizhuren);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        XizhurenEntity xizhuren = new XizhurenEntity();
        xizhuren.setPassword("123456");
        xizhuren.setId(id);
        xizhurenService.updateById(xizhuren);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        XizhurenEntity xizhuren = xizhurenService.selectOne(new EntityWrapper<XizhurenEntity>().eq("username", username));
        if(xizhuren!=null){
            xizhuren.setPassword("123456");
            boolean b = xizhurenService.updateById(xizhuren);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrXizhuren(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        XizhurenEntity xizhuren = xizhurenService.selectById(id);
        if(xizhuren !=null){
            //entity转view
            XizhurenView view = new XizhurenView();
            BeanUtils.copyProperties( xizhuren , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }





}
