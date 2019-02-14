package com.umbrella.core.common.session_manage;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class SessionContext {

    private static class UmbrellaSessionContextSingletonCreater {
        private static final SessionContext INSTANCE = new SessionContext();
    }

    public static final SessionContext getInstance() {
        return UmbrellaSessionContextSingletonCreater.INSTANCE;
    }
    private Map<String, HttpSession> map;


    private SessionContext() {
        map = new HashMap<String, HttpSession>();
    }

    //添加
    public synchronized void addSession(HttpSession session) {
        if(session!= null)
            map.put(session.getId(), session);
    }

    //获取
    public synchronized HttpSession getSession(String sessionId) {
        if(sessionId == null)
            return null;
        return map.get(sessionId);
    }

    //删除
    public synchronized void delSession(HttpSession session) {
        if(session!= null)
            map.remove(session.getId());
    }

}
