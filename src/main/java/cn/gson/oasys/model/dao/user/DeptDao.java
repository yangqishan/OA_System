package cn.gson.oasys.model.dao.user;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import cn.gson.oasys.model.entity.user.Dept;

public interface DeptDao extends PagingAndSortingRepository<Dept, Long>{

	List<Dept> findByDeptId(Long id);

	@Override
	Page<Dept> findAll(Pageable pageable);

	@Query("select de.deptName from Dept de where de.deptId=:id")
	String findname(@Param("id")Long id);
}
