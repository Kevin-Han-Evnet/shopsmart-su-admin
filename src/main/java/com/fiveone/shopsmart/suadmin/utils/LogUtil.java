package com.fiveone.shopsmart.suadmin.utils;

import com.fiveone.shopsmart.suadmin.SuAdminApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {
    private static final Logger logger = LoggerFactory.getLogger(SuAdminApplication.class);

    /**
     * 디버깅 메시지를 자유롭게 써보아요
     * @param msg
     */
    public static void info (String msg) {
        logger.info(msg);
    }

    /**
     * 디버깅 메시지를 자유롭게 써보아요
     * @param msg
     */
    public static void debug (String msg) {
        logger.debug(msg);
    }

    /**
     * 디버깅 메시지를 자유롭게 써보아요
     * @param msg
     */
    public static void error (String msg) {

    }
}
