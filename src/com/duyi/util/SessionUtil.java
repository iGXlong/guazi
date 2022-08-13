package com.duyi.util;

import javax.servlet.http.HttpSession;

/**
 * 用于快速的想Session中存储和获取数据
 */
public class SessionUtil {
    /**
     * 用于向session中存储管理员登陆成功的标记
     * @param session
     */
    public static void setManagerFlag(HttpSession session){
        session.setAttribute("managerFlag",1);
    }

    /**
     * 用于判断session中是否包含管理员登陆成功的标记
     * @param session
     * @return true表示管理员已登陆
     */
    public static boolean getManagerFlag(HttpSession session){
        Integer i = (Integer)session.getAttribute("managerFlag");
        return i==null?false:true;
    }
}
