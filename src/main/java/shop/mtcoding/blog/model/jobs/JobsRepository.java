package shop.mtcoding.blog.model.jobs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.blog.model.user.User;

import java.util.List;

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
    public void save(JobRequest.JobWriterDTO requestDTO) {
        Query query = em.createNativeQuery("insert into Jobs_tb(title,area,edu,career,content,dead_line,task,comp_id,created_at) values(?,?,?,?,?,?,?,?,now())");
        query.setParameter(1,requestDTO.getTitle());
        query.setParameter(2,requestDTO.getArea());
        query.setParameter(3,requestDTO.getEdu());
        query.setParameter(4,requestDTO.getCareer());
        query.setParameter(5,requestDTO.getContent());
        query.setParameter(6,requestDTO.getDeadLine());
        query.setParameter(7,requestDTO.getTask());
        query.setParameter(8,requestDTO.getCompId());
        query.executeUpdate();
    }

    @Transactional
    public void update(JobRequest.JobUpdateDTO requestDTO){
        Query query = em.createNativeQuery("update Jobs_tb set title = ? ,area = ?,edu=?,carrer =? ,content = ?, dead_line = ? , task = ? where id = ?");
        query.setParameter(1,requestDTO.getTitle());
        query.setParameter(2,requestDTO.getArea());
        query.setParameter(3,requestDTO.getEdu());
        query.setParameter(4,requestDTO.getCareer());
        query.setParameter(5,requestDTO.getContent());
        query.setParameter(6,requestDTO.getDeadLine());
        query.setParameter(7,requestDTO.getTask());
        query.setParameter(8,requestDTO.getId());
        query.executeUpdate();
    }



    @Transactional
    public void deleteById () {}
}