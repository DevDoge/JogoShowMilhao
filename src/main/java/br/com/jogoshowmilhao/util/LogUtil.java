package br.com.jogoshowmilhao.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogUtil {
    public static final String LOG4J_PROPERTIES = "log4j.properties";

    public LogUtil() {
    }
    public static Logger getLogger(Object object){
        PropertyConfigurator.configure(LogUtil.class.
                getClassLoader().getResource(LOG4J_PROPERTIES));
    return Logger.getLogger(object.getClass());
    }
}