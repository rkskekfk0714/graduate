package gp.domain;

import gp.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {


    @Query(value = "select * from recipe order by recipehit desc",nativeQuery = true)
    List<Recipe> bestrecipe();




    @Modifying
    @Query("update Recipe p set p.recipehit = p.recipehit + 1 where p.recipekey = :recipekey")
    int updateView(Long recipekey);

    public Page<Recipe> findByRecipetype(String recipetype, Pageable pageable);
    public Page<Recipe> findByRecipetitleContaining(String recipetitle, Pageable pageable);
    public Page<Recipe> findByRecipecreatorContaining(String recipecreator, Pageable pageable);
}
