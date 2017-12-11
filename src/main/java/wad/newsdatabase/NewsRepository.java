/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.newsdatabase;

/**
 *
 * @author riku
 * 
 */
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<Article, Long> {
    
    
}
