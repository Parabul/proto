package kz.proto.dao.repository;

import kz.proto.dao.domain.entity.GlUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<GlUser, Integer> {

	GlUser findByEmail(String email);
	
	GlUser findByCashierId(Integer cashierId);
}