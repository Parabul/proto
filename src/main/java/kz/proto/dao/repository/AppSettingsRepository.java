package kz.proto.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kz.proto.dao.domain.entity.AppSettings;

@Repository
public interface AppSettingsRepository extends JpaRepository<AppSettings, Integer> {

	public static final String general = "general";

	public AppSettings findByCode(String code);
}