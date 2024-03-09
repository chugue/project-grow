package shop.mtcoding.blog.model.user;

import lombok.Data;
import shop.mtcoding.blog.model.skill.SkillRequest;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class UserRequst {

    @Data
    public static class ResumeOfterDTO {
        private Integer id; // apply 의 키값
        private String compName;
        private String title;
        private String career;
        private Integer jobsId;
        private Integer status;
        private List<SkillRequest.JobSkillDTO> skillList;

        public ResumeOfterDTO(Integer id, String compName, String title, String career, Integer jobsId, Integer status) {
            this.id = id;
            this.compName = compName;
            this.title = title;
            this.career = career;
            this.jobsId = jobsId;
            this.status = status;
        }
    }

    @Data
    public static class UserDto {
        private Integer id;
        private String email;
        private String myName;
        private String phone;
        private String address;
        private Date birth;
        private String businessNumber;
        private String photo;
        private String compName;
        private String homepage;
        private Integer role;
        private Timestamp createdAt;

    }
}