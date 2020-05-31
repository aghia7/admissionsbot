package kz.aitu.bot.repository;

import kz.aitu.bot.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
