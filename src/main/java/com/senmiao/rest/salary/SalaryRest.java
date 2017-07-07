package com.senmiao.rest.salary;

import com.senmiao.components.salary.search.SalarySearch;
import com.senmiao.components.salary.service.SalaryService;
import com.senmiao.dto.salary.SalaryBo;
import com.senmiao.dto.salary.SalaryForm;
import com.senmiao.dto.salary.SalaryList;
import com.telecom.common.domain.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yy on 2017/7/6.
 */

@RestController
@RequestMapping("/server/salary")
public class SalaryRest {

    private Logger log = LoggerFactory.getLogger(SalaryRest.class);
    @Resource private SalaryService srv;

    @RequestMapping("/list.json")
    @ResponseBody
    public Map<String, Object> list(@ModelAttribute SalarySearch searchForm) {
        Map<String, Object> map = new HashMap<>();
        List<SalaryBo> accounts = new SalaryList(srv.list(searchForm)).getList();
        map.put("aaData", accounts);
        return map;
    }


    @RequestMapping("/save.json")
    @ResponseBody
    public Result<List<SalaryBo>> saveSalary(@ModelAttribute SalaryForm form){
        return new Result<>(200, "保存成功",new SalaryList(srv.saveSalary(form)).getList());
    }


}
