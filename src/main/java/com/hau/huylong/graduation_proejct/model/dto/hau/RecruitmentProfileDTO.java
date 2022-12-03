package com.hau.huylong.graduation_proejct.model.dto.hau;

import lombok.Data;

@Data
public class RecruitmentProfileDTO {
    private String positionOffer;
    //cấp bậc mong muốn
    private String levelDesire;
    //trình độ học vấn
    private String academyLevel;
    // ngành nghề
    private String career;
    //hình thức làm việc
    private String workForm;
    // cấp bậc hiện tại
    private String currentLevel;
    // mức lương mong muốn
    private Float offerSalary;
    // số năm kinh nghiệm
    private Float experienceNumber;
    // Nơi làm việc
    private String workAddress;
    // Thông tin người dùng
    private String userId;
    // Địa chỉ
    private String address;
    // mục tiêu nghề nghiệp
    private String careerTarget;
    // Kinh nghiệm làm việc
    private String workExperience;
    // Thông tin học vấn
    private String academyInfo;
    // Ngoại ngữ
    private String foreignLanguage;
    // Tin học
    private String officeInfo;
}
