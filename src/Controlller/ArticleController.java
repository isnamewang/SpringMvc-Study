package Controlller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Copyright: Copyright (c) 2020 Asiainfo
 *
 * @ClassName: Controlller.ArticleController
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: wusd
 * @date: 2020/4/19 22:18
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2020/4/19      wusd          v1.0.0               修改原因
 */
@Controller
@SessionAttributes("articleId")
public class ArticleController {
    private Log logger = LogFactory.getLog(ArticleController.class);
    private final String[] sensitiveWords = new String[]{"k1","s2"};

    @ModelAttribute("comment")
    public String replaceSensitWords(String comment){
        if(comment!=null){
            logger.info("原先comment:"+comment);
            for(String sw : sensitiveWords){
                comment=comment.replace(sw,"");
            }
            logger.info("去掉敏感词comment:"+comment);
        }
        return comment;
    }
    @RequestMapping(value={"/articles/{articleId}/comment"})
    public String doComment(@PathVariable String articleId, RedirectAttributes
                            attributes, Model model){
        attributes.addFlashAttribute("comment",model.asMap().get("comment"));
        return "redirect:/showArticle";
    }

    @RequestMapping(value={"/showArticle"},method = {RequestMethod.GET})
    public String showArticle(Model model, SessionStatus sessionStatus){
        String articleId = (String)model.asMap().get("articleId");
        model.addAttribute("articleTitle",articleId+"号标题");
        model.addAttribute("article",articleId+"号文章内容");
        sessionStatus.setComplete();
        return "article";
    }



}
