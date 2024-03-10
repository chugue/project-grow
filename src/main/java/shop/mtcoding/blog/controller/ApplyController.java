package shop.mtcoding.blog.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import shop.mtcoding.blog.model.apply.ApplyRepository;
import shop.mtcoding.blog.model.jobs.JobRequest;
import shop.mtcoding.blog.model.jobs.JobsRepository;
import shop.mtcoding.blog.model.resume.ResumeRepository;
import shop.mtcoding.blog.model.resume.ResumeRequest;
import shop.mtcoding.blog.model.skill.SkillRepository;
import shop.mtcoding.blog.model.skill.SkillRequest;
import shop.mtcoding.blog.model.user.User;

import java.util.List;


@RequiredArgsConstructor
@Controller
public class ApplyController {
    private final ApplyRepository applyRepository;
    private final HttpSession session;
    private final JobsRepository jobsRepository;
    private final SkillRepository skillRepository;
    private final ResumeRepository resumeRepository;


    @GetMapping("/resume/{jobId}/apply")
    public String apply (@PathVariable Integer jobId, @RequestParam("resumeId") Integer resumeId, HttpServletRequest request){
        boolean applySuccess = false;

        applyRepository.saveResumeJobsApply(resumeId, jobId);
        Object[] status =  applyRepository.findStatusByResumeJobs(resumeId,jobId);
        if (status != null){
            applySuccess = true;
            request.setAttribute("applySuccess", applySuccess);
        }
        Object[] job = jobsRepository.findByJobId(jobId);

        JobRequest.JobsJoinDTO Checked = JobRequest.JobsJoinDTO.builder()
                .compName(String.valueOf(job[0]))
                .userId((Integer) job[1])
                .address(String.valueOf(job[2]))
                .phone(String.valueOf(job[3]))
                .area(String.valueOf(job[4]))
                .edu(String.valueOf(job[5]))
                .career(String.valueOf(job[6]))
                .content(String.valueOf(job[7]))
                .title(String.valueOf(job[8]))
                .homepage(String.valueOf(job[9]))
                .task(String.valueOf(job[10]))
                .deadLine(job[11] != null ? String.valueOf(job[11]) : null)  // job[11]이 deadLine에 해당합니다.
                .businessNumber(String.valueOf(job[12]))
                .photo(String.valueOf(job[13]))
                .build();

        List<SkillRequest.ApplyskillDTO> skillList = skillRepository.JobsSkill(jobId);
        User user = (User) session.getAttribute("sessionUser");
        List<ResumeRequest.UserViewDTO> resumeList = resumeRepository.findAllUserId((user.getId()));
        // row 세션에 담아
        request.setAttribute("jobsId", jobId);
        request.setAttribute("jobs", Checked);
        request.setAttribute("skillList", skillList);
        request.setAttribute("resumeList", resumeList);
        System.out.println(11111);
        return "/jobs/jobsDetail";
    }
}
