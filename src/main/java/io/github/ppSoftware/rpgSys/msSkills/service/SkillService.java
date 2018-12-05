package io.github.ppSoftware.rpgSys.msSkills.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.github.ppSoftware.rpgSys.msSkills.exception.ResourceNotFoundException;
import io.github.ppSoftware.rpgSys.msSkills.model.SkillDao;
import io.github.ppSoftware.rpgSys.msSkills.repository.SkillDaoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SkillService {

	private SkillDaoRepository skillDaoRepository;

	public Optional<SkillDao> findByName(String name) {
		return skillDaoRepository.findByName(name);
	}

	public Page<SkillDao> findAll(Pageable pageable) {
		return skillDaoRepository.findAll(pageable);
	}

	public SkillDao save(SkillDao skill) {
		return skillDaoRepository.save(skill);
	}

	public ResponseEntity<?> delete(String skillName) {
		return skillDaoRepository.findByName(skillName).map(skill -> {
			skillDaoRepository.delete(skill);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Skill not found with id " + skillName));

	}

	public SkillDao update(@Valid SkillDao skill, Long skillId) {
		return skillDaoRepository.findById(skillId).map(skillDao -> {
			skillDao.setName(skill.getName());
			skillDao.setDescription(skill.getDescription());
			skillDao.setUpdatedAt(skill.getCreatedAt());
			return skillDaoRepository.save(skillDao);
		}).orElseThrow(() -> new ResourceNotFoundException("Skill not found with id " + skillId));
	}

}
