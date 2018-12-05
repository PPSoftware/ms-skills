package io.github.ppSoftware.rpgSys.msSkills.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.ppSoftware.rpgSys.msSkills.model.SkillDao;

@Repository
public interface SkillDaoRepository extends JpaRepository<SkillDao, Long> {

	Optional<SkillDao> findByName(String name);
}
