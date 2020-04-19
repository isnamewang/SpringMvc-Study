package Controlller;

import com.sun.jmx.snmp.SnmpUnknownModelLcdException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Copyright: Copyright (c) 2020 Asiainfo
 *
 * @ClassName: Controlller.Hand
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wusd
 * @date: 2020/4/17 11:55
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2020/4/17      wusd          v1.0.0               修改原因
 */
@Controller
public class Hand implements EnvironmentAware {

    private final Log logger = LogFactory.getLog(Hand.class);

    @RequestMapping(value={"/"},method ={RequestMethod.HEAD})
    public String head(){
        return "go.jsp";
    }

    @RequestMapping(value = {"/index","/"},method = RequestMethod.GET)
    public String index(Model model){
        logger.info("======processed by index======");
        model.addAttribute("msg","hello");
        return "go.jsp";
    }

    private Environment environment=null;
    @Override
    public void setEnvironment(Environment environment) {
        this.environment=environment;
    }
}
