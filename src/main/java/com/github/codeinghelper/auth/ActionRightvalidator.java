package com.github.codeinghelper.auth;

import com.github.codeinghelper.exception.http.ForbiddenException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;

/**
 * @author ：lzz
 * @BelongsProject: com.github.lizeze.auth.validator
 * @date ：Created in 2020/8/7 9:11
 * @description ：
 * @modified By：
 */

@Aspect
@Component
public class ActionRightvalidator {


    @Autowired
    RightManager rightManager;

    @Pointcut("@annotation(com.github.codeinghelper.auth.ActionRight)")
    private void permission() {

    }

    /**
     * 目标方法调用之前执行
     */
    @Before("permission()&&@annotation(actionRight)")
    public void doBefore(JoinPoint joinPoint, ActionRight actionRight) {
        System.out.println("================== step 2: before ==================");
        System.out.println("******拦截前的逻辑******");
        System.out.println("目标方法名为:" + joinPoint.getSignature().getName());
        System.out.println("目标方法所属类的简单类名:" + joinPoint.getSignature().getDeclaringType().getSimpleName());
        System.out.println("目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("目标方法声明类型:" + Modifier.toString(joinPoint.getSignature().getModifiers()));
        //获取传入目标方法的参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println("第" + (i + 1) + "个参数为:" + args[i]);
        }
        System.out.println("被代理的对象:" + joinPoint.getTarget());
        System.out.println("代理对象自己:" + joinPoint.getThis());

        System.out.println("拦截的注解的参数：");
        System.out.println(actionRight.actionCode());
    }

    /**
     * 目标方法调用之后执行
     */
    @After("permission()")
    public void doAfter() {
        System.out.println("================== step 4: after ==================");
    }

    /**
     * 环绕
     * 会将目标方法封装起来
     * 具体验证业务数据
     */
    @Around("permission()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("================== step 1: around ==================");
        long startTime = System.currentTimeMillis();
        /*
         * 获取当前http请求中的token
         * 解析token :
         * 1、token是否存在
         * 2、token格式是否正确
         * 3、token是否已过期（解析信息或者redis中是否存在）
         * */
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            throw new ForbiddenException(4003);
        }
        Map<String, String> map = rightManager.ActionRights();
        // 校验token的业务逻辑
        // ...

        /*
         * 获取注解的值，并进行权限验证:
         * redis 中是否存在对应的权限
         * redis 中没有则从数据库中获取权限
         * 数据空中没有，抛异常，非法请求，没有权限
         * */
        Method method = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod();
        ActionRight visitPermission = method.getAnnotation(ActionRight.class);
        String value = visitPermission.actionCode();
        Boolean require = visitPermission.require();
        if (require) {
            if (!map.containsKey(value)) throw new ForbiddenException(4003);
        }
        // 校验权限的业务逻辑
        // List<Object> permissions = redis.get(permission)
        // db.getPermission
        // permissions.contains(value)
        // ...
        System.out.println(value);

        // 执行具体方法
        Object result = proceedingJoinPoint.proceed();

        long endTime = System.currentTimeMillis();

        /*
         * 记录相关执行结果
         * 可以存入MongoDB 后期做数据分析
         * */
        // 打印请求 url
//        System.out.println("URL            : " + request.getRequestURL().toString());
//        // 打印 Http method
//        System.out.println("HTTP Method    : " + request.getMethod());
//        // 打印调用 controller 的全路径以及执行方法
//        System.out.println("controller     : " + proceedingJoinPoint.getSignature().getDeclaringTypeName());
//        // 调用方法
//        System.out.println("Method         : " + proceedingJoinPoint.getSignature().getName());
//        // 执行耗时
//        System.out.println("cost-time      : " + (endTime - startTime) + " ms");

        return result;

    }


}
