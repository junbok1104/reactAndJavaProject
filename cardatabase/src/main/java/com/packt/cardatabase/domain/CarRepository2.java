package com.packt.cardatabase.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CarRepository2 extends PagingAndSortingRepository<Car, Long>{

	//페이징 매김과 정렬을 적용하기 위해 사용할 때 PagingAndSortingRepository 를 사용
}
