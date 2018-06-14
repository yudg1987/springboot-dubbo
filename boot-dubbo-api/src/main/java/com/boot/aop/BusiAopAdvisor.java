package com.boot.aop;

import org.springframework.core.Ordered;

/**
 * <br>
 * 标题: <br>
 * 描述: 业务服务异常捕获切面<br>
 * 公司: www.tydic.com<br>
 *
 * @autho QIJIANFEI
 * @time 2017年7月24日 上午11:48:26
 */
public class BusiAopAdvisor implements Ordered {


    @Override
    public int getOrder() {
        return 0;
    }
}