package shop.mtcoding.blog.model.jobs;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Repository
public class JobsRepository {
    private final EntityManager em;

    public void findAll(){
    }

    public void findById(){}

    @Transactional
    public void updateById(){}

    @Transactional
    public void save() {}

    @Transactional
    public void deleteById () {}
}
