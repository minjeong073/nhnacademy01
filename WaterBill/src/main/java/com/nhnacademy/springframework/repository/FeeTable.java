package com.nhnacademy.springframework.repository;

public interface FeeTable {
    /**
     * csv 파일 로드(파일 위치)
     * 사용량에 따른 요금 찾기 (물 사용량)
     *
     * class DefaultFeeTable
     */

    void load();

    void findRatesBasedOnUsage();
}
