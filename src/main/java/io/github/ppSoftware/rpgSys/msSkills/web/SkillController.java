package io.github.ppSoftware.rpgSys.msSkills.web;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.ppSoftware.rpgSys.msSkills.model.SkillDao;
import io.github.ppSoftware.rpgSys.msSkills.service.SkillService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/skills")
@AllArgsConstructor
public class SkillController {

	private SkillService skillService;

	@GetMapping("/{skill}")
	Optional<SkillDao> getSkill(@PathVariable String skill) {
		return skillService.findByName(skill);
	}

	@GetMapping("/list")
	Page<SkillDao> getSkills(Pageable pageable) {
		return skillService.findAll(pageable);
	}

	@PostMapping("/add")
	public SkillDao createSkill(@Valid @RequestBody SkillDao skill) {
		return skillService.save(skill);
	}

	@PutMapping("/update/{skillId}")
	public SkillDao update(@Valid @RequestBody SkillDao skill, @PathVariable Long skillId) {
		return skillService.update(skill, skillId);
	}

	@DeleteMapping("/delete/{skillName}")
	public ResponseEntity<?> deleteSkill(@PathVariable String skillName) {
		return skillService.delete(skillName);
	}

}
