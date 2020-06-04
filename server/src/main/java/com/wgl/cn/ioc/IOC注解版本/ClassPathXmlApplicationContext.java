package com.wgl.cn.ioc.IOC注解版本;

/**
 * @Description TODO
 * @Author guilin wu
 * @Date 2020-05-26 002610:21:29
 * #Version 1.0
 **/


import com.alibaba.druid.util.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 手写Spring专题 注解版本注入bean
 *
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class ClassPathXmlApplicationContext {
    // 扫包范围,效果等于xml文件中的 <context:component-scan...... 配置
    private String packageName;
    ConcurrentHashMap<String, Object> initBean = null;

    public ClassPathXmlApplicationContext(String packageName) { //参数给的是扫包的范围
        this.packageName = packageName;
    }





    // 使用beanID查找对象
    public Object getBean(String beanId) throws Exception {
        // 1.使用反射机制获取该包下所有的类已经存在bean的注解类,这个方法就是返回包下的类中存在注解的类
        List<Class> listClassesAnnotation = findClassExisService();

        if (listClassesAnnotation == null || listClassesAnnotation.isEmpty()) {
            throw new Exception("没有需要初始化的bean");
        }
        // 2.使用Java反射机制初始化对象,将有注解的类实例化并装入一个map中
        initBean = initBean(listClassesAnnotation);
        if (initBean == null || initBean.isEmpty()) {
            throw new Exception("初始化bean为空!");
        }
        // 3.使用beanID查找查找对应bean对象
        Object object = initBean.get(beanId);
        // 4.使用反射读取类的属性,赋值信息
        attriAssign(object);
        return object;
    }


    // 找到 包下所有的类已经存在bean的注解类
    public List<Class> findClassExisService() throws Exception {
        // 1.使用反射机制获取该包下所有的类
        if (StringUtils.isEmpty(packageName)) {
            throw new Exception("扫包地址不能为空!");
        }
        // 2.使用反射技术获取当前包下所有的类  ,这就得到多个类
        List<Class<?>> classesByPackageName = ClassUtil.getClasses(packageName);

        List<Class> exisClassesAnnotation = new ArrayList<Class>();
        // 4.判断哪些类上存在注解
        for (Class classInfo : classesByPackageName) {
            ExtService extService = (ExtService) classInfo.getDeclaredAnnotation(ExtService.class);
            // 3.类上有注解的存入集合
            if (extService != null) {
                exisClassesAnnotation.add(classInfo);
                continue;
            }
        }
        return exisClassesAnnotation;
    }

    // 初始化bean对象
    public ConcurrentHashMap<String, Object> initBean(List<Class> listClassesAnnotation) throws InstantiationException, IllegalAccessException {
      //listClassesAnnotation  存的的有注解的类 ,
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<String, Object>();
        for (Class classInfo : listClassesAnnotation) {
            // 初始化对象 这里将这些bean通过class实例化
            Object newInstance = classInfo.newInstance();
            // 获取父类名称
            String beanId = toLowerCaseFirstOne(classInfo.getSimpleName());
            concurrentHashMap.put(beanId, newInstance);
        }
        // 在存取map,返回
        return concurrentHashMap;
    }

    // 使用反射读取类的属性,赋值信息
    public void attriAssign(Object object) throws IllegalArgumentException, IllegalAccessException {
        // 1.获取类的属性是否存在 获取bean注解
        Class<? extends Object> classInfo = object.getClass();
        Field[] declaredFields = classInfo.getDeclaredFields();
        for (Field field : declaredFields) {
            // 属性名称
            String name = field.getName();
            // 2.使用属性名称查找bean容器赋值
            Object bean = initBean.get(name);
            if (bean != null) {
                // 私有访问允许访问
                field.setAccessible(true);
                // 给属性赋值
                field.set(object, bean);
                continue;
            }
        }

    }




    // 首字母转小写
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

}
