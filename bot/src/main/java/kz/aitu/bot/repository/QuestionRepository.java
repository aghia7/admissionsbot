package kz.aitu.bot.repository;

import kz.aitu.bot.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByCategoryId(Long id);
}
