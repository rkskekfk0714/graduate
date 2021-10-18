package gp.domain;

import gp.web.dto.MaterialDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Long> {

//    public List<Material> findByMaterialMainCate(String MaterialMainCate);
    public Page<Material> findByMaterialMainCate(String materialMainCate, Pageable pageable);
    public List<Material> findByMaterialMainCate(String materialMainCate);

    @Query(value = "select * from  material where material_Title in (:materialList)", nativeQuery = true)
    List<Material> findMaterialList(String[] materialList);

    @Query(value = "select * from  material where material_Key in (:materialList)", nativeQuery = true)
    List<Material> findMaterialListById(String[] materialList);
}
