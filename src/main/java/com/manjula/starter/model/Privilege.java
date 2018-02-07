//package com.manjula.starter.model;
//
//import com.manjula.starter.dto.PrivilegeDto;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.beans.BeanUtils;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author Manjula Jayawardana
// */
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Entity
//@Table(name = "tbl_permission")
//public class Privilege {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    private String code;
//    private String name;
//    private String description;
//
//    public static Privilege valueOf(PrivilegeDto privilegeDto) {
//        Privilege privilege = new Privilege();
//        BeanUtils.copyProperties(privilegeDto, privilege);
//        return privilege;
//    }
//
//    public static List<PrivilegeDto> dtos(List<Privilege> privileges) {
//        List<PrivilegeDto> privilegeViews = new ArrayList<>();
//        for (Privilege privilege : privileges) {
//            privilegeViews.add(privilege.dto());
//        }
//        return privilegeViews;
//    }
//
//    public PrivilegeDto dto() {
//        PrivilegeDto privilegeDto = new PrivilegeDto();
//        BeanUtils.copyProperties(this, privilegeDto);
//        return privilegeDto;
//    }
//
//}
