package cn.gson.oasys.controller.user;

import java.util.List;


import cn.gson.oasys.model.entity.user.User;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.gson.oasys.model.dao.user.DeptDao;
import cn.gson.oasys.model.dao.user.PositionDao;
import cn.gson.oasys.model.entity.user.Dept;
import cn.gson.oasys.model.entity.user.Position;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class PossionController {
	
	@Autowired
	PositionDao pdao;
	@Autowired
	DeptDao ddao;
	
	@RequestMapping("positionmanage")
	public String positionmanage(Model model,@RequestParam(value="page",defaultValue="0") int page,
								 @RequestParam(value="size",defaultValue="10") int size) {
		
		//List<Position> positions = (List<Position>) pdao.findAll();
		Pageable pa=new PageRequest(page, size);
		Page<Position> positionspage = pdao.findAll(pa);
		List<Position> positions = positionspage.getContent();
		model.addAttribute("positions",positions);
		model.addAttribute("page",positionspage);
		model.addAttribute("url","positionmanagepaging");
		
		return "user/positionmanage";
	}

	@RequestMapping("positionmanagepaging")
	public String userPaging(Model model,@RequestParam(value="page",defaultValue="0") int page,
							 @RequestParam(value="size",defaultValue="10") int size,
							 @RequestParam(value="search",required=false) String search,
							 HttpServletRequest request
	){
		Pageable pa=new PageRequest(page, size);
		Page<Position> positionspage = null;
		if(StringUtil.isEmpty(search)){
			positionspage =  pdao.findAll(pa);
		}else{

			positionspage = pdao.findlike(search, pa);
		}
		List<Position> positions = positionspage.getContent();
		model.addAttribute("positions",positions);
		model.addAttribute("page",positionspage);
		model.addAttribute("url", "positionmanagepaging");
		request.getSession().setAttribute("search",search);
		return "user/positionmanagepaging";
	}
	
	@RequestMapping(value = "positionedit" ,method = RequestMethod.GET)
	public String positioneditget(@RequestParam(value = "positionid",required=false) Long positionid,Model model){
		if(positionid!=null){
			
			Position position = pdao.findOne(positionid);
			System.out.println(position);
			Dept dept = ddao.findOne(position.getDeptid());
			model.addAttribute("positiondept",dept);
			model.addAttribute("position",position);
		}
		List<Dept> depts = (List<Dept>) ddao.findAll();
		model.addAttribute("depts", depts);
		return "user/positionedit";
	}
	
	@RequestMapping(value = "positionedit" ,method = RequestMethod.POST)
	public String positioneditpost(Position position,Model model){
		System.out.println(position);
		
		Position psition2 = pdao.save(position);
		
		if(psition2!=null){
			model.addAttribute("success",1);
			return "/positionmanage";
		}
		
		model.addAttribute("errormess","数据插入失败");
		return "user/positionedit";
	}


	
	
	@RequestMapping("removeposition")
	public String removeposition(@RequestParam("positionid") Long positionid,Model model){
		pdao.delete(positionid);
		model.addAttribute("success",1);
		return "/positionmanage";
	}
	
	
	
}
