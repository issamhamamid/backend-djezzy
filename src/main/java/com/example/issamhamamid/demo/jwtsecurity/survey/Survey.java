package com.example.issamhamamid.demo.jwtsecurity.survey;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Entity
@Table(name="survey")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Survey {

    @Column(name = "ingestion_dttm" , columnDefinition = "TIMESTAMP")
    private LocalDateTime ingestionDttm;

    @Column(name = "msisdn" )
    private String msisdn;


    @Column(name = "survey_type" )
    private int surveyType;

    @Column(name = "lang_id")
    private String langId;

    @Column(name = "question_number")
    private int questionNumber;

    @Column(name = "first_resp"  , columnDefinition = "TIMESTAMP")
    private LocalDateTime firstResp;

    @Column(name = "last_resp"  , columnDefinition = "TIMESTAMP")
    private LocalDateTime lastResp;

    @Column(name = "status")
    private String status;


    @Column(name = "activ_contract_date" , columnDefinition = "DATE")
    private LocalDateTime activContractDate;

    @Column(name = "age_group ")
    private  String ageGroup;

    @Column(name = "city_id")
    private int cityId;


    @Column(name = "city_name")
    private String cityName;


    @Column(name = "contract_number_b2c_mob")
    private Long contractNumberB2cMob;

    @Column(name = "curr_price_plan_desc")
    private String currPricePlanDesc;

    @Column(name = "curr_price_plan_key")
    private String currPricePlanKey;

    @Column(name = "data_arpu_segment")
    private String dataArpuSegment;

    @Column(name = "handset_brand")
    private String  handsetBrand;

    @Column(name = "handset_model")
    private String handsetModel;

    @Column(name = "mobile_data_technology")
    private String mobileDataTechnology;

    @Column(name = "region_id")
    private String regionId;

    @Column(name = "region_name")
    private String regionName;

    @Column(name = "segment_type")
    private String segmentType;

    @Column(name = "sub_region_id")
    private String subRegionId;

    @Column(name = "sub_region_name")
    private String subRegionName;


    @Column(name = "use_quota_median")
    private String useQuotaMedian;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;








}
