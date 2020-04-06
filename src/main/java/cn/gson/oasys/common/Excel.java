package cn.gson.oasys.common;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import cn.gson.oasys.model.dao.user.DeptDao;
import cn.gson.oasys.model.dao.user.PositionDao;
import cn.gson.oasys.model.dao.user.UserDao;
import cn.gson.oasys.model.entity.user.Position;
import cn.gson.oasys.model.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Excel {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PositionDao positionDao;
    @Autowired
    private DeptDao deptDao;
    @RequestMapping("/excel")
    @ResponseBody
    public void downloadexcel(HttpServletRequest request,
                              HttpServletResponse response) throws Exception{

        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
        List<User> list=userDao.findAll();
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> lm = new HashMap<String, String>();
            User user=list.get(i);
            lm.put("realName", user.getRealName());
            lm.put("sex", user.getSex());
            lm.put("position",user.getPosition().getName());
            lm.put("dept", user.getDept().getDeptName());
            lm.put("userName", user.getUserName());
            lm.put("tel",user.getUserTel());
            lm.put("salar", user.getSalary());
            listMap.add(lm);
        }
        map.put("list", listMap);

        ExcelUtils.saveTemplateFile(request,"excel/userExcel.xlsx","excel","员工信息.xlsx",map);



    }

}
