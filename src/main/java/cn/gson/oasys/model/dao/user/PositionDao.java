package cn.gson.oasys.model.dao.user;

import java.util.List;

import cn.gson.oasys.model.entity.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import cn.gson.oasys.model.entity.user.Position;

public interface PositionDao extends PagingAndSortingRepository<Position, Long>{

	@Query("select po.name from Position po where po.id=:id")
	String findById(@Param("id")Long id);
	
	List<Position> findByDeptidAndNameNotLike(Long deptid,String name);
	
	List<Position> findByDeptidAndNameLike(Long deptid,String name);

	Position findOneByDeptidAndNameLike(Long deptid,String name);

	List<Position> findByDeptid(Long deletedeptid);

	@Override
	Page<Position> findAll(Pageable pageable);
	@Query("from Position po where po.name like %?1% or po.level like %?1% or po.describtion like %?1%")
	Page<Position> findlike(String name, Pageable pa);
}
